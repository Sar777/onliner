package by.orion.onlinertasks.di.modules;

import android.support.annotation.NonNull;

import java.util.List;

import javax.inject.Singleton;

import by.orion.onlinertasks.di.qualifiers.OkHttpInterceptors;
import by.orion.onlinertasks.di.qualifiers.OkHttpNetworkInterceptors;
import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;

import static java.util.Collections.emptyList;

@Module
public class OkHttpInterceptorsModule {

    @Provides
    @OkHttpInterceptors
    @Singleton
    @NonNull
    public List<Interceptor> provideOkHttpInterceptors() {
        return emptyList();
    }

    @Provides
    @OkHttpNetworkInterceptors
    @Singleton
    @NonNull
    public List<Interceptor> provideOkHttpNetworkInterceptors() {
        return emptyList();
    }

}
