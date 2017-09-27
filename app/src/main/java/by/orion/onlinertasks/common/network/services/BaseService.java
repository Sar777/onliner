package by.orion.onlinertasks.common.network.services;

import android.support.annotation.NonNull;

import java.util.List;

import by.orion.onlinertasks.data.models.profile.ProfilesPage;
import by.orion.onlinertasks.data.models.profile.details.Profile;
import by.orion.onlinertasks.data.models.profile.reviews.ProfileReviewsPage;
import by.orion.onlinertasks.data.models.regions.Region;
import by.orion.onlinertasks.data.models.sections.Section;
import by.orion.onlinertasks.data.models.sections.Sections;
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

    @GET("profiles/{id}/reviews")
    Single<ProfileReviewsPage> getProfileReviews(@Path("id") @NonNull Integer id, @Query("page") @NonNull Integer page, @Query("role") @NonNull String role);

    @GET("regions")
    Single<List<Region>> getRegions();

    @GET("sections")
    Single<Sections> getSections();

    @GET("sections/{id}")
    Single<Section> getSection(@Path("id") @NonNull Integer id);

    @GET("sections?include=categories")
    Single<Sections> getSectionsWithCategories();
}
