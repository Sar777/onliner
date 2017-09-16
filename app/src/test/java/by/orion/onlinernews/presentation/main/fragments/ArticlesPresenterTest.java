package by.orion.onlinernews.presentation.main.fragments;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import by.orion.onlinernews.AppTestRunner;
import by.orion.onlinernews.TestRxSchedulerProvider;
import by.orion.onlinernews.data.models.Article;
import by.orion.onlinernews.data.models.impl.RemoteArticle;
import by.orion.onlinernews.domain.interactors.ArticlesInteractor;
import by.orion.onlinernews.presentation.common.models.ArticleCategory;
import io.reactivex.Single;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(AppTestRunner.class)
public class ArticlesPresenterTest {

    @Mock
    ArticlesInteractor articlesInteractorMock;

    @Mock
    ArticlesView$$State articlesView$$StateMock;

    private ArticlesPresenter articlesPresenter;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        articlesPresenter = new ArticlesPresenter(ArticleCategory.PEOPLE, new TestRxSchedulerProvider(), articlesInteractorMock);
        articlesPresenter.setViewState(articlesView$$StateMock);
    }

    @Test
    public void articles_shouldShowProgressBarAndHideErrorAndHideArticlesListOnFirstAttach() {
        //arrange
        when(articlesInteractorMock.getArticlesByCategory(any()))
                .thenReturn(Single.just(new ArrayList<>()));

        //act
        articlesPresenter.onFirstViewAttach();

        // assert
        verify(articlesView$$StateMock).showProgress();
        verify(articlesView$$StateMock).hideError();
        verify(articlesView$$StateMock).hideArticles();
    }

    @Test
    public void articles_shouldLoadAndShowListArticlesOnFirstAttach() {
        //arrange
        List<Article> list = new ArrayList<>();
        for (int i = 0; i < 10; ++i) {
            list.add(new RemoteArticle());
        }

        when(articlesInteractorMock.getArticlesByCategory(any()))
                .thenReturn(Single.just(list));

        //act
        articlesPresenter.onFirstViewAttach();

        // assert
        verify(articlesView$$StateMock).showArticles();
        verify(articlesView$$StateMock).hideProgress();
    }

    @Test
    public void articles_shouldLoadAndErrorOnFirstAttach() {
        //arrange
        when(articlesInteractorMock.getArticlesByCategory(any()))
                .thenReturn(Single.error(new RuntimeException()));

        //act
        articlesPresenter.onFirstViewAttach();

        // assert
        verify(articlesView$$StateMock).hideProgress();
        verify(articlesView$$StateMock).showError();
    }
}