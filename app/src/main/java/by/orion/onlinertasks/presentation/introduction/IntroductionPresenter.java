package by.orion.onlinertasks.presentation.introduction;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import javax.inject.Inject;

import by.orion.onlinertasks.R;

@InjectViewState
public class IntroductionPresenter extends MvpPresenter<IntroductionView> {

    private final int maxPages;

    private int currentPage;

    @Inject
    public IntroductionPresenter(int maxPages) {
        this.maxPages = maxPages;
        this.currentPage = 0;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();

        getViewState().setCurrentDot(0);
    }

    public void onNextPageClick() {
        if (++currentPage < maxPages) {
            getViewState().selectPage(currentPage);
        } else {
            getViewState().goToMainScreen();
        }
    }

    public void onSkipClick() {
        getViewState().goToMainScreen();
    }

    public void onPageSelected(int page) {
        currentPage = page;

        getViewState().setCurrentDot(page);

        if (page == maxPages - 1) {
            getViewState().setButtonNextText(R.string.title_introduction_start);
            getViewState().hideButtonSkip();
        } else {
            getViewState().setButtonNextText(R.string.title_introduction_next);
            getViewState().showButtonSkip();
        }
    }
}
