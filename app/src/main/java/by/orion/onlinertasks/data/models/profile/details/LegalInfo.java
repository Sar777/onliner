package by.orion.onlinertasks.data.models.profile.details;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

@AutoValue
public abstract class LegalInfo {

    @SerializedName("unp")
    public String unp;

    public static TypeAdapter<LegalInfo> typeAdapter(Gson gson) {
        return new AutoValue_LegalInfo.GsonTypeAdapter(gson);
    }
}
