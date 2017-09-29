package by.orion.onlinertasks.common.network.services;

import by.orion.onlinertasks.data.models.credentials.AccessToken;
import by.orion.onlinertasks.data.models.credentials.AccessTokenRequestBody;
import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface CredentialsService {

    // OAuth
    @POST("oauth/token")
    Single<AccessToken> accessToken(@Body AccessTokenRequestBody body);
}
