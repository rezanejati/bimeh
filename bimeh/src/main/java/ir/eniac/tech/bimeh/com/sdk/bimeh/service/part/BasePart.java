package ir.eniac.tech.bimeh.com.sdk.bimeh.service.part;

import android.os.Handler;
import android.util.Log;

import java.io.IOException;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import ir.eniac.tech.bimeh.com.sdk.bimeh.BuildConfig;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.generator.ServiceGenerator;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.helper.Const;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.listener.OnServiceStatus;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.mock.MockProcessor;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.model.SingletonResponse;
import okhttp3.RequestBody;
import okio.Buffer;
import retrofit2.Response;


/**
 * Created by Javad.Abadi on 3/26/2018.
 */

public abstract class BasePart
{
    private ServiceGenerator serviceGenerator;

    public BasePart(ServiceGenerator serviceGenerator)
    {
        this.serviceGenerator = serviceGenerator;
    }

    protected abstract BasePart getPart();

    public ServiceGenerator getServiceGenerator()
    {
        return serviceGenerator;
    }


    public <T> void start(Observable<Response<T>> observable, OnServiceStatus<T> listener)
    {
        if (!BuildConfig.DEBUG)
        {
            call(observable, listener);
            return;
        }
        MockProcessor<T> mockProcessor = new MockProcessor<>(listener, getPart());
        if (Const.MOCK && mockProcessor.getRawRes() != null && mockProcessor.loadJSONFromAsset() != null)
        {
            T model = mockProcessor.getMockModel();
            if (model == null)
            {
                call(observable, listener);
                return;
            }
            new Handler().postDelayed(() -> listener.onReady(model), 50);
            return;
        }
        call(observable, listener);
    }


    private <T> void call(Observable<Response<T>> observable, OnServiceStatus<T> listener)
    {
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(new Observer<Response<T>>()
                {
                    @Override
                    public void onSubscribe(Disposable d)
                    {

                    }

                    @Override
                    public void onNext(Response<T> value)
                    {
                        if (BuildConfig.DEBUG && Const.TEST)
                        {
                            SingletonResponse.getInstance().addResponse(value);
                        }
                        if (BuildConfig.DEBUG)
                        {
                            Log.e("--URL--", value.raw().request().url().toString());
                            Log.e("--Body--", bodyToString(value.raw().request().body()));
                        }
                        listener.onReady(value.body());
                    }


                    @Override
                    public void onError(Throwable e)
                    {
                        e.printStackTrace();
                        listener.onError(e.getMessage());
                    }

                    @Override
                    public void onComplete()
                    {

                    }
                });
    }

    protected String bodyToString(final RequestBody request)
    {
        try
        {
            final RequestBody copy = request;
            final Buffer buffer = new Buffer();
            if (copy != null)
                copy.writeTo(buffer);
            else
                return "";
            return buffer.readUtf8();
        } catch (final IOException e)
        {
            return "did not work";
        }
    }

}