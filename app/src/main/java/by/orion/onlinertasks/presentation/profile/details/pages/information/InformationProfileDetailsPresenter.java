package by.orion.onlinertasks.presentation.profile.details.pages.information;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import javax.inject.Inject;

import by.orion.onlinertasks.common.exceptions.errors.UnknownError;
import by.orion.onlinertasks.data.models.common.requests.ProfileDetailsRequestParams;
import by.orion.onlinertasks.domain.interactors.InformationProfileDetailsInteractor;
import by.orion.onlinertasks.presentation.common.rx.RxSchedulersProvider;
import by.orion.onlinertasks.presentation.profile.details.pages.information.models.ProfileDetailsInformation;

@InjectViewState
public class InformationProfileDetailsPresenter extends MvpPresenter<InformationProfileDetailsView> {

    @NonNull
    private final Integer id;

    @NonNull
    private final RxSchedulersProvider rxSchedulersProvider;

    @NonNull
    private final InformationProfileDetailsInteractor informationProfileDetailsInteractor;

    @Inject
    public InformationProfileDetailsPresenter(@NonNull Integer id, @NonNull RxSchedulersProvider rxSchedulersProvider, @NonNull InformationProfileDetailsInteractor informationProfileDetailsInteractor) {
        this.id = id;
        this.rxSchedulersProvider = rxSchedulersProvider;
        this.informationProfileDetailsInteractor = informationProfileDetailsInteractor;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();

        getViewState().showProgress();
        getViewState().hideDetailsLayout();

        informationProfileDetailsInteractor.getProfileInformation(ProfileDetailsRequestParams.builder().id(id).build())
                .compose(rxSchedulersProvider.getIoToMainTransformerSingle())
                .subscribe(this::onProfileDetailsSuccess, this::onProfileDetailsError);
    }

    private void onProfileDetailsSuccess(@NonNull ProfileDetailsInformation information) {
        String description = information.description();
        if (!TextUtils.isEmpty(description)) {
            getViewState().setDescription(description);
            getViewState().showDescription();
        } else {
            getViewState().hideDescription();
        }

        String executorLocation = information.executor_location();
        if (!TextUtils.isEmpty(executorLocation)) {
            getViewState().setExecutorLocation(executorLocation);
            getViewState().showExecutorLocation();
        } else {
            getViewState().hideExecutorLocation();
        }

        getViewState().showDetailsLayout();
    }

    private void onProfileDetailsError(@NonNull Throwable throwable) {
        getViewState().hideProgress();
        getViewState().showError(new UnknownError());
    }
}
