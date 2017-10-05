package by.orion.onlinertasks.data.models.profile.reviews;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

@AutoValue
public abstract class Review {

    @SerializedName("id")
    public abstract Integer id();

    @SerializedName("profile_id")
    public abstract Integer profileId();

    @SerializedName("profile_role")
    public abstract String profileRole();

    @SerializedName("review")
    public abstract String review();

    @SerializedName("average_rating")
    public abstract Float averageRating();

    @SerializedName("rating")
    public abstract Rating rating();

    @SerializedName("task")
    public abstract Task task();

    @SerializedName("author")
    public abstract Author author();

    @SerializedName("created_at")
    public abstract String createdAt();

    public static TypeAdapter<Review> typeAdapter(Gson gson) {
        return new AutoValue_Review.GsonTypeAdapter(gson);
    }
}
