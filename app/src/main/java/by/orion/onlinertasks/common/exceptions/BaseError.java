package by.orion.onlinertasks.common.exceptions;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;

public abstract class BaseError extends RuntimeException implements Error {

    @StringRes
    private final int messageId;

    @NonNull
    private final Uri uri;

    public BaseError(@StringRes int messageId) {
        this.messageId = messageId;
        this.uri = Uri.EMPTY;
    }

    public BaseError(@StringRes int messageId, @NonNull Throwable cause) {
        super(cause);
        this.messageId = messageId;
        this.uri = Uri.EMPTY;
    }

    public BaseError(@StringRes int messageId, @NonNull Uri uri) {
        this.messageId = messageId;
        this.uri = uri;
    }

    public BaseError(@StringRes int messageId, @NonNull Uri uri, @NonNull Throwable cause) {
        super(cause);
        this.messageId = messageId;
        this.uri = uri;
    }

    @StringRes
    @Override
    public int getMessageId() {
        return messageId;
    }

    @NonNull
    @Override
    public Uri getUri() {
        return uri;
    }
}
