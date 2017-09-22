package by.orion.onlinertasks.di.modules;

import android.support.annotation.NonNull;

import javax.inject.Singleton;

import by.orion.onlinertasks.data.datasource.profile.ProfileDataSource;
import by.orion.onlinertasks.data.datasource.profiles.ProfilesDataSource;
import by.orion.onlinertasks.data.datasource.splash.SplashDataSource;
import by.orion.onlinertasks.data.datasource.tasks.TasksDataSource;
import by.orion.onlinertasks.data.repository.profile.ProfileRepository;
import by.orion.onlinertasks.data.repository.profile.ProfileRepositoryImpl;
import by.orion.onlinertasks.data.repository.profiles.ProfilesRepository;
import by.orion.onlinertasks.data.repository.profiles.ProfilesRepositoryImpl;
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
    ProfileRepository provideProfileRepository(@NonNull @LocalDataSource ProfileDataSource localDataSource,
                                               @NonNull @RemoteDataSource ProfileDataSource remoteDataSource) {
        return new ProfileRepositoryImpl(localDataSource, remoteDataSource);
    }
}
