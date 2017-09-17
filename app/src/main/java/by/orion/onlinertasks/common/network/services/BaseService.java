package by.orion.onlinertasks.common.network.services;

import by.orion.onlinertasks.data.models.task.TasksPage;
import io.reactivex.Single;
import retrofit2.http.GET;

public interface BaseService {

    @GET("tasks")
    Single<TasksPage> getAllTasks();
}
