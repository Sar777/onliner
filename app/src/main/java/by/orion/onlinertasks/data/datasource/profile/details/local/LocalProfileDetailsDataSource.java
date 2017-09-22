package by.orion.onlinertasks.data.datasource.profile.details.local;

import android.support.annotation.NonNull;

import com.pushtorefresh.storio.sqlite.StorIOSQLite;

import javax.inject.Inject;

import by.orion.onlinertasks.data.datasource.profile.details.ProfileDetailsDataSource;
import by.orion.onlinertasks.data.models.profile.details.Profile;
import by.orion.onlinertasks.data.models.requests.ProfileRequestParams;
import io.reactivex.Completable;
import io.reactivex.Single;

public class LocalProfileDetailsDataSource implements ProfileDetailsDataSource {

    @NonNull
    private final StorIOSQLite storIOSQLite;

    @Inject
    public LocalProfileDetailsDataSource(@NonNull StorIOSQLite storIOSQLite) {
        this.storIOSQLite = storIOSQLite;
    }

    @Override
    public Single<Profile> getValue(@NonNull Integer key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Completable setValue(@NonNull Integer key, @NonNull Profile value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Single<Profile> getProfile(@NonNull ProfileRequestParams params) {
        throw new UnsupportedOperationException();
    }
}
