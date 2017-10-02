package by.orion.onlinertasks.presentation.login;

import android.support.annotation.StringRes;

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import by.orion.onlinertasks.presentation.BaseMvpView;

public interface LoginView extends BaseMvpView {

    String TAG_USERNAME_ERROR = "TAG_USERNAME_ERROR";
    String TAG_PASSWORD_ERROR = "TAG_PASSWORD_ERROR";

    @StateStrategyType(value = AddToEndSingleStrategy.class, tag = TAG_USERNAME_ERROR)
    void showUsernameError(@StringRes int errorId);

    @StateStrategyType(value = AddToEndSingleStrategy.class, tag = TAG_USERNAME_ERROR)
    void hideUsernameError();

    @StateStrategyType(value = AddToEndSingleStrategy.class, tag = TAG_PASSWORD_ERROR)
    void showPasswordError(@StringRes int errorId);

    @StateStrategyType(value = AddToEndSingleStrategy.class, tag = TAG_PASSWORD_ERROR)
    void hidePasswordError();

    @StateStrategyType(OneExecutionStateStrategy.class)
    void goToMainScreen();
}
