package by.orion.onlinertasks.data.repository.profile;

import android.support.annotation.NonNull;

import by.orion.onlinertasks.data.models.common.requests.ProfileDetailsRequestParams;
import by.orion.onlinertasks.data.models.profile.details.Profile;
import by.orion.onlinertasks.data.repository.Repository;
import io.reactivex.Single;

public interface ProfileDetailsRepository extends Repository {

    Single<Profile> getProfile(@NonNull ProfileDetailsRequestParams params);
}
