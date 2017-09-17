package by.orion.onlinertasks.di.modules;

import android.support.annotation.NonNull;

import dagger.Module;

@Module
public class TestDataModule {

    @NonNull
    private final String baseUrl;

    public TestDataModule(@NonNull final String baseUrl) {
        this.baseUrl = baseUrl;
    }
}