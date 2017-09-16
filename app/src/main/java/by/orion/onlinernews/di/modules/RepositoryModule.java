package by.orion.onlinernews.di.modules;

import android.support.annotation.NonNull;

import javax.inject.Singleton;

import by.orion.onlinernews.data.datasource.impl.ArticlesDataSource;
import by.orion.onlinernews.data.repository.ArticlesRepository;
import by.orion.onlinernews.data.repository.impl.ArticlesRepositoryImpl;
import by.orion.onlinernews.di.LocalDataSource;
import by.orion.onlinernews.di.RemoteDataSource;
import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Provides
    @Singleton
    ArticlesRepository provideArticlesRepository(@NonNull @LocalDataSource ArticlesDataSource localDataSource,
                                                 @NonNull @RemoteDataSource ArticlesDataSource remoteDataSource) {
        return new ArticlesRepositoryImpl(localDataSource, remoteDataSource);
    }
}
