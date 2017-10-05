package by.orion.onlinertasks.presentation.profile.details.pages.reviews;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import java.util.List;

import by.orion.onlinertasks.presentation.BaseMvpView;
import by.orion.onlinertasks.presentation.profile.details.pages.reviews.models.ReviewItem;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface ReviewsProfileDetailsView extends BaseMvpView {

    String TAG_REVIEWS = "TAG_REVIEWS";

    @StateStrategyType(value = AddToEndSingleStrategy.class, tag = TAG_REVIEWS)
    void showReviews();

    @StateStrategyType(value = AddToEndSingleStrategy.class, tag = TAG_REVIEWS)
    void hideReviews();

    void setReviews(@NonNull List<ReviewItem> reviewsList);
}
