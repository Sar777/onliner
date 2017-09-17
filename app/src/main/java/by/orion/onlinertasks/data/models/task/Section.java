package by.orion.onlinertasks.data.models.task;

import com.google.auto.value.AutoValue;
import com.google.gson.annotations.SerializedName;

import by.orion.onlinertasks.common.annotations.AutoGson;

@AutoGson
@AutoValue
public abstract class Section {

    @SerializedName("id")
    public abstract Integer id();

    @SerializedName("name")
    public abstract String name();

    @SerializedName("slug")
    public abstract String slug();
}
