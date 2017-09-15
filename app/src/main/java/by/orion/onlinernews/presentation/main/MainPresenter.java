package by.orion.onlinernews.presentation.main;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import javax.inject.Inject;

import by.orion.onlinernews.presentation.common.models.ArticleCategory;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    @Inject
    public MainPresenter() {
    }

    public void onClickCategory(@NonNull ArticleCategory category) {
        switch (category) {
            case PEOPLE:
                getViewState().showPeople();
                break;
            case OPINIONS:
                getViewState().showOpinions();
                break;
            case AUTO:
                getViewState().showAuto();
                break;
            case TECH:
                getViewState().showTech();
                break;
            case REALT:
                getViewState().showRealt();
                break;
            default:
                break;
        }
    }
}
