package by.orion.onlinertasks.presentation.profile.details.pages.information.mappers;

import android.content.Context;
import android.support.annotation.NonNull;

import java.util.List;

import javax.inject.Inject;

import by.orion.onlinertasks.common.GenericObjectMapper;
import by.orion.onlinertasks.common.triple.ImmutableTriple;
import by.orion.onlinertasks.data.models.profile.details.Executor;
import by.orion.onlinertasks.data.models.profile.details.Profile;
import by.orion.onlinertasks.data.models.regions.Region;
import by.orion.onlinertasks.data.models.sections.Sections;
import by.orion.onlinertasks.presentation.profile.details.pages.information.models.ProfileDetailsInformation;

public class ProfileToProfileDetailsInformationMapper implements GenericObjectMapper<ImmutableTriple<Profile, List<Region>, Sections>, ProfileDetailsInformation> {

    @NonNull
    private final Context context;

    @Inject
    public ProfileToProfileDetailsInformationMapper(@NonNull Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ProfileDetailsInformation map(@NonNull ImmutableTriple<Profile, List<Region>, Sections> triple) {
        Profile profile = triple.getLeft();
        List<Region> regions = triple.getMiddle();
        Sections sections = triple.getRight();

        ProfileDetailsInformation.Builder builder = ProfileDetailsInformation.builder();

        builder.id(profile.id());
        builder.description(profile.description());

        Executor executor = profile.executor();
        if (executor != null) {
            builder.executor_location(new ProfileExecutorLocationToProfileDetailsInformationLocation(context, executor.regions()).map(regions));
        }

        return builder.build();
    }
}
