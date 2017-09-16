package by.orion.onlinernews.data.datasource;

import android.support.annotation.NonNull;

import io.reactivex.Completable;
import io.reactivex.Single;

public interface DataSource<K, V> {

    Single<V> getValue(@NonNull K key);

    Completable setValue(@NonNull K key, @NonNull V value);
}
