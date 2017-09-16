package by.orion.onlinernews.di.modules;

import android.content.Context;
import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import by.orion.onlinernews.common.network.convertors.RetrofitUniversalConverterFactory;
import by.orion.onlinernews.di.qualifiers.OkHttpInterceptors;
import by.orion.onlinernews.di.qualifiers.OkHttpNetworkInterceptors;
import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

@Module
public class NetModule {

    @NonNull
    private final String baseUrl;

    public NetModule(@NonNull String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Provides
    @NonNull
    Cache provideOkHttpCache(@NonNull Context context) {
        int cacheSize = 10 * 1024 * 1024; // 10 MiB
        return new Cache(context.getCacheDir(), cacheSize);
    }

    @Provides
    @NonNull
    Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        return gsonBuilder.create();
    }

    @Provides
    @NonNull
    Converter.Factory provideRetrofitUniversalConverterFactory(@NonNull Gson gson) {
        return new RetrofitUniversalConverterFactory(gson);
    }

    @Provides
    @NonNull
    CallAdapter.Factory provideRxJava2CallAdapterFactory() {
        return RxJava2CallAdapterFactory.create();
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

    @Singleton
    @Provides
    @NonNull
    Retrofit provideRetrofit(@NonNull Converter.Factory converterFactory,
                             @NonNull CallAdapter.Factory rxAdapter,
                             @NonNull OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .addConverterFactory(converterFactory)
                .addCallAdapterFactory(rxAdapter)
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .build();
    }
}
