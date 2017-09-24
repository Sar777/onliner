package by.orion.onlinertasks.presentation.main.fragments.profiles;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import by.orion.onlinertasks.App;
import by.orion.onlinertasks.R;
import by.orion.onlinertasks.common.adapters.EndlessScrollListener;
import by.orion.onlinertasks.di.components.presentation.DaggerProfilesPresenterComponent;
import by.orion.onlinertasks.di.components.presentation.ProfilesPresenterComponent;
import by.orion.onlinertasks.di.modules.presentation.ProfilesPresenterModule;
import by.orion.onlinertasks.presentation.main.fragments.profiles.adapters.ProfilesAdapter;
import by.orion.onlinertasks.presentation.main.fragments.profiles.models.ProfileItem;
import by.orion.onlinertasks.presentation.profile.details.ProfileDetailsActivity;

public class ProfilesFragment extends MvpAppCompatFragment implements ProfilesView {

    @BindView(R.id.progressbar_all_profiles)
    ProgressBar progressBar;

    @BindView(R.id.recycler_all_profiles)
    RecyclerView recyclerView;

    @InjectPresenter
    ProfilesPresenter presenter;

    private ProfilesAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_all_profiles, container, false);
        ButterKnife.bind(this, view);

        initView();
        return view;
    }

    @Override
    public void showError() {

    }

    @Override
    public void hideError() {

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
    public void showProfiles() {
        recyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProfiles() {
        recyclerView.setVisibility(View.GONE);
    }

    @Override
    public void addProfiles(@NonNull List<ProfileItem> tasks) {
        adapter.addAll(tasks);
    }

    @Override
    public void enableLoadMoreProfiles() {
        recyclerView.addOnScrollListener(new EndlessScrollListener() {
            @Override
            protected void loadMore() {
                adapter.addItem(null);
                presenter.onLoadMoreProfilesRequest();
            }
        });
    }

    @Override
    public void disableLoadMoreProfiles() {
        recyclerView.clearOnScrollListeners();
    }

    @Override
    public void goToProfileDetails(@NonNull Integer id) {
        startActivity(ProfileDetailsActivity.newIntent(getContext(), id));
    }

    @NonNull
    @ProvidePresenter
    ProfilesPresenter providePresenter() {
        ProfilesPresenterComponent profilesPresenterComponent = DaggerProfilesPresenterComponent.builder()
                .applicationComponent(App.getComponent())
                .profilesPresenterModule(new ProfilesPresenterModule())
                .build();

        return profilesPresenterComponent.getPresenter();
    }

    private void initView() {
        adapter = new ProfilesAdapter(id -> presenter.onProfileClick(id));
        adapter.setHasStableIds(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
    }

    @NonNull
    public static ProfilesFragment newInstance() {
        return new ProfilesFragment();
    }
}
