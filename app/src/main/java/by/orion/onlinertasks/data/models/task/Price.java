package by.orion.onlinertasks.data.models.task;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

@AutoValue
public abstract class Price {

    @SerializedName("amount")
    public abstract String amount();

    @SerializedName("currency")
    public abstract String currency();

    public static TypeAdapter<Price> typeAdapter(Gson gson) {
        return new AutoValue_Price.GsonTypeAdapter(gson);
    }
}
