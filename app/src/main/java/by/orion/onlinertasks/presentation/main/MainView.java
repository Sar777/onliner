package by.orion.onlinertasks.presentation.main;

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import by.orion.onlinertasks.presentation.BaseMvpView;

@StateStrategyType(OneExecutionStateStrategy.class)
public interface MainView extends BaseMvpView {

    String TAG_LOGIN_BUTTON = "TAG_LOGIN_BUTTON";

    void showAllTasks();

    void showAllProfiles();

    void goToLoginScreen();

    @StateStrategyType(value = AddToEndSingleStrategy.class, tag = TAG_LOGIN_BUTTON)
    void showLoginButton();

    @StateStrategyType(value = AddToEndSingleStrategy.class, tag = TAG_LOGIN_BUTTON)
    void hideLoginButton();
}
