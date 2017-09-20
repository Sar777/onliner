package by.orion.onlinertasks.presentation.introduction;

import android.content.Context;
import android.support.annotation.NonNull;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import javax.inject.Inject;

import by.orion.onlinertasks.R;

@InjectViewState
public class IntroductionPresenter extends MvpPresenter<IntroductionView> {

    @NonNull
    private final Context context;

    private final int maxPages;

    private int currentPage;

    @Inject
    public IntroductionPresenter(@NonNull Context context, int maxPages) {
        this.context = context;
        this.maxPages = maxPages;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();

        getViewState().setCurrentDot(0);
    }

    public void onNextSlideClick() {
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
