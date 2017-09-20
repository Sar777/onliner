package by.orion.onlinertasks.data.repository.splash;

import android.support.annotation.NonNull;

import by.orion.onlinertasks.data.repository.Repository;
import io.reactivex.Single;

public interface SplashRepository extends Repository {

    Single<Boolean> isFirstTimeLaunch();

    Single<Boolean> setFirstTimeLaunch(@NonNull Boolean first);
}
