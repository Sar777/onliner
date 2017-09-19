package by.orion.onlinertasks.data.models.profile;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@AutoValue
public abstract class Profile {

    @SerializedName("id")
    public abstract Integer id();

    @SerializedName("photo")
    public abstract String photo();

    @SerializedName("display_name")
    public abstract String displayName();

    @SerializedName("description")
    public abstract String description();

    @SerializedName("sections")
    public abstract List<String> sections();

    @SerializedName("rating")
    public abstract Rating rating();

    @SerializedName("completed_tasks_qty")
    public abstract Integer completedTasksQty();

    @SerializedName("url")
    public abstract String url();

    @SerializedName("html_url")
    public abstract String htmlUrl();

    public static TypeAdapter<Profile> typeAdapter(Gson gson) {
        return new AutoValue_Profile.GsonTypeAdapter(gson);
    }
}
