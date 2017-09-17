package by.orion.onlinertasks.data.datasource.tasks.local;

import android.support.annotation.NonNull;

import com.pushtorefresh.storio.sqlite.StorIOSQLite;

import java.util.List;

import javax.inject.Inject;

import by.orion.onlinertasks.data.datasource.tasks.TasksDataSource;
import by.orion.onlinertasks.data.models.task.Task;
import by.orion.onlinertasks.data.models.task.TasksPage;
import by.orion.onlinertasks.data.models.task.TasksRequestParams;
import io.reactivex.Completable;
import io.reactivex.Single;

public class LocalTasksDataSource implements TasksDataSource {

    @NonNull
    private final StorIOSQLite storIOSQLite;

    @Inject
    public LocalTasksDataSource(@NonNull StorIOSQLite storIOSQLite) {
        this.storIOSQLite = storIOSQLite;
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
        return null;
    }

    @Override
    public Single<List<Task>> saveAllTasks(@NonNull List<Task> tasks) {
        return null;
    }
}
