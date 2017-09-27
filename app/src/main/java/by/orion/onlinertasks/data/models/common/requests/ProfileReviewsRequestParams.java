package by.orion.onlinertasks.data.models.common.requests;

import android.support.annotation.NonNull;

import com.google.auto.value.AutoValue;

import by.orion.onlinertasks.data.models.common.Role;

@AutoValue
public abstract class ProfileReviewsRequestParams {

    @NonNull
    public abstract Integer id();

    @NonNull
    public abstract Integer page();

    @NonNull
    public abstract Role role();

    public static Builder builder() {
        return new AutoValue_ProfileReviewsRequestParams.Builder()
                .page(1)
                .role(Role.EXECUTOR);
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder id(Integer id);
        public abstract Builder page(Integer page);
        public abstract Builder role(Role role);
        public abstract ProfileReviewsRequestParams build();
    }
}
