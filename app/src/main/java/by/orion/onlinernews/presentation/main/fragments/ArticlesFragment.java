package by.orion.onlinernews.presentation.main.fragments;

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
import by.orion.onlinernews.App;
import by.orion.onlinernews.R;
import by.orion.onlinernews.di.components.presentation.ArticlesPresenterComponent;
import by.orion.onlinernews.di.components.presentation.DaggerArticlesPresenterComponent;
import by.orion.onlinernews.di.modules.presentation.ArticlesPresenterModule;
import by.orion.onlinernews.presentation.common.models.ArticleCategory;

public class ArticlesFragment extends MvpAppCompatFragment implements ArticlesView {

    @NonNull
    private static final String BUNDLE_ARTICLES_CATEGORY_TYPE = "BUNDLE_ARTICLES_CATEGORY_TYPE";

    @BindView(R.id.progressbar_articles_by_category)
    ProgressBar progressBar;

    @BindView(R.id.recycler_articles_by_category)
    RecyclerView recyclerView;

    @InjectPresenter
    ArticlesPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_articles, container, false);
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
    ArticlesPresenter providePresenter() {
        ArticleCategory category = ArticleCategory.valueOf(getArguments().getInt(BUNDLE_ARTICLES_CATEGORY_TYPE));

        ArticlesPresenterComponent articlesPresenterComponent = DaggerArticlesPresenterComponent.builder()
                .applicationComponent(App.getComponent())
                .articlesPresenterModule(new ArticlesPresenterModule(category))
                .build();

        return articlesPresenterComponent.getPresenter();
    }

    @NonNull
    public static ArticlesFragment newInstance(@NonNull ArticleCategory category) {
        Bundle args = new Bundle();
        args.putInt(BUNDLE_ARTICLES_CATEGORY_TYPE, category.getId());

        ArticlesFragment fragment = new ArticlesFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
