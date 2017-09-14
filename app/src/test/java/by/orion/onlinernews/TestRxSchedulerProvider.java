package by.orion.onlinernews;

import android.support.annotation.NonNull;

import by.orion.onlinernews.presentation.common.rx.RxSchedulersProvider;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

public class TestRxSchedulerProvider extends RxSchedulersProvider {

    @NonNull
    @Override
    public Scheduler getIOScheduler() {
        return Schedulers.trampoline();
    }

    @NonNull
    @Override
    public Scheduler getComputationScheduler() {
        return Schedulers.trampoline();
    }
}