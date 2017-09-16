package by.orion.onlinernews.data.models.impl;

import java.util.List;

import pl.droidsonroids.jspoon.annotation.Selector;

public class ArticlesPage {

    @Selector("div[class=news-tidings__list] > [class^=news-tidings__item]")
    public List<RemoteArticle> articles;
}
