package by.orion.onlinertasks.data.models.profile.details.rating;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

@AutoValue
public abstract class Rating {

    @SerializedName("customer")
    public abstract Customer customer();

    @SerializedName("executor")
    public abstract Executor executor();

    public static TypeAdapter<Rating> typeAdapter(Gson gson) {
        return new AutoValue_Rating.GsonTypeAdapter(gson);
    }
}
