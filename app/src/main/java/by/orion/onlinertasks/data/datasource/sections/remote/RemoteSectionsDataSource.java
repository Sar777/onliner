package by.orion.onlinertasks.data.datasource.sections.remote;

import android.support.annotation.NonNull;

import javax.inject.Inject;

import by.orion.onlinertasks.common.network.services.BaseService;
import by.orion.onlinertasks.data.datasource.sections.SectionsDataSource;
import by.orion.onlinertasks.data.models.sections.Section;
import by.orion.onlinertasks.data.models.sections.Sections;
import io.reactivex.Completable;
import io.reactivex.Single;

public class RemoteSectionsDataSource implements SectionsDataSource {

    @NonNull
    private final BaseService service;

    @Inject
    public RemoteSectionsDataSource(@NonNull BaseService service) {
        this.service = service;
    }

    @Override
    public Single<Integer> getValue(@NonNull Section key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Completable setValue(@NonNull Section key, @NonNull Integer value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Single<Sections> getSections() {
        return service.getSections();
    }

    @Override
    public Single<Section> getSection(@NonNull Integer id) {
        return service.getSection(id);
    }

    @Override
    public Single<Sections> getSectionsWithCategories() {
        return service.getSectionsWithCategories();
    }
}
