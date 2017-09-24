package by.orion.onlinertasks.presentation.main.fragments.profiles;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import java.util.List;

import by.orion.onlinertasks.presentation.BaseMvpView;
import by.orion.onlinertasks.presentation.main.fragments.profiles.models.ProfileItem;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface ProfilesView extends BaseMvpView {

    String TAG_PROFILES = "TAG_PROFILES";
    String TAG_LOAD_MORE_PROFILES = "TAG_LOAD_MORE_PROFILES";

    @StateStrategyType(value = AddToEndSingleStrategy.class, tag = TAG_PROFILES)
    void showProfiles();

    @StateStrategyType(value = AddToEndSingleStrategy.class, tag = TAG_PROFILES)
    void hideProfiles();

    void addProfiles(@NonNull List<ProfileItem> profiles);

    @StateStrategyType(value = AddToEndSingleStrategy.class, tag = TAG_LOAD_MORE_PROFILES)
    void enableLoadMoreProfiles();

    @StateStrategyType(value = AddToEndSingleStrategy.class, tag = TAG_LOAD_MORE_PROFILES)
    void disableLoadMoreProfiles();

    @StateStrategyType(OneExecutionStateStrategy.class)
    void goToProfileDetails(@NonNull Integer id);
}
