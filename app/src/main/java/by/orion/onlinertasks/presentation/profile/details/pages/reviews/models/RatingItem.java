package by.orion.onlinertasks.presentation.profile.details.pages.reviews.models;

import android.support.annotation.NonNull;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class RatingItem {

    @NonNull
    public abstract Integer politeness();

    @NonNull
    public abstract Integer quality();

    @NonNull
    public abstract Integer punctuality();

    public static Builder builder() {
        return new AutoValue_RatingItem.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder politeness(Integer politeness);
        public abstract Builder quality(Integer quality);
        public abstract Builder punctuality(Integer punctuality);
        public abstract RatingItem build();
    }
}
