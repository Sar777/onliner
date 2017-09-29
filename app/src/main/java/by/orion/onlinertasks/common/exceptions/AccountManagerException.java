package by.orion.onlinertasks.common.exceptions;

import android.support.annotation.NonNull;

public class AccountManagerException extends RuntimeException {

    public AccountManagerException(@NonNull final String message) {
        super(message);
    }
}
