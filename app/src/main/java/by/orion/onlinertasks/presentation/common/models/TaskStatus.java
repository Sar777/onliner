package by.orion.onlinertasks.presentation.common.models;

import android.support.annotation.NonNull;

import java.util.HashMap;
import java.util.Map;

public enum TaskStatus {

    ACTIVE(0, "active"),
    ACCEPTED(1, "accepted"),
    COMPLETED(2, "completed"),
    NOT_COMPLETED(3, "not_completed");

    private static final Map<String, TaskStatus> lookup = new HashMap<>();

    static {
        for(TaskStatus status : TaskStatus.values())
            lookup.put(status.getName(), status);
    }

    private final int id;

    @NonNull
    private final String name;

    TaskStatus(final int id, @NonNull final String name) {
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
    public static TaskStatus get(@NonNull final String name) {
        return lookup.getOrDefault(name, ACTIVE);
    }
}
