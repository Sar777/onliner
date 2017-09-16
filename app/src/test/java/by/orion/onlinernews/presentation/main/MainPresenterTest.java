package by.orion.onlinernews.presentation.main;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import by.orion.onlinernews.AppTestRunner;
import by.orion.onlinernews.presentation.common.models.ArticleCategory;

import static org.mockito.Mockito.times;
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
    public void onClickCategory_shouldShowArticleCategoryPeople() {
        //act
        mainPresenter.onClickCategory(ArticleCategory.PEOPLE);

        // assert
        verify(mainView$$StateMock).showPeople();
    }

    @Test
    public void onClickCategory_shouldShowArticleCategoryOpinions() {
        //act
        mainPresenter.onClickCategory(ArticleCategory.OPINIONS);

        // assert
        verify(mainView$$StateMock).showOpinions();
    }

    @Test
    public void onClickCategory_shouldShowArticleCategoryAuto() {
        //act
        mainPresenter.onClickCategory(ArticleCategory.AUTO);

        // assert
        verify(mainView$$StateMock).showAuto();
    }

    @Test
    public void onClickCategory_shouldShowArticleCategoryTech() {
        //act
        mainPresenter.onClickCategory(ArticleCategory.TECH);

        // assert
        verify(mainView$$StateMock).showTech();
    }

    @Test
    public void onClickCategory_shouldShowArticleCategoryRealt() {
        //act
        mainPresenter.onClickCategory(ArticleCategory.REALT);

        // assert
        verify(mainView$$StateMock).showRealt();
    }

    @Test
    public void onClickCategory_shouldShowArticleCategoryUnknown() {
        //act
        mainPresenter.onClickCategory(ArticleCategory.UNKNOWN);

        // assert
        verify(mainView$$StateMock, times(0)).showPeople();
        verify(mainView$$StateMock, times(0)).showOpinions();
        verify(mainView$$StateMock, times(0)).showAuto();
        verify(mainView$$StateMock, times(0)).showTech();
        verify(mainView$$StateMock, times(0)).showRealt();
    }
}