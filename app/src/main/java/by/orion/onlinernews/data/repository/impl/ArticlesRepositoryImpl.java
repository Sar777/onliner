package by.orion.onlinernews.data.repository.impl;

import android.support.annotation.NonNull;

import java.util.List;

import javax.inject.Inject;

import by.orion.onlinernews.data.datasource.impl.ArticlesDataSource;
import by.orion.onlinernews.data.models.Article;
import by.orion.onlinernews.data.repository.ArticlesRepository;
import by.orion.onlinernews.di.qualifiers.LocalDataSource;
import by.orion.onlinernews.di.qualifiers.RemoteDataSource;
import by.orion.onlinernews.presentation.common.models.ArticleCategory;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

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

    @Override
    public Single<List<Article>> getArticlesByCategory(@NonNull ArticleCategory category) {
        Single<List<Article>> remoteArticles = getAndSaveRemoteArticlesByCategory(category);
        Single<List<Article>> localArticles = getLocalArticlesByCategory(category);

        return localArticles.onErrorResumeNext(remoteArticles.subscribeOn(Schedulers.io()));
    }

    private Single<List<Article>> getAndSaveRemoteArticlesByCategory(@NonNull ArticleCategory category) {
        return remoteDataSource.getArticlesByCategory(category)
                .flatMap(articles -> localDataSource.saveArticles(articles).toSingleDefault(articles));
    }

    private Single<List<Article>> getLocalArticlesByCategory(ArticleCategory category) {
        return localDataSource.getArticlesByCategory(category);
    }
}
