package by.orion.onlinernews.domain.interactors;

import android.support.annotation.NonNull;

import java.util.List;

import javax.inject.Inject;

import by.orion.onlinernews.data.models.Article;
import by.orion.onlinernews.data.repository.ArticlesRepository;
import by.orion.onlinernews.presentation.common.models.ArticleCategory;
import io.reactivex.Single;

public class ArticlesInteractor {

    private final ArticlesRepository articlesRepository;

    @Inject
    public ArticlesInteractor(ArticlesRepository articlesRepository) {
        this.articlesRepository = articlesRepository;
    }

    @NonNull
    public Single<List<Article>> getArticlesByCategory(@NonNull ArticleCategory category) {
        return articlesRepository.getArticlesByCategory(category);
    }
}
