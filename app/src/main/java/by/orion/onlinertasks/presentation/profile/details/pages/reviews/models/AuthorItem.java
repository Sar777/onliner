package by.orion.onlinertasks.presentation.profile.details.pages.reviews.models;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class AuthorItem {

    @NonNull
    public abstract Integer id();

    @NonNull
    public abstract String name();

    @Nullable
    public abstract String photo();

    public static Builder builder() {
        return new AutoValue_AuthorItem.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder id(Integer id);
        public abstract Builder name(String name);
        public abstract Builder photo(String photo);
        public abstract AuthorItem build();
    }
}
