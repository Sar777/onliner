package by.orion.onlinertasks.di.modules;

import android.support.annotation.NonNull;

import javax.inject.Singleton;

import by.orion.onlinertasks.data.datasource.profile.details.ProfileDetailsDataSource;
import by.orion.onlinertasks.data.datasource.profile.reviews.ProfileReviewsDataSource;
import by.orion.onlinertasks.data.datasource.profiles.ProfilesDataSource;
import by.orion.onlinertasks.data.datasource.regions.RegionsDataSource;
import by.orion.onlinertasks.data.datasource.sections.SectionsDataSource;
import by.orion.onlinertasks.data.datasource.splash.SplashDataSource;
import by.orion.onlinertasks.data.datasource.tasks.TasksDataSource;
import by.orion.onlinertasks.data.repository.profile.ProfileDetailsRepository;
import by.orion.onlinertasks.data.repository.profile.ProfileDetailsRepositoryImpl;
import by.orion.onlinertasks.data.repository.profile.reviews.ProfileReviewsRepository;
import by.orion.onlinertasks.data.repository.profile.reviews.ProfileReviewsRepositoryImpl;
import by.orion.onlinertasks.data.repository.profiles.ProfilesRepository;
import by.orion.onlinertasks.data.repository.profiles.ProfilesRepositoryImpl;
import by.orion.onlinertasks.data.repository.regions.RegionsRepository;
import by.orion.onlinertasks.data.repository.regions.RegionsRepositoryImpl;
import by.orion.onlinertasks.data.repository.sections.SectionsRepository;
import by.orion.onlinertasks.data.repository.sections.SectionsRepositoryImpl;
import by.orion.onlinertasks.data.repository.splash.SplashRepository;
import by.orion.onlinertasks.data.repository.splash.SplashRepositoryImpl;
import by.orion.onlinertasks.data.repository.tasks.TasksRepository;
import by.orion.onlinertasks.data.repository.tasks.TasksRepositoryImpl;
import by.orion.onlinertasks.di.qualifiers.LocalDataSource;
import by.orion.onlinertasks.di.qualifiers.RemoteDataSource;
import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Singleton
    @Provides
    @NonNull
    SplashRepository provideSplashRepository(@NonNull @LocalDataSource SplashDataSource localDataSource) {
        return new SplashRepositoryImpl(localDataSource);
    }

    @Singleton
    @Provides
    @NonNull
    TasksRepository provideTasksRepository(@NonNull @LocalDataSource TasksDataSource localDataSource,
                                           @NonNull @RemoteDataSource TasksDataSource remoteDataSource) {
        return new TasksRepositoryImpl(localDataSource, remoteDataSource);
    }

    @Singleton
    @Provides
    @NonNull
    ProfilesRepository provideProfilesRepository(@NonNull @LocalDataSource ProfilesDataSource localDataSource,
                                                 @NonNull @RemoteDataSource ProfilesDataSource remoteDataSource) {
        return new ProfilesRepositoryImpl(localDataSource, remoteDataSource);
    }

    @Singleton
    @Provides
    @NonNull
    ProfileDetailsRepository provideProfileDetailsRepository(@NonNull @LocalDataSource ProfileDetailsDataSource localDataSource,
                                                             @NonNull @RemoteDataSource ProfileDetailsDataSource remoteDataSource) {
        return new ProfileDetailsRepositoryImpl(localDataSource, remoteDataSource);
    }

    @Singleton
    @Provides
    @NonNull
    RegionsRepository provideRegionsRepository(@NonNull @LocalDataSource RegionsDataSource localDataSource,
                                               @NonNull @RemoteDataSource RegionsDataSource remoteDataSource) {
        return new RegionsRepositoryImpl(localDataSource, remoteDataSource);
    }

    @Singleton
    @Provides
    @NonNull
    SectionsRepository provideSectionsRepository(@NonNull @LocalDataSource SectionsDataSource localDataSource,
                                                 @NonNull @RemoteDataSource SectionsDataSource remoteDataSource) {
        return new SectionsRepositoryImpl(localDataSource, remoteDataSource);
    }

    @Singleton
    @Provides
    @NonNull
    ProfileReviewsRepository provideProfileReviewsRepository(@NonNull @LocalDataSource ProfileReviewsDataSource localDataSource,
                                                             @NonNull @RemoteDataSource ProfileReviewsDataSource remoteDataSource) {
        return new ProfileReviewsRepositoryImpl(localDataSource, remoteDataSource);
    }
}
