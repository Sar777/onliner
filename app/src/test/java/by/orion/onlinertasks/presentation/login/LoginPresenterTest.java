package by.orion.onlinertasks.presentation.login;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import by.orion.onlinertasks.AppTestRunner;
import by.orion.onlinertasks.R;
import by.orion.onlinertasks.TestRxSchedulerProvider;
import by.orion.onlinertasks.common.exceptions.RetrofitException;
import by.orion.onlinertasks.domain.interactors.LoginInteractor;
import io.reactivex.Completable;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(AppTestRunner.class)
public class LoginPresenterTest {

    @Mock
    LoginView$$State loginView$$StateMock;

    @Mock
    LoginInteractor loginInteractorMock;

    private LoginPresenter loginPresenter;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        loginPresenter = new LoginPresenter(loginInteractorMock, new TestRxSchedulerProvider());
        loginPresenter.setViewState(loginView$$StateMock);
    }

    @Test
    public void login_shouldOpenMainScreenAfterSuccessLogin() {
        when(loginInteractorMock.signIn("Test", "Test")).thenReturn(Completable.complete());

        // act
        loginPresenter.onSignIn("Test", "Test");

        // assert
        verify(loginView$$StateMock).goToMainScreen();
    }

    @Test
    public void login_shouldShowErrorAfterFailLogin() {
        when(loginInteractorMock.signIn(anyString(), anyString())).thenReturn(Completable.error(RetrofitException.unexpectedError(new RuntimeException())));

        // act
        loginPresenter.onSignIn("Test", "Test");

        // assert
        verify(loginView$$StateMock).showError(any());
    }

    @Test
    public void login_shouldShowErrorIfPutEmptyUsername() {
        when(loginInteractorMock.signIn(anyString(), anyString())).thenReturn(Completable.complete());

        // act
        loginPresenter.onSignIn("", "Test");

        // assert
        verify(loginView$$StateMock).showUsernameError(R.string.msg_login_error_username_empty);
    }

    @Test
    public void login_shouldShowErrorIfPutEmptyPassword() {
        when(loginInteractorMock.signIn(anyString(), anyString())).thenReturn(Completable.complete());

        // act
        loginPresenter.onSignIn("Test", "");

        // assert
        verify(loginView$$StateMock).showPasswordError(R.string.msg_login_error_password_empty);
    }

    @Test
    public void login_shouldHideUsernamePasswordInputErrorsIfClickSign() {
        when(loginInteractorMock.signIn(anyString(), anyString())).thenReturn(Completable.complete());

        // act
        loginPresenter.onSignIn("Test", "Test");

        // assert
        verify(loginView$$StateMock).hideUsernameError();
        verify(loginView$$StateMock).hidePasswordError();
    }
}
