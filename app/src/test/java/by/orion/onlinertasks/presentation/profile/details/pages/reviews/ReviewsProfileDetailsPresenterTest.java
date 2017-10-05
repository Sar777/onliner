package by.orion.onlinertasks.presentation.profile.details.pages.reviews;

import android.support.annotation.NonNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import by.orion.onlinertasks.AppTestRunner;
import by.orion.onlinertasks.TestRxSchedulerProvider;
import by.orion.onlinertasks.data.models.common.Role;
import by.orion.onlinertasks.data.models.common.requests.ProfileReviewsRequestParams;
import by.orion.onlinertasks.domain.interactors.ReviewsProfileDetailsInteractor;
import by.orion.onlinertasks.presentation.profile.details.pages.reviews.models.AuthorItem;
import by.orion.onlinertasks.presentation.profile.details.pages.reviews.models.RatingItem;
import by.orion.onlinertasks.presentation.profile.details.pages.reviews.models.ReviewItem;
import io.reactivex.Single;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(AppTestRunner.class)
public class ReviewsProfileDetailsPresenterTest {

    private final static int TEST_ID = 1;

    @Mock
    ReviewsProfileDetailsInteractor reviewsProfileDetailsInteractorMock;

    @Mock
    ReviewsProfileDetailsView$$State reviewsProfileDetailsViewStateMock;

    private ReviewsProfileDetailsPresenter presenter;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        presenter = new ReviewsProfileDetailsPresenter(TEST_ID, reviewsProfileDetailsInteractorMock, new TestRxSchedulerProvider());
        presenter.setViewState(reviewsProfileDetailsViewStateMock);
    }

    @Test
    public void shouldShowProgressAndHideReviewsOnFirstViewAttach() {
        when(reviewsProfileDetailsInteractorMock.getProfileReviews(getRequestParams())).thenReturn(Single.just(getListItems()));

        //act
        presenter.onFirstViewAttach();

        // assert
        verify(reviewsProfileDetailsViewStateMock).showProgress();
        verify(reviewsProfileDetailsViewStateMock).hideReviews();
    }

    @Test
    public void shouldHideProgressAndShowAndSetReviewsAfterSuccessLoad() {
        when(reviewsProfileDetailsInteractorMock.getProfileReviews(getRequestParams())).thenReturn(Single.just(getListItems()));

        //act
        presenter.onFirstViewAttach();

        // assert
        verify(reviewsProfileDetailsViewStateMock).hideProgress();
        verify(reviewsProfileDetailsViewStateMock).setReviews(any());
        verify(reviewsProfileDetailsViewStateMock).showReviews();
    }

    @Test
    public void shouldHideProgressAndShowErrorAfterErrorLoad() {
        when(reviewsProfileDetailsInteractorMock.getProfileReviews(getRequestParams())).thenReturn(Single.error(new RuntimeException()));

        //act
        presenter.onFirstViewAttach();

        // assert
        verify(reviewsProfileDetailsViewStateMock, times(0)).showReviews();
        verify(reviewsProfileDetailsViewStateMock, times(0)).setReviews(any());

        verify(reviewsProfileDetailsViewStateMock).hideProgress();
        verify(reviewsProfileDetailsViewStateMock).showError(any());
    }

    @NonNull
    private ProfileReviewsRequestParams getRequestParams() {
        return ProfileReviewsRequestParams.builder()
                .id(TEST_ID)
                .role(Role.EXECUTOR)
                .page(1)
                .build();
    }

    @NonNull
    private List<ReviewItem> getListItems() {
        List<ReviewItem> items = new ArrayList<>();
        for (int i = 0; i < 10; ++i) {
            items.add(ReviewItem.builder()
                    .id(0)
                    .averageRating(0.0f)
                    .rating(RatingItem.builder().politeness(0).punctuality(0).quality(0).build())
                    .review("Test")
                    .author(AuthorItem.builder().id(0).name("Test").photo("Test").build())
                    .createdAt(new Date())
                    .profileRole(Role.EXECUTOR)
                    .build());
        }

        return items;
    }
}