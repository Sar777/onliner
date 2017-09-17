package by.orion.onlinertasks.data.repository.tasks;

import android.support.annotation.NonNull;

import by.orion.onlinertasks.data.models.task.TasksPage;
import by.orion.onlinertasks.data.models.task.TasksRequestParams;
import by.orion.onlinertasks.data.repository.Repository;
import io.reactivex.Single;

public interface TasksRepository extends Repository {

    Single<TasksPage> getAllTasks(@NonNull TasksRequestParams params);
}
