package by.orion.onlinertasks.presentation.profile.details;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import by.orion.onlinertasks.App;
import by.orion.onlinertasks.R;
import by.orion.onlinertasks.di.components.presentation.DaggerProfileDetailsPresenterComponent;
import by.orion.onlinertasks.di.components.presentation.ProfileDetailsPresenterComponent;
import by.orion.onlinertasks.di.modules.presentation.ProfileDetailsPresenterModule;

public class ProfileDetailsActivity extends AppCompatActivity implements ProfileDetailsView {

    @NonNull
    private static final String EXTRA_PROFILE_ID = "EXTRA_PROFILE_ID";

    @InjectPresenter
    ProfileDetailsPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_details);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showError() {

    }

    @Override
    public void hideError() {

    }

    @NonNull
    @ProvidePresenter
    ProfileDetailsPresenter providePresenter() {
        Integer id = getIntent().getIntExtra(EXTRA_PROFILE_ID, 0);

        ProfileDetailsPresenterComponent profileDetailsPresenterComponent = DaggerProfileDetailsPresenterComponent.builder()
                .applicationComponent(App.getComponent())
                .profileDetailsPresenterModule(new ProfileDetailsPresenterModule(id))
                .build();

        return profileDetailsPresenterComponent.getPresenter();
    }

    @NonNull
    public static Intent newIntent(@NonNull Context context, @NonNull Integer id) {
        Intent intent = new Intent(context, ProfileDetailsActivity.class);
        intent.putExtra(EXTRA_PROFILE_ID, id);
        return intent;
    }
}
