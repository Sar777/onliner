package by.orion.onlinertasks.data.deserializers;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.Date;

import by.orion.onlinertasks.data.models.credentials.Credentials;

import static by.orion.onlinertasks.data.models.credentials.CredentialsConstants.AuthenticationGrants;

public class CredentialsConverter implements JsonDeserializer<Credentials> {

    public Credentials deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        String accessToken = "";
        String refreshToken = "";
        String tokenType = "";
        long expiresInSeconds = 0;

        if (json.getAsJsonObject().get("access_token") != null) {
            accessToken = json.getAsJsonObject().get("access_token").getAsString();
        }

        if (json.getAsJsonObject().get(AuthenticationGrants.REFRESH) != null) {
            refreshToken = json.getAsJsonObject().get(AuthenticationGrants.REFRESH).getAsString();
        }

        if (json.getAsJsonObject().get("token_type") != null) {
            tokenType = json.getAsJsonObject().get("token_type").getAsString();
        }

        if (json.getAsJsonObject().get("expires_in") != null) {
            expiresInSeconds = json.getAsJsonObject().get("expires_in").getAsLong() - 120;
        }

        Date expiresIn = new Date();
        expiresIn.setTime(expiresIn.getTime() + (1000 * expiresInSeconds));

        return Credentials.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .expiresIn(expiresIn)
                .tokenType(tokenType)
                .build();
    }
}