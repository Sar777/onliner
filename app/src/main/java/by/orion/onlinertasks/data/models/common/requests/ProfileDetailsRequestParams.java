package by.orion.onlinertasks.data.models.common.requests;

import android.support.annotation.NonNull;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class ProfileDetailsRequestParams {

    @NonNull
    public abstract Integer id();

    public static Builder builder() {
        return new AutoValue_ProfileDetailsRequestParams.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder id(Integer id);
        public abstract ProfileDetailsRequestParams build();
    }
}
