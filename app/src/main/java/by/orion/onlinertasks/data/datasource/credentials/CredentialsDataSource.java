package by.orion.onlinertasks.data.datasource.credentials;

import android.accounts.Account;
import android.support.annotation.NonNull;

import by.orion.onlinertasks.data.datasource.DataSource;
import by.orion.onlinertasks.data.models.common.requests.SignInRequestParams;
import by.orion.onlinertasks.data.models.credentials.Credentials;
import io.reactivex.Single;

public interface CredentialsDataSource extends DataSource<String, Credentials> {

    Single<Credentials> signIn(@NonNull SignInRequestParams params);

    Single<Credentials> refreshCredentials(@NonNull Credentials credentials);

    Single<Account> saveAccount(@NonNull SignInRequestParams params, @NonNull Credentials token);
}
