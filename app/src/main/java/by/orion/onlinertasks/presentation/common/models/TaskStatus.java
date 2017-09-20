package by.orion.onlinertasks.presentation.common.models;

import android.support.annotation.NonNull;
import android.support.annotation.StringRes;

import java.util.HashMap;
import java.util.Map;

import by.orion.onlinertasks.R;

public enum TaskStatus {

    ACTIVE(0, "active", R.string.msg_common_task_status_active),
    ACCEPTED(1, "accepted", R.string.msg_common_task_status_accepted),
    COMPLETED(2, "completed", R.string.msg_common_task_status_completed),
    NOT_COMPLETED(3, "not_completed", R.string.msg_common_task_status_not_completed);

    private static final Map<String, TaskStatus> lookup = new HashMap<>();

    static {
        for (TaskStatus status : TaskStatus.values()) {
            lookup.put(status.getName(), status);
        }
    }

    private final int id;

    @NonNull
    private final String name;

    @StringRes
    private final int resId;

    TaskStatus(final int id, @NonNull final String name, @StringRes int resId) {
        this.id = id;
        this.name = name;
        this.resId = resId;
    }

    public int getId() {
        return id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    @StringRes
    public int getResId() {
        return resId;
    }

    @NonNull
    public static TaskStatus get(@NonNull final String name) {
        if (!lookup.containsKey(name)) {
            return ACTIVE;
        }

        return lookup.get(name);
    }
}
