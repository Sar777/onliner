package by.orion.onlinernews.common.network.convertors;

import android.support.annotation.NonNull;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

public final class StringConverterFactory extends Converter.Factory {

    static final StringConverter INSTANCE = new StringConverter();

    private StringConverterFactory() {
    }

    public static StringConverterFactory create() {
        return new StringConverterFactory();
    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        return INSTANCE;
    }

    private final static class StringConverter implements Converter<ResponseBody, String> {

        @Override
        public String convert(@NonNull ResponseBody responseBody) throws IOException {
            return responseBody.string();
        }
    }
}
