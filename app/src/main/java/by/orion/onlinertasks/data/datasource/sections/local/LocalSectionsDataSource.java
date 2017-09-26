package by.orion.onlinertasks.data.datasource.sections.local;

import android.support.annotation.NonNull;

import com.pushtorefresh.storio.sqlite.StorIOSQLite;

import javax.inject.Inject;

import by.orion.onlinertasks.data.datasource.sections.SectionsDataSource;
import by.orion.onlinertasks.data.models.sections.Section;
import by.orion.onlinertasks.data.models.sections.Sections;
import io.reactivex.Completable;
import io.reactivex.Single;

public class LocalSectionsDataSource implements SectionsDataSource {

    @NonNull
    private final StorIOSQLite storIOSQLite;

    @Inject
    public LocalSectionsDataSource(@NonNull StorIOSQLite storIOSQLite) {
        this.storIOSQLite = storIOSQLite;
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
        throw new UnsupportedOperationException();
    }

    @Override
    public Single<Section> getSection(@NonNull Integer id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Single<Sections> getSectionsWithCategories() {
        throw new UnsupportedOperationException();
    }
}
