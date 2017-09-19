package by.orion.onlinertasks.presentation.main.fragments.tasks;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import java.util.List;

import by.orion.onlinertasks.presentation.BaseMvpView;
import by.orion.onlinertasks.presentation.main.fragments.tasks.models.TaskItem;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface TasksView extends BaseMvpView {

    String TAG_TASK = "TAG_TASK";
    String TAG_LOAD_MORE_TASKS = "TAG_LOAD_MORE_TASKS";

    @StateStrategyType(value = AddToEndSingleStrategy.class, tag = TAG_TASK)
    void showTasks();

    @StateStrategyType(value = AddToEndSingleStrategy.class, tag = TAG_TASK)
    void hideTasks();

    void addTasks(@NonNull List<TaskItem> tasks);

    @StateStrategyType(value = AddToEndSingleStrategy.class, tag = TAG_LOAD_MORE_TASKS)
    void enableLoadMoreTasks();

    @StateStrategyType(value = AddToEndSingleStrategy.class, tag = TAG_LOAD_MORE_TASKS)
    void disableLoadMoreTasks();
}
