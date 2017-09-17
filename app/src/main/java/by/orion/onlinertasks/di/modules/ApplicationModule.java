package by.orion.onlinertasks.di.modules;

import android.content.Context;
import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    @NonNull
    private final Context context;

    public ApplicationModule(@NonNull final Context context) {
        this.context = context.getApplicationContext();
    }

    @Provides
    @Singleton
    @NonNull
    Context provideApplicationContext() {
        return context;
    }

}