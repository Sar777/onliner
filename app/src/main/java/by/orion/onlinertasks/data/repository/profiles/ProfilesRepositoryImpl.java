package by.orion.onlinertasks.data.repository.profiles;

import android.support.annotation.NonNull;

import javax.inject.Inject;

import by.orion.onlinertasks.data.datasource.profiles.ProfilesDataSource;
import by.orion.onlinertasks.data.models.profile.ProfilesPage;
import by.orion.onlinertasks.data.models.requests.ProfilesRequestParams;
import by.orion.onlinertasks.di.qualifiers.LocalDataSource;
import by.orion.onlinertasks.di.qualifiers.RemoteDataSource;
import io.reactivex.Single;

public class ProfilesRepositoryImpl implements ProfilesRepository {

    @NonNull
    private final ProfilesDataSource localDataSource;

    @NonNull
    private final ProfilesDataSource remoteDataSource;

    @Inject
    public ProfilesRepositoryImpl(@NonNull @LocalDataSource ProfilesDataSource localDataSource,
                                  @NonNull @RemoteDataSource ProfilesDataSource remoteDataSource) {
        this.localDataSource = localDataSource;
        this.remoteDataSource = remoteDataSource;
    }

    @Override
    public Single<ProfilesPage> getAllProfiles(@NonNull ProfilesRequestParams params) {
        return remoteDataSource.getAllProfiles(params);
    }
}
