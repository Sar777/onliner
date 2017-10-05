package by.orion.onlinertasks.domain.interactors;

import android.support.annotation.NonNull;

import java.util.List;

import javax.inject.Inject;

import by.orion.onlinertasks.data.models.common.requests.ProfileReviewsRequestParams;
import by.orion.onlinertasks.data.models.profile.reviews.ProfileReviewsPage;
import by.orion.onlinertasks.data.repository.profile.reviews.ProfileReviewsRepository;
import by.orion.onlinertasks.presentation.profile.details.pages.reviews.mappers.ProfileReviewListToProfileReviewItemListMapper;
import by.orion.onlinertasks.presentation.profile.details.pages.reviews.models.ReviewItem;
import io.reactivex.Single;

public class ReviewsProfileDetailsInteractor {

    @NonNull
    private final ProfileReviewsRepository profileReviewsRepository;

    @NonNull
    private final ProfileReviewListToProfileReviewItemListMapper profileReviewListToProfileReviewItemListMapper;

    @Inject
    public ReviewsProfileDetailsInteractor(@NonNull ProfileReviewsRepository profileReviewsRepository,
                                           @NonNull ProfileReviewListToProfileReviewItemListMapper profileReviewListToProfileReviewItemListMapper) {
        this.profileReviewsRepository = profileReviewsRepository;
        this.profileReviewListToProfileReviewItemListMapper = profileReviewListToProfileReviewItemListMapper;
    }

    public Single<List<ReviewItem>> getProfileReviews(@NonNull ProfileReviewsRequestParams params) {
        return profileReviewsRepository.getReviews(params)
                .map(ProfileReviewsPage::reviews)
                .map(profileReviewListToProfileReviewItemListMapper::map);
    }
}
