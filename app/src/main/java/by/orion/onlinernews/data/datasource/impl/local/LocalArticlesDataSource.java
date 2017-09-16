package by.orion.onlinernews.data.datasource.impl.local;

import android.support.annotation.NonNull;

import com.pushtorefresh.storio.sqlite.StorIOSQLite;

import java.util.List;

import javax.inject.Inject;

import by.orion.onlinernews.data.datasource.impl.ArticlesDataSource;
import by.orion.onlinernews.data.models.Article;
import by.orion.onlinernews.presentation.common.models.ArticleCategory;
import io.reactivex.Completable;
import io.reactivex.CompletableEmitter;
import io.reactivex.Single;

public class LocalArticlesDataSource implements ArticlesDataSource {

    @NonNull
    private final StorIOSQLite storIOSQLite;

    @Inject
    public LocalArticlesDataSource(@NonNull StorIOSQLite storIOSQLite) {
        this.storIOSQLite = storIOSQLite;
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
        return Single.error(new Throwable());
    }

    @Override
    public Completable saveArticles(@NonNull List<Article> articles) {
        return Completable.create(CompletableEmitter::onComplete);
    }
}
