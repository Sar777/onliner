package by.orion.onlinertasks.common.exceptions;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;

public interface Error {

    @StringRes
    int getMessageId();

    @NonNull
    Uri getUri();
}
