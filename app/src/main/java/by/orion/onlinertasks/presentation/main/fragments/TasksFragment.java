package by.orion.onlinertasks.presentation.main.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import by.orion.onlinertasks.App;
import by.orion.onlinertasks.R;
import by.orion.onlinertasks.di.components.presentation.ArticlesPresenterComponent;
import by.orion.onlinertasks.di.components.presentation.DaggerArticlesPresenterComponent;
import by.orion.onlinertasks.di.modules.presentation.TasksPresenterModule;

public class TasksFragment extends MvpAppCompatFragment implements TasksView {

    @BindView(R.id.progressbar_all_tasks)
    ProgressBar progressBar;

    @BindView(R.id.recycler_all_tasks)
    RecyclerView recyclerView;

    @InjectPresenter
    TasksPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_all_tasks, container, false);
        ButterKnife.bind(this, view);
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
    public void showArticles() {
        recyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideArticles() {
        recyclerView.setVisibility(View.GONE);
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

    @NonNull
    public static TasksFragment newInstance() {
        return new TasksFragment();
    }
}
