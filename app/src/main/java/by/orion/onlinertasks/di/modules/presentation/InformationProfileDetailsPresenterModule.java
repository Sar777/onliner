package by.orion.onlinertasks.di.modules.presentation;

import android.support.annotation.NonNull;

import dagger.Module;
import dagger.Provides;

@Module
public class InformationProfileDetailsPresenterModule {

    @NonNull
    private final Integer id;

    public InformationProfileDetailsPresenterModule(@NonNull Integer id) {
        this.id = id;
    }

    @Provides
    @NonNull
    public Integer getId() {
        return id;
    }
}
