package by.orion.onlinertasks.presentation.login;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import javax.inject.Inject;

import by.orion.onlinertasks.R;
import by.orion.onlinertasks.presentation.common.rx.RxSchedulersProvider;

@InjectViewState
public class LoginPresenter extends MvpPresenter<LoginView> {

    @NonNull
    private final RxSchedulersProvider rxSchedulersProvider;

    @Inject
    public LoginPresenter(@NonNull RxSchedulersProvider rxSchedulersProvider) {
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

        signIn(username, password);
    }

    private void signIn(@NonNull final String username, @NonNull final String password) {

    }
}
