package by.orion.onlinertasks.presentation.main.fragments.profiles.models;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class ProfileItem {

    @NonNull
    public abstract Integer id();

    @Nullable
    public abstract String photo();

    @NonNull
    public abstract String displayName();

    @NonNull
    public abstract String description();

    @NonNull
    public abstract String sections();

    @NonNull
    public abstract RatingItem rating();

    @NonNull
    public abstract String completedTasksQty();

    public static Builder builder() {
        return new AutoValue_ProfileItem.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder id(Integer id);
        public abstract Builder photo(String photo);
        public abstract Builder displayName(String displayName);
        public abstract Builder description(String description);
        public abstract Builder sections(String sections);
        public abstract Builder rating(RatingItem rating);
        public abstract Builder completedTasksQty(String completedTasksQty);
        public abstract ProfileItem build();
    }
}
