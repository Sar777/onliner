package by.orion.onlinertasks.data.models.regions;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

@AutoValue
public abstract class Region {

    @SerializedName("id")
    public abstract Integer id();

    @SerializedName("name")
    public abstract String name();

    @SerializedName("slug")
    public abstract String slug();

    public static TypeAdapter<Region> typeAdapter(Gson gson) {
        return new AutoValue_Region.GsonTypeAdapter(gson);
    }
}
