package by.orion.onlinertasks.presentation.profile.details.pages;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import by.orion.onlinertasks.presentation.BaseMvpView;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface InformationProfileDetailsView extends BaseMvpView {

    String TAG_DETAILS_LAYOUT = "TAG_DETAILS_LAYOUT";
    String TAG_DESCRIPTION = "TAG_DESCRIPTION";
    String TAG_EXECUTOR_LOCATION = "TAG_EXECUTOR_LOCATION";

    @StateStrategyType(value = AddToEndSingleStrategy.class, tag = TAG_DETAILS_LAYOUT)
    void showDetailsLayout();

    @StateStrategyType(value = AddToEndSingleStrategy.class, tag = TAG_DETAILS_LAYOUT)
    void hideDetailsLayout();

    void setDescription(@NonNull String description);

    @StateStrategyType(value = AddToEndSingleStrategy.class, tag = TAG_DESCRIPTION)
    void showDescription();

    @StateStrategyType(value = AddToEndSingleStrategy.class, tag = TAG_DESCRIPTION)
    void hideDescription();

    void setExecutorLocation(@NonNull String location);

    @StateStrategyType(value = AddToEndSingleStrategy.class, tag = TAG_EXECUTOR_LOCATION)
    void showExecutorLocation();

    @StateStrategyType(value = AddToEndSingleStrategy.class, tag = TAG_EXECUTOR_LOCATION)
    void hideExecutorLocation();
}
