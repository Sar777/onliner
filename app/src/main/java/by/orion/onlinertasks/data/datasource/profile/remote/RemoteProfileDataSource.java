package by.orion.onlinertasks.data.datasource.profile.remote;

import android.support.annotation.NonNull;

import by.orion.onlinertasks.common.network.services.BaseService;
import by.orion.onlinertasks.data.datasource.profile.ProfileDataSource;
import by.orion.onlinertasks.data.models.profile.details.Profile;
import by.orion.onlinertasks.data.models.requests.ProfileRequestParams;
import io.reactivex.Completable;
import io.reactivex.Single;

public class RemoteProfileDataSource implements ProfileDataSource {

    @NonNull
    private final BaseService service;

    public RemoteProfileDataSource(@NonNull BaseService service) {
        this.service = service;
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
        return service.getProfile(params.id());
    }
}
