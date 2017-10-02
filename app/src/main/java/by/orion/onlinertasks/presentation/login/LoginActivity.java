package by.orion.onlinertasks.presentation.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.design.widget.TextInputEditText;
import android.widget.Button;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import by.orion.onlinertasks.App;
import by.orion.onlinertasks.R;
import by.orion.onlinertasks.common.exceptions.BaseError;
import by.orion.onlinertasks.di.components.presentation.DaggerLoginPresenterComponent;
import by.orion.onlinertasks.di.components.presentation.LoginPresenterComponent;
import by.orion.onlinertasks.di.modules.presentation.LoginPresenterModule;
import by.orion.onlinertasks.presentation.main.MainActivity;

public class LoginActivity extends MvpAppCompatActivity implements LoginView {

    @BindView(R.id.inputedittext_login_username)
    TextInputEditText textInputEditTextUsername;

    @BindView(R.id.inputedittext_login_password)
    TextInputEditText textInputEditTextPassword;

    @BindView(R.id.button_login_sign_in)
    Button buttonSignIn;

    @InjectPresenter
    LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        initView();
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showError(@NonNull BaseError error) {
        Toast.makeText(this, getString(error.getMessageId()), Toast.LENGTH_LONG).show();
    }

    @Override
    public void hideError() {

    }

    @Override
    public void showUsernameError(@StringRes int errorId) {
        textInputEditTextUsername.setError(getString(errorId));
    }

    @Override
    public void hideUsernameError() {
        textInputEditTextUsername.setError(null);
    }

    @Override
    public void showPasswordError(@StringRes int errorId) {
        textInputEditTextPassword.setError(getString(errorId));
    }

    @Override
    public void hidePasswordError() {
        textInputEditTextPassword.setError(null);
    }

    @Override
    public void goToMainScreen() {
        startActivity(MainActivity.newIntent(this));
    }

    private void initView() {
        buttonSignIn.setOnClickListener(v -> presenter.onSignIn(textInputEditTextUsername.getText().toString(), textInputEditTextPassword.getText().toString()));
    }

    @ProvidePresenter
    LoginPresenter providePresenter() {
        LoginPresenterComponent loginPresenterComponent = DaggerLoginPresenterComponent.builder()
                .applicationComponent(App.getComponent())
                .loginPresenterModule(new LoginPresenterModule())
                .build();

        return loginPresenterComponent.getPresenter();
    }

    @NonNull
    public static Intent newIntent(@NonNull Context context) {
        return new Intent(context, LoginActivity.class);
    }
}
