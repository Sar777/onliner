package by.orion.onlinernews.presentation.splash;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import by.orion.onlinernews.AppTestRunner;
import by.orion.onlinernews.TestRxSchedulerProvider;

import static org.mockito.Mockito.verify;

@RunWith(AppTestRunner.class)
public class SplashPresenterTest {

    private static final int DELAY = 3;

    @Mock
    SplashView$$State splashViewStateMock;

    private SplashPresenter splashPresenter;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        splashPresenter = new SplashPresenter(DELAY, new TestRxSchedulerProvider());
        splashPresenter.setViewState(splashViewStateMock);
    }

    @Test
    public void mainScreen_shouldOpenMainScreenOnFirstAttach() {
        //act
        splashPresenter.onFirstViewAttach();

        // assert
        verify(splashViewStateMock).goToMainScreen();
    }
}