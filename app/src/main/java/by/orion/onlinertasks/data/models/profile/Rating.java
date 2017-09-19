package by.orion.onlinertasks.data.models.profile;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

@AutoValue
public abstract class Rating {

    @SerializedName("rates")
    public abstract Rates rates();

    @SerializedName("votes")
    public abstract Integer votes();

    @SerializedName("average_rate")
    public abstract Float averageRate();

    public static TypeAdapter<Rating> typeAdapter(Gson gson) {
        return new AutoValue_Rating.GsonTypeAdapter(gson);
    }
}
