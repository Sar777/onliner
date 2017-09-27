package by.orion.onlinertasks.data.datasource.profile.details.remote;

import android.support.annotation.NonNull;

import by.orion.onlinertasks.common.network.services.BaseService;
import by.orion.onlinertasks.data.datasource.profile.details.ProfileDetailsDataSource;
import by.orion.onlinertasks.data.models.common.requests.ProfileRequestParams;
import by.orion.onlinertasks.data.models.profile.details.Profile;
import io.reactivex.Completable;
import io.reactivex.Single;

public class RemoteProfileDetailsDataSource implements ProfileDetailsDataSource {

    @NonNull
    private final BaseService service;

    public RemoteProfileDetailsDataSource(@NonNull BaseService service) {
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
