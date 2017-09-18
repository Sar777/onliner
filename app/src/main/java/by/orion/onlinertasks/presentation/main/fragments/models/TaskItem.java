package by.orion.onlinertasks.presentation.main.fragments.models;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

import by.orion.onlinertasks.presentation.common.models.TaskStatus;

@AutoValue
public abstract class TaskItem {

    @NonNull
    public abstract Integer id();

    @NonNull
    public abstract String title();

    @NonNull
    public abstract String description();

    @Nullable
    public abstract String imageUrl();

    @Nullable
    public abstract String price();

    @NonNull
    public abstract TaskStatus status();

    @NonNull
    public abstract Integer proposalsQty();

    @NonNull
    public abstract LocationItem location();

    @NonNull
    public abstract String deadline();

    @NonNull
    public abstract String createdAt();

    @NonNull
    public abstract AuthorItem author();

    @NonNull
    public abstract SectionItem section();

    public static Builder builder() {
        return new AutoValue_TaskItem.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder id(Integer id);
        public abstract Builder title(String title);
        public abstract Builder description(String description);
        public abstract Builder imageUrl(String image);
        public abstract Builder price(String price);
        public abstract Builder status(TaskStatus status);
        public abstract Builder proposalsQty(Integer proposals_qty);
        public abstract Builder location(LocationItem location);
        public abstract Builder deadline(String deadline);
        public abstract Builder createdAt(String created_at);
        public abstract Builder author(AuthorItem author);
        public abstract Builder section(SectionItem section);
        public abstract TaskItem build();
    }
}
