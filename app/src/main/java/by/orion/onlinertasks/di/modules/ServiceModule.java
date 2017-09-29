package by.orion.onlinertasks.di.modules;

import android.support.annotation.NonNull;

import javax.inject.Named;
import javax.inject.Singleton;

import by.orion.onlinertasks.common.network.services.BaseService;
import by.orion.onlinertasks.common.network.services.CredentialsService;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

import static by.orion.onlinertasks.di.modules.ApiModule.CREDENTIALS_API;
import static by.orion.onlinertasks.di.modules.ApiModule.TASKS_API;

@Module
public class ServiceModule {

    @Singleton
    @Provides
    BaseService provideBaseService(@NonNull @Named(TASKS_API) Retrofit retrofit) {
        return retrofit.create(BaseService.class);
    }

    @Singleton
    @Provides
    CredentialsService provideCredentialsService(@NonNull @Named(CREDENTIALS_API) Retrofit retrofit) {
        return retrofit.create(CredentialsService.class);
    }
}
