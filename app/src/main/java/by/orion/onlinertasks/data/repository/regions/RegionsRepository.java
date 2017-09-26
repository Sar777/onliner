package by.orion.onlinertasks.data.repository.regions;

import java.util.List;

import by.orion.onlinertasks.data.models.regions.Region;
import by.orion.onlinertasks.data.repository.Repository;
import io.reactivex.Single;

public interface RegionsRepository extends Repository {

    Single<List<Region>> getRegions();
}
