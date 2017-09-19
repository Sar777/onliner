package by.orion.onlinertasks.presentation.main.fragments.tasks.models;

import android.support.annotation.NonNull;

import com.google.auto.value.AutoValue;

import java.util.List;

@AutoValue
public abstract class TaskPage {

    public abstract int page();

    public abstract int lastPage();

    @NonNull
    public abstract List<TaskItem> tasks();

    public static Builder builder() {
        return new AutoValue_TaskPage.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder page(int page);
        public abstract Builder lastPage(int lastPage);
        public abstract Builder tasks(List<TaskItem> tasks);
        public abstract TaskPage build();
    }
}
