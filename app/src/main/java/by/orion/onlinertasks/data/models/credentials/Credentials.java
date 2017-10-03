package by.orion.onlinertasks.data.models.credentials;

import com.google.auto.value.AutoValue;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

@AutoValue
public abstract class Credentials {

    @SerializedName("access_token")
    public abstract String accessToken();

    @SerializedName("expires_in")
    public abstract Date expiresIn();

    @SerializedName("token_type")
    public abstract String tokenType();

    @SerializedName("refresh_token")
    public abstract String refreshToken();

    public static Builder builder() {
        return new AutoValue_Credentials.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder accessToken(String accessToken);
        public abstract Builder expiresIn(Date expiresIn);
        public abstract Builder tokenType(String tokenType);
        public abstract Builder refreshToken(String refreshToken);
        public abstract Credentials build();
    }
}
