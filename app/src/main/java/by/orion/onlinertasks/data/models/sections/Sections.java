package by.orion.onlinertasks.data.models.sections;

import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@AutoValue
public abstract class Sections {

    @SerializedName("sections")
    public abstract List<Section> sections();

    @SerializedName("categories")
    @Nullable
    public abstract List<Category> categories();

    public static TypeAdapter<Sections> typeAdapter(Gson gson) {
        return new AutoValue_Sections.GsonTypeAdapter(gson);
    }
}
