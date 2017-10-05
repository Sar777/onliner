package by.orion.onlinertasks.data.models.profile.reviews;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

@AutoValue
public abstract class Author {

    @NonNull
    @SerializedName("id")
    public abstract Integer id();

    @NonNull
    @SerializedName("name")
    public abstract String name();

    @Nullable
    @SerializedName("photo")
    public abstract String photo();

    @NonNull
    @SerializedName("url")
    public abstract String url();

    @NonNull
    @SerializedName("html_url")
    public abstract String htmlUrl();

    public static TypeAdapter<Author> typeAdapter(Gson gson) {
        return new AutoValue_Author.GsonTypeAdapter(gson);
    }
}
