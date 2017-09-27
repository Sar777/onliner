package by.orion.onlinertasks.data.models.task;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import by.orion.onlinertasks.data.models.common.Page;

@AutoValue
public abstract class TasksPage {

    @SerializedName("tasks")
    public abstract List<Task> tasks();

    @SerializedName("total")
    public abstract Integer total();

    @SerializedName("page")
    public abstract Page page();

    public static TypeAdapter<TasksPage> typeAdapter(Gson gson) {
        return new AutoValue_TasksPage.GsonTypeAdapter(gson);
    }
}
