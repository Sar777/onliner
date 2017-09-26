package by.orion.onlinertasks.di.modules;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import com.pushtorefresh.storio.sqlite.StorIOSQLite;

import javax.inject.Singleton;

import by.orion.onlinertasks.common.network.services.BaseService;
import by.orion.onlinertasks.data.datasource.profile.details.ProfileDetailsDataSource;
import by.orion.onlinertasks.data.datasource.profile.details.local.LocalProfileDetailsDataSource;
import by.orion.onlinertasks.data.datasource.profile.details.remote.RemoteProfileDetailsDataSource;
import by.orion.onlinertasks.data.datasource.profiles.ProfilesDataSource;
import by.orion.onlinertasks.data.datasource.profiles.local.LocalProfilesDataSource;
import by.orion.onlinertasks.data.datasource.profiles.remote.RemoteProfilesDataSource;
import by.orion.onlinertasks.data.datasource.regions.RegionsDataSource;
import by.orion.onlinertasks.data.datasource.regions.local.LocalRegionsDataSource;
import by.orion.onlinertasks.data.datasource.regions.remote.RemoteRegionsDataSource;
import by.orion.onlinertasks.data.datasource.splash.SplashDataSource;
import by.orion.onlinertasks.data.datasource.splash.local.LocalSplashDataSource;
import by.orion.onlinertasks.data.datasource.tasks.TasksDataSource;
import by.orion.onlinertasks.data.datasource.tasks.local.LocalTasksDataSource;
import by.orion.onlinertasks.data.datasource.tasks.remote.RemoteTasksDataSource;
import by.orion.onlinertasks.di.qualifiers.LocalDataSource;
import by.orion.onlinertasks.di.qualifiers.RemoteDataSource;
import dagger.Module;
import dagger.Provides;

@Module
public class DataSourceModule {

    @Singleton
    @LocalDataSource
    @Provides
    @NonNull
    SplashDataSource provideLocalSplashDataSource(@NonNull SharedPreferences sharedPreferences) {
        return new LocalSplashDataSource(sharedPreferences);
    }

    @Singleton
    @LocalDataSource
    @Provides
    @NonNull
    TasksDataSource provideLocalTasksDataSource(@NonNull StorIOSQLite storIOSQLite) {
        return new LocalTasksDataSource(storIOSQLite);
    }

    @Singleton
    @RemoteDataSource
    @Provides
    @NonNull
    TasksDataSource provideRemoteTasksDataSource(@NonNull BaseService service) {
        return new RemoteTasksDataSource(service);
    }

    @Singleton
    @LocalDataSource
    @Provides
    @NonNull
    ProfilesDataSource provideLocalProfilesDataSource(@NonNull StorIOSQLite storIOSQLite) {
        return new LocalProfilesDataSource(storIOSQLite);
    }

    @Singleton
    @RemoteDataSource
    @Provides
    @NonNull
    ProfilesDataSource provideRemoteProfilesDataSource(@NonNull BaseService service) {
        return new RemoteProfilesDataSource(service);
    }

    @Singleton
    @LocalDataSource
    @Provides
    @NonNull
    ProfileDetailsDataSource provideLocalProfileDetailsDataSource(@NonNull StorIOSQLite storIOSQLite) {
        return new LocalProfileDetailsDataSource(storIOSQLite);
    }

    @Singleton
    @RemoteDataSource
    @Provides
    @NonNull
    ProfileDetailsDataSource provideRemoteProfileDetailsDataSource(@NonNull BaseService service) {
        return new RemoteProfileDetailsDataSource(service);
    }

    @Singleton
    @LocalDataSource
    @Provides
    @NonNull
    RegionsDataSource provideLocalRegionsDataSource(@NonNull StorIOSQLite storIOSQLite) {
        return new LocalRegionsDataSource(storIOSQLite);
    }

    @Singleton
    @RemoteDataSource
    @Provides
    @NonNull
    RegionsDataSource provideRemoteRegionsDataSource(@NonNull BaseService service) {
        return new RemoteRegionsDataSource(service);
    }
}
