package by.orion.onlinernews.data.models;

import android.support.annotation.NonNull;

public interface Article {

    @NonNull
    String getTitle();

    @NonNull
    String getDescription();

    @NonNull
    String getViews();

    @NonNull
    Integer getComments();

    @NonNull
    Integer getPictures();

    @NonNull
    Long getDate();

    @NonNull
    Boolean hasUpdate();

    @NonNull
    Boolean hasVideo();
}
