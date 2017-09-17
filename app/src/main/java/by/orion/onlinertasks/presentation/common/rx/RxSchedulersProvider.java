package by.orion.onlinertasks.presentation.common.rx;

import android.support.annotation.NonNull;

import javax.inject.Inject;

import io.reactivex.CompletableTransformer;
import io.reactivex.Scheduler;
import io.reactivex.SingleTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class RxSchedulersProvider {

    @Inject
    public RxSchedulersProvider() {
    }

    @NonNull
    public CompletableTransformer getIoToMainTransformerCompletableCompletable() {
        return objectObservable -> objectObservable
                .subscribeOn(getIOScheduler())
                .observeOn(getMainThreadScheduler());
    }

    @NonNull
    public <T> SingleTransformer<T, T> getIoToMainTransformerSingle()  {
        return objectObservable -> objectObservable
                .subscribeOn(getIOScheduler())
                .observeOn(getMainThreadScheduler());
    }

    @NonNull
    public CompletableTransformer getComputationToMainTransformerCompletable() {
        return objectObservable -> objectObservable
                .subscribeOn(getComputationScheduler())
                .observeOn(getMainThreadScheduler());
    }

    @NonNull
    public <T> SingleTransformer<T, T> getComputationToMainTransformerSingle()  {
        return objectObservable -> objectObservable
                .subscribeOn(getComputationScheduler())
                .observeOn(getMainThreadScheduler());
    }

    @NonNull
    public Scheduler getMainThreadScheduler() {
        return AndroidSchedulers.mainThread();
    }

    @NonNull
    public Scheduler getIOScheduler() {
        return Schedulers.io();
    }

    @NonNull
    public Scheduler getComputationScheduler() {
        return Schedulers.computation();
    }

}