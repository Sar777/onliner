package by.orion.onlinertasks.presentation.login;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.io.IOException;

import javax.inject.Inject;

import by.orion.onlinertasks.R;
import by.orion.onlinertasks.common.exceptions.BaseError;
import by.orion.onlinertasks.common.exceptions.RetrofitException;
import by.orion.onlinertasks.common.exceptions.errors.NetworkError;
import by.orion.onlinertasks.common.exceptions.errors.UnknownError;
import by.orion.onlinertasks.common.exceptions.errors.login.InvalidGrantError;
import by.orion.onlinertasks.domain.interactors.LoginInteractor;
import by.orion.onlinertasks.presentation.common.rx.RxSchedulersProvider;

@InjectViewState
public class LoginPresenter extends MvpPresenter<LoginView> {

    @NonNull
    private final LoginInteractor loginInteractor;

    @NonNull
    private final RxSchedulersProvider rxSchedulersProvider;

    @Inject
    public LoginPresenter(@NonNull LoginInteractor loginInteractor, @NonNull RxSchedulersProvider rxSchedulersProvider) {
        this.loginInteractor = loginInteractor;
        this.rxSchedulersProvider = rxSchedulersProvider;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();

        getViewState().hideError();
        getViewState().hideProgress();
        getViewState().hideUsernameError();
        getViewState().hidePasswordError();
    }

    public void onSignIn(@NonNull final String username, @NonNull final String password) {
        boolean error = false;

        getViewState().hideUsernameError();
        getViewState().hidePasswordError();

        if (TextUtils.isEmpty(username)) {
            getViewState().showUsernameError(R.string.msg_login_error_username_empty);
            error = true;
        }

        if (TextUtils.isEmpty(password)) {
            getViewState().showPasswordError(R.string.msg_login_error_password_empty);
            error = true;
        }

        if (error) {
            return;
        }

        loginInteractor.signIn(username, password)
                .compose(rxSchedulersProvider.getIoToMainTransformerCompletableCompletable())
                .subscribe(this::onSignInSuccess, this::onSignInError);
    }

    private void onSignInSuccess() {
        getViewState().goToMainScreen();
    }

    private void onSignInError(@NonNull Throwable throwable) throws IOException {
        if (throwable instanceof RetrofitException) {
            RetrofitException exception = (RetrofitException) throwable;
            if (exception.getKind() == RetrofitException.Kind.HTTP) {
                getViewState().showError(new InvalidGrantError());
            } else if (exception.getKind() == RetrofitException.Kind.NETWORK) {
                getViewState().showError(new NetworkError());
            } else {
                getViewState().showError(new UnknownError(throwable));
            }
        }
        else if (throwable instanceof BaseError) {
            getViewState().showError((BaseError)throwable);
        }
    }
}
