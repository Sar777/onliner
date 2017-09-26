package by.orion.onlinertasks.data.repository.sections;

import android.support.annotation.NonNull;

import by.orion.onlinertasks.data.models.sections.Section;
import by.orion.onlinertasks.data.models.sections.Sections;
import by.orion.onlinertasks.data.repository.Repository;
import io.reactivex.Single;

public interface SectionsRepository extends Repository {

    Single<Sections> getSections();

    Single<Section> getSection(@NonNull Integer id);

    Single<Sections> getSectionsWithCategories();
}
