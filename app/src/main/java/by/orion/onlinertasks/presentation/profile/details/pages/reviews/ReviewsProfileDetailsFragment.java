package by.orion.onlinertasks.presentation.profile.details.pages.reviews;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import by.orion.onlinertasks.App;
import by.orion.onlinertasks.R;
import by.orion.onlinertasks.common.exceptions.BaseError;
import by.orion.onlinertasks.di.components.presentation.DaggerReviewsProfileDetailsPresenterComponent;
import by.orion.onlinertasks.di.components.presentation.ReviewsProfileDetailsPresenterComponent;
import by.orion.onlinertasks.di.modules.presentation.ReviewsProfileDetailsPresenterModule;

public class ReviewsProfileDetailsFragment extends MvpAppCompatFragment implements ReviewsProfileDetailsView {

    @NonNull
    private static final String BUNDLE_PROFILE_ID = "BUNDLE_PROFILE_ID";

    @BindView(R.id.progressbar_profile_details_reviews)
    ProgressBar progressBar;

    @InjectPresenter
    ReviewsProfileDetailsPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile_details_reviews, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showError(@NonNull BaseError error) {

    }

    @Override
    public void hideError() {

    }

    @NonNull
    @ProvidePresenter
    ReviewsProfileDetailsPresenter providePresenter() {
        Integer id = getArguments().getInt(BUNDLE_PROFILE_ID);

        ReviewsProfileDetailsPresenterComponent reviewsProfileDetailsPresenterComponent = DaggerReviewsProfileDetailsPresenterComponent.builder()
                .applicationComponent(App.getComponent())
                .reviewsProfileDetailsPresenterModule(new ReviewsProfileDetailsPresenterModule(id))
                .build();

        return reviewsProfileDetailsPresenterComponent.getPresenter();
    }

    @NonNull
    public static Fragment newInstance(@NonNull Integer id) {
        Fragment fragment = new ReviewsProfileDetailsFragment();

        Bundle bundle = new Bundle();
        bundle.putInt(BUNDLE_PROFILE_ID, id);

        fragment.setArguments(bundle);
        return fragment;
    }
}
