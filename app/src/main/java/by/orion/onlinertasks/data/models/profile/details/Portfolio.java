package by.orion.onlinertasks.data.models.profile.details;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

@AutoValue
public abstract class Portfolio {

    @SerializedName("original")
    public String original;

    @SerializedName("240x160")
    public String _240x160;

    @SerializedName("1260x840")
    public String _1260x840;

    @SerializedName("1600x900")
    public String _1600x900;

    @SerializedName("2100x1200")
    public String _2100x1200;

    public static TypeAdapter<Portfolio> typeAdapter(Gson gson) {
        return new AutoValue_Portfolio.GsonTypeAdapter(gson);
    }
}
