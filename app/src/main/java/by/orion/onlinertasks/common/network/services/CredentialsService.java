package by.orion.onlinertasks.common.network.services;

import by.orion.onlinertasks.data.models.credentials.AccessTokenRequestBody;
import by.orion.onlinertasks.data.models.credentials.Credentials;
import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface CredentialsService {

    // OAuth
    @POST("oauth/token")
    Single<Credentials> accessToken(@Body AccessTokenRequestBody body);

    @FormUrlEncoded
    @POST("/oauth/token")
    Single<Credentials> refreshCredentials(@Field("refresh_token") String str, @Field("client_id") String str2, @Field("grant_type") String str3);
}
