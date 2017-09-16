package by.orion.onlinernews.data.models.impl;

import android.support.annotation.NonNull;

import by.orion.onlinernews.data.models.Article;
import pl.droidsonroids.jspoon.annotation.Selector;

public class RemoteArticle implements Article {

    @Selector("div[class=news-tidings__clamping] > div[class=news-tidings__subtitle]")
    @NonNull
    private String title;

    @Selector("div[class=news-tidings__clamping] > div[class^=news-tidings__speech]")
    @NonNull
    private String description;

    @Selector(value = "div[class=^news-tidings__image]", attr = "style")
    @NonNull
    private String imageUrl;

    @Selector(value = "div[class=news-tidings__group] > div", defValue = "-1")
    @NonNull
    private String views;

    @Selector(value = "div[class=news-tidings__group] > a", defValue = "-1")
    @NonNull
    private Integer comments;

    @NonNull
    private Integer pictures;

    @NonNull
    private Long date;

    @Selector(value = "div[class=news-tidings__control] > div[class*=news-tidings__button_video]", defValue = "false")
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
    public String getViews() {
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
