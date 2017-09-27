package by.orion.onlinertasks.data.repository.profile;

import android.support.annotation.NonNull;

import javax.inject.Inject;

import by.orion.onlinertasks.data.datasource.profile.details.ProfileDetailsDataSource;
import by.orion.onlinertasks.data.models.common.requests.ProfileRequestParams;
import by.orion.onlinertasks.data.models.profile.details.Profile;
import by.orion.onlinertasks.di.qualifiers.LocalDataSource;
import by.orion.onlinertasks.di.qualifiers.RemoteDataSource;
import io.reactivex.Single;

public class ProfileDetailsRepositoryImpl implements ProfileDetailsRepository {

    @NonNull
    private final ProfileDetailsDataSource localDataSource;

    @NonNull
    private final ProfileDetailsDataSource remoteDataSource;

    @Inject
    public ProfileDetailsRepositoryImpl(@NonNull @LocalDataSource ProfileDetailsDataSource localDataSource,
                                        @NonNull @RemoteDataSource ProfileDetailsDataSource remoteDataSource) {
        this.localDataSource = localDataSource;
        this.remoteDataSource = remoteDataSource;
    }

    @Override
    public Single<Profile> getProfile(@NonNull ProfileRequestParams params) {
        return remoteDataSource.getProfile(params);
    }
}
