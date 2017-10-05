package by.orion.onlinertasks;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import by.orion.onlinertasks.di.components.ApplicationComponent;
import by.orion.onlinertasks.di.components.DaggerApplicationComponent;
import by.orion.onlinertasks.di.modules.ApplicationModule;
import by.orion.onlinertasks.di.modules.DataSourceModule;
import by.orion.onlinertasks.di.modules.DbModule;
import by.orion.onlinertasks.di.modules.NetModule;
import by.orion.onlinertasks.di.modules.NetworkServiceModule;
import by.orion.onlinertasks.di.modules.RepositoryModule;

public class App extends Application {

    private static ApplicationComponent applicationComponent;
    private static App instance;

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;
        applicationComponent = buildComponent();
    }

    @NonNull
    public ApplicationComponent buildComponent() {
        return DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .dataSourceModule(new DataSourceModule())
                .repositoryModule(new RepositoryModule())
                .netModule(new NetModule())
                .networkServiceModule(new NetworkServiceModule())
                .dbModule(new DbModule())
                .build();
    }

    @NonNull
    public static Context getInstance() {
        return instance;
    }

    @NonNull
    public static ApplicationComponent getComponent() {
        return applicationComponent;
    }
}
