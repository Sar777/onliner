package by.orion.onlinertasks.di.modules;

import android.support.annotation.NonNull;

import javax.inject.Singleton;

import by.orion.onlinertasks.data.datasource.tasks.TasksDataSource;
import by.orion.onlinertasks.data.repository.tasks.TasksRepository;
import by.orion.onlinertasks.data.repository.tasks.TasksRepositoryImpl;
import by.orion.onlinertasks.di.qualifiers.LocalDataSource;
import by.orion.onlinertasks.di.qualifiers.RemoteDataSource;
import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Provides
    @Singleton
    TasksRepository provideTasksRepository(@NonNull @LocalDataSource TasksDataSource localDataSource,
                                           @NonNull @RemoteDataSource TasksDataSource remoteDataSource) {
        return new TasksRepositoryImpl(localDataSource, remoteDataSource);
    }
}
