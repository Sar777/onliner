package by.orion.onlinertasks.common.exceptions;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.io.IOException;
import java.lang.annotation.Annotation;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RetrofitException extends RuntimeException {

    public static RetrofitException httpError(@NonNull String url, @NonNull Response response, @NonNull Retrofit retrofit) {
        String message = response.code() + " " + response.message();
        return new RetrofitException(message, url, response, Kind.HTTP, null, retrofit);
    }

    public static RetrofitException networkError(@NonNull IOException exception) {
        return new RetrofitException(exception.getMessage(), null, null, Kind.NETWORK, exception, null);
    }

    public static RetrofitException unexpectedError(@NonNull Throwable exception) {
        return new RetrofitException(exception.getMessage(), null, null, Kind.UNEXPECTED, exception, null);
    }

    /** Identifies the event kind which triggered a {@link RetrofitException}. */
    public enum Kind {
        /** An {@link IOException} occurred while communicating to the server. */
        NETWORK,
        /** A non-200 HTTP status code was received from the server. */
        HTTP,
        /**
         * An internal error occurred while attempting to execute a request. It is best practice to
         * re-throw this exception so your application crashes.
         */
        UNEXPECTED
    }

    @Nullable
    private final String url;

    @Nullable
    private final Response response;

    @NonNull
    private final Kind kind;

    @Nullable
    private final Retrofit retrofit;

    private RetrofitException(@NonNull String message, @Nullable String url, @Nullable Response response, @NonNull Kind kind, @Nullable Throwable exception, @Nullable Retrofit retrofit) {
        super(message, exception);
        this.url = url;
        this.response = response;
        this.kind = kind;
        this.retrofit = retrofit;
    }

    /** The request URL which produced the error. */
    @Nullable
    public String getUrl() {
        return url;
    }

    /** Response object containing status code, headers, body, etc. */
    @Nullable
    public Response getResponse() {
        return response;
    }

    /** The event kind which triggered this error. */
    @NonNull
    public Kind getKind() {
        return kind;
    }

    /** The Retrofit this request was executed on */
    @Nullable
    public Retrofit getRetrofit() {
        return retrofit;
    }

    /**
     * HTTP response body converted to specified {@code type}. {@code null} if there is no
     * response.
     *
     * @throws IOException if unable to convert the body to the specified {@code type}.
     */
    public <T> T getErrorBodyAs(Class<T> type) throws IOException {
        if (response == null || response.errorBody() == null) {
            return null;
        }
        Converter<ResponseBody, T> converter = retrofit.responseBodyConverter(type, new Annotation[]{});
        return converter.convert(response.errorBody());
    }
}
