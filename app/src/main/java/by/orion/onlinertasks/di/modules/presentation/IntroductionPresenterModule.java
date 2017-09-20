package by.orion.onlinertasks.di.modules.presentation;

import dagger.Module;
import dagger.Provides;

@Module
public class IntroductionPresenterModule {

    private final int maxPages;

    public IntroductionPresenterModule(int maxPages) {
        this.maxPages = maxPages;
    }

    @Provides
    public int getMaxPages() {
        return maxPages;
    }
}
