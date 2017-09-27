package by.orion.onlinertasks.data.models.profile.reviews;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

@AutoValue
public abstract class Rating {

    @SerializedName("politeness")
    public abstract Integer politeness();

    @SerializedName("quality")
    public abstract Integer quality();

    @SerializedName("punctuality")
    public abstract Integer punctuality();

    public static TypeAdapter<Rating> typeAdapter(Gson gson) {
        return new AutoValue_Rating.GsonTypeAdapter(gson);
    }
}
