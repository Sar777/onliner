package by.orion.onlinertasks.presentation.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import by.orion.onlinertasks.App;
import by.orion.onlinertasks.R;
import by.orion.onlinertasks.common.utils.FragmentUtils;
import by.orion.onlinertasks.di.components.presentation.DaggerMainPresenterComponent;
import by.orion.onlinertasks.di.components.presentation.MainPresenterComponent;
import by.orion.onlinertasks.di.modules.presentation.MainPresenterModule;
import by.orion.onlinertasks.presentation.common.models.MenuOption;
import by.orion.onlinertasks.presentation.main.fragments.profiles.ProfilesFragment;
import by.orion.onlinertasks.presentation.main.fragments.tasks.TasksFragment;

public class MainActivity extends MvpAppCompatActivity implements MainView, NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.toolbar_main)
    Toolbar toolbar;

    @BindView(R.id.drawer_layout_main)
    DrawerLayout drawerLayout;

    @BindView(R.id.nav_view_main)
    NavigationView navigationView;

    @BindView(R.id.layout_content_main)
    ViewGroup viewGroupRoot;

    @InjectPresenter
    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        initToolbar();
        initView();
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        displayScreen(item);
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
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

    @Override
    public void showAllTasks() {
        FragmentUtils.replaceFragment(TasksFragment.newInstance(), getSupportFragmentManager(), R.id.layout_content_main, null);
    }

    @Override
    public void showAllProfiles() {
        FragmentUtils.replaceFragment(ProfilesFragment.newInstance(), getSupportFragmentManager(), R.id.layout_content_main, null);
    }

    private void initToolbar() {
        setSupportActionBar(toolbar);
    }

    private void initView() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
    }

    private void displayScreen(@NonNull MenuItem item) {
        MenuOption option;
        switch (item.getItemId()) {
            case R.id.nav_all_tasks:
                option = MenuOption.ALL_TASKS;
                break;
            case R.id.nav_all_profiles:
                option = MenuOption.ALL_PROFILES;
                break;
            default:
                throw new UnsupportedOperationException("Unknown menu: " + item.getTitle());
        }

        presenter.onClickMenu(option);
        toolbar.setTitle(item.getTitle());
    }

    @ProvidePresenter
    MainPresenter providePresenter() {
        MainPresenterComponent mainPresenterComponent = DaggerMainPresenterComponent.builder()
                .applicationComponent(App.getComponent())
                .mainPresenterModule(new MainPresenterModule())
                .build();

        return mainPresenterComponent.getPresenter();
    }

    @NonNull
    public static Intent newIntent(@NonNull Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        return intent;
    }
}
