package by.orion.onlinernews.data.models.impl;

import android.support.annotation.NonNull;

import by.orion.onlinernews.data.models.Article;

public class RemoteArticle implements Article {

    @NonNull
    private String title;

    @NonNull
    private String description;

    @NonNull
    private Integer views;

    @NonNull
    private Integer comments;

    @NonNull
    private Integer pictures;

    @NonNull
    private Long date;

    @NonNull
    private Boolean hasUpdate;

    @NonNull
    private Boolean hasVideo;

    @Override
    @NonNull
    public String getTitle() {
        return title;
    }

    @Override
    @NonNull
    public String getDescription() {
        return description;
    }

    @Override
    @NonNull
    public Integer getViews() {
        return views;
    }

    @Override
    @NonNull
    public Integer getComments() {
        return comments;
    }

    @Override
    @NonNull
    public Integer getPictures() {
        return pictures;
    }

    @Override
    @NonNull
    public Long getDate() {
        return date;
    }

    @Override
    @NonNull
    public Boolean hasUpdate() {
        return hasUpdate;
    }

    @Override
    @NonNull
    public Boolean hasVideo() {
        return hasVideo;
    }
}
