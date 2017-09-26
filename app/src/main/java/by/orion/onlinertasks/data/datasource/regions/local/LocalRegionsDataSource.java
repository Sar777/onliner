package by.orion.onlinertasks.data.datasource.regions.local;

import android.support.annotation.NonNull;

import com.pushtorefresh.storio.sqlite.StorIOSQLite;

import java.util.List;

import javax.inject.Inject;

import by.orion.onlinertasks.data.datasource.regions.RegionsDataSource;
import by.orion.onlinertasks.data.models.regions.Region;
import io.reactivex.Completable;
import io.reactivex.Single;

public class LocalRegionsDataSource implements RegionsDataSource {

    @NonNull
    private final StorIOSQLite storIOSQLite;

    @Inject
    public LocalRegionsDataSource(@NonNull StorIOSQLite storIOSQLite) {
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
    public Single<List<Region>> getRegions() {
        throw new UnsupportedOperationException();
    }
}
