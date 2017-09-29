package by.orion.onlinertasks.data.models.credentials;

import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import by.orion.onlinertasks.BuildConfig;

public class AccessTokenRequestBody {

    @SerializedName("username")
    @Expose
    @NonNull
    private final String username;

    @SerializedName("password")
    @Expose
    @NonNull
    private final String password;

    @SerializedName("client_id")
    @Expose
    @NonNull
    private final String clientId = BuildConfig.CLIENT_ID;

    @SerializedName("grant_type")
    @Expose
    @NonNull
    private final String grantType = "password";

    public AccessTokenRequestBody(@NonNull String username, @NonNull String password) {
        this.username = username;
        this.password = password;
    }

    @NonNull
    public String getUsername() {
        return username;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    @NonNull
    public String getClientId() {
        return clientId;
    }

    @NonNull
    public String getGrantType() {
        return grantType;
    }
}
