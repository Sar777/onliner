package by.orion.onlinertasks.domain.interactors;

import android.support.annotation.NonNull;

import javax.inject.Inject;

import by.orion.onlinertasks.data.models.common.requests.ProfileDetailsRequestParams;
import by.orion.onlinertasks.data.models.profile.details.Profile;
import by.orion.onlinertasks.data.repository.profile.ProfileDetailsRepository;
import io.reactivex.Single;

public class ProfileDetailsInteractor {

    @NonNull
    private final ProfileDetailsRepository profileDetailsRepository;

    @Inject
    public ProfileDetailsInteractor(@NonNull ProfileDetailsRepository profileDetailsRepository) {
        this.profileDetailsRepository = profileDetailsRepository;
    }

    public Single<Profile> getProfile(@NonNull ProfileDetailsRequestParams params) {
        return profileDetailsRepository.getProfile(params);
    }
}
