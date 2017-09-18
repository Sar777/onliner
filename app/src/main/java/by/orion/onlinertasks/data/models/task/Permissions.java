package by.orion.onlinertasks.data.models.task;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

@AutoValue
public abstract class Permissions {

    @SerializedName("admin")
    public abstract Boolean admin();

    @SerializedName("accept")
    public abstract Boolean accept();

    @SerializedName("arbitrage")
    public abstract Boolean arbitrage();

    @SerializedName("close")
    public abstract Boolean close();

    @SerializedName("delete")
    public abstract Boolean delete();

    @SerializedName("propose")
    public abstract Boolean propose();

    public static TypeAdapter<Permissions> typeAdapter(Gson gson) {
        return new AutoValue_Permissions.GsonTypeAdapter(gson);
    }
}
