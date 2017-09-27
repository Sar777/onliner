package by.orion.onlinertasks.data.models.common;

import android.support.annotation.NonNull;

public enum Role {

    CUSTOMER(0, "customer"),
    EXECUTOR(1, "executor");

    @NonNull
    private final Integer id;

    @NonNull
    private final String name;

    Role(final @NonNull Integer id, @NonNull final String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    @NonNull
    public String getName() {
        return name;
    }
}
