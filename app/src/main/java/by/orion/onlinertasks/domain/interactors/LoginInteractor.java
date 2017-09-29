package by.orion.onlinertasks.domain.interactors;

import android.support.annotation.NonNull;

import javax.inject.Inject;

import by.orion.onlinertasks.data.models.common.requests.SignInRequestParams;
import by.orion.onlinertasks.data.repository.credentials.CredentialsRepository;
import io.reactivex.Completable;

public class LoginInteractor {

    @NonNull
    private final CredentialsRepository credentialsRepository;

    @Inject
    public LoginInteractor(@NonNull CredentialsRepository credentialsRepository) {
        this.credentialsRepository = credentialsRepository;
    }

    public Completable signIn(@NonNull String username, @NonNull String password) {
        return credentialsRepository.signIn(SignInRequestParams.builder()
                .username(username)
                .password(password)
                .build());
    }
}
