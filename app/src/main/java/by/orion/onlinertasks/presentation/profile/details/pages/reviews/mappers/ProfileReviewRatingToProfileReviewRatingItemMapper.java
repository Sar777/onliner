package by.orion.onlinertasks.presentation.profile.details.pages.reviews.mappers;

import android.support.annotation.NonNull;

import by.orion.onlinertasks.common.GenericObjectMapper;
import by.orion.onlinertasks.data.models.profile.reviews.Rating;
import by.orion.onlinertasks.presentation.profile.details.pages.reviews.models.RatingItem;

public class ProfileReviewRatingToProfileReviewRatingItemMapper implements GenericObjectMapper<Rating, RatingItem> {

    @NonNull
    @Override
    public RatingItem map(@NonNull Rating rating) {
        return RatingItem.builder()
                .politeness(rating.politeness())
                .punctuality(rating.punctuality())
                .quality(rating.quality())
                .build();
    }
}
