package by.orion.onlinertasks.data.models.task;

import com.google.auto.value.AutoValue;
import com.google.gson.annotations.SerializedName;

import by.orion.onlinertasks.common.annotations.AutoGson;

@AutoGson
@AutoValue
public abstract class Price {

    @SerializedName("amount")
    public abstract Integer amount();

    @SerializedName("currency")
    public abstract String currency();

    public static Price create(Integer amount, String currency) {
        return new AutoValue_Price(amount, currency);
    }
}
