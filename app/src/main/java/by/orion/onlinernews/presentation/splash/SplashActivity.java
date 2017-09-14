package by.orion.onlinernews.presentation.splash;

import android.os.Bundle;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import by.orion.onlinernews.App;
import by.orion.onlinernews.R;
import by.orion.onlinernews.di.components.presentation.DaggerSplashPresenterComponent;
import by.orion.onlinernews.di.components.presentation.SplashPresenterComponent;
import by.orion.onlinernews.di.modules.presentation.SplashPresenterModule;
import by.orion.onlinernews.presentation.main.MainActivity;
import hugo.weaving.DebugLog;

public class SplashActivity extends MvpAppCompatActivity implements SplashView {

    @InjectPresenter
    SplashPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    @DebugLog
    @Override
    public void showError() {

    }

    @DebugLog
    @Override
    public void hideError() {

    }

    @DebugLog
    @Override
    public void goToMainScreen() {
        startActivity(MainActivity.newIntent(this));
    }

    @ProvidePresenter
    SplashPresenter providePresenter() {
        SplashPresenterComponent splashPresenterComponent = DaggerSplashPresenterComponent.builder()
                .applicationComponent(App.getComponent())
                .splashPresenterModule(new SplashPresenterModule())
                .build();

        return splashPresenterComponent.getPresenter();
    }
}
