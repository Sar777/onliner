package by.orion.onlinernews.common.network.services;

import android.support.annotation.NonNull;

import by.orion.onlinernews.common.network.HtmlJspoon;
import by.orion.onlinernews.data.models.impl.ArticlesPage;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface BaseService {

    @HtmlJspoon
    @GET
    Single<ArticlesPage> getArticles(@NonNull @Url String url);
}
