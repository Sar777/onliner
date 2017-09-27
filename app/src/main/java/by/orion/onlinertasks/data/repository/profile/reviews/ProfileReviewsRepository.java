package by.orion.onlinertasks.data.repository.profile.reviews;

import android.support.annotation.NonNull;

import by.orion.onlinertasks.data.models.common.requests.ProfileReviewsRequestParams;
import by.orion.onlinertasks.data.models.profile.reviews.ProfileReviewsPage;
import by.orion.onlinertasks.data.repository.Repository;
import io.reactivex.Single;

public interface ProfileReviewsRepository extends Repository {

    Single<ProfileReviewsPage> getReviews(@NonNull ProfileReviewsRequestParams params);
}
