package by.orion.onlinertasks.presentation.profile.details.pages.mappers;

import android.support.annotation.NonNull;

import javax.inject.Inject;

import by.orion.onlinertasks.common.GenericObjectMapper;
import by.orion.onlinertasks.data.models.profile.details.Profile;
import by.orion.onlinertasks.presentation.profile.details.pages.models.ProfileDetailsInformation;

public class ProfileToProfileDetailsInformationMapper implements GenericObjectMapper<Profile, ProfileDetailsInformation> {

    @Inject
    public ProfileToProfileDetailsInformationMapper() {
    }

    @NonNull
    @Override
    public ProfileDetailsInformation map(@NonNull Profile profile) {
        return ProfileDetailsInformation.builder()
                .id(profile.id())
                .description(profile.description())
                .build();
    }
}
