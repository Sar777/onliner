package by.orion.onlinertasks.common.network.services;

import android.support.annotation.NonNull;

import java.util.List;

import by.orion.onlinertasks.data.models.profile.ProfilesPage;
import by.orion.onlinertasks.data.models.profile.details.Profile;
import by.orion.onlinertasks.data.models.regions.Region;
import by.orion.onlinertasks.data.models.task.TasksPage;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface BaseService {

    @GET("tasks")
    Single<TasksPage> getAllTasks(@Query("page") @NonNull Integer page);

    @GET("profiles")
    Single<ProfilesPage> getAllProfiles(@Query("page") @NonNull Integer page);

    @GET("profiles/{id}")
    Single<Profile> getProfile(@Path("id") @NonNull Integer id);

    @GET("regions")
    Single<List<Region>> getRegions();
}
