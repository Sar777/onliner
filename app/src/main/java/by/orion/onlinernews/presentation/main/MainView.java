package by.orion.onlinernews.presentation.main;

import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import by.orion.onlinernews.presentation.BaseMvpView;

@StateStrategyType(OneExecutionStateStrategy.class)
public interface MainView extends BaseMvpView {

    void showPeople();

    void showOpinions();

    void showAuto();

    void showTech();

    void showRealt();
}
