package by.orion.onlinertasks.common.account;

import android.accounts.AbstractAccountAuthenticator;
import android.accounts.Account;
import android.accounts.AccountAuthenticatorResponse;
import android.accounts.AccountManager;
import android.accounts.NetworkErrorException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import by.orion.onlinertasks.data.models.credentials.Credentials;
import by.orion.onlinertasks.data.repository.credentials.CredentialsRepository;
import by.orion.onlinertasks.presentation.login.LoginActivity;

public class UserAuthenticator extends AbstractAccountAuthenticator {

    @NonNull
    private final CredentialsRepository credentialsRepository;

    @NonNull
    protected final Context context;

    UserAuthenticator(@NonNull Context context, @NonNull CredentialsRepository credentialsRepository) {
        super(context);
        this.context = context;
        this.credentialsRepository = credentialsRepository;
    }

    @Override
    public Bundle addAccount(AccountAuthenticatorResponse response, String accountType, String authTokenType, String[] requiredFeatures, Bundle options) throws NetworkErrorException {
        final Intent intent = new Intent(context, LoginActivity.class);
        intent.putExtra(AccountManager.KEY_ACCOUNT_AUTHENTICATOR_RESPONSE, response);

        final Bundle bundle = new Bundle();
        if (options != null) {
            bundle.putAll(options);
        }
        bundle.putParcelable(AccountManager.KEY_INTENT, intent);
        return bundle;
    }

    @Override
    public Bundle getAuthToken(AccountAuthenticatorResponse response, Account account, String authTokenType, Bundle options) throws NetworkErrorException {
        Bundle result = new Bundle();
        AccountManager am = AccountManager.get(context.getApplicationContext());

        String accessToken = am.peekAuthToken(account, authTokenType);
        String refreshToken = am.getPassword(account);

        Credentials credentials = null;
        if (TextUtils.isEmpty(accessToken) && !TextUtils.isEmpty(refreshToken)) {
            try {
                credentials = credentialsRepository.refreshCredentials(Credentials.builder().accessToken(accessToken).refreshToken(refreshToken).build()).blockingGet();
                accessToken = credentials.accessToken();
            } catch (RuntimeException ignored) {
            }
        }

        if (!TextUtils.isEmpty(accessToken)) {
            result.putString(AccountManager.KEY_ACCOUNT_NAME, account.name);
            result.putString(AccountManager.KEY_ACCOUNT_TYPE, account.type);
            result.putString(AccountManager.KEY_AUTHTOKEN, accessToken);

            if (credentials != null) {
                am.setUserData(account, AccountConstants.EXPIRE_TOKEN, String.valueOf(credentials.expiresIn().getTime()));
            }
        } else {
            Bundle bundle = new Bundle();
            bundle.putParcelable(AccountManager.KEY_INTENT, getLoginIntent(response));
        }
        return result;
    }

    @NonNull
    private Intent getLoginIntent(AccountAuthenticatorResponse response) {
        Intent intent = new Intent(context, LoginActivity.class);
        intent.putExtra(AccountManager.KEY_ACCOUNT_AUTHENTICATOR_RESPONSE, response);
        return intent;
    }

    @Override
    public Bundle editProperties(AccountAuthenticatorResponse response, String accountType) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Bundle confirmCredentials(AccountAuthenticatorResponse response, Account account, Bundle options) throws NetworkErrorException {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getAuthTokenLabel(String authTokenType) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Bundle updateCredentials(AccountAuthenticatorResponse response, Account account, String authTokenType, Bundle options) throws NetworkErrorException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Bundle hasFeatures(AccountAuthenticatorResponse response, Account account, String[] features) throws NetworkErrorException {
        throw new UnsupportedOperationException();
    }
}
