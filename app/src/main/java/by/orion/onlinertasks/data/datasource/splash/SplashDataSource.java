package by.orion.onlinertasks.data.datasource.splash;

import android.support.annotation.NonNull;

import by.orion.onlinertasks.data.datasource.DataSource;
import io.reactivex.Single;

public interface SplashDataSource extends DataSource<String, Object> {

    Single<Boolean> setFirstTimeLaunch(@NonNull Boolean first);

    Single<Boolean> isFirstTimeLaunch();
}
