package by.orion.onlinertasks.presentation.main.fragments;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import javax.inject.Inject;

import by.orion.onlinertasks.data.models.task.TasksPage;
import by.orion.onlinertasks.data.models.task.TasksRequestParams;
import by.orion.onlinertasks.domain.interactors.TasksInteractor;
import by.orion.onlinertasks.presentation.common.rx.RxSchedulersProvider;

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

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();

        getViewState().hideError();
        getViewState().hideTasks();
        getViewState().showProgress();

        tasksInteractor.getAllTasks(new TasksRequestParams())
                .compose(rxSchedulersProvider.getIoToMainTransformerSingle())
                .subscribe(this::onAllTasksSuccess, this::onAllTasksError);
    }

    private void onAllTasksSuccess(@NonNull TasksPage tasksPage) {
        page = tasksPage.page().current();
        lastPage = tasksPage.page().last();

        getViewState().hideProgress();
        getViewState().showTasks();
        getViewState().addTasks(tasksPage.tasks());
    }

    private void onAllTasksError(@NonNull Throwable throwable) {
        getViewState().hideProgress();
        getViewState().showError();
    }
}
