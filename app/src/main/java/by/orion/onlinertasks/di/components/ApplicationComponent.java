package by.orion.onlinertasks.di.components;

import android.content.Context;

import javax.inject.Singleton;

import by.orion.onlinertasks.data.repository.tasks.TasksRepository;
import by.orion.onlinertasks.di.modules.ApplicationModule;
import by.orion.onlinertasks.di.modules.DataSourceModule;
import by.orion.onlinertasks.di.modules.DbModule;
import by.orion.onlinertasks.di.modules.MappersModule;
import by.orion.onlinertasks.di.modules.NetModule;
import by.orion.onlinertasks.di.modules.OkHttpInterceptorsModule;
import by.orion.onlinertasks.di.modules.RepositoryModule;
import by.orion.onlinertasks.di.modules.ServiceModule;
import dagger.Component;

@Singleton
@Component(modules = { ApplicationModule.class,
                       RepositoryModule.class,
                       DataSourceModule.class,
                       MappersModule.class,
                       NetModule.class,
                       ServiceModule.class,
                       DbModule.class,
                       OkHttpInterceptorsModule.class})
public interface ApplicationComponent {

    Context provideContext();

    TasksRepository provideTasksRepository();
}