package by.orion.onlinertasks.presentation.splash;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import by.orion.onlinertasks.AppTestRunner;
import by.orion.onlinertasks.TestRxSchedulerProvider;
import by.orion.onlinertasks.domain.interactors.SplashInteractor;
import io.reactivex.Single;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(AppTestRunner.class)
public class SplashPresenterTest {

    private static final int DELAY = 3;

    @Mock
    SplashInteractor splashInteractorMock;

    @Mock
    SplashView$$State splashViewStateMock;

    private SplashPresenter splashPresenter;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        splashPresenter = new SplashPresenter(DELAY, splashInteractorMock, new TestRxSchedulerProvider());
        splashPresenter.setViewState(splashViewStateMock);
    }

    @Test
    public void mainScreen_shouldOpenIntroductionScreenWithFirstTimeLaunchOnFirstAttach() {
        when(splashInteractorMock.isFirstTimeLaunchAndChangeIfNeed()).thenReturn(Single.just(true));

        //act
        splashPresenter.onFirstViewAttach();

        // assert
        verify(splashViewStateMock).goToIntroductionScreen();
    }

    @Test
    public void mainScreen_shouldOpenMainScreenOnFirstAttach() {
        when(splashInteractorMock.isFirstTimeLaunchAndChangeIfNeed()).thenReturn(Single.just(false));

        //act
        splashPresenter.onFirstViewAttach();

        // assert
        verify(splashViewStateMock).goToMainScreen();
    }
}