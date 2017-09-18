package by.orion.onlinertasks.data.models.task;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

@AutoValue
public abstract class Image {

    @SerializedName("280x280")
    public abstract String _280x280();

    @SerializedName("640x320")
    public abstract String _640x320();

    @SerializedName("2100x1200")
    public abstract String _2100x1200();

    @SerializedName("original")
    public abstract String _original();

    public static TypeAdapter<Image> typeAdapter(Gson gson) {
        return new AutoValue_Image.GsonTypeAdapter(gson);
    }
}
