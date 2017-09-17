package by.orion.onlinertasks.data.models.task;

import com.google.auto.value.AutoValue;
import com.google.gson.annotations.SerializedName;

import by.orion.onlinertasks.common.annotations.AutoGson;

@AutoGson
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

    @SerializedName("street_address")
    public abstract String streetAddress();

    public static Location create(Integer geoTownId, Integer regionId, String region, String district, String town, String formattedLocality, String streetAddress) {
        return new AutoValue_Location(geoTownId, regionId, region, district, town, formattedLocality, streetAddress);
    }
}
