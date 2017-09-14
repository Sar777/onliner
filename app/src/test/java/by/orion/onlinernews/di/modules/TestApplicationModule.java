package by.orion.onlinernews.di.modules;

import android.content.Context;
import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class TestApplicationModule {

    private final Context context;

    public TestApplicationModule(Context context) {
        this.context = context.getApplicationContext();
    }

    @Provides
    @Singleton
    @NonNull
    Context provideApplicationContext() {
        return context;
    }
}