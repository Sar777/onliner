package by.orion.onlinertasks.presentation.splash;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import by.orion.onlinertasks.common.exceptions.errors.UnknownError;
import by.orion.onlinertasks.domain.interactors.SplashInteractor;
import by.orion.onlinertasks.presentation.common.rx.RxSchedulersProvider;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class SplashPresenter extends MvpPresenter<SplashView> {

    private final int delay;

    @NonNull
    private final SplashInteractor splashInteractor;

    @NonNull
    private final RxSchedulersProvider rxSchedulersProvider;

    @Inject
    public SplashPresenter(int delay, @NonNull SplashInteractor splashInteractor, @NonNull RxSchedulersProvider rxSchedulersProvider) {
        this.delay = delay;
        this.splashInteractor = splashInteractor;
        this.rxSchedulersProvider = rxSchedulersProvider;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();

        splashInteractor.isFirstTimeLaunchAndChangeIfNeed()
                .delay(delay, TimeUnit.SECONDS, Schedulers.trampoline())
                .compose(rxSchedulersProvider.getIoToMainTransformerSingle())
                .subscribe(this::onFirstTimeLaunchSuccess, this::onFirstTimeLaunchError);
    }

    private void onFirstTimeLaunchSuccess(@NonNull Boolean isFirst) {
        if (isFirst) {
            getViewState().goToIntroductionScreen();
        } else {
            getViewState().goToMainScreen();
        }
    }

    private void onFirstTimeLaunchError(@NonNull Throwable error) {
        getViewState().showError(new UnknownError());
    }
}
