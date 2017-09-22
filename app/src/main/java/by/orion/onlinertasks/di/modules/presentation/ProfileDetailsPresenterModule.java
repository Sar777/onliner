package by.orion.onlinertasks.di.modules.presentation;

import android.support.annotation.NonNull;

import dagger.Module;
import dagger.Provides;

@Module
public class ProfileDetailsPresenterModule {

    @NonNull
    private final Integer id;

    public ProfileDetailsPresenterModule(@NonNull Integer id) {
        this.id = id;
    }

    @Provides
    @NonNull
    public Integer getId() {
        return id;
    }
}
