package by.orion.onlinertasks.di.modules;

import android.support.annotation.NonNull;

import javax.inject.Singleton;

import by.orion.onlinertasks.data.datasource.profiles.ProfilesDataSource;
import by.orion.onlinertasks.data.datasource.tasks.TasksDataSource;
import by.orion.onlinertasks.data.repository.profiles.ProfilesRepository;
import by.orion.onlinertasks.data.repository.profiles.ProfilesRepositoryImpl;
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
}
