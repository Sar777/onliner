package by.orion.onlinernews.data.datasource.impl.remote;

import android.support.annotation.NonNull;

import java.util.List;

import by.orion.onlinernews.common.network.services.BaseService;
import by.orion.onlinernews.data.datasource.impl.ArticlesDataSource;
import by.orion.onlinernews.data.models.Article;
import by.orion.onlinernews.presentation.common.models.ArticleCategory;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;

public class RemoteArticlesDataSource implements ArticlesDataSource {

    @NonNull
    private final BaseService service;

    public RemoteArticlesDataSource(@NonNull BaseService service) {
        this.service = service;
    }

    @Override
    public Single<Article> getValue(@NonNull Integer key) {
        return null;
    }

    @Override
    public Completable setValue(@NonNull Integer key, @NonNull Article value) {
        return null;
    }

    @Override
    public Single<List<Article>> getArticlesByCategory(@NonNull ArticleCategory category) {
        return service.getArticles(category.getUrl())
                .map(articlesPage -> articlesPage.articles)
                .toObservable()
                .flatMap(Observable::fromIterable)
                .map(remoteArticle -> (Article)remoteArticle)
                .toList();
    }

    @Override
    public Completable saveArticles(@NonNull List<Article> articles) {
        throw new UnsupportedOperationException();
    }
}
