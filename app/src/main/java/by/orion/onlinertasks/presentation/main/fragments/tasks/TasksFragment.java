package by.orion.onlinertasks.presentation.main.fragments.tasks;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import by.orion.onlinertasks.App;
import by.orion.onlinertasks.R;
import by.orion.onlinertasks.common.adapters.EndlessScrollListener;
import by.orion.onlinertasks.common.exceptions.BaseError;
import by.orion.onlinertasks.di.components.presentation.DaggerTasksPresenterComponent;
import by.orion.onlinertasks.di.components.presentation.TasksPresenterComponent;
import by.orion.onlinertasks.di.modules.presentation.TasksPresenterModule;
import by.orion.onlinertasks.presentation.main.fragments.tasks.adapters.TasksAdapter;
import by.orion.onlinertasks.presentation.main.fragments.tasks.models.TaskItem;

public class TasksFragment extends MvpAppCompatFragment implements TasksView {

    @BindView(R.id.progressbar_all_tasks)
    ProgressBar progressBar;

    @BindView(R.id.recycler_all_tasks)
    RecyclerView recyclerView;

    @InjectPresenter
    TasksPresenter presenter;

    private TasksAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_all_tasks, container, false);
        ButterKnife.bind(this, view);

        initView();
        return view;
    }

    @Override
    public void showError(@NonNull BaseError error) {

    }

    @Override
    public void hideError() {

    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showTasks() {
        recyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideTasks() {
        recyclerView.setVisibility(View.GONE);
    }

    @Override
    public void addTasks(@NonNull List<TaskItem> tasks) {
        adapter.addAll(tasks);
    }

    @Override
    public void enableLoadMoreTasks() {
        recyclerView.addOnScrollListener(new EndlessScrollListener() {
            @Override
            protected void loadMore() {
                adapter.addItem(null);
                presenter.onLoadMoreTasksRequest();
            }
        });
    }

    @Override
    public void disableLoadMoreTasks() {
        recyclerView.clearOnScrollListeners();
    }

    @NonNull
    @ProvidePresenter
    TasksPresenter providePresenter() {
        TasksPresenterComponent tasksPresenterComponent = DaggerTasksPresenterComponent.builder()
                .applicationComponent(App.getComponent())
                .tasksPresenterModule(new TasksPresenterModule())
                .build();

        return tasksPresenterComponent.getPresenter();
    }

    private void initView() {
        adapter = new TasksAdapter();
        adapter.setHasStableIds(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
    }

    @NonNull
    public static TasksFragment newInstance() {
        return new TasksFragment();
    }
}
