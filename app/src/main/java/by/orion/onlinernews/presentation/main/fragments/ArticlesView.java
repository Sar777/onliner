package by.orion.onlinernews.presentation.main.fragments;

import by.orion.onlinernews.presentation.BaseMvpView;

public interface ArticlesView extends BaseMvpView {

    void showProgress();

    void hideProgress();

    void showArticles();

    void hideArticles();
}
