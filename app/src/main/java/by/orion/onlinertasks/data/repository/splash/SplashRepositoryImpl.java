package by.orion.onlinertasks.data.repository.splash;

import android.support.annotation.NonNull;

import javax.inject.Inject;

import by.orion.onlinertasks.data.datasource.splash.SplashDataSource;
import by.orion.onlinertasks.di.qualifiers.LocalDataSource;
import io.reactivex.Single;

public class SplashRepositoryImpl implements SplashRepository {

    @NonNull
    private final SplashDataSource localDataSource;

    @Inject
    public SplashRepositoryImpl(@NonNull @LocalDataSource SplashDataSource localDataSource) {
        this.localDataSource = localDataSource;
    }

    @Override
    public Single<Boolean> isFirstTimeLaunch() {
        return localDataSource.isFirstLaunch();
    }

    @Override
    public Single<Boolean> setFirstTimeLaunch(@NonNull Boolean first) {
        return localDataSource.setFirstLaunch(first);
    }
}
