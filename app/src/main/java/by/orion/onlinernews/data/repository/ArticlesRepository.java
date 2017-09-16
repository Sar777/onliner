package by.orion.onlinernews.data.repository;

import android.support.annotation.NonNull;

import java.util.List;

import by.orion.onlinernews.data.models.Article;
import by.orion.onlinernews.presentation.common.models.ArticleCategory;
import io.reactivex.Single;

public interface ArticlesRepository {

    Single<List<Article>> getArticlesByCategory(@NonNull ArticleCategory category);
}
