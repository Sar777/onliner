package by.orion.onlinernews.di.components;

import javax.inject.Singleton;

import by.orion.onlinernews.data.repository.ArticlesRepository;
import by.orion.onlinernews.di.modules.ApplicationModule;
import by.orion.onlinernews.di.modules.DataSourceModule;
import by.orion.onlinernews.di.modules.DbModule;
import by.orion.onlinernews.di.modules.NetModule;
import by.orion.onlinernews.di.modules.RepositoryModule;
import by.orion.onlinernews.di.modules.ServiceModule;
import dagger.Component;

@Singleton
@Component(modules = { ApplicationModule.class, RepositoryModule.class, DataSourceModule.class, NetModule.class, ServiceModule.class, DbModule.class})
public interface ApplicationComponent {

    ArticlesRepository provideArticlesRepository();
}