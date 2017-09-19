package by.orion.onlinertasks.presentation.main.fragments.profiles.mappers;

import android.content.Context;
import android.support.annotation.NonNull;

import javax.inject.Inject;

import by.orion.onlinertasks.R;
import by.orion.onlinertasks.common.GenericObjectMapper;
import by.orion.onlinertasks.data.models.profile.Profile;
import by.orion.onlinertasks.presentation.main.fragments.profiles.models.ProfileItem;

public class ProfileToProfileItemMapper implements GenericObjectMapper<Profile, ProfileItem> {

    @NonNull
    private final Context context;

    @Inject
    public ProfileToProfileItemMapper(@NonNull Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ProfileItem map(@NonNull Profile profile) {
        return ProfileItem.builder()
                .id(profile.id())
                .photo(profile.photo())
                .displayName(profile.displayName())
                .description(profile.description())
                .sections(new ProfileListSectionToProfileSectionItemMapper(context).map(profile.sections()))
                .rating(new ProfileRatingToProfileRatingItemMapper().map(profile.rating()))
                .completedTasksQty(String.format(context.getString(R.string.msg_profile_task_completed), profile.completedTasksQty()))
                .build();
    }
}
