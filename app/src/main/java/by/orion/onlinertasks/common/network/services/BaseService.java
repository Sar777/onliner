package by.orion.onlinertasks.common.network.services;

import by.orion.onlinertasks.data.models.profile.ProfilesPage;
import by.orion.onlinertasks.data.models.task.TasksPage;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BaseService {

    @GET("tasks")
    Single<TasksPage> getAllTasks(@Query("page") int page);

    @GET("profiles")
    Single<ProfilesPage> getAllProfiles(@Query("page") int page);
}
