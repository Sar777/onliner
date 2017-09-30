package by.orion.onlinertasks.data.datasource.credentials.remote;

import android.accounts.Account;
import android.support.annotation.NonNull;

import by.orion.onlinertasks.common.network.services.CredentialsService;
import by.orion.onlinertasks.data.datasource.credentials.CredentialsDataSource;
import by.orion.onlinertasks.data.models.common.requests.SignInRequestParams;
import by.orion.onlinertasks.data.models.credentials.AccessTokenRequestBody;
import by.orion.onlinertasks.data.models.credentials.Credentials;
import io.reactivex.Completable;
import io.reactivex.Single;

import static by.orion.onlinertasks.data.models.credentials.CredentialsConstants.AuthenticationClients;
import static by.orion.onlinertasks.data.models.credentials.CredentialsConstants.AuthenticationGrants;

public class RemoteCredentialsDataSource implements CredentialsDataSource {

    @NonNull
    private final CredentialsService service;

    public RemoteCredentialsDataSource(@NonNull CredentialsService service) {
        this.service = service;
    }

    @Override
    public Single<Credentials> getValue(@NonNull String key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Completable setValue(@NonNull String key, @NonNull Credentials value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Single<Credentials> signIn(@NonNull SignInRequestParams params) {
        return service.accessToken(new AccessTokenRequestBody(params.username(), params.password()));
    }

    @Override
    public Single<Credentials> refreshCredentials(@NonNull Credentials credentials) {
        return service.refreshCredentials(credentials.refreshToken(), AuthenticationClients.USER, AuthenticationGrants.PASSWORD);
    }

    @Override
    public Single<Account> saveAccount(@NonNull SignInRequestParams params, @NonNull Credentials token) {
        throw new UnsupportedOperationException();
    }
}
