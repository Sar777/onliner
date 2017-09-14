package by.orion.onlinernews.di.modules.presentation;

import dagger.Module;
import dagger.Provides;

@Module
public class SplashPresenterModule {

    private static final int DELAY_SPLASH = 3; // in secs

    @Provides
    public int getSplashDelay() {
        return DELAY_SPLASH;
    }
}
