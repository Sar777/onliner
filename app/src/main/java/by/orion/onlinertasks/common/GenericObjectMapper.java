package by.orion.onlinertasks.common;

import android.support.annotation.NonNull;

public interface GenericObjectMapper<F, T> {

    @NonNull
    T map(@NonNull F object);
}
