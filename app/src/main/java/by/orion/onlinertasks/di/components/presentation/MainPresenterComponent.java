package by.orion.onlinertasks.di.components.presentation;

import by.orion.onlinertasks.di.components.ApplicationComponent;
import by.orion.onlinertasks.di.modules.presentation.MainPresenterModule;
import by.orion.onlinertasks.di.scopes.Presenter;
import by.orion.onlinertasks.presentation.main.MainPresenter;
import dagger.Component;

@Presenter
@Component(dependencies = ApplicationComponent.class, modules = MainPresenterModule.class)
public interface MainPresenterComponent {

    MainPresenter getPresenter();
}