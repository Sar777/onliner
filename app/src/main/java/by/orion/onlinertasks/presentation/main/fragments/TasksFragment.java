package by.orion.onlinertasks.presentation.main.fragments;

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
import by.orion.onlinertasks.data.models.task.Task;
import by.orion.onlinertasks.di.components.presentation.ArticlesPresenterComponent;
import by.orion.onlinertasks.di.components.presentation.DaggerArticlesPresenterComponent;
import by.orion.onlinertasks.di.modules.presentation.TasksPresenterModule;
import by.orion.onlinertasks.presentation.main.fragments.adapters.TasksAdapter;

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
    public void showError() {

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
    public void addTasks(@NonNull List<Task> tasks) {
        adapter.addAll(tasks);
    }

    @NonNull
    @ProvidePresenter
    TasksPresenter providePresenter() {
        ArticlesPresenterComponent articlesPresenterComponent = DaggerArticlesPresenterComponent.builder()
                .applicationComponent(App.getComponent())
                .tasksPresenterModule(new TasksPresenterModule())
                .build();

        return articlesPresenterComponent.getPresenter();
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
