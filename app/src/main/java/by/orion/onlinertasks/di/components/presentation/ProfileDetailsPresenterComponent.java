package by.orion.onlinertasks.di.components.presentation;

import by.orion.onlinertasks.di.components.ApplicationComponent;
import by.orion.onlinertasks.di.modules.presentation.ProfileDetailsPresenterModule;
import by.orion.onlinertasks.di.scopes.Presenter;
import by.orion.onlinertasks.presentation.profile.details.ProfileDetailsPresenter;
import dagger.Component;

@Presenter
@Component(dependencies = ApplicationComponent.class, modules = ProfileDetailsPresenterModule.class)
public interface ProfileDetailsPresenterComponent {

    ProfileDetailsPresenter getPresenter();
}