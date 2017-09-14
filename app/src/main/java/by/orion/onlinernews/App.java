package by.orion.onlinernews;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import by.orion.onlinernews.di.components.ApplicationComponent;
import by.orion.onlinernews.di.components.DaggerApplicationComponent;
import by.orion.onlinernews.di.modules.ApplicationModule;
import by.orion.onlinernews.di.modules.DataModule;

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
                .dataModule(new DataModule(BuildConfig.BASE_DOMAIN))
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
