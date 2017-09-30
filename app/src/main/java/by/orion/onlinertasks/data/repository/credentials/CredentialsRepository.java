package by.orion.onlinertasks.data.repository.credentials;

import android.support.annotation.NonNull;

import by.orion.onlinertasks.data.models.common.requests.SignInRequestParams;
import by.orion.onlinertasks.data.models.credentials.Credentials;
import by.orion.onlinertasks.data.repository.Repository;
import io.reactivex.Completable;
import io.reactivex.Single;

public interface CredentialsRepository extends Repository {

    Completable signIn(@NonNull SignInRequestParams params);

    Single<Credentials> refreshCredentials(@NonNull Credentials credentials);
}
