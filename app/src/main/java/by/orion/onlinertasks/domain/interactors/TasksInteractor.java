package by.orion.onlinertasks.domain.interactors;

import android.support.annotation.NonNull;

import javax.inject.Inject;

import by.orion.onlinertasks.data.models.task.TasksPage;
import by.orion.onlinertasks.data.models.task.TasksRequestParams;
import by.orion.onlinertasks.data.repository.tasks.TasksRepository;
import by.orion.onlinertasks.presentation.main.fragments.mappers.ListTaskToListTaskItemMapper;
import io.reactivex.Single;

public class TasksInteractor {

    @NonNull
    private final TasksRepository tasksRepository;

    @NonNull
    private final ListTaskToListTaskItemMapper listTaskToListTaskItemMapper;

    @Inject
    public TasksInteractor(@NonNull TasksRepository tasksRepository,
                           @NonNull ListTaskToListTaskItemMapper listTaskToListTaskItemMapper) {
        this.tasksRepository = tasksRepository;
        this.listTaskToListTaskItemMapper = listTaskToListTaskItemMapper;
    }

    public Single<TasksPage> getAllTasks(@NonNull TasksRequestParams params) {
        return tasksRepository.getAllTasks(params);
    }
}
