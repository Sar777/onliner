package by.orion.onlinertasks.presentation.main;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import by.orion.onlinertasks.AppTestRunner;
import by.orion.onlinertasks.presentation.common.models.MenuOption;

import static org.mockito.Mockito.verify;

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
}