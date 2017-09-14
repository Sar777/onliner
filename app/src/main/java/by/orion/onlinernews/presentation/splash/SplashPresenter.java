package by.orion.onlinernews.presentation.splash;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import by.orion.onlinernews.presentation.common.rx.RxSchedulersProvider;
import hugo.weaving.DebugLog;
import io.reactivex.Completable;
import io.reactivex.CompletableEmitter;

@InjectViewState
public class SplashPresenter extends MvpPresenter<SplashView> {

    private static final int DELAY_SPLASH = 3; // in secs

    @NonNull
    private final RxSchedulersProvider rxSchedulersProvider;

    @Inject
    public SplashPresenter(@NonNull RxSchedulersProvider rxSchedulersProvider) {
        this.rxSchedulersProvider = rxSchedulersProvider;
    }

    @DebugLog
    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();

        Completable.create(CompletableEmitter::onComplete)
                .delay(DELAY_SPLASH, TimeUnit.SECONDS)
                .compose(rxSchedulersProvider.getIoToMainTransformerCompletableCompletable())
                .subscribe(() -> getViewState().goToMainScreen());
    }
}
