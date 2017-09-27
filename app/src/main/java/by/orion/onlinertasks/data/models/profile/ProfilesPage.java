package by.orion.onlinertasks.data.models.profile;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import by.orion.onlinertasks.data.models.common.Page;

@AutoValue
public abstract class ProfilesPage {

    @SerializedName("profiles")
    public abstract List<Profile> profiles();

    @SerializedName("total")
    public abstract Integer total();

    @SerializedName("page")
    public abstract Page page();

    public static TypeAdapter<ProfilesPage> typeAdapter(Gson gson) {
        return new AutoValue_ProfilesPage.GsonTypeAdapter(gson);
    }
}
