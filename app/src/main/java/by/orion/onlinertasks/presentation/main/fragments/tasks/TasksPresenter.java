package by.orion.onlinertasks.presentation.main.fragments.tasks;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import javax.inject.Inject;

import by.orion.onlinertasks.common.exceptions.errors.UnknownError;
import by.orion.onlinertasks.data.models.common.requests.TasksRequestParams;
import by.orion.onlinertasks.domain.interactors.TasksInteractor;
import by.orion.onlinertasks.presentation.common.rx.RxSchedulersProvider;
import by.orion.onlinertasks.presentation.main.fragments.tasks.models.TaskPage;

@InjectViewState
public class TasksPresenter extends MvpPresenter<TasksView> {

    @NonNull
    private final RxSchedulersProvider rxSchedulersProvider;

    @NonNull
    private final TasksInteractor tasksInteractor;

    private int page;
    private int lastPage;

    @Inject
    public TasksPresenter(@NonNull RxSchedulersProvider rxSchedulersProvider,
                          @NonNull TasksInteractor tasksInteractor) {
        this.rxSchedulersProvider = rxSchedulersProvider;
        this.tasksInteractor = tasksInteractor;
    }

    public void onLoadMoreTasksRequest() {
        getViewState().disableLoadMoreTasks();

        loadTasks(TasksRequestParams.builder()
                .page(page + 1)
                .build());
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();

        getViewState().hideError();
        getViewState().hideTasks();
        getViewState().showProgress();

        loadTasks(TasksRequestParams.builder().build());
    }

    private void loadTasks(@NonNull TasksRequestParams params) {
        tasksInteractor.getAllTasks(params)
                .compose(rxSchedulersProvider.getIoToMainTransformerSingle())
                .subscribe(this::onAllTasksSuccess, this::onAllTasksError);
    }

    private void onAllTasksSuccess(@NonNull TaskPage taskPage) {
        page = taskPage.page();
        lastPage = taskPage.lastPage();

        if (page < lastPage) {
            getViewState().enableLoadMoreTasks();
        }

        getViewState().hideProgress();
        getViewState().showTasks();
        getViewState().addTasks(taskPage.tasks());
    }

    private void onAllTasksError(@NonNull Throwable throwable) {
        getViewState().hideProgress();
        getViewState().showError(new UnknownError());
    }
}
