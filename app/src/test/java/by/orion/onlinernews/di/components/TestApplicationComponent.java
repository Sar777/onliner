package by.orion.onlinernews.di.components;

import javax.inject.Singleton;

import by.orion.onlinernews.di.modules.TestApplicationModule;
import dagger.Component;

@Singleton
@Component(modules = { TestApplicationModule.class, TestApplicationModule.class })
public interface TestApplicationComponent extends ApplicationComponent {
}