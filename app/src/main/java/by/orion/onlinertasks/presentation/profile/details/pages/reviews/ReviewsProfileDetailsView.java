package by.orion.onlinertasks.presentation.profile.details.pages.reviews;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import java.util.List;

import by.orion.onlinertasks.presentation.BaseMvpView;
import by.orion.onlinertasks.presentation.profile.details.pages.reviews.models.ReviewItem;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface ReviewsProfileDetailsView extends BaseMvpView {

    void addReviews(@NonNull List<ReviewItem> reviewsList);
}
