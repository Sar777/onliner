package by.orion.onlinernews.data.datasource.impl;

import android.support.annotation.NonNull;

import java.util.List;

import by.orion.onlinernews.data.datasource.DataSource;
import by.orion.onlinernews.data.models.Article;
import by.orion.onlinernews.presentation.common.models.ArticleCategory;
import io.reactivex.Completable;
import io.reactivex.Single;

public interface ArticlesDataSource extends DataSource<Integer, Article> {

    Single<List<Article>> getArticlesByCategory(@NonNull ArticleCategory category);

    Completable saveArticles(@NonNull List<Article> articles);
}
