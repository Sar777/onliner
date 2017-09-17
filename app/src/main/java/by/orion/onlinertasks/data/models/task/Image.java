package by.orion.onlinertasks.data.models.task;

import com.google.auto.value.AutoValue;
import com.google.gson.annotations.SerializedName;

import by.orion.onlinertasks.common.annotations.AutoGson;

@AutoGson
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

    public static Image create(String _280x280, String _640x320, String _2100x1200, String _original) {
        return new AutoValue_Image(_280x280, _640x320, _2100x1200, _original);
    }
}
