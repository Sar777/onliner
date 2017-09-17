package by.orion.onlinertasks.data.models.task;

import com.google.auto.value.AutoValue;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import by.orion.onlinertasks.common.annotations.AutoGson;
import by.orion.onlinertasks.data.models.Page;

@AutoGson
@AutoValue
public abstract class TasksPage {

    @SerializedName("tasks")
    public abstract List<Task> tasks();

    @SerializedName("total")
    public abstract Integer total();

    @SerializedName("page")
    public abstract Page page();

    public static TasksPage create(List<Task> tasks, Integer total, Page page) {
        return new AutoValue_TasksPage(tasks, total, page);
    }
}
