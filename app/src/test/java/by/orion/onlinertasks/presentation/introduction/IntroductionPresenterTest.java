package by.orion.onlinertasks.presentation.introduction;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import by.orion.onlinertasks.R;

import static org.mockito.Mockito.verify;

public class IntroductionPresenterTest {

    private static final int MAX_PAGES = 4;

    @Mock
    IntroductionView$$State introductionView$$StateMock;

    private IntroductionPresenter introductionPresenter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        introductionPresenter = new IntroductionPresenter(MAX_PAGES);
        introductionPresenter.setViewState(introductionView$$StateMock);
    }

    @Test
    public void shouldInitializationDotsOnFirstViewAttach_isCorrect() {
        //act
        introductionPresenter.onFirstViewAttach();

        // assert
        verify(introductionView$$StateMock).setCurrentDot(0);
    }

    @Test
    public void shouldAfterClickSkipNeedOpenMainScreen_isCorrect() {
        //act
        introductionPresenter.onSkipClick();

        // assert
        verify(introductionView$$StateMock).goToMainScreen();
    }

    @Test
    public void shouldAfterClickLastPageNeedHideSkipButtonAndChangeText_isCorrect() {
        //act
        introductionPresenter.onPageSelected(MAX_PAGES - 1);

        // assert
        verify(introductionView$$StateMock).setCurrentDot(MAX_PAGES - 1);
        verify(introductionView$$StateMock).hideButtonSkip();
        verify(introductionView$$StateMock).setButtonNextText(R.string.title_introduction_start);
    }

    @Test
    public void shouldAfterClickNonLastPageNeedShowSkipButtonAndChangeText_isCorrect() {
        introductionPresenter.onPageSelected(0);

        // assert
        verify(introductionView$$StateMock).setCurrentDot(0);
        verify(introductionView$$StateMock).showButtonSkip();
        verify(introductionView$$StateMock).setButtonNextText(R.string.title_introduction_next);
    }

    @Test
    public void shouldOpenMainScreenAfterClickAllPages_isCorrect() {
        introductionPresenter.onFirstViewAttach();

        //act
        for (int i = 0; i < MAX_PAGES; ++i) {
            introductionPresenter.onNextPageClick();
        }

        // assert
        verify(introductionView$$StateMock).goToMainScreen();
    }
}