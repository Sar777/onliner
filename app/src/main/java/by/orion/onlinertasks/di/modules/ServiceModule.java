package by.orion.onlinertasks.di.modules;

import android.support.annotation.NonNull;

import javax.inject.Singleton;

import by.orion.onlinertasks.common.network.services.BaseService;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class ServiceModule {

    @Singleton
    @Provides
    BaseService provideBaseService(@NonNull Retrofit retrofit) {
        return retrofit.create(BaseService.class);
    }
}
