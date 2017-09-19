package by.orion.onlinertasks.di.components.presentation;

import by.orion.onlinertasks.di.components.ApplicationComponent;
import by.orion.onlinertasks.di.modules.presentation.ProfilesPresenterModule;
import by.orion.onlinertasks.di.scopes.Presenter;
import by.orion.onlinertasks.presentation.main.fragments.profiles.ProfilesPresenter;
import dagger.Component;

@Presenter
@Component(dependencies = ApplicationComponent.class, modules = ProfilesPresenterModule.class)
public interface ProfilesPresenterComponent {

    ProfilesPresenter getPresenter();
}