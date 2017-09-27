package by.orion.onlinertasks.data.repository.profile.reviews;

import android.support.annotation.NonNull;

import javax.inject.Inject;

import by.orion.onlinertasks.data.datasource.profile.reviews.ProfileReviewsDataSource;
import by.orion.onlinertasks.data.models.common.requests.ProfileReviewsRequestParams;
import by.orion.onlinertasks.data.models.profile.reviews.ProfileReviewsPage;
import by.orion.onlinertasks.di.qualifiers.LocalDataSource;
import by.orion.onlinertasks.di.qualifiers.RemoteDataSource;
import io.reactivex.Single;

public class ProfileReviewsRepositoryImpl implements ProfileReviewsRepository {

    @NonNull
    private final ProfileReviewsDataSource localDataSource;

    @NonNull
    private final ProfileReviewsDataSource remoteDataSource;

    @Inject
    public ProfileReviewsRepositoryImpl(@NonNull @LocalDataSource ProfileReviewsDataSource localDataSource,
                                        @NonNull @RemoteDataSource ProfileReviewsDataSource remoteDataSource) {
        this.localDataSource = localDataSource;
        this.remoteDataSource = remoteDataSource;
    }

    @Override
    public Single<ProfileReviewsPage> getReviews(@NonNull ProfileReviewsRequestParams params) {
        return remoteDataSource.getReviews(params);
    }
}
