package by.orion.onlinertasks.presentation.main;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import by.orion.onlinertasks.AppTestRunner;
import by.orion.onlinertasks.TestRxSchedulerProvider;
import by.orion.onlinertasks.domain.interactors.MainInteractor;
import by.orion.onlinertasks.presentation.common.models.MenuOption;
import io.reactivex.Single;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(AppTestRunner.class)
public class MainPresenterTest {

    @Mock
    MainInteractor mainInteractorMock;

    @Mock
    MainView$$State mainView$$StateMock;

    private MainPresenter mainPresenter;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mainPresenter = new MainPresenter(mainInteractorMock, new TestRxSchedulerProvider());
        mainPresenter.setViewState(mainView$$StateMock);
    }

    @Test
    public void main_shouldOpenAllTasksOnClickAllTasks() {
        // act
        mainPresenter.onClickMenu(MenuOption.ALL_TASKS);

        // assert
        verify(mainView$$StateMock).showAllTasks();
    }

    @Test
    public void main_shouldOpenAllProfilesOnClickAllProfiles() {
        // act
        mainPresenter.onClickMenu(MenuOption.ALL_PROFILES);

        // assert
        verify(mainView$$StateMock).showAllProfiles();
    }

    @Test
    public void main_shouldHideLoginButtonAfterOnFirstViewAttach() {
        when(mainInteractorMock.isAuthorizedUser()).thenReturn(Single.just(true));

        // act
        mainPresenter.onFirstViewAttach();

        // assert
        verify(mainView$$StateMock).hideLoginButton();
    }

    @Test
    public void main_shouldNotShowLoginButtonIfUserAuthorized() {
        when(mainInteractorMock.isAuthorizedUser()).thenReturn(Single.just(true));

        // act
        mainPresenter.onFirstViewAttach();

        // assert
        verify(mainView$$StateMock, times(0)).showLoginButton();
    }

    @Test
    public void main_shouldShowLoginButtonIfUserNotAuthorized() {
        when(mainInteractorMock.isAuthorizedUser()).thenReturn(Single.just(false));

        // act
        mainPresenter.onFirstViewAttach();

        // assert
        verify(mainView$$StateMock).showLoginButton();
    }
}