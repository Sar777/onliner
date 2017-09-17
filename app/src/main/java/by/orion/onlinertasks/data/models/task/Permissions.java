package by.orion.onlinertasks.data.models.task;

import com.google.auto.value.AutoValue;
import com.google.gson.annotations.SerializedName;

import by.orion.onlinertasks.common.annotations.AutoGson;

@AutoGson
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

    public static Permissions create(Boolean admin, Boolean accept, Boolean arbitrage, Boolean close, Boolean delete, Boolean propose) {
        return new AutoValue_Permissions(admin, accept, arbitrage, close, delete, propose);
    }
}
