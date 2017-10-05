package by.orion.onlinertasks.presentation.profile.details.pages.reviews;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.List;

import javax.inject.Inject;

import by.orion.onlinertasks.common.exceptions.errors.UnknownError;
import by.orion.onlinertasks.data.models.common.requests.ProfileReviewsRequestParams;
import by.orion.onlinertasks.domain.interactors.ReviewsProfileDetailsInteractor;
import by.orion.onlinertasks.presentation.common.rx.RxSchedulersProvider;
import by.orion.onlinertasks.presentation.profile.details.pages.reviews.models.ReviewItem;

@InjectViewState
public class ReviewsProfileDetailsPresenter extends MvpPresenter<ReviewsProfileDetailsView> {

    @NonNull
    private final Integer id;

    @NonNull
    private final RxSchedulersProvider rxSchedulersProvider;

    @NonNull
    private final ReviewsProfileDetailsInteractor reviewsProfileDetailsInteractor;

    @Inject
    public ReviewsProfileDetailsPresenter(@NonNull Integer id, @NonNull RxSchedulersProvider rxSchedulersProvider, @NonNull ReviewsProfileDetailsInteractor reviewsProfileDetailsInteractor) {
        this.id = id;
        this.rxSchedulersProvider = rxSchedulersProvider;
        this.reviewsProfileDetailsInteractor = reviewsProfileDetailsInteractor;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();

        getViewState().showProgress();
        getViewState().hideReviews();

        reviewsProfileDetailsInteractor.getProfileReviews(ProfileReviewsRequestParams.builder().id(id).build())
                .compose(rxSchedulersProvider.getIoToMainTransformerSingle())
                .subscribe(this::onProfileReviewsSuccess, this::onProfileReviewsError);
    }

    private void onProfileReviewsSuccess(@NonNull List<ReviewItem> reviewsItems) {
        getViewState().hideProgress();
        getViewState().setReviews(reviewsItems);
        getViewState().showReviews();
    }

    private void onProfileReviewsError(@NonNull Throwable throwable) {
        getViewState().hideProgress();
        getViewState().showError(new UnknownError());
    }
}
