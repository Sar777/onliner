package by.orion.onlinernews.data.repository.impl;

import android.support.annotation.NonNull;

import javax.inject.Inject;

import by.orion.onlinernews.data.datasource.impl.ArticlesDataSource;
import by.orion.onlinernews.data.repository.ArticlesRepository;
import by.orion.onlinernews.di.LocalDataSource;
import by.orion.onlinernews.di.RemoteDataSource;

public class ArticlesRepositoryImpl implements ArticlesRepository {

    @NonNull
    private final ArticlesDataSource localDataSource;

    @NonNull
    private final ArticlesDataSource remoteDataSource;

    @Inject
    public ArticlesRepositoryImpl(@NonNull @LocalDataSource ArticlesDataSource localDataSource,
                                  @NonNull @RemoteDataSource ArticlesDataSource remoteDataSource) {
        this.localDataSource = localDataSource;
        this.remoteDataSource = remoteDataSource;
    }
}
