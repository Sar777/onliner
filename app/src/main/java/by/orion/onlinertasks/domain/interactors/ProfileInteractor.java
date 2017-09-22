package by.orion.onlinertasks.domain.interactors;

import android.support.annotation.NonNull;

import javax.inject.Inject;

import by.orion.onlinertasks.data.models.profile.details.Profile;
import by.orion.onlinertasks.data.models.requests.ProfileRequestParams;
import by.orion.onlinertasks.data.repository.profile.ProfileRepository;
import io.reactivex.Single;

public class ProfileInteractor {

    @NonNull
    private final ProfileRepository profileRepository;

    @Inject
    public ProfileInteractor(@NonNull ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public Single<Profile> getProfile(@NonNull ProfileRequestParams params) {
        return profileRepository.getProfile(params);
    }
}
