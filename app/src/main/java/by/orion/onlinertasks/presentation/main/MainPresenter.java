package by.orion.onlinertasks.presentation.main;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import javax.inject.Inject;

import by.orion.onlinertasks.common.exceptions.BaseError;
import by.orion.onlinertasks.common.exceptions.errors.UnknownError;
import by.orion.onlinertasks.domain.interactors.MainInteractor;
import by.orion.onlinertasks.presentation.common.models.MenuOption;
import by.orion.onlinertasks.presentation.common.rx.RxSchedulersProvider;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    @NonNull
    private final MainInteractor mainInteractor;

    @NonNull
    private final RxSchedulersProvider rxSchedulersProvider;

    @Inject
    public MainPresenter(@NonNull MainInteractor mainInteractor, @NonNull RxSchedulersProvider rxSchedulersProvider) {
        this.mainInteractor = mainInteractor;
        this.rxSchedulersProvider = rxSchedulersProvider;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();

        getViewState().hideLoginButton();

        mainInteractor.isAuthorizedUser()
                .compose(rxSchedulersProvider.getComputationToMainTransformerSingle())
                .subscribe(this::onUserAuthorizedCheckSuccess, this::onUserAuthorizedCheckError);
    }

    public void onClickMenu(@NonNull MenuOption option) {
        switch (option) {
            case ALL_TASKS:
                getViewState().showAllTasks();
                break;
            case ALL_PROFILES:
                getViewState().showAllProfiles();
                break;
            case LOGIN:
                getViewState().goToLoginScreen();
                break;
            default:
                break;
        }
    }

    private void onUserAuthorizedCheckSuccess(@NonNull Boolean authorized) {
        if (!authorized) {
            getViewState().showLoginButton();
        }
    }

    private void onUserAuthorizedCheckError(@NonNull Throwable throwable) {
        if (throwable instanceof BaseError) {
            getViewState().showError((BaseError) throwable);
        } else {
            getViewState().showError(new UnknownError());
        }
    }
}
