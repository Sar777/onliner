package by.orion.onlinertasks.presentation.main.fragments.profiles.mappers;

import android.support.annotation.NonNull;

import by.orion.onlinertasks.common.GenericObjectMapper;
import by.orion.onlinertasks.data.models.profile.Rates;
import by.orion.onlinertasks.presentation.main.fragments.profiles.models.RatesItem;

public class ProfileRatesToProfileRatesItemMapper implements GenericObjectMapper<Rates, RatesItem> {
    
    @NonNull
    @Override
    public RatesItem map(@NonNull Rates rates) {
        return RatesItem.builder()
                .politeness(rates.politeness())
                .quality(rates.quality())
                .punctuality(rates.punctuality())
                .build();
    }
}
