package by.orion.onlinertasks.presentation.main.fragments.profiles;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import by.orion.onlinertasks.AppTestRunner;
import by.orion.onlinertasks.TestRxSchedulerProvider;
import by.orion.onlinertasks.domain.interactors.ProfilesInteractor;
import by.orion.onlinertasks.presentation.main.fragments.profiles.models.ProfilePage;
import io.reactivex.Single;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(AppTestRunner.class)
public class ProfilesPresenterTest {

    @Mock
    ProfilesInteractor profilesInteractorMock;

    @Mock
    ProfilesView$$State articlesView$$StateMock;

    private ProfilesPresenter profilesPresenter;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        profilesPresenter = new ProfilesPresenter(new TestRxSchedulerProvider(), profilesInteractorMock);
        profilesPresenter.setViewState(articlesView$$StateMock);
    }

    @Test
    public void profiles_shouldShowProgressHideErrorHideProfiles() {
        when(profilesInteractorMock.getAllProfiles(any())).thenReturn(Single.just(mock(ProfilePage.class)));

        // act
        profilesPresenter.onFirstViewAttach();

        // assert
        verify(articlesView$$StateMock).showProgress();
        verify(articlesView$$StateMock).hideError();
        verify(articlesView$$StateMock).hideProfiles();
    }

    @Test
    public void profiles_shouldLoadProfilesSuccessOnFirstViewAttach() {
        when(profilesInteractorMock.getAllProfiles(any())).thenReturn(Single.just(mock(ProfilePage.class)));

        //act
        profilesPresenter.onFirstViewAttach();

        // assert
        verify(articlesView$$StateMock).hideProgress();
        verify(articlesView$$StateMock).showProfiles();
        verify(articlesView$$StateMock).addProfiles(any());
    }

    @Test
    public void profiles_shouldLoadProfilesErrorOnFirstViewAttach() {
        when(profilesInteractorMock.getAllProfiles(any())).thenReturn(Single.error(new IllegalArgumentException()));

        //act
        profilesPresenter.onFirstViewAttach();

        // assert
        verify(articlesView$$StateMock).hideProgress();
        verify(articlesView$$StateMock).showError();
    }

    @Test
    public void profiles_shouldLoadMoreProfilesRequestEnableListener() {
        when(profilesInteractorMock.getAllProfiles(any())).thenReturn(Single.just(getProfilePage(1, 999)));

        profilesPresenter.onLoadMoreProfilesRequest();

        // assert
        verify(articlesView$$StateMock).disableLoadMoreProfiles();

        verify(articlesView$$StateMock).enableLoadMoreProfiles();

        verify(articlesView$$StateMock).hideProgress();
        verify(articlesView$$StateMock).showProfiles();
        verify(articlesView$$StateMock).addProfiles(any());
    }

    @Test
    public void profiles_shouldLoadMoreProfilesRequestLastPage() {
        when(profilesInteractorMock.getAllProfiles(any())).thenReturn(Single.just(getProfilePage(2, 2)));

        profilesPresenter.onLoadMoreProfilesRequest();

        // assert
        verify(articlesView$$StateMock).disableLoadMoreProfiles();

        verify(articlesView$$StateMock, times(0)).enableLoadMoreProfiles();

        verify(articlesView$$StateMock).hideProgress();
        verify(articlesView$$StateMock).showProfiles();
        verify(articlesView$$StateMock).addProfiles(any());
    }

    private ProfilePage getProfilePage(int page, int lastPage) {
        return ProfilePage.builder()
                .page(page)
                .profiles(new ArrayList<>())
                .lastPage(lastPage)
                .build();
    }
}