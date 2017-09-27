package by.orion.onlinertasks.data.datasource.profile.reviews;

import android.support.annotation.NonNull;

import by.orion.onlinertasks.data.datasource.DataSource;
import by.orion.onlinertasks.data.models.common.requests.ProfileReviewsRequestParams;
import by.orion.onlinertasks.data.models.profile.reviews.ProfileReviewsPage;
import io.reactivex.Single;

public interface ProfileReviewsDataSource extends DataSource<Integer, ProfileReviewsPage> {

    Single<ProfileReviewsPage> getReviews(@NonNull ProfileReviewsRequestParams params);
}
