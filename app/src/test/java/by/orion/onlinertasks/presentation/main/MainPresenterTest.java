package by.orion.onlinertasks.presentation.main;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import by.orion.onlinertasks.AppTestRunner;

@RunWith(AppTestRunner.class)
public class MainPresenterTest {

    @Mock
    MainView$$State mainView$$StateMock;

    private MainPresenter mainPresenter;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mainPresenter = new MainPresenter();
        mainPresenter.setViewState(mainView$$StateMock);
    }
}