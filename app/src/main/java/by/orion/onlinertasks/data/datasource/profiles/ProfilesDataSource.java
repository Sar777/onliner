package by.orion.onlinertasks.data.datasource.profiles;

import android.support.annotation.NonNull;

import by.orion.onlinertasks.data.datasource.DataSource;
import by.orion.onlinertasks.data.models.profile.ProfilesPage;
import by.orion.onlinertasks.data.models.requests.ProfilesRequestParams;
import io.reactivex.Single;

public interface ProfilesDataSource extends DataSource {

    Single<ProfilesPage> getAllProfiles(@NonNull ProfilesRequestParams params);
}
