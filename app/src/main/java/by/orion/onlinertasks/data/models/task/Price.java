package by.orion.onlinertasks.data.models.task;

import com.google.auto.value.AutoValue;
import com.google.gson.annotations.SerializedName;

import by.orion.onlinertasks.common.annotations.AutoGson;

@AutoGson
@AutoValue
public abstract class Price {

    @SerializedName("amount")
    public abstract Boolean amount();

    @SerializedName("currency")
    public abstract Boolean currency();

    public static Price create(Boolean amount, Boolean currency) {
        return new AutoValue_Price(amount, currency);
    }
}
