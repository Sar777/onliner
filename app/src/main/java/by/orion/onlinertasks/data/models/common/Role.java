package by.orion.onlinertasks.data.models.common;

import android.support.annotation.NonNull;

import java.util.HashMap;
import java.util.Map;

public enum Role {

    CUSTOMER(0, "customer"),
    EXECUTOR(1, "executor");

    private static final Map<String, Role> lookup = new HashMap<>();

    static {
        for (Role role : Role.values()) {
            lookup.put(role.getName(), role);
        }
    }

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

    @NonNull
    public static Role get(@NonNull final String name) {
        if (!lookup.containsKey(name)) {
            return CUSTOMER;
        }

        return lookup.get(name);
    }
}
