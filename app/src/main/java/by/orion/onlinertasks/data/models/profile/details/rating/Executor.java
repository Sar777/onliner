package by.orion.onlinertasks.data.models.profile.details.rating;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

import by.orion.onlinertasks.data.models.profile.Rates;

@AutoValue
public abstract class Executor {

    @SerializedName("rates")
    public abstract Rates rates();

    @SerializedName("votes")
    public abstract Integer votes();

    @SerializedName("average_rate")
    public abstract Integer averageRate();

    public static TypeAdapter<Executor> typeAdapter(Gson gson) {
        return new AutoValue_Executor.GsonTypeAdapter(gson);
    }
}
