package by.orion.onlinertasks.presentation.main.fragments.models;

import android.support.annotation.NonNull;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class LocationItem {

    @NonNull
    public abstract String region();

    @NonNull
    public abstract String district();

    @NonNull
    public abstract String town();

    public static Builder builder() {
        return new AutoValue_LocationItem.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder region(String region);
        public abstract Builder district(String district);
        public abstract Builder town(String town);
        public abstract LocationItem build();
    }
}
