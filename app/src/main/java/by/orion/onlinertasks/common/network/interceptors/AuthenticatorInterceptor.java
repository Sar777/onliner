package by.orion.onlinertasks.common.network.interceptors;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import by.orion.onlinertasks.common.account.AccountConstants;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AuthenticatorInterceptor implements Interceptor {

    @NonNull
    private final AccountManager accountManager;

    @Inject
    public AuthenticatorInterceptor(@NonNull AccountManager accountManager) {
        this.accountManager = accountManager;
    }

    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        if (withAuthorizationToken(chain.request())) {
            request = replaceAuthTokenIfTokenExpired(chain.request());
        }

        Response response = chain.proceed(request);
        if (response.code() != HttpURLConnection.HTTP_UNAUTHORIZED && response.code() != HttpURLConnection.HTTP_FORBIDDEN) {
            return response;
        }
        String authToken = refreshAndGetAuthToken();
        return !TextUtils.isEmpty(authToken) ? chain.proceed(replaceAuthorizationToken(response.request(), authToken)) : response;
    }

    private Request replaceAuthTokenIfTokenExpired(@NonNull Request request) {
        if (!isTokenExpired()) {
            return request;
        }

        String refreshedToken = refreshAndGetAuthToken();
        if (TextUtils.isEmpty(refreshedToken)) {
            return request;
        }
        return replaceAuthorizationToken(request, refreshedToken);
    }

    private boolean isTokenExpired() {
        List<Account> accounts = Arrays.asList(accountManager.getAccountsByType(AccountConstants.TYPE));
        if (accounts.isEmpty()) {
            return false;
        }

        Account account = accounts.get(0);
        return !TextUtils.isEmpty(accountManager.getUserData(account, AccountConstants.EXPIRE_TOKEN)) && new Date().after(new Date(Long.valueOf(accountManager.getUserData(account, AccountConstants.EXPIRE_TOKEN))));

    }

    private boolean withAuthorizationToken(@NonNull Request request) {
        return !TextUtils.isEmpty(request.header("Authorization"));
    }

    @NonNull
    private Request replaceAuthorizationToken(@NonNull Request request, @NonNull String token) {
        return request.newBuilder().removeHeader("Authorization").header("Authorization", formatAuthorization(token)).build();
    }

    @Nullable
    private String refreshAndGetAuthToken() {
        List<Account> accounts = Arrays.asList(accountManager.getAccountsByType(AccountConstants.TYPE));
        if (accounts.isEmpty()) {
            return null;
        }

        Account account = accounts.get(0);
        String currentAuthToken = accountManager.peekAuthToken(account, AccountConstants.ACCESS_TOKEN);
        if (!TextUtils.isEmpty(currentAuthToken)) {
            accountManager.invalidateAuthToken(AccountConstants.TYPE, currentAuthToken);
        }

        try {
            String refreshedAuthToken = accountManager.blockingGetAuthToken(account, AccountConstants.ACCESS_TOKEN, false);
            if (!TextUtils.isEmpty(refreshedAuthToken)) {
                return refreshedAuthToken;
            }

            accountManager.removeAccount(account, null, null);
            return null;
        } catch (OperationCanceledException e) {
            return null;
        } catch (IOException e2) {
            return null;
        } catch (AuthenticatorException e3) {
            return null;
        }
    }

    @NonNull
    public static String formatAuthorization(@NonNull String accessToken) {
        return String.format("Bearer %s", accessToken);
    }
}
