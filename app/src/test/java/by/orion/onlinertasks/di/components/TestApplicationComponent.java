package by.orion.onlinertasks.di.components;

import android.content.Context;

import javax.inject.Singleton;

import by.orion.onlinertasks.di.modules.TestApplicationModule;
import dagger.Component;

@Singleton
@Component(modules = { TestApplicationModule.class, TestApplicationModule.class })
public interface TestApplicationComponent extends ApplicationComponent {

    Context provideContext();
}