package by.orion.onlinertasks.domain.interactors;


import android.support.annotation.NonNull;

import javax.inject.Inject;

import by.orion.onlinertasks.data.repository.credentials.CredentialsRepository;
import io.reactivex.Single;

public class MainInteractor {

    @NonNull
    private final CredentialsRepository credentialsRepository;

    @Inject
    public MainInteractor(@NonNull CredentialsRepository credentialsRepository) {
        this.credentialsRepository = credentialsRepository;
    }

    public Single<Boolean> isAuthorizedUser() {
        return credentialsRepository.isAuthorized();
    }
}
