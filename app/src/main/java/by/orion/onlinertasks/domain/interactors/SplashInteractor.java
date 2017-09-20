package by.orion.onlinertasks.domain.interactors;

import android.support.annotation.NonNull;

import javax.inject.Inject;

import by.orion.onlinertasks.data.repository.splash.SplashRepository;
import io.reactivex.Single;

public class SplashInteractor {

    @NonNull
    private final SplashRepository splashRepository;

    @Inject
    public SplashInteractor(@NonNull SplashRepository splashRepository) {
        this.splashRepository = splashRepository;
    }

    public Single<Boolean> isFirstTimeLaunchAndChangeIfNeed() {
        return splashRepository.isFirstTimeLaunch()
                .flatMap(isFirst -> isFirst ? splashRepository.setFirstTimeLaunch(false) : Single.just(isFirst));
    }
}
