package by.orion.onlinertasks.presentation.main.fragments.profiles.models;

import android.support.annotation.NonNull;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class RatingItem {

    @NonNull
    public abstract RatesItem rates();

    @NonNull
    public abstract Integer votes();

    @NonNull
    public abstract Float averageRate();

    public static Builder builder() {
        return new AutoValue_RatingItem.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder rates(RatesItem rates);
        public abstract Builder votes(Integer votes);
        public abstract Builder averageRate(Float averageRate);
        public abstract RatingItem build();
    }
}
