package by.orion.onlinertasks.presentation.main;

import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import by.orion.onlinertasks.presentation.BaseMvpView;

@StateStrategyType(OneExecutionStateStrategy.class)
public interface MainView extends BaseMvpView {

    void showAllTasks();

    void showAllProfiles();
}
