package by.orion.onlinertasks.data.models.sections;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

@AutoValue
public abstract class Section {

    @SerializedName("id")
    public abstract Integer id();

    @SerializedName("category_id")
    public abstract Integer categoryId();

    @SerializedName("name")
    public abstract String name();

    @SerializedName("meta_title")
    public abstract String metaTitle();

    @SerializedName("slug")
    public abstract String slug();

    @SerializedName("need_documents")
    public abstract Boolean needDocuments();

    @SerializedName("need_license")
    public abstract Boolean needLicense();

    @SerializedName("published")
    public abstract Boolean published();

    public static TypeAdapter<Section> typeAdapter(Gson gson) {
        return new AutoValue_Section.GsonTypeAdapter(gson);
    }
}
