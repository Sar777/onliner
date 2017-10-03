package by.orion.onlinertasks.data.repository.credentials;

import android.support.annotation.NonNull;

import javax.inject.Inject;

import by.orion.onlinertasks.data.datasource.credentials.CredentialsDataSource;
import by.orion.onlinertasks.data.models.common.requests.SignInRequestParams;
import by.orion.onlinertasks.data.models.credentials.Credentials;
import by.orion.onlinertasks.di.qualifiers.LocalDataSource;
import by.orion.onlinertasks.di.qualifiers.RemoteDataSource;
import io.reactivex.Completable;
import io.reactivex.Single;

public class CredentialsRepositoryImpl implements CredentialsRepository {

    @NonNull
    private final CredentialsDataSource localDataSource;

    @NonNull
    private final CredentialsDataSource remoteDataSource;

    @Inject
    public CredentialsRepositoryImpl(@NonNull @LocalDataSource CredentialsDataSource localDataSource,
                                     @NonNull @RemoteDataSource CredentialsDataSource remoteDataSource) {
        this.localDataSource = localDataSource;
        this.remoteDataSource = remoteDataSource;
    }

    @Override
    public Completable signIn(@NonNull SignInRequestParams params) {
        return remoteDataSource.signIn(params)
                .flatMap(token -> localDataSource.saveAccount(params, token))
                .toCompletable();
    }

    @Override
    public Single<Boolean> isAuthorized() {
        return localDataSource.isAuthorized();
    }

    @Override
    public Single<Credentials> refreshCredentials(@NonNull Credentials credentials) {
        return remoteDataSource.refreshCredentials(credentials);
    }
}
