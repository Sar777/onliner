package by.orion.onlinertasks.data.models.profile.details;

import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

import by.orion.onlinertasks.data.models.profile.details.rating.Rating;

@AutoValue
public abstract class Profile {

    @SerializedName("id")
    public abstract Integer id();

    @SerializedName("display_name")
    public abstract String displayName();

    @Nullable
    @SerializedName("description")
    public abstract String description();

    @Nullable
    @SerializedName("photo")
    public abstract String photo();

    @SerializedName("rating")
    public abstract Rating rating();

    @Nullable
    @SerializedName("executor")
    public abstract Executor executor();

    @SerializedName("status")
    public abstract String status();

    @SerializedName("created_tasks_qty")
    public abstract Integer createdTasksQty();

    @SerializedName("created_at")
    public abstract String createdAt();

    @SerializedName("url")
    public abstract String url();

    @SerializedName("html_url")
    public abstract String htmlUrl();

    public static TypeAdapter<Profile> typeAdapter(Gson gson) {
        return new AutoValue_Profile.GsonTypeAdapter(gson);
    }
}
