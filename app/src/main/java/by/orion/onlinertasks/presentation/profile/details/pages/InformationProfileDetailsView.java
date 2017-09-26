package by.orion.onlinertasks.presentation.profile.details.pages;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import by.orion.onlinertasks.presentation.BaseMvpView;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface InformationProfileDetailsView extends BaseMvpView {

    String TAG_DETAILS_LAYOUT = "TAG_DETAILS_LAYOUT";

    @StateStrategyType(value = AddToEndSingleStrategy.class, tag = TAG_DETAILS_LAYOUT)
    void showDetailsLayout();

    @StateStrategyType(value = AddToEndSingleStrategy.class, tag = TAG_DETAILS_LAYOUT)
    void hideDetailsLayout();

    void setDescription(@NonNull String description);

    void setLocation(@NonNull String location);
}
