package by.orion.onlinertasks.di.modules;

import android.content.Context;
import android.support.annotation.NonNull;

import javax.inject.Singleton;

import by.orion.onlinertasks.presentation.main.fragments.profiles.mappers.ListProfileToListProfileItemMapper;
import by.orion.onlinertasks.presentation.main.fragments.tasks.mappers.ListTaskToListTaskItemMapper;
import by.orion.onlinertasks.presentation.profile.details.pages.mappers.ProfileToProfileDetailsInformationMapper;
import dagger.Module;
import dagger.Provides;

@Module
public class MappersModule {

    @Singleton
    @Provides
    @NonNull
    ListTaskToListTaskItemMapper provideListTaskToListTaskItemMapper(@NonNull Context context) {
        return new ListTaskToListTaskItemMapper(context);
    }

    @Singleton
    @Provides
    @NonNull
    ListProfileToListProfileItemMapper provideListProfileToListProfileItemMapper(@NonNull Context context) {
        return new ListProfileToListProfileItemMapper(context);
    }

    @Singleton
    @Provides
    @NonNull
    ProfileToProfileDetailsInformationMapper provideProfileToProfileDetailsInformationMapper(@NonNull Context context) {
        return new ProfileToProfileDetailsInformationMapper(context);
    }
}
