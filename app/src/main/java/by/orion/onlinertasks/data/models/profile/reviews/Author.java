package by.orion.onlinertasks.data.models.profile.reviews;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

@AutoValue
public abstract class Author {

    @SerializedName("id")
    public abstract Integer id();

    @SerializedName("name")
    public abstract String name();

    @SerializedName("photo")
    public abstract Object photo();

    @SerializedName("url")
    public abstract String url();

    @SerializedName("html_url")
    public abstract String htmlUrl();

    public static TypeAdapter<Author> typeAdapter(Gson gson) {
        return new AutoValue_Author.GsonTypeAdapter(gson);
    }
}
