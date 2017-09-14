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
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class SplashPresenter extends MvpPresenter<SplashView> {

    private final int delay;

    @NonNull
    private final RxSchedulersProvider rxSchedulersProvider;

    @Inject
    public SplashPresenter(int delay, @NonNull RxSchedulersProvider rxSchedulersProvider) {
        this.delay = delay;
        this.rxSchedulersProvider = rxSchedulersProvider;
    }

    @DebugLog
    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();

        Completable.create(CompletableEmitter::onComplete)
                .delay(delay, TimeUnit.SECONDS, Schedulers.trampoline())
                .compose(rxSchedulersProvider.getIoToMainTransformerCompletableCompletable())
                .subscribe(() -> getViewState().goToMainScreen());
    }
}
