package by.orion.onlinernews;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import by.orion.onlinernews.di.components.ApplicationComponent;
import by.orion.onlinernews.di.components.DaggerApplicationComponent;
import by.orion.onlinernews.di.modules.ApplicationModule;
import by.orion.onlinernews.di.modules.DataSourceModule;
import by.orion.onlinernews.di.modules.DbModule;
import by.orion.onlinernews.di.modules.NetModule;
import by.orion.onlinernews.di.modules.RepositoryModule;
import by.orion.onlinernews.di.modules.ServiceModule;

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
                .netModule(new NetModule(BuildConfig.BASE_DOMAIN))
                .serviceModule(new ServiceModule())
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
