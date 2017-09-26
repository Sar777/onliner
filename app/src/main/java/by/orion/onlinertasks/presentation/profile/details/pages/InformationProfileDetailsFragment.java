package by.orion.onlinertasks.presentation.profile.details.pages;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import by.orion.onlinertasks.App;
import by.orion.onlinertasks.R;
import by.orion.onlinertasks.di.components.presentation.DaggerInformationProfileDetailsPresenterComponent;
import by.orion.onlinertasks.di.components.presentation.InformationProfileDetailsPresenterComponent;
import by.orion.onlinertasks.di.modules.presentation.InformationProfileDetailsPresenterModule;

public class InformationProfileDetailsFragment extends MvpAppCompatFragment implements InformationProfileDetailsView {

    @NonNull
    private static final String BUNDLE_PROFILE_ID = "BUNDLE_PROFILE_ID";

    @BindView(R.id.progressbar_profile_details_information)
    ProgressBar progressBar;

    @BindView(R.id.layout_profile_details_information)
    ViewGroup viewGroupRoot;

    @BindView(R.id.textview_profile_details_inf_description)
    TextView textViewDescription;

    @BindView(R.id.textview_profile_details_inf_location)
    TextView textViewLocation;

    @InjectPresenter
    InformationProfileDetailsPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile_details_information, container, false);
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
    public void showError() {

    }

    @Override
    public void hideError() {

    }

    @Override
    public void showDetailsLayout() {
        viewGroupRoot.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideDetailsLayout() {
        viewGroupRoot.setVisibility(View.GONE);
    }

    @Override
    public void setDescription(@NonNull String description) {
        textViewDescription.setText(description);
    }

    @Override
    public void setLocation(@NonNull String location) {
        textViewLocation.setText(location);
    }

    @NonNull
    @ProvidePresenter
    InformationProfileDetailsPresenter providePresenter() {
        Integer id = getArguments().getInt(BUNDLE_PROFILE_ID);

        InformationProfileDetailsPresenterComponent informationProfileDetailsPresenterComponent = DaggerInformationProfileDetailsPresenterComponent.builder()
                .applicationComponent(App.getComponent())
                .informationProfileDetailsPresenterModule(new InformationProfileDetailsPresenterModule(id))
                .build();

        return informationProfileDetailsPresenterComponent.getPresenter();
    }

    @NonNull
    public static Fragment newInstance(@NonNull Integer id) {
        Fragment fragment = new InformationProfileDetailsFragment();

        Bundle bundle = new Bundle();
        bundle.putInt(BUNDLE_PROFILE_ID, id);

        fragment.setArguments(bundle);
        return fragment;
    }
}
