package by.orion.onlinertasks.presentation.profile.details.pages.reviews.mappers;

import android.support.annotation.NonNull;

import com.github.thunder413.datetimeutils.DateTimeUtils;

import by.orion.onlinertasks.common.GenericObjectMapper;
import by.orion.onlinertasks.data.models.common.Role;
import by.orion.onlinertasks.data.models.profile.reviews.Review;
import by.orion.onlinertasks.presentation.profile.details.pages.reviews.models.ReviewItem;

public class ProfileReviewToProfileReviewItemMapper implements GenericObjectMapper<Review, ReviewItem> {

    @NonNull
    @Override
    public ReviewItem map(@NonNull Review review) {
        return ReviewItem.builder()
                .id(review.id())
                .averageRating(review.averageRating())
                .rating(new ProfileReviewRatingToProfileReviewRatingItemMapper().map(review.rating()))
                .review(review.review())
                .author(new ProfileReviewAuthorToProfileReviewAuthorItemMapper().map(review.author()))
                .task(new ProfileReviewTaskToProfileReviewTaskItemMapper().map(review.task()))
                .createdAt(DateTimeUtils.formatDate(review.createdAt()))
                .profileRole(Role.get(review.profileRole()))
                .build();
    }
}
