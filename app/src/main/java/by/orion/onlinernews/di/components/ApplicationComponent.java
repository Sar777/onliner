package by.orion.onlinernews.di.components;

import javax.inject.Singleton;

import by.orion.onlinernews.di.modules.ApplicationModule;
import by.orion.onlinernews.di.modules.DataModule;
import by.orion.onlinernews.di.modules.DbModule;
import by.orion.onlinernews.di.modules.NetModule;
import dagger.Component;

@Singleton
@Component(modules = { ApplicationModule.class, DataModule.class, NetModule.class, DbModule.class})
public interface ApplicationComponent {

}