package by.orion.onlinertasks.presentation.main.fragments;


import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import by.orion.onlinertasks.AppTestRunner;
import by.orion.onlinertasks.TestRxSchedulerProvider;
import by.orion.onlinertasks.domain.interactors.TasksInteractor;

@RunWith(AppTestRunner.class)
public class TasksPresenterTest {

    @Mock
    TasksInteractor tasksInteractorMock;

    @Mock
    TasksView$$State articlesView$$StateMock;

    private TasksPresenter tasksPresenter;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        tasksPresenter = new TasksPresenter(new TestRxSchedulerProvider(), tasksInteractorMock);
        tasksPresenter.setViewState(articlesView$$StateMock);
    }
}