package by.orion.onlinertasks.data.repository.credentials;

import android.support.annotation.NonNull;

import by.orion.onlinertasks.data.models.common.requests.SingInRequestParams;
import by.orion.onlinertasks.data.repository.Repository;
import io.reactivex.Completable;

public interface CredentialsRepository extends Repository {

    Completable singIn(@NonNull SingInRequestParams params);
}
