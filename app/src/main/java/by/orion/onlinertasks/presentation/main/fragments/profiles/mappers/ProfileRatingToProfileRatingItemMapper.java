package by.orion.onlinertasks.presentation.main.fragments.profiles.mappers;

import android.support.annotation.NonNull;

import by.orion.onlinertasks.common.GenericObjectMapper;
import by.orion.onlinertasks.data.models.profile.Rating;
import by.orion.onlinertasks.presentation.main.fragments.profiles.models.RatingItem;

public class ProfileRatingToProfileRatingItemMapper implements GenericObjectMapper<Rating, RatingItem> {
    
    @NonNull
    @Override
    public RatingItem map(@NonNull Rating rating) {
        return RatingItem.builder()
                .rates(new ProfileRatesToProfileRatesItemMapper().map(rating.rates()))
                .votes(rating.votes())
                .averageRate(rating.averageRate())
                .build();
    }
}
