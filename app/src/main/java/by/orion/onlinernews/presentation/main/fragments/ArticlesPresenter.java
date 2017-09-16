package by.orion.onlinernews.presentation.main.fragments;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.List;

import javax.inject.Inject;

import by.orion.onlinernews.data.models.Article;
import by.orion.onlinernews.domain.interactors.ArticlesInteractor;
import by.orion.onlinernews.presentation.common.models.ArticleCategory;
import by.orion.onlinernews.presentation.common.rx.RxSchedulersProvider;

@InjectViewState
public class ArticlesPresenter extends MvpPresenter<ArticlesView> {

    @NonNull
    private final ArticleCategory category;

    @NonNull
    private final RxSchedulersProvider rxSchedulersProvider;

    @NonNull
    private final ArticlesInteractor articlesInteractor;

    @Inject
    public ArticlesPresenter(@NonNull ArticleCategory category,
                             @NonNull RxSchedulersProvider rxSchedulersProvider,
                             @NonNull ArticlesInteractor articlesInteractor) {
        this.category = category;
        this.rxSchedulersProvider = rxSchedulersProvider;
        this.articlesInteractor = articlesInteractor;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();

        getViewState().hideError();
        getViewState().hideArticles();
        getViewState().showProgress();

        articlesInteractor.getArticlesByCategory(category)
                .compose(rxSchedulersProvider.getIoToMainTransformerSingle())
                .subscribe(this::onArticlesListSuccess, this::onArticlesListError);
    }

    private void onArticlesListSuccess(@NonNull List<Article> articles) {
        getViewState().hideProgress();
        getViewState().showArticles();
    }

    private void onArticlesListError(@NonNull Throwable throwable) {
        getViewState().hideProgress();
        getViewState().showError();
    }
}
