package by.orion.onlinertasks.data.repository.regions;

import android.support.annotation.NonNull;

import java.util.List;

import javax.inject.Inject;

import by.orion.onlinertasks.data.datasource.regions.RegionsDataSource;
import by.orion.onlinertasks.data.models.regions.Region;
import by.orion.onlinertasks.di.qualifiers.LocalDataSource;
import by.orion.onlinertasks.di.qualifiers.RemoteDataSource;
import io.reactivex.Single;

public class RegionsRepositoryImpl implements RegionsRepository {

    @NonNull
    private final RegionsDataSource localDataSource;

    @NonNull
    private final RegionsDataSource remoteDataSource;

    @Inject
    public RegionsRepositoryImpl(@NonNull @LocalDataSource RegionsDataSource localDataSource,
                                 @NonNull @RemoteDataSource RegionsDataSource remoteDataSource) {
        this.localDataSource = localDataSource;
        this.remoteDataSource = remoteDataSource;
    }

    @Override
    public Single<List<Region>> getRegions() {
        return remoteDataSource.getRegions();
    }
}
