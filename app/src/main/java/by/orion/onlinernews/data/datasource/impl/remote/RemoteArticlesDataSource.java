package by.orion.onlinernews.data.datasource.impl.remote;

import android.support.annotation.NonNull;

import by.orion.onlinernews.common.network.services.BaseService;
import by.orion.onlinernews.data.datasource.impl.ArticlesDataSource;
import by.orion.onlinernews.data.models.Article;
import io.reactivex.Completable;
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
}
