package by.orion.onlinertasks.presentation.main.fragments;

import by.orion.onlinertasks.presentation.BaseMvpView;

public interface TasksView extends BaseMvpView {

    void showProgress();

    void hideProgress();

    void showArticles();

    void hideArticles();
}
