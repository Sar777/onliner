package by.orion.onlinertasks.data.models.task;

import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

@AutoValue
public abstract class Task {

    @SerializedName("id")
    public abstract Integer id();

    @SerializedName("title")
    public abstract String title();

    @SerializedName("description")
    public abstract String description();

    @SerializedName("image")
    @Nullable
    public abstract Image image();

    @SerializedName("price")
    @Nullable
    public abstract Price price();

    @SerializedName("executor_id")
    @Nullable
    public abstract Integer executor_id();

    @SerializedName("status")
    public abstract String status();

    @SerializedName("proposals_qty")
    public abstract Integer proposals_qty();

    @SerializedName("location")
    public abstract Location location();

    @SerializedName("deadline")
    public abstract String deadline();

    @SerializedName("created_at")
    public abstract String created_at();

    @SerializedName("url")
    public abstract String url();

    @SerializedName("html_url")
    public abstract String html_url();

    @SerializedName("author")
    public abstract Author author();

    @SerializedName("section")
    public abstract Section section();

    public static TypeAdapter<Task> typeAdapter(Gson gson) {
        return new AutoValue_Task.GsonTypeAdapter(gson);
    }
}