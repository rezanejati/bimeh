package ir.eniac.tech.bimeh.com.sdk.bimeh.service.listener;


/**
 * Created by Javad.Abadi on 3/26/2018.
 */

public interface OnServiceStatus<T>
{

    void onReady(T t);


    void onError(String message);
}