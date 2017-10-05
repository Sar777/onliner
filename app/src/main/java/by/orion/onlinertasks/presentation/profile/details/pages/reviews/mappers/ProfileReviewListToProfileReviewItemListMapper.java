package by.orion.onlinertasks.presentation.profile.details.pages.reviews.mappers;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import by.orion.onlinertasks.common.GenericObjectMapper;
import by.orion.onlinertasks.data.models.profile.reviews.Review;
import by.orion.onlinertasks.presentation.profile.details.pages.reviews.models.ReviewItem;

public class ProfileReviewListToProfileReviewItemListMapper implements GenericObjectMapper<List<Review>, List<ReviewItem>> {

    @Inject
    public ProfileReviewListToProfileReviewItemListMapper() {
    }

    @NonNull
    @Override
    public List<ReviewItem> map(@NonNull List<Review> reviews) {
        List<ReviewItem> reviewItems = new ArrayList<>(reviews.size());
        GenericObjectMapper<Review, ReviewItem> mapper = new ProfileReviewToProfileReviewItemMapper();
        for (Review review : reviews) {
            reviewItems.add(mapper.map(review));
        }

        return reviewItems;
    }
}
