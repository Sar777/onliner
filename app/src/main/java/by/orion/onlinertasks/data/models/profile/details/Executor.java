package by.orion.onlinertasks.data.models.profile.details;

import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@AutoValue
public abstract class Executor {

    @SerializedName("type")
    public abstract String type();

    @Nullable
    @SerializedName("first_name")
    public abstract String firstName();

    @Nullable
    @SerializedName("middle_name")
    public abstract String middleName();

    @Nullable
    @SerializedName("last_name")
    public abstract String lastName();

    @SerializedName("legal_info")
    public abstract LegalInfo legalInfo();

    @SerializedName("portfolio")
    public abstract List<Portfolio> portfolio();

    @SerializedName("sections")
    public abstract List<Integer> sections();

    @SerializedName("regions")
    public abstract List<Integer> regions();

    @SerializedName("status")
    public abstract String status();

    @SerializedName("completed_tasks_qty")
    public abstract Integer completedTasksQty();

    public static TypeAdapter<Executor> typeAdapter(Gson gson) {
        return new AutoValue_Executor.GsonTypeAdapter(gson);
    }
}
