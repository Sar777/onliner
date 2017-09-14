package by.orion.onlinernews.di.components.presentation;

import by.orion.onlinernews.di.components.ApplicationComponent;
import by.orion.onlinernews.di.modules.presentation.SplashPresenterModule;
import by.orion.onlinernews.di.scopes.Presenter;
import by.orion.onlinernews.presentation.splash.SplashPresenter;
import dagger.Component;

@Presenter
@Component(dependencies = ApplicationComponent.class, modules = SplashPresenterModule.class)
public interface SplashPresenterComponent {

    SplashPresenter getPresenter();
}