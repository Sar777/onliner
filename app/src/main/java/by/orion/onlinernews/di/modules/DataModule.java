package by.orion.onlinernews.di.modules;

import android.support.annotation.NonNull;

import dagger.Module;

@Module
public class DataModule {

    @NonNull
    private final String baseUrl;

    public DataModule(@NonNull final String baseUrl) {
        this.baseUrl = baseUrl;
    }
}
