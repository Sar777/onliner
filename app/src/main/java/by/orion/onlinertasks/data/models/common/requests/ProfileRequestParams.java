package by.orion.onlinertasks.data.models.common.requests;

import android.support.annotation.NonNull;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class ProfileRequestParams {

    @NonNull
    public abstract Integer id();

    public static Builder builder() {
        return new AutoValue_ProfileRequestParams.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder id(Integer id);
        public abstract ProfileRequestParams build();
    }
}
