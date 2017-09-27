package by.orion.onlinertasks.data.datasource.profile.reviews.local;

import android.support.annotation.NonNull;

import com.pushtorefresh.storio.sqlite.StorIOSQLite;

import javax.inject.Inject;

import by.orion.onlinertasks.data.datasource.profile.reviews.ProfileReviewsDataSource;
import by.orion.onlinertasks.data.models.common.requests.ProfileReviewsRequestParams;
import by.orion.onlinertasks.data.models.profile.reviews.ProfileReviewsPage;
import io.reactivex.Completable;
import io.reactivex.Single;

public class LocalProfileReviewsDataSource implements ProfileReviewsDataSource {

    @NonNull
    private final StorIOSQLite storIOSQLite;

    @Inject
    public LocalProfileReviewsDataSource(@NonNull StorIOSQLite storIOSQLite) {
        this.storIOSQLite = storIOSQLite;
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
        throw new UnsupportedOperationException();
    }
}
