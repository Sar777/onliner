package by.orion.onlinertasks.data.models.profile.details.rating;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

import by.orion.onlinertasks.data.models.profile.Rates;

@AutoValue
public abstract class Customer {

    @SerializedName("votes")
    public abstract Integer votes();

    @SerializedName("average_rate")
    public abstract Integer averageRate();

    @SerializedName("stars")
    public abstract Stars stars();

    public static TypeAdapter<Customer> typeAdapter(Gson gson) {
        return new AutoValue_Customer.GsonTypeAdapter(gson);
    }
}
