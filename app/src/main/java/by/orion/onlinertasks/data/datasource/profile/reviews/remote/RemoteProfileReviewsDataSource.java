package by.orion.onlinertasks.data.datasource.profile.reviews.remote;

import android.support.annotation.NonNull;

import by.orion.onlinertasks.common.network.services.BaseService;
import by.orion.onlinertasks.data.datasource.profile.reviews.ProfileReviewsDataSource;
import by.orion.onlinertasks.data.models.common.requests.ProfileReviewsRequestParams;
import by.orion.onlinertasks.data.models.profile.reviews.ProfileReviewsPage;
import io.reactivex.Completable;
import io.reactivex.Single;

public class RemoteProfileReviewsDataSource implements ProfileReviewsDataSource {

    @NonNull
    private final BaseService service;

    public RemoteProfileReviewsDataSource(@NonNull BaseService service) {
        this.service = service;
    }

    @Override
    public Single<ProfileReviewsPage> getValue(@NonNull Integer key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Completable setValue(@NonNull Integer key, @NonNull ProfileReviewsPage value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Single<ProfileReviewsPage> getReviews(@NonNull ProfileReviewsRequestParams params) {
        return service.getProfileReviews(params.id(), params.page(), params.role().getName());
    }
}
