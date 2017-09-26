package by.orion.onlinertasks.data.repository.sections;

import android.support.annotation.NonNull;

import javax.inject.Inject;

import by.orion.onlinertasks.data.datasource.sections.SectionsDataSource;
import by.orion.onlinertasks.data.models.sections.Section;
import by.orion.onlinertasks.data.models.sections.Sections;
import by.orion.onlinertasks.di.qualifiers.LocalDataSource;
import by.orion.onlinertasks.di.qualifiers.RemoteDataSource;
import io.reactivex.Single;

public class SectionsRepositoryImpl implements SectionsRepository {

    @NonNull
    private final SectionsDataSource localDataSource;

    @NonNull
    private final SectionsDataSource remoteDataSource;

    @Inject
    public SectionsRepositoryImpl(@NonNull @LocalDataSource SectionsDataSource localDataSource,
                                  @NonNull @RemoteDataSource SectionsDataSource remoteDataSource) {
        this.localDataSource = localDataSource;
        this.remoteDataSource = remoteDataSource;
    }

    @Override
    public Single<Sections> getSections() {
        return remoteDataSource.getSections();
    }

    @Override
    public Single<Section> getSection(@NonNull Integer id) {
        return remoteDataSource.getSection(id);
    }

    @Override
    public Single<Sections> getSectionsWithCategories() {
        return remoteDataSource.getSectionsWithCategories();
    }
}
