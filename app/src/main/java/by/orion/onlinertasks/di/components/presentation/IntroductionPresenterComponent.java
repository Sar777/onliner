package by.orion.onlinertasks.di.components.presentation;

import by.orion.onlinertasks.di.components.ApplicationComponent;
import by.orion.onlinertasks.di.modules.presentation.IntroductionPresenterModule;
import by.orion.onlinertasks.di.scopes.Presenter;
import by.orion.onlinertasks.presentation.introduction.IntroductionPresenter;
import dagger.Component;

@Presenter
@Component(dependencies = ApplicationComponent.class, modules = IntroductionPresenterModule.class)
public interface IntroductionPresenterComponent {

    IntroductionPresenter getPresenter();
}