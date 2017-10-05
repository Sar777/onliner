package by.orion.onlinertasks.presentation.profile.details.pages.information.models;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class ProfileDetailsInformation {

    @NonNull
    public abstract Integer id();

    @Nullable
    public abstract String description();

    @Nullable
    public abstract String executor_location();

    public static Builder builder() {
        return new AutoValue_ProfileDetailsInformation.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder id(Integer id);
        public abstract Builder description(String description);
        public abstract Builder executor_location(String location);
        public abstract ProfileDetailsInformation build();
    }
}
