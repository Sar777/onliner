package by.orion.onlinertasks.data.datasource.regions;

import java.util.List;

import by.orion.onlinertasks.data.datasource.DataSource;
import by.orion.onlinertasks.data.models.regions.Region;
import io.reactivex.Single;

public interface RegionsDataSource extends DataSource {

    Single<List<Region>> getRegions();
}
