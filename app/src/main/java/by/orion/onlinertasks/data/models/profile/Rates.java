package by.orion.onlinertasks.data.models.profile;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

@AutoValue
public abstract class Rates {

    @SerializedName("politeness")
    public abstract Integer politeness();

    @SerializedName("quality")
    public abstract Integer quality();

    @SerializedName("punctuality")
    public abstract Integer punctuality();

    public static TypeAdapter<Rates> typeAdapter(Gson gson) {
        return new AutoValue_Rates.GsonTypeAdapter(gson);
    }
}
