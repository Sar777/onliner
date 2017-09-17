package by.orion.onlinertasks.common.network.interceptors;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class HeadersInterceptor implements Interceptor {

    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();

        // Request customization: add request headers
        Request.Builder requestBuilder = request.newBuilder()
                .header("Content-Type", "application/json; charset=utf-8")
                .header("Accept", "application/json, text/plain, */*");

        return chain.proceed(requestBuilder.build());
    }
}
