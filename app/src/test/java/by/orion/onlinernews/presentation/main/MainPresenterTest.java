package by.orion.onlinernews.presentation.main;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import by.orion.onlinernews.presentation.common.models.ArticleCategory;

import static org.mockito.Mockito.verify;

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
}