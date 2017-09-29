package by.orion.onlinertasks.di.modules;

import android.accounts.AccountManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
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

    @Singleton
    @Provides
    @NonNull
    Context provideApplicationContext() {
        return context;
    }

    @Singleton
    @Provides
    @NonNull
    SharedPreferences provideSharedPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    @Singleton
    @Provides
    @NonNull
    AccountManager provideAccountManager() {
        return AccountManager.get(context);
    }
}