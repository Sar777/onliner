package by.orion.onlinertasks.presentation.main.fragments.profiles;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import javax.inject.Inject;

import by.orion.onlinertasks.common.exceptions.errors.UnknownError;
import by.orion.onlinertasks.data.models.common.requests.ProfilesRequestParams;
import by.orion.onlinertasks.domain.interactors.ProfilesInteractor;
import by.orion.onlinertasks.presentation.common.rx.RxSchedulersProvider;
import by.orion.onlinertasks.presentation.main.fragments.profiles.models.ProfilePage;

@InjectViewState
public class ProfilesPresenter extends MvpPresenter<ProfilesView> {

    @NonNull
    private final RxSchedulersProvider rxSchedulersProvider;

    @NonNull
    private final ProfilesInteractor profilesInteractor;

    private int page;
    private int lastPage;

    @Inject
    public ProfilesPresenter(@NonNull RxSchedulersProvider rxSchedulersProvider,
                             @NonNull ProfilesInteractor profilesInteractor) {
        this.rxSchedulersProvider = rxSchedulersProvider;
        this.profilesInteractor = profilesInteractor;
    }

    public void onLoadMoreProfilesRequest() {
        getViewState().disableLoadMoreProfiles();

        loadProfiles(ProfilesRequestParams.builder()
                .page(page + 1)
                .build());
    }

    public void onProfileClick(@NonNull Integer id) {
        getViewState().goToProfileDetails(id);
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();

        getViewState().hideError();
        getViewState().hideProfiles();
        getViewState().showProgress();

        loadProfiles(ProfilesRequestParams.builder().build());
    }

    private void loadProfiles(@NonNull ProfilesRequestParams params) {
        profilesInteractor.getAllProfiles(params)
                .compose(rxSchedulersProvider.getIoToMainTransformerSingle())
                .subscribe(this::onAllProfilesSuccess, this::onAllProfilesError);
    }

    private void onAllProfilesSuccess(@NonNull ProfilePage profilePage) {
        page = profilePage.page();
        lastPage = profilePage.lastPage();

        if (page < lastPage) {
            getViewState().enableLoadMoreProfiles();
        }

        getViewState().hideProgress();
        getViewState().showProfiles();
        getViewState().addProfiles(profilePage.profiles());
    }

    private void onAllProfilesError(@NonNull Throwable throwable) {
        getViewState().hideProgress();
        getViewState().showError(new UnknownError());
    }
}
