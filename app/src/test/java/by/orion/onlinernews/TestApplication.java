package by.orion.onlinernews;

import android.support.annotation.Nullable;

import by.orion.onlinernews.di.components.ApplicationComponent;

public class TestApplication extends App {

    @Nullable
    @Override
    public ApplicationComponent buildComponent() {
        return null;
    }
}
