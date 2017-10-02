package by.orion.onlinertasks.presentation.profile.details;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;

import butterknife.BindView;
import butterknife.ButterKnife;
import by.orion.onlinertasks.App;
import by.orion.onlinertasks.R;
import by.orion.onlinertasks.common.exceptions.BaseError;
import by.orion.onlinertasks.di.components.presentation.DaggerProfileDetailsPresenterComponent;
import by.orion.onlinertasks.di.components.presentation.ProfileDetailsPresenterComponent;
import by.orion.onlinertasks.di.modules.presentation.ProfileDetailsPresenterModule;
import by.orion.onlinertasks.presentation.profile.details.adapters.ProfileDetailsPageAdapter;

public class ProfileDetailsActivity extends AppCompatActivity implements ProfileDetailsView {

    @NonNull
    private static final String EXTRA_PROFILE_ID = "EXTRA_PROFILE_ID";

    @BindView(R.id.toolbar_profile_details)
    Toolbar toolbar;

    @BindView(R.id.viewpager_profile_details)
    ViewPager viewPager;

    @BindView(R.id.tablayout_profile_details)
    TabLayout tabLayout;

    @BindView(R.id.imageview_profile_details_background)
    ImageView imageViewBackground;

    @BindView(R.id.imageview_profile_details_avatar)
    ImageView imageViewAvatar;

    @InjectPresenter
    ProfileDetailsPresenter presenter;

    private ProfileDetailsPageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_details);

        ButterKnife.bind(this);

        initToolbar();
        initView();
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showError(@NonNull BaseError error) {

    }

    @Override
    public void hideError() {

    }

    @Override
    public void setBackground(@NonNull String imageUrl) {
        Glide.with(this)
                .load(imageUrl)
                .into(imageViewBackground);
    }

    @Override
    public void setAvatar(@NonNull String imageUrl) {
        Glide.with(this)
                .load(imageUrl)
                .apply(new RequestOptions().transform(new CircleCrop()))
                .into(imageViewAvatar);
    }

    private void initToolbar() {
        setSupportActionBar(toolbar);
    }

    private void initView() {
        Integer id = getIntent().getIntExtra(EXTRA_PROFILE_ID, 0);
        adapter = new ProfileDetailsPageAdapter(this, id, getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);
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
