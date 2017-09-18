package by.orion.onlinertasks.presentation.main.fragments;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import java.util.List;

import by.orion.onlinertasks.presentation.BaseMvpView;
import by.orion.onlinertasks.presentation.main.fragments.models.TaskItem;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface TasksView extends BaseMvpView {

    String TAG_PROGRESS = "TAG_PROGRESS";
    String TAG_TASK = "TAG_TASK";

    @StateStrategyType(value = AddToEndSingleStrategy.class, tag = TAG_PROGRESS)
    void showProgress();

    @StateStrategyType(value = AddToEndSingleStrategy.class, tag = TAG_PROGRESS)
    void hideProgress();

    @StateStrategyType(value = AddToEndSingleStrategy.class, tag = TAG_TASK)
    void showTasks();

    @StateStrategyType(value = AddToEndSingleStrategy.class, tag = TAG_TASK)
    void hideTasks();

    void addTasks(@NonNull List<TaskItem> tasks);
}
