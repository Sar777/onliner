package by.orion.onlinertasks.common.exceptions.errors;

import by.orion.onlinertasks.R;
import by.orion.onlinertasks.common.exceptions.BaseError;

public class UnknownError extends BaseError {

    public UnknownError() {
        super(R.string.msg_common_error_unknown);
    }
}
