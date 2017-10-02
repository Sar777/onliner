package by.orion.onlinertasks.common.exceptions.errors.login;

import javax.inject.Inject;

import by.orion.onlinertasks.R;
import by.orion.onlinertasks.common.exceptions.BaseError;

public class InvalidGrantError extends BaseError {

    @Inject
    public InvalidGrantError() {
        super(R.string.msg_login_error_invalid_grant);
    }
}
