package by.orion.onlinernews.di.components.presentation;

import by.orion.onlinernews.di.components.ApplicationComponent;
import by.orion.onlinernews.di.modules.presentation.MainPresenterModule;
import by.orion.onlinernews.di.scopes.Presenter;
import by.orion.onlinernews.presentation.main.MainPresenter;
import dagger.Component;

@Presenter
@Component(dependencies = ApplicationComponent.class, modules = MainPresenterModule.class)
public interface MainPresenterComponent {

    MainPresenter getPresenter();
}