package by.orion.onlinertasks.di.modules;

import android.content.Context;
import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapterFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import by.orion.onlinertasks.common.adapters.AutoValueGsonFactory;
import by.orion.onlinertasks.common.network.adapters.RxErrorHandlingCallAdapterFactory;
import by.orion.onlinertasks.di.qualifiers.OkHttpInterceptors;
import by.orion.onlinertasks.di.qualifiers.OkHttpNetworkInterceptors;
import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static by.orion.onlinertasks.di.modules.ApiModule.CREDENTIALS_API;
import static by.orion.onlinertasks.di.modules.ApiModule.TASKS_API;

@Module
public class NetModule {

    @Provides
    @NonNull
    Cache provideOkHttpCache(@NonNull Context context) {
        int cacheSize = 10 * 1024 * 1024; // 10 MiB
        return new Cache(context.getCacheDir(), cacheSize);
    }

    @Provides
    @NonNull
    Gson provideGson(@NonNull TypeAdapterFactory typeAdapterFactory) {
        return new GsonBuilder()
                .registerTypeAdapterFactory(typeAdapterFactory)
                .create();
    }

    @Provides
    @NonNull
    TypeAdapterFactory provideAutoValueGsonTypeAdapterFactory() {
        return AutoValueGsonFactory.create();
    }

    @Provides
    @NonNull
    Converter.Factory provideGsonConverterFactory(@NonNull Gson gson) {
        return GsonConverterFactory.create(gson);
    }

    @Provides
    @NonNull
    CallAdapter.Factory provideRxErrorHandlingCallAdapterFactory() {
        return RxErrorHandlingCallAdapterFactory.create();
    }

    @Provides
    @NonNull
    OkHttpClient provideOkHttpClient(@NonNull Cache cache,
                                     @OkHttpInterceptors @NonNull List<Interceptor> interceptors,
                                     @OkHttpNetworkInterceptors @NonNull List<Interceptor> networkInterceptors) {
        final OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();
        for (Interceptor interceptor : interceptors) {
            okHttpBuilder.addInterceptor(interceptor);
        }

        for (Interceptor networkInterceptor : networkInterceptors) {
            okHttpBuilder.addNetworkInterceptor(networkInterceptor);
        }

        return okHttpBuilder
                .connectTimeout(5, TimeUnit.SECONDS) // Default 10 secs
                .writeTimeout(20, TimeUnit.SECONDS) // Default 10 secs
                .readTimeout(20, TimeUnit.SECONDS) // Default 10 secs
                .cache(cache)
                .build();
    }

    @Named(TASKS_API)
    @Singleton
    @Provides
    @NonNull
    Retrofit provideTasksRetrofit(@NonNull @Named(TASKS_API) String url,
                                  @NonNull Converter.Factory converterFactory,
                                  @NonNull CallAdapter.Factory rxErrorAdapter,
                                  @NonNull OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .addConverterFactory(converterFactory)
                .addCallAdapterFactory(rxErrorAdapter)
                .baseUrl(url)
                .client(okHttpClient)
                .build();
    }

    @Named(CREDENTIALS_API)
    @Singleton
    @Provides
    @NonNull
    Retrofit provideCredentialsRetrofit(@NonNull @Named(CREDENTIALS_API) String url,
                                        @NonNull Converter.Factory converterFactory,
                                        @NonNull CallAdapter.Factory rxErrorAdapter,
                                        @NonNull OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .addConverterFactory(converterFactory)
                .addCallAdapterFactory(rxErrorAdapter)
                .baseUrl(url)
                .client(okHttpClient)
                .build();
    }
}
