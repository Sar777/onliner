package by.orion.onlinertasks.data.models.common;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

@AutoValue
public abstract class Page {

    @SerializedName("limit")
    public abstract Integer limit();

    @SerializedName("items")
    public abstract Integer items();

    @SerializedName("current")
    public abstract Integer current();

    @SerializedName("last")
    public abstract Integer last();

    public static TypeAdapter<Page> typeAdapter(Gson gson) {
        return new AutoValue_Page.GsonTypeAdapter(gson);
    }
}
