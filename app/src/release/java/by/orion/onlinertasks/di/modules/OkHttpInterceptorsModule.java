package by.orion.onlinertasks.di.modules;

import android.accounts.AccountManager;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.inject.Singleton;

import by.orion.onlinertasks.common.network.interceptors.AuthenticatorInterceptor;
import by.orion.onlinertasks.common.network.interceptors.HeadersInterceptor;
import by.orion.onlinertasks.di.qualifiers.OkHttpInterceptors;
import by.orion.onlinertasks.di.qualifiers.OkHttpNetworkInterceptors;
import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;

import static java.util.Collections.emptyList;

@Module
public class OkHttpInterceptorsModule {

    @NonNull
    private static final String HEADERS_INTERCEPTOR = "HEADERS_INTERCEPTOR";

    @NonNull
    private static final String AUTHENTICATOR_INTERCEPTOR = "AUTHENTICATOR_INTERCEPTOR";

    @Named(HEADERS_INTERCEPTOR)
    @Provides
    @Singleton
    @NonNull
    public Interceptor provideHeadersInterceptor() {
        return new HeadersInterceptor();
    }

    @Named(AUTHENTICATOR_INTERCEPTOR)
    @Provides
    @Singleton
    @NonNull
    public Interceptor provideAuthenticatorInterceptor(@NonNull AccountManager accountManager) {
        return new AuthenticatorInterceptor(accountManager);
    }

    @Provides
    @OkHttpInterceptors
    @Singleton
    @NonNull
    public List<Interceptor> provideOkHttpInterceptors(@NonNull @Named(HEADERS_INTERCEPTOR) Interceptor headersInterceptor,
                                                       @NonNull @Named(AUTHENTICATOR_INTERCEPTOR) Interceptor authenticatorInterceptor) {
        List<Interceptor> interceptors = new ArrayList<>();
        interceptors.add(headersInterceptor);
        interceptors.add(authenticatorInterceptor);
        return interceptors;
    }

    @Provides
    @OkHttpNetworkInterceptors
    @Singleton
    @NonNull
    public List<Interceptor> provideOkHttpNetworkInterceptors() {
        return emptyList();
    }
}
