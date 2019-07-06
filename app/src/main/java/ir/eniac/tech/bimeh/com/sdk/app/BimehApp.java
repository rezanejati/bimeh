package ir.eniac.tech.bimeh.com.sdk.app;

import android.content.Context;
import android.util.Log;

import ir.eniac.tech.bimeh.com.sdk.bimeh.EniacApplication;

public class BimehApp extends EniacApplication
{

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("testt", "onCreate: ");


    }


    @Override
    public void onTerminate() {
        super.onTerminate();
    }

}
