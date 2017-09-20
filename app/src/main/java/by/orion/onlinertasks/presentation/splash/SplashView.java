package by.orion.onlinertasks.presentation.splash;

import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import by.orion.onlinertasks.presentation.BaseMvpView;

public interface SplashView extends BaseMvpView {

    @StateStrategyType(OneExecutionStateStrategy.class)
    void goToMainScreen();

    @StateStrategyType(OneExecutionStateStrategy.class)
    void goToIntroductionScreen();
}
