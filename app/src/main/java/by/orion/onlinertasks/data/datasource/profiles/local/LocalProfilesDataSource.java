package by.orion.onlinertasks.data.datasource.profiles.local;

import android.support.annotation.NonNull;

import com.pushtorefresh.storio.sqlite.StorIOSQLite;

import javax.inject.Inject;

import by.orion.onlinertasks.data.datasource.profiles.ProfilesDataSource;
import by.orion.onlinertasks.data.models.common.requests.ProfilesRequestParams;
import by.orion.onlinertasks.data.models.profile.ProfilesPage;
import io.reactivex.Completable;
import io.reactivex.Single;

public class LocalProfilesDataSource implements ProfilesDataSource {

    @NonNull
    private final StorIOSQLite storIOSQLite;

    @Inject
    public LocalProfilesDataSource(@NonNull StorIOSQLite storIOSQLite) {
        this.storIOSQLite = storIOSQLite;
    }

    @Override
    public Single getValue(@NonNull Object key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Completable setValue(@NonNull Object key, @NonNull Object value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Single<ProfilesPage> getAllProfiles(@NonNull ProfilesRequestParams params) {
        throw new UnsupportedOperationException();
    }
}
