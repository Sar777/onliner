package by.orion.onlinernews.presentation.common.models;

import android.support.annotation.NonNull;
import android.util.SparseArray;

import by.orion.onlinernews.BuildConfig;

public enum ArticleCategory {
    PEOPLE(0, BuildConfig.PEOPLE_SUBDOMAIN),
    OPINIONS(1, BuildConfig.OPINIONS_SUBDOMAIN),
    AUTO(2, BuildConfig.AUTO_SUBDOMAIN),
    TECH(3, BuildConfig.TECH_SUBDOMAIN),
    REALT(4, BuildConfig.REALT_SUBDOMAIN),
    UNKNOWN(5, "unknown");

    @NonNull
    private static SparseArray<ArticleCategory> map = new SparseArray<>();

    @NonNull
    private final Integer id;

    @NonNull
    private final String url;

    static {
        for (ArticleCategory id : ArticleCategory.values()) {
            map.put(id.id, id);
        }
    }

    ArticleCategory(@NonNull final Integer id, @NonNull final String url) {
        this.id = id;
        this.url = url;
    }

    @NonNull
    public Integer getId() {
        return id;
    }

    @NonNull
    public String getUrl() {
        return url;
    }

    @NonNull
    public static ArticleCategory valueOf(@NonNull Integer id) {
        return map.get(id, UNKNOWN);
    }
}
