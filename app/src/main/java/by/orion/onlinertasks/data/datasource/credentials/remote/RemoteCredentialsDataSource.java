package by.orion.onlinertasks.data.datasource.credentials.remote;

import android.accounts.Account;
import android.support.annotation.NonNull;

import by.orion.onlinertasks.common.network.services.CredentialsService;
import by.orion.onlinertasks.data.datasource.credentials.CredentialsDataSource;
import by.orion.onlinertasks.data.models.common.requests.SignInRequestParams;
import by.orion.onlinertasks.data.models.credentials.AccessToken;
import by.orion.onlinertasks.data.models.credentials.AccessTokenRequestBody;
import io.reactivex.Completable;
import io.reactivex.Single;

public class RemoteCredentialsDataSource implements CredentialsDataSource {

    @NonNull
    private final CredentialsService service;

    public RemoteCredentialsDataSource(@NonNull CredentialsService service) {
        this.service = service;
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
        return service.accessToken(new AccessTokenRequestBody(params.username(), params.password()));
    }

    @Override
    public Single<Account> saveAccount(@NonNull SignInRequestParams params, @NonNull AccessToken token) {
        throw new UnsupportedOperationException();
    }
}
