package by.orion.onlinertasks.data.models.task;

import com.google.auto.value.AutoValue;
import com.google.gson.annotations.SerializedName;

import by.orion.onlinertasks.common.annotations.AutoGson;

@AutoGson
@AutoValue
public abstract class Task {

    @SerializedName("id")
    public abstract Integer id();

    @SerializedName("title")
    public abstract String title();

    @SerializedName("description")
    public abstract String description();

    @SerializedName("image")
    public abstract Image image();

    @SerializedName("price")
    public abstract Price price();

    @SerializedName("executor_id")
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

    @SerializedName("permissions")
    public abstract Permissions permissions();

    public static Task create(Integer id, String title, String description, Image image, Price price, Integer executor_id, String status, Integer proposals_qty, Location location, String deadline, String created_at, String url, String html_url, Author author, Section section, Permissions permissions) {
        return new AutoValue_Task(id, title, description, image, price, executor_id, status, proposals_qty, location, deadline, created_at, url, html_url, author, section, permissions);
    }
}