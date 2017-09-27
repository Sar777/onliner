package by.orion.onlinertasks.data.datasource.profiles.remote;

import android.support.annotation.NonNull;

import javax.inject.Inject;

import by.orion.onlinertasks.common.network.services.BaseService;
import by.orion.onlinertasks.data.datasource.profiles.ProfilesDataSource;
import by.orion.onlinertasks.data.models.common.requests.ProfilesRequestParams;
import by.orion.onlinertasks.data.models.profile.ProfilesPage;
import io.reactivex.Completable;
import io.reactivex.Single;

public class RemoteProfilesDataSource implements ProfilesDataSource {

    @NonNull
    private final BaseService service;

    @Inject
    public RemoteProfilesDataSource(@NonNull BaseService service) {
        this.service = service;
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
        return service.getAllProfiles(params.page());
    }
}
