package by.orion.onlinertasks.data.datasource.splash.local;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import by.orion.onlinertasks.data.datasource.splash.SplashDataSource;
import io.reactivex.Completable;
import io.reactivex.Single;

public class LocalSplashDataSource implements SplashDataSource {

    @NonNull
    private static final String KEY_IS_FIRST_LAUNCH = "KEY_IS_FIRST_LAUNCH";

    @NonNull
    private final SharedPreferences sharedPreferences;

    public LocalSplashDataSource(@NonNull SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    @Override
    public Single<Object> getValue(@NonNull String key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Completable setValue(@NonNull String key, @NonNull Object value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Single<Boolean> setFirstLaunch(@NonNull Boolean first) {
        return Single.just(sharedPreferences.edit())
                .map(editor -> editor.putBoolean(KEY_IS_FIRST_LAUNCH, first))
                .map(SharedPreferences.Editor::commit)
                .map(success -> !first);
    }

    @Override
    public Single<Boolean> isFirstLaunch() {
        return Single.just(sharedPreferences.getBoolean(KEY_IS_FIRST_LAUNCH, true));
    }
}
