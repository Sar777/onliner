package by.orion.onlinernews.common.network.services;

import java.util.List;

import by.orion.onlinernews.data.models.impl.RemoteArticle;
import io.reactivex.Single;
import retrofit2.http.GET;

public interface BaseService {

    @GET
    Single<List<RemoteArticle>> getArticles();
}
