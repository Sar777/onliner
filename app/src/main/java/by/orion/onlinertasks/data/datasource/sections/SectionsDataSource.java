package by.orion.onlinertasks.data.datasource.sections;

import android.support.annotation.NonNull;

import by.orion.onlinertasks.data.datasource.DataSource;
import by.orion.onlinertasks.data.models.sections.Section;
import by.orion.onlinertasks.data.models.sections.Sections;
import io.reactivex.Single;

public interface SectionsDataSource extends DataSource<Section, Integer> {

    Single<Sections> getSections();

    Single<Section> getSection(@NonNull Integer id);

    Single<Sections> getSectionsWithCategories();
}
