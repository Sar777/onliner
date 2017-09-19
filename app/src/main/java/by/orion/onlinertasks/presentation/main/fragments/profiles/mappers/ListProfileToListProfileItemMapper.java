package by.orion.onlinertasks.presentation.main.fragments.profiles.mappers;

import android.content.Context;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import by.orion.onlinertasks.common.GenericObjectMapper;
import by.orion.onlinertasks.data.models.profile.Profile;
import by.orion.onlinertasks.presentation.main.fragments.profiles.models.ProfileItem;

public class ListProfileToListProfileItemMapper implements GenericObjectMapper<List<Profile>, List<ProfileItem>> {

    @NonNull
    private final Context context;

    @Inject
    public ListProfileToListProfileItemMapper(@NonNull Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public List<ProfileItem> map(@NonNull List<Profile> profiles) {
        List<ProfileItem> profileItems = new ArrayList<>(profiles.size());
        GenericObjectMapper<Profile, ProfileItem> mapper = new ProfileToProfileItemMapper(context);
        for (Profile profile : profiles) {
            profileItems.add(mapper.map(profile));
        }

        return profileItems;
    }
}
