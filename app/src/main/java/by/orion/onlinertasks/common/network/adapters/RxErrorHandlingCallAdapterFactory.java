package by.orion.onlinertasks.common.network.adapters;

import android.support.annotation.NonNull;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import by.orion.onlinertasks.common.exceptions.RetrofitException;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.HttpException;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public class RxErrorHandlingCallAdapterFactory extends CallAdapter.Factory {

    private final RxJava2CallAdapterFactory originalCallAdapterFactory;

    private RxErrorHandlingCallAdapterFactory() {
        originalCallAdapterFactory = RxJava2CallAdapterFactory.create();
    }

    public static CallAdapter.Factory create() {
        return new RxErrorHandlingCallAdapterFactory();
    }

    @Override
    public CallAdapter<?, ?> get(final Type returnType, final Annotation[] annotations, final Retrofit retrofit) {
        Type type = getRawType(returnType);

        AbstractRxCallAdapterWrapper adapterWrapper;
        if (type.equals(Single.class)) {
            adapterWrapper = new RxCallSingleAdapterWrapper<>(retrofit, originalCallAdapterFactory.get(returnType, annotations, retrofit));
        } else if (type.equals(Observable.class)) {
            adapterWrapper = new RxCallObservableAdapterWrapper<>(retrofit, originalCallAdapterFactory.get(returnType, annotations, retrofit));
        } else if (type.equals(Flowable.class)) {
            adapterWrapper = new RxCallFlowableAdapterWrapper<>(retrofit, originalCallAdapterFactory.get(returnType, annotations, retrofit));
        } else {
            throw new UnsupportedOperationException("Unsupported error handler raw type: " + type.toString());
        }

        return adapterWrapper;
    }

    private class RxCallSingleAdapterWrapper<R> extends AbstractRxCallAdapterWrapper<R, Single<R>> {

        public RxCallSingleAdapterWrapper(@NonNull Retrofit retrofit, @NonNull CallAdapter<R, ?> wrapped) {
            super(retrofit, wrapped);
        }

        @SuppressWarnings("unchecked")
        @Override
        public Single<R> adapt(Call<R> call) {
            return ((Single) wrappedCallAdapter.adapt(call)).onErrorResumeNext(new Function<Throwable, SingleSource>() {
                @Override
                public Single apply(final Throwable throwable) {
                    return Single.error(asRetrofitException(throwable));
                }
            });
        }
    }

    private class RxCallObservableAdapterWrapper<R> extends AbstractRxCallAdapterWrapper<R, Observable<R>> {

        public RxCallObservableAdapterWrapper(@NonNull Retrofit retrofit, @NonNull CallAdapter<R, ?> wrapped) {
            super(retrofit, wrapped);
        }

        @SuppressWarnings("unchecked")
        @Override
        public Observable<R> adapt(Call<R> call) {
            return ((Observable) wrappedCallAdapter.adapt(call)).onErrorResumeNext(new Function<Throwable, Observable>() {
                @Override
                public Observable apply(final Throwable throwable) {
                    return Observable.error(asRetrofitException(throwable));
                }
            });
        }
    }

    private class RxCallFlowableAdapterWrapper<R> extends AbstractRxCallAdapterWrapper<R, Flowable<R>> {

        public RxCallFlowableAdapterWrapper(@NonNull Retrofit retrofit, @NonNull CallAdapter<R, ?> wrapped) {
            super(retrofit, wrapped);
        }

        @SuppressWarnings("unchecked")
        @Override
        public Flowable<R> adapt(Call<R> call) {
            return ((Flowable) wrappedCallAdapter.adapt(call)).onErrorResumeNext(new Function<Throwable, Flowable>() {
                @Override
                public Flowable apply(final Throwable throwable) {
                    return Flowable.error(asRetrofitException(throwable));
                }
            });
        }
    }

    private abstract class AbstractRxCallAdapterWrapper<R, T> implements CallAdapter<R, T> {

        @NonNull
        final Retrofit retrofit;

        @NonNull
        final CallAdapter<R, ?> wrappedCallAdapter;

        AbstractRxCallAdapterWrapper(@NonNull final Retrofit retrofit, @NonNull final CallAdapter<R, ?> wrapped) {
            this.retrofit = retrofit;
            this.wrappedCallAdapter = wrapped;
        }

        @Override
        public Type responseType() {
            return wrappedCallAdapter.responseType();
        }

        @SuppressWarnings("unchecked")
        @Override
        public T adapt(final Call<R> call) {
            throw new UnsupportedOperationException();
        }

        RetrofitException asRetrofitException(final Throwable throwable) {
            // We had non-200 http error
            if (throwable instanceof HttpException) {
                final HttpException httpException = (HttpException) throwable;
                final Response response = httpException.response();

                return RetrofitException.httpError(response.raw().request().url().toString(), response, retrofit);
            }
            // A network error happened
            if (throwable instanceof IOException) {
                return RetrofitException.networkError((IOException) throwable);
            }

            // We don't know what happened. We need to simply convert to an unknown error
            return RetrofitException.unexpectedError(throwable);
        }
    }
}