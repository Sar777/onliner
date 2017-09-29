package by.orion.onlinertasks.data.models.common.requests;

import android.support.annotation.NonNull;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class SingInRequestParams {

    @NonNull
    public abstract String username();

    @NonNull
    public abstract String password();

    public static Builder builder() {
        return new AutoValue_SingInRequestParams.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder username(String username);
        public abstract Builder password(String password);
        public abstract SingInRequestParams build();
    }
}
