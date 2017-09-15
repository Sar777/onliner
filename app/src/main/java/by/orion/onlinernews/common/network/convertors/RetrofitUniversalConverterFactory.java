package by.orion.onlinernews.common.network.convertors;

import android.support.annotation.NonNull;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import by.orion.onlinernews.common.network.Gson;
import by.orion.onlinernews.common.network.Jspoon;
import by.orion.onlinernews.common.network.String;
import okhttp3.ResponseBody;
import pl.droidsonroids.retrofit2.JspoonConverterFactory;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUniversalConverterFactory extends Converter.Factory {

    @NonNull
    private final Converter.Factory jspoon;

    @NonNull
    private final Converter.Factory string;

    @NonNull
    private final Converter.Factory gson;

    public RetrofitUniversalConverterFactory(@NonNull com.google.gson.Gson gson) {
        jspoon = JspoonConverterFactory.create();
        string = StringConverterFactory.create();
        this.gson = GsonConverterFactory.create(gson);
    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        for (Annotation annotation : annotations) {
            if (annotation.annotationType() == Gson.class) {
                return gson.responseBodyConverter(type, annotations, retrofit);
            } else if (annotation.annotationType() == String.class) {
                return string.responseBodyConverter(type, annotations, retrofit);
            } else if (annotation.annotationType() == Jspoon.class) {
                return jspoon.responseBodyConverter(type, annotations, retrofit);
            }
        }

        throw new IllegalArgumentException("Unknown converter");
    }
}