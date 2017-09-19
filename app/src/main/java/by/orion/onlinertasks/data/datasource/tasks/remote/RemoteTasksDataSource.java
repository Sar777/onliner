package by.orion.onlinertasks.data.datasource.tasks.remote;

import android.support.annotation.NonNull;

import java.util.List;

import javax.inject.Inject;

import by.orion.onlinertasks.common.network.services.BaseService;
import by.orion.onlinertasks.data.datasource.tasks.TasksDataSource;
import by.orion.onlinertasks.data.models.task.Task;
import by.orion.onlinertasks.data.models.task.TasksPage;
import by.orion.onlinertasks.data.models.requests.TasksRequestParams;
import io.reactivex.Completable;
import io.reactivex.Single;

public class RemoteTasksDataSource implements TasksDataSource {

    @NonNull
    private final BaseService service;

    @Inject
    public RemoteTasksDataSource(@NonNull BaseService service) {
        this.service = service;
    }

    @Override
    public Single<Task> getValue(@NonNull Integer key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Completable setValue(@NonNull Integer key, @NonNull Task value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Single<TasksPage> getAllTasks(@NonNull TasksRequestParams params) {
        return service.getAllTasks(params.page());
    }

    @Override
    public Single<List<Task>> saveAllTasks(@NonNull List<Task> tasks) {
        throw new UnsupportedOperationException();
    }
}
