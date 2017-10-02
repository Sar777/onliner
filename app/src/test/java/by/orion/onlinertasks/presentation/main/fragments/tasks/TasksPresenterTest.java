package by.orion.onlinertasks.presentation.main.fragments.tasks;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import by.orion.onlinertasks.AppTestRunner;
import by.orion.onlinertasks.TestRxSchedulerProvider;
import by.orion.onlinertasks.domain.interactors.TasksInteractor;
import by.orion.onlinertasks.presentation.main.fragments.tasks.models.TaskPage;
import io.reactivex.Single;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(AppTestRunner.class)
public class TasksPresenterTest {

    @Mock
    TasksInteractor tasksInteractorMock;

    @Mock
    TasksView$$State tasksView$$StateMock;

    private TasksPresenter tasksPresenter;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        tasksPresenter = new TasksPresenter(new TestRxSchedulerProvider(), tasksInteractorMock);
        tasksPresenter.setViewState(tasksView$$StateMock);
    }

    @Test
    public void task_shouldShowProgressHideErrorHideTasks() {
        when(tasksInteractorMock.getAllTasks(any())).thenReturn(Single.just(mock(TaskPage.class)));

        // act
        tasksPresenter.onFirstViewAttach();

        // assert
        verify(tasksView$$StateMock).showProgress();
        verify(tasksView$$StateMock).hideError();
        verify(tasksView$$StateMock).hideTasks();
    }

    @Test
    public void tasks_shouldLoadTasksSuccessOnFirstViewAttach() {
        when(tasksInteractorMock.getAllTasks(any())).thenReturn(Single.just(mock(TaskPage.class)));

        //act
        tasksPresenter.onFirstViewAttach();

        // assert
        verify(tasksView$$StateMock).hideProgress();
        verify(tasksView$$StateMock).showTasks();
        verify(tasksView$$StateMock).addTasks(any());
    }

    @Test
    public void tasks_shouldLoadTasksErrorOnFirstViewAttach() {
        when(tasksInteractorMock.getAllTasks(any())).thenReturn(Single.error(new IllegalArgumentException()));

        //act
        tasksPresenter.onFirstViewAttach();

        // assert
        verify(tasksView$$StateMock).hideProgress();
        verify(tasksView$$StateMock).showError(any());
    }

    @Test
    public void tasks_shouldLoadMoreTasksRequestEnableListener() {
        TaskPage taskPage = TaskPage.builder()
                .page(1)
                .tasks(new ArrayList<>())
                .lastPage(999)
                .build();

        when(tasksInteractorMock.getAllTasks(any())).thenReturn(Single.just(taskPage));

        tasksPresenter.onLoadMoreTasksRequest();

        // assert
        verify(tasksView$$StateMock).disableLoadMoreTasks();

        verify(tasksView$$StateMock).enableLoadMoreTasks();

        verify(tasksView$$StateMock).hideProgress();
        verify(tasksView$$StateMock).showTasks();
        verify(tasksView$$StateMock).addTasks(any());
    }

    @Test
    public void tasks_shouldLoadMoreTasksRequestLastPage() {
        TaskPage taskPage = TaskPage.builder()
                .page(2)
                .tasks(new ArrayList<>())
                .lastPage(2)
                .build();

        when(tasksInteractorMock.getAllTasks(any())).thenReturn(Single.just(taskPage));

        tasksPresenter.onLoadMoreTasksRequest();

        // assert
        verify(tasksView$$StateMock).disableLoadMoreTasks();

        verify(tasksView$$StateMock, times(0)).enableLoadMoreTasks();

        verify(tasksView$$StateMock).hideProgress();
        verify(tasksView$$StateMock).showTasks();
        verify(tasksView$$StateMock).addTasks(any());
    }
}