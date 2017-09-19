package by.orion.onlinertasks.presentation.splash;

import android.os.Bundle;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import by.orion.onlinertasks.App;
import by.orion.onlinertasks.R;
import by.orion.onlinertasks.di.components.presentation.DaggerSplashPresenterComponent;
import by.orion.onlinertasks.di.components.presentation.SplashPresenterComponent;
import by.orion.onlinertasks.di.modules.presentation.SplashPresenterModule;
import by.orion.onlinertasks.presentation.main.MainActivity;

public class SplashActivity extends MvpAppCompatActivity implements SplashView {

    @InjectPresenter
    SplashPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
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
