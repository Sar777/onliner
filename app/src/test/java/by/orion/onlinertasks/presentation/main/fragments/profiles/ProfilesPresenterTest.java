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
    ProfilesView$$State tasksView$$StateMock;

    private ProfilesPresenter profilesPresenter;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        profilesPresenter = new ProfilesPresenter(new TestRxSchedulerProvider(), profilesInteractorMock);
        profilesPresenter.setViewState(tasksView$$StateMock);
    }

    @Test
    public void profiles_shouldShowProgressHideErrorHideProfiles() {
        when(profilesInteractorMock.getAllProfiles(any())).thenReturn(Single.just(mock(ProfilePage.class)));

        // act
        profilesPresenter.onFirstViewAttach();

        // assert
        verify(tasksView$$StateMock).showProgress();
        verify(tasksView$$StateMock).hideError();
        verify(tasksView$$StateMock).hideProfiles();
    }

    @Test
    public void profiles_shouldLoadProfilesSuccessOnFirstViewAttach() {
        when(profilesInteractorMock.getAllProfiles(any())).thenReturn(Single.just(mock(ProfilePage.class)));

        //act
        profilesPresenter.onFirstViewAttach();

        // assert
        verify(tasksView$$StateMock).hideProgress();
        verify(tasksView$$StateMock).showProfiles();
        verify(tasksView$$StateMock).addProfiles(any());
    }

    @Test
    public void profiles_shouldLoadProfilesErrorOnFirstViewAttach() {
        when(profilesInteractorMock.getAllProfiles(any())).thenReturn(Single.error(new IllegalArgumentException()));

        //act
        profilesPresenter.onFirstViewAttach();

        // assert
        verify(tasksView$$StateMock).hideProgress();
        verify(tasksView$$StateMock).showError(any());
    }

    @Test
    public void profiles_shouldLoadMoreProfilesRequestEnableListener() {
        when(profilesInteractorMock.getAllProfiles(any())).thenReturn(Single.just(getProfilePage(1, 999)));

        profilesPresenter.onLoadMoreProfilesRequest();

        // assert
        verify(tasksView$$StateMock).disableLoadMoreProfiles();

        verify(tasksView$$StateMock).enableLoadMoreProfiles();

        verify(tasksView$$StateMock).hideProgress();
        verify(tasksView$$StateMock).showProfiles();
        verify(tasksView$$StateMock).addProfiles(any());
    }

    @Test
    public void profiles_shouldLoadMoreProfilesRequestLastPage() {
        when(profilesInteractorMock.getAllProfiles(any())).thenReturn(Single.just(getProfilePage(2, 2)));

        profilesPresenter.onLoadMoreProfilesRequest();

        // assert
        verify(tasksView$$StateMock).disableLoadMoreProfiles();

        verify(tasksView$$StateMock, times(0)).enableLoadMoreProfiles();

        verify(tasksView$$StateMock).hideProgress();
        verify(tasksView$$StateMock).showProfiles();
        verify(tasksView$$StateMock).addProfiles(any());
    }

    private ProfilePage getProfilePage(int page, int lastPage) {
        return ProfilePage.builder()
                .page(page)
                .profiles(new ArrayList<>())
                .lastPage(lastPage)
                .build();
    }
}