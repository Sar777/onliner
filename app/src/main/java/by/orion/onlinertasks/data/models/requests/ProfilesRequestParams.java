package by.orion.onlinertasks.data.models.requests;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class ProfilesRequestParams {

    public abstract Integer page();

    public static Builder builder() {
        return new AutoValue_ProfilesRequestParams.Builder()
                .page(1);
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder page(Integer page);
        public abstract ProfilesRequestParams build();
    }
}
