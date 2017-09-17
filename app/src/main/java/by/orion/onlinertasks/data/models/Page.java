package by.orion.onlinertasks.data.models;

import com.google.auto.value.AutoValue;
import com.google.gson.annotations.SerializedName;

import by.orion.onlinertasks.common.annotations.AutoGson;

@AutoGson
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

    public static Page create(Integer limit, Integer items, Integer current, Integer last) {
        return new AutoValue_Page(limit, items, current, last);
    }
}
