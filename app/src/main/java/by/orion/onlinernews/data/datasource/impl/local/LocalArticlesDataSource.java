package by.orion.onlinernews.data.datasource.impl.local;

import android.support.annotation.NonNull;

import by.orion.onlinernews.data.datasource.impl.ArticlesDataSource;
import by.orion.onlinernews.data.models.Article;
import io.reactivex.Completable;
import io.reactivex.Single;

public class LocalArticlesDataSource implements ArticlesDataSource {

    @Override
    public Single<Article> getValue(@NonNull Integer key) {
        return null;
    }

    @Override
    public Completable setValue(@NonNull Integer key, @NonNull Article value) {
        return null;
    }
}
