package by.orion.onlinernews.presentation.splash;

import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import by.orion.onlinernews.presentation.BaseMvpView;

public interface SplashView extends BaseMvpView {

    @StateStrategyType(OneExecutionStateStrategy.class)
    void goToMainScreen();
}
