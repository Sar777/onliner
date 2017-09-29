package by.orion.onlinertasks.data.datasource.credentials.local;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.os.Bundle;
import android.support.annotation.NonNull;

import javax.inject.Inject;

import by.orion.onlinertasks.common.account.AccountConstants;
import by.orion.onlinertasks.common.exceptions.AccountManagerException;
import by.orion.onlinertasks.data.datasource.credentials.CredentialsDataSource;
import by.orion.onlinertasks.data.models.common.requests.SignInRequestParams;
import by.orion.onlinertasks.data.models.credentials.AccessToken;
import io.reactivex.Completable;
import io.reactivex.Single;

public class LocalCredentialsDataSource implements CredentialsDataSource {

    @NonNull
    private static final String BUNDLE_ACCESS_TOKEN = "BUNDLE_ACCESS_TOKEN";

    @NonNull
    private static final String BUNDLE_REFRESH_TOKEN = "BUNDLE_REFRESH_TOKEN";

    @NonNull
    private static final String BUNDLE_EXPIRE_IN = "BUNDLE_EXPIRE_IN";

    @NonNull
    private final AccountManager accountManager;

    @Inject
    public LocalCredentialsDataSource(@NonNull AccountManager accountManager) {
        this.accountManager = accountManager;
    }

    @Override
    public Single<AccessToken> getValue(@NonNull String key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Completable setValue(@NonNull String key, @NonNull AccessToken value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Single<AccessToken> signIn(@NonNull SignInRequestParams params) {
        return null;
    }

    @Override
    public Single<Account> saveAccount(@NonNull SignInRequestParams params, @NonNull AccessToken token) {
        return Single.create(e -> {
            Bundle bundle = new Bundle();
            bundle.putString(BUNDLE_ACCESS_TOKEN, token.accessToken());
            bundle.putString(BUNDLE_REFRESH_TOKEN, token.accessToken());
            bundle.putInt(BUNDLE_EXPIRE_IN, token.expiresIn());

            Account account = new Account(params.username(), AccountConstants.TYPE);
            if (accountManager.addAccountExplicitly(account, params.password(), bundle)) {
                e.onSuccess(account);
            } else {
                e.onError(new AccountManagerException("Fail added account to account manager"));
            }
        });
    }
}
