package by.orion.onlinernews.di.modules.presentation;

import android.support.annotation.NonNull;

import by.orion.onlinernews.presentation.common.models.ArticleCategory;
import dagger.Module;
import dagger.Provides;

@Module
public class ArticlesPresenterModule {

    @NonNull
    private final ArticleCategory category;

    public ArticlesPresenterModule(@NonNull ArticleCategory category) {
        this.category = category;
    }

    @Provides
    @NonNull
    public ArticleCategory getCategory() {
        return category;
    }
}
