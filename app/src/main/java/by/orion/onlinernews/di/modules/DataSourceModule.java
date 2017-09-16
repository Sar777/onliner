package by.orion.onlinernews.di.modules;

import android.support.annotation.NonNull;

import javax.inject.Singleton;

import by.orion.onlinernews.common.network.services.BaseService;
import by.orion.onlinernews.data.datasource.impl.ArticlesDataSource;
import by.orion.onlinernews.data.datasource.impl.local.LocalArticlesDataSource;
import by.orion.onlinernews.data.datasource.impl.remote.RemoteArticlesDataSource;
import by.orion.onlinernews.di.LocalDataSource;
import by.orion.onlinernews.di.RemoteDataSource;
import dagger.Module;
import dagger.Provides;

@Module
public class DataSourceModule {

    @Singleton
    @LocalDataSource
    @Provides
    @NonNull
    ArticlesDataSource provideLocalArticleDataSource() {
        return new LocalArticlesDataSource();
    }

    @Singleton
    @RemoteDataSource
    @Provides
    @NonNull
    ArticlesDataSource provideRemoteArticleDataSource(@NonNull BaseService service) {
        return new RemoteArticlesDataSource(service);
    }
}
