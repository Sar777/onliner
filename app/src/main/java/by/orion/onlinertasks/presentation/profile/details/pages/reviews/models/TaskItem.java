package by.orion.onlinertasks.presentation.profile.details.pages.reviews.models;

import android.support.annotation.NonNull;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class TaskItem {

    @NonNull
    public abstract Integer id();

    @NonNull
    public abstract String title();

    public static Builder builder() {
        return new AutoValue_TaskItem.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder id(Integer id);
        public abstract Builder title(String title);
        public abstract TaskItem build();
    }
}
