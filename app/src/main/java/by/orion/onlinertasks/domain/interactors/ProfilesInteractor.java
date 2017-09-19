package by.orion.onlinertasks.domain.interactors;

import android.support.annotation.NonNull;

import javax.inject.Inject;

import by.orion.onlinertasks.data.models.requests.ProfilesRequestParams;
import by.orion.onlinertasks.data.repository.profiles.ProfilesRepository;
import by.orion.onlinertasks.presentation.main.fragments.profiles.mappers.ListProfileToListProfileItemMapper;
import by.orion.onlinertasks.presentation.main.fragments.profiles.models.ProfilePage;
import io.reactivex.Single;

public class ProfilesInteractor {

    @NonNull
    private final ProfilesRepository profilesRepository;

    @NonNull
    private final ListProfileToListProfileItemMapper listProfileToListProfileItemMapper;

    @Inject
    public ProfilesInteractor(@NonNull ProfilesRepository profilesRepository,
                              @NonNull ListProfileToListProfileItemMapper listProfileToListProfileItemMapper) {
        this.profilesRepository = profilesRepository;
        this.listProfileToListProfileItemMapper = listProfileToListProfileItemMapper;
    }

    public Single<ProfilePage> getAllProfiles(@NonNull ProfilesRequestParams params) {
        return profilesRepository.getAllProfiles(params)
                .map(profilesPage -> ProfilePage.builder()
                                            .page(profilesPage.page().current())
                                            .lastPage(profilesPage.total())
                                            .profiles(listProfileToListProfileItemMapper.map(profilesPage.profiles()))
                                            .build());
    }
}
