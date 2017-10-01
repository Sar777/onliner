package by.orion.onlinertasks.common.network.errors;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

@AutoValue
public abstract class ServiceErrorResponse {

    @SerializedName("error")
    public abstract String error();

    @SerializedName("error_description")
    public abstract String description();

    public static TypeAdapter<ServiceErrorResponse> typeAdapter(Gson gson) {
        return new AutoValue_ServiceErrorResponse.GsonTypeAdapter(gson);
    }
}
