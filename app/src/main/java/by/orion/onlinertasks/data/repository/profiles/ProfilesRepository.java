package by.orion.onlinertasks.data.repository.profiles;

import android.support.annotation.NonNull;

import by.orion.onlinertasks.data.models.common.requests.ProfilesRequestParams;
import by.orion.onlinertasks.data.models.profile.ProfilesPage;
import by.orion.onlinertasks.data.repository.Repository;
import io.reactivex.Single;

public interface ProfilesRepository extends Repository {

    Single<ProfilesPage> getAllProfiles(@NonNull ProfilesRequestParams params);
}
