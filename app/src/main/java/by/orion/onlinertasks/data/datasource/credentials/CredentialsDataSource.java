package by.orion.onlinertasks.data.datasource.credentials;

import android.accounts.Account;
import android.support.annotation.NonNull;

import by.orion.onlinertasks.data.datasource.DataSource;
import by.orion.onlinertasks.data.models.common.requests.SignInRequestParams;
import by.orion.onlinertasks.data.models.credentials.AccessToken;
import io.reactivex.Single;

public interface CredentialsDataSource extends DataSource<String, AccessToken> {

    Single<AccessToken> signIn(@NonNull SignInRequestParams params);

    Single<Account> saveAccount(@NonNull SignInRequestParams params, @NonNull AccessToken token);
}
