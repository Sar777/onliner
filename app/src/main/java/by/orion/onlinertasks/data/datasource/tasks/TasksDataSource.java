package by.orion.onlinertasks.data.datasource.tasks;

import android.support.annotation.NonNull;

import java.util.List;

import by.orion.onlinertasks.data.datasource.DataSource;
import by.orion.onlinertasks.data.models.task.Task;
import by.orion.onlinertasks.data.models.task.TasksPage;
import by.orion.onlinertasks.data.models.task.TasksRequestParams;
import io.reactivex.Single;

public interface TasksDataSource extends DataSource<Integer, Task> {

    Single<TasksPage> getAllTasks(@NonNull TasksRequestParams params);

    Single<List<Task>> saveAllTasks(@NonNull List<Task> tasks);
}
