package by.orion.onlinertasks.data.models.credentials;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

@AutoValue
public abstract class AccessToken {

    @SerializedName("access_token")
    public abstract String accessToken();

    @SerializedName("expires_in")
    public abstract Integer expiresIn();

    @SerializedName("token_type")
    public abstract String tokenType();

    @SerializedName("scope")
    public abstract String scope();

    @SerializedName("refresh_token")
    public abstract String refreshToken();

    public static TypeAdapter<AccessToken> typeAdapter(Gson gson) {
        return new AutoValue_AccessToken.GsonTypeAdapter(gson);
    }
}
