package by.orion.onlinertasks.data.repository.tasks;

import android.support.annotation.NonNull;

import javax.inject.Inject;

import by.orion.onlinertasks.data.datasource.tasks.TasksDataSource;
import by.orion.onlinertasks.data.models.common.requests.TasksRequestParams;
import by.orion.onlinertasks.data.models.task.TasksPage;
import by.orion.onlinertasks.di.qualifiers.LocalDataSource;
import by.orion.onlinertasks.di.qualifiers.RemoteDataSource;
import io.reactivex.Single;

public class TasksRepositoryImpl implements TasksRepository {

    @NonNull
    private final TasksDataSource localDataSource;

    @NonNull
    private final TasksDataSource remoteDataSource;

    @Inject
    public TasksRepositoryImpl(@NonNull @LocalDataSource TasksDataSource localDataSource,
                               @NonNull @RemoteDataSource TasksDataSource remoteDataSource) {
        this.localDataSource = localDataSource;
        this.remoteDataSource = remoteDataSource;
    }

    @Override
    public Single<TasksPage> getAllTasks(@NonNull TasksRequestParams params) {
        return remoteDataSource.getAllTasks(params);
    }
}
