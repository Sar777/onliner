package by.orion.onlinertasks.di.components.presentation;

import by.orion.onlinertasks.di.components.ApplicationComponent;
import by.orion.onlinertasks.di.modules.presentation.SplashPresenterModule;
import by.orion.onlinertasks.di.scopes.Presenter;
import by.orion.onlinertasks.presentation.splash.SplashPresenter;
import dagger.Component;

@Presenter
@Component(dependencies = ApplicationComponent.class, modules = SplashPresenterModule.class)
public interface SplashPresenterComponent {

    SplashPresenter getPresenter();
}