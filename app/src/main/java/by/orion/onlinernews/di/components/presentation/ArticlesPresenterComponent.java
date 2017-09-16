package by.orion.onlinernews.di.components.presentation;

import by.orion.onlinernews.di.components.ApplicationComponent;
import by.orion.onlinernews.di.modules.presentation.ArticlesPresenterModule;
import by.orion.onlinernews.di.scopes.Presenter;
import by.orion.onlinernews.presentation.main.fragments.ArticlesPresenter;
import dagger.Component;

@Presenter
@Component(dependencies = ApplicationComponent.class, modules = ArticlesPresenterModule.class)
public interface ArticlesPresenterComponent {

    ArticlesPresenter getPresenter();
}