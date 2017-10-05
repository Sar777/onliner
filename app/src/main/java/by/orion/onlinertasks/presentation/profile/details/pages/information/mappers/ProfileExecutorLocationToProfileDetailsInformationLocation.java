package by.orion.onlinertasks.presentation.profile.details.pages.information.mappers;

import android.content.Context;
import android.support.annotation.NonNull;

import java.util.List;

import by.orion.onlinertasks.R;
import by.orion.onlinertasks.common.GenericObjectMapper;
import by.orion.onlinertasks.data.models.regions.Region;

public class ProfileExecutorLocationToProfileDetailsInformationLocation implements GenericObjectMapper<List<Region>, String> {

    @NonNull
    private final Context context;

    @NonNull
    private final List<Integer> executorRegionList;

    public ProfileExecutorLocationToProfileDetailsInformationLocation(@NonNull Context context, @NonNull List<Integer> executorRegionList) {
        this.context = context;
        this.executorRegionList = executorRegionList;
    }

    @NonNull
    @Override
    public String map(@NonNull List<Region> regions) {
        if (regions.size() == executorRegionList.size()) {
            return context.getString(R.string.msg_profile_details_information_work_all_location);
        }

        StringBuilder builder = new StringBuilder();
        builder.append(context.getString(R.string.msg_profile_details_information_work_in));

        for (Region region : regions) {
            if (!hasRegion(region.id())) {
                continue;
            }

            builder.append(" ")
                    .append(region.name())
                    .append(", ");
        }

        builder.delete(builder.length() - 2, builder.length());
        return builder.toString();
    }

    private boolean hasRegion(@NonNull final Integer id) {
        for (Integer regId : executorRegionList) {
            if (regId.equals(id)) {
                return true;
            }
        }

        return false;
    }
}
