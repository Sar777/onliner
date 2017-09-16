package by.orion.onlinernews.di.modules;

import android.support.annotation.NonNull;

import com.pushtorefresh.storio.sqlite.StorIOSQLite;

import javax.inject.Singleton;

import by.orion.onlinernews.common.network.services.BaseService;
import by.orion.onlinernews.data.datasource.impl.ArticlesDataSource;
import by.orion.onlinernews.data.datasource.impl.local.LocalArticlesDataSource;
import by.orion.onlinernews.data.datasource.impl.remote.RemoteArticlesDataSource;
import by.orion.onlinernews.di.qualifiers.LocalDataSource;
import by.orion.onlinernews.di.qualifiers.RemoteDataSource;
import dagger.Module;
import dagger.Provides;

@Module
public class DataSourceModule {

    @Singleton
    @LocalDataSource
    @Provides
    @NonNull
    ArticlesDataSource provideLocalArticleDataSource(@NonNull StorIOSQLite storIOSQLite) {
        return new LocalArticlesDataSource(storIOSQLite);
    }

    @Singleton
    @RemoteDataSource
    @Provides
    @NonNull
    ArticlesDataSource provideRemoteArticleDataSource(@NonNull BaseService service) {
        return new RemoteArticlesDataSource(service);
    }
}
