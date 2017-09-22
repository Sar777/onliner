package by.orion.onlinertasks.data.models.profile.details.rating;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

@AutoValue
public abstract class Stars {

    @SerializedName("1")
    public abstract Integer _1();

    @SerializedName("2")
    public abstract Integer _2();

    @SerializedName("3")
    public abstract Integer _3();

    @SerializedName("4")
    public abstract Integer _4();

    @SerializedName("5")
    public abstract Integer _5();

    public static TypeAdapter<Stars> typeAdapter(Gson gson) {
        return new AutoValue_Stars.GsonTypeAdapter(gson);
    }
}
