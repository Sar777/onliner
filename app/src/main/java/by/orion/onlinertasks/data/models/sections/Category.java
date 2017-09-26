package by.orion.onlinertasks.data.models.sections;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@AutoValue
public abstract class Category {

    @SerializedName("id")
    public abstract Integer id();

    @SerializedName("name")
    public abstract String name();

    @SerializedName("sections")
    public abstract List<Integer> sections();

    public static TypeAdapter<Category> typeAdapter(Gson gson) {
        return new AutoValue_Category.GsonTypeAdapter(gson);
    }
}
