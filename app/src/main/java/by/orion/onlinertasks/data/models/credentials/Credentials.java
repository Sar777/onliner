package by.orion.onlinertasks.data.models.credentials;

import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

@AutoValue
public abstract class Credentials {

    @SerializedName("access_token")
    public abstract String accessToken();

    @SerializedName("expires_in")
    public abstract Date expiresIn();

    @Nullable
    @SerializedName("token_type")
    public abstract String tokenType();

    @SerializedName("refresh_token")
    public abstract String refreshToken();

    public static TypeAdapter<Credentials> typeAdapter(Gson gson) {
        return new AutoValue_Credentials.GsonTypeAdapter(gson);
    }

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
