package by.orion.onlinertasks.data.datasource.regions.remote;

import android.support.annotation.NonNull;

import java.util.List;

import javax.inject.Inject;

import by.orion.onlinertasks.common.network.services.BaseService;
import by.orion.onlinertasks.data.datasource.regions.RegionsDataSource;
import by.orion.onlinertasks.data.models.regions.Region;
import io.reactivex.Completable;
import io.reactivex.Single;

public class RemoteRegionsDataSource implements RegionsDataSource {

    @NonNull
    private final BaseService service;

    @Inject
    public RemoteRegionsDataSource(@NonNull BaseService service) {
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
    public Single<List<Region>> getRegions() {
        return service.getRegions();
    }
}
