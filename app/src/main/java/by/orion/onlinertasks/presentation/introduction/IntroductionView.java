package by.orion.onlinertasks.presentation.introduction;

import android.support.annotation.StringRes;

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import by.orion.onlinertasks.presentation.BaseMvpView;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface IntroductionView extends BaseMvpView {

    String TAG_BUTTON_SKIP = "TAG_BUTTON_SKIP";

    void setCurrentDot(int page);

    void selectPage(int page);

    void setButtonNextText(@StringRes int resId);

    @StateStrategyType(value = AddToEndSingleStrategy.class, tag = TAG_BUTTON_SKIP)
    void showButtonSkip();

    @StateStrategyType(value = AddToEndSingleStrategy.class, tag = TAG_BUTTON_SKIP)
    void hideButtonSkip();

    @StateStrategyType(OneExecutionStateStrategy.class)
    void goToMainScreen();
}
