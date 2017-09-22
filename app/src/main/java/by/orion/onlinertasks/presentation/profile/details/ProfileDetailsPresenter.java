package by.orion.onlinertasks.presentation.profile.details;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import javax.inject.Inject;

import by.orion.onlinertasks.domain.interactors.ProfileDetailsInteractor;
import by.orion.onlinertasks.presentation.common.rx.RxSchedulersProvider;

@InjectViewState
public class ProfileDetailsPresenter extends MvpPresenter<ProfileDetailsView> {

    @NonNull
    private final Integer id;

    @NonNull
    private final ProfileDetailsInteractor profileDetailsInteractor;

    @NonNull
    private final RxSchedulersProvider rxSchedulersProvider;

    @Inject
    public ProfileDetailsPresenter(@NonNull Integer id, @NonNull ProfileDetailsInteractor profileDetailsInteractor, @NonNull RxSchedulersProvider rxSchedulersProvider) {
        this.id = id;
        this.profileDetailsInteractor = profileDetailsInteractor;
        this.rxSchedulersProvider = rxSchedulersProvider;
    }
}
