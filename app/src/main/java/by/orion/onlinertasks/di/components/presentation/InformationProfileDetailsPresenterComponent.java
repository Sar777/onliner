package by.orion.onlinertasks.di.components.presentation;

import by.orion.onlinertasks.di.components.ApplicationComponent;
import by.orion.onlinertasks.di.modules.presentation.InformationProfileDetailsPresenterModule;
import by.orion.onlinertasks.di.scopes.Presenter;
import by.orion.onlinertasks.presentation.profile.details.pages.InformationProfileDetailsPresenter;
import dagger.Component;

@Presenter
@Component(dependencies = ApplicationComponent.class, modules = InformationProfileDetailsPresenterModule.class)
public interface InformationProfileDetailsPresenterComponent {

    InformationProfileDetailsPresenter getPresenter();
}