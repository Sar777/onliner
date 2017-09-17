package by.orion.onlinertasks.data.models.task;

import com.google.auto.value.AutoValue;
import com.google.gson.annotations.SerializedName;

import by.orion.onlinertasks.common.annotations.AutoGson;

@AutoGson
@AutoValue
public abstract class Author {

    @SerializedName("id")
    public abstract Integer id();

    @SerializedName("name")
    public abstract String name();

    @SerializedName("photo")
    public abstract String photo();

    @SerializedName("url")
    public abstract String url();

    @SerializedName("html_url")
    public abstract String htmlUrl();

    public static Author create(Integer id, String name, String photo, String url, String htmlUrl) {
        return new AutoValue_Author(id, name, photo, url, htmlUrl);
    }
}