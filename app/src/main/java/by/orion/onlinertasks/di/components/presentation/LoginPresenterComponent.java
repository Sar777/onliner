package by.orion.onlinertasks.di.components.presentation;

import by.orion.onlinertasks.di.components.ApplicationComponent;
import by.orion.onlinertasks.di.modules.presentation.LoginPresenterModule;
import by.orion.onlinertasks.di.scopes.Presenter;
import by.orion.onlinertasks.presentation.login.LoginPresenter;
import dagger.Component;

@Presenter
@Component(dependencies = ApplicationComponent.class, modules = LoginPresenterModule.class)
public interface LoginPresenterComponent {

    LoginPresenter getPresenter();
}
