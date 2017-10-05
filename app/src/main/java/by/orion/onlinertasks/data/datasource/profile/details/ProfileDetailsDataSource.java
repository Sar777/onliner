package by.orion.onlinertasks.data.datasource.profile.details;

import android.support.annotation.NonNull;

import by.orion.onlinertasks.data.datasource.DataSource;
import by.orion.onlinertasks.data.models.common.requests.ProfileDetailsRequestParams;
import by.orion.onlinertasks.data.models.profile.details.Profile;
import io.reactivex.Single;

public interface ProfileDetailsDataSource extends DataSource<Integer, Profile> {

    Single<Profile> getProfile(@NonNull ProfileDetailsRequestParams params);
}
