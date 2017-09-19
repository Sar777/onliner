package by.orion.onlinertasks.presentation.main.fragments.tasks.mappers;

import android.support.annotation.NonNull;

import by.orion.onlinertasks.common.GenericObjectMapper;
import by.orion.onlinertasks.data.models.task.Location;
import by.orion.onlinertasks.presentation.main.fragments.tasks.models.LocationItem;

public class TaskLocationToTaskLocationItemMapper implements GenericObjectMapper<Location, LocationItem> {
    
    @NonNull
    @Override
    public LocationItem map(@NonNull Location location) {
        return LocationItem.builder()
                .district(location.district())
                .region(location.region())
                .town(location.town())
                .build();
    }
}
