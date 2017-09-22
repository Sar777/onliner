package by.orion.onlinertasks.data.models.requests;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class ProfileRequestParams {

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
