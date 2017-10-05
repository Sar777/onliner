package by.orion.onlinertasks.data.models.task;

import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

@AutoValue
public abstract class Location {

    @SerializedName("geo_town_id")
    public abstract Integer geoTownId();

    @SerializedName("region_id")
    public abstract Integer regionId();

    @SerializedName("region")
    public abstract String region();

    @SerializedName("district")
    public abstract String district();

    @SerializedName("town")
    public abstract String town();

    @SerializedName("formatted_locality")
    public abstract String formattedLocality();

    @Nullable
    @SerializedName("street_address")
    public abstract String streetAddress();

    public static TypeAdapter<Location> typeAdapter(Gson gson) {
        return new AutoValue_Location.GsonTypeAdapter(gson);
    }
}
