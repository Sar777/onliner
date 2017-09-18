package by.orion.onlinertasks.presentation.main.fragments.models;

import android.support.annotation.NonNull;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class SectionItem {

    @NonNull
    public abstract Integer id();

    @NonNull
    public abstract String name();

    @NonNull
    public abstract String slug();

    public static Builder builder() {
        return new AutoValue_SectionItem.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder id(Integer id);
        public abstract Builder name(String name);
        public abstract Builder slug(String slug);
        public abstract SectionItem build();
    }
}
