package by.orion.onlinertasks.domain.interactors;

import android.support.annotation.NonNull;

import javax.inject.Inject;

import by.orion.onlinertasks.data.models.common.requests.TasksRequestParams;
import by.orion.onlinertasks.data.repository.tasks.TasksRepository;
import by.orion.onlinertasks.presentation.main.fragments.tasks.mappers.ListTaskToListTaskItemMapper;
import by.orion.onlinertasks.presentation.main.fragments.tasks.models.TaskPage;
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

    public Single<TaskPage> getAllTasks(@NonNull TasksRequestParams params) {
        return tasksRepository.getAllTasks(params)
                .map(tasksPage -> TaskPage.builder()
                                            .page(tasksPage.page().current())
                                            .lastPage(tasksPage.total())
                                            .tasks(listTaskToListTaskItemMapper.map(tasksPage.tasks()))
                                            .build());
    }
}
