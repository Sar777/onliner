package by.orion.onlinertasks.presentation.profile.details.pages.models;

import android.support.annotation.NonNull;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class ProfileDetailsInformation {

    @NonNull
    public abstract Integer id();

    @NonNull
    public abstract String description();

    public static Builder builder() {
        return new AutoValue_ProfileDetailsInformation.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder id(Integer id);
        public abstract Builder description(String description);
        public abstract ProfileDetailsInformation build();
    }
}
