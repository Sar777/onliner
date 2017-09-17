package by.orion.onlinertasks.domain.interactors;

import android.support.annotation.NonNull;

import javax.inject.Inject;

import by.orion.onlinertasks.data.models.task.TasksPage;
import by.orion.onlinertasks.data.models.task.TasksRequestParams;
import by.orion.onlinertasks.data.repository.tasks.TasksRepository;
import io.reactivex.Single;

public class TasksInteractor {

    @NonNull
    private final TasksRepository tasksRepository;

    @Inject
    public TasksInteractor(@NonNull TasksRepository tasksRepository) {
        this.tasksRepository = tasksRepository;
    }

    public Single<TasksPage> getAllTasks(@NonNull TasksRequestParams params) {
        return tasksRepository.getAllTasks(params);
    }
}
