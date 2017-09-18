package by.orion.onlinertasks.data.models.task;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class TasksRequestParams {

    public abstract int page();

    public static Builder builder() {
        return new AutoValue_TasksRequestParams.Builder()
                .page(1);
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder page(int page);
        public abstract TasksRequestParams build();
    }
}
