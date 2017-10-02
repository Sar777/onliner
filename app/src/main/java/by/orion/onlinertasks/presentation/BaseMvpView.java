package by.orion.onlinertasks.presentation;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import by.orion.onlinertasks.common.exceptions.BaseError;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface BaseMvpView extends MvpView {

    String TAG_PROGRESS = "TAG_PROGRESS";

    @StateStrategyType(value = AddToEndSingleStrategy.class, tag = TAG_PROGRESS)
    void showProgress();

    @StateStrategyType(value = AddToEndSingleStrategy.class, tag = TAG_PROGRESS)
    void hideProgress();

    void showError(@NonNull BaseError error);

    void hideError();
}
