package by.orion.onlinertasks.data.repository.profile;

import android.support.annotation.NonNull;

import javax.inject.Inject;

import by.orion.onlinertasks.data.datasource.profile.ProfileDataSource;
import by.orion.onlinertasks.data.models.profile.details.Profile;
import by.orion.onlinertasks.data.models.requests.ProfileRequestParams;
import by.orion.onlinertasks.di.qualifiers.LocalDataSource;
import by.orion.onlinertasks.di.qualifiers.RemoteDataSource;
import io.reactivex.Single;

public class ProfileRepositoryImpl implements ProfileRepository {

    @NonNull
    private final ProfileDataSource localDataSource;

    @NonNull
    private final ProfileDataSource remoteDataSource;

    @Inject
    public ProfileRepositoryImpl(@NonNull @LocalDataSource ProfileDataSource localDataSource,
                                 @NonNull @RemoteDataSource ProfileDataSource remoteDataSource) {
        this.localDataSource = localDataSource;
        this.remoteDataSource = remoteDataSource;
    }

    @Override
    public Single<Profile> getProfile(@NonNull ProfileRequestParams params) {
        return remoteDataSource.getProfile(params);
    }
}
