package by.orion.onlinertasks.data.models.profile.reviews;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

@AutoValue
public abstract class Task {

    @SerializedName("id")
    public abstract Integer id();

    @SerializedName("title")
    public abstract String title();

    @SerializedName("url")
    public abstract String url();

    @SerializedName("html_url")
    public abstract String htmlUrl();

    public static TypeAdapter<Task> typeAdapter(Gson gson) {
        return new AutoValue_Task.GsonTypeAdapter(gson);
    }
}
