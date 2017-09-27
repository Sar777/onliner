package by.orion.onlinertasks.data.models.profile.reviews;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import by.orion.onlinertasks.data.models.common.Page;

@AutoValue
public abstract class ProfileReviewsPage {

    @SerializedName("reviews")
    public List<Review> reviews;

    @SerializedName("total")
    public Integer total;

    @SerializedName("page")
    public Page page;

    public static TypeAdapter<ProfileReviewsPage> typeAdapter(Gson gson) {
        return new AutoValue_ProfileReviewsPage.GsonTypeAdapter(gson);
    }
}
