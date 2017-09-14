package by.orion.onlinernews.di.modules;

import android.content.Context;
import android.support.annotation.NonNull;

import com.pushtorefresh.storio.sqlite.StorIOSQLite;
import com.pushtorefresh.storio.sqlite.impl.DefaultStorIOSQLite;

import javax.inject.Singleton;

import by.orion.onlinernews.data.database.DbOpenHelper;
import dagger.Module;
import dagger.Provides;

@Module
public class DbModule {

    @Provides
    @Singleton
    @NonNull
    DbOpenHelper provideDbOpenHelper(@NonNull Context context) {
        return new DbOpenHelper(context);
    }

    @Provides
    @Singleton
    @NonNull
    StorIOSQLite provideStorIOSQLite(@NonNull DbOpenHelper dbOpenHelper) {
        return DefaultStorIOSQLite.builder()
                .sqliteOpenHelper(dbOpenHelper)
                .build();
    }
}
