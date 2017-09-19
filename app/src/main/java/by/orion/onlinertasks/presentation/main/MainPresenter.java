package by.orion.onlinertasks.presentation.main;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import javax.inject.Inject;

import by.orion.onlinertasks.presentation.common.models.MenuOption;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    @Inject
    public MainPresenter() {
    }

    public void onClickMenu(@NonNull MenuOption option) {
        switch (option) {
            case ALL_TASKS:
                getViewState().showAllTasks();
                break;
            case ALL_PROFILES:
                getViewState().showAllProfiles();
                break;
            default:
                break;
        }
    }
}
