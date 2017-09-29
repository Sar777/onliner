package by.orion.onlinertasks.di.modules;

import android.support.annotation.NonNull;

import javax.inject.Named;

import by.orion.onlinertasks.BuildConfig;
import dagger.Module;
import dagger.Provides;

@Module
public class ApiModule {

    @NonNull
    static final String TASKS_API = "TASKS_API";

    @NonNull
    static final String CREDENTIALS_API = "CREDENTIALS_API";

    @Named(TASKS_API)
    @Provides
    @NonNull
    String provideTasksApi() {
        return BuildConfig.TASKS_API;
    }

    @Named(CREDENTIALS_API)
    @Provides
    @NonNull
    String provideCredentialsApi() {
        return BuildConfig.CREDENTIALS_API;
    }
}
