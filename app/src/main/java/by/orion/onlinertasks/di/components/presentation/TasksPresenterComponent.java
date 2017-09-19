package by.orion.onlinertasks.di.components.presentation;

import by.orion.onlinertasks.di.components.ApplicationComponent;
import by.orion.onlinertasks.di.modules.presentation.TasksPresenterModule;
import by.orion.onlinertasks.di.scopes.Presenter;
import by.orion.onlinertasks.presentation.main.fragments.tasks.TasksPresenter;
import dagger.Component;

@Presenter
@Component(dependencies = ApplicationComponent.class, modules = TasksPresenterModule.class)
public interface TasksPresenterComponent {

    TasksPresenter getPresenter();
}