package ir.eniac.tech.bimeh.com.sdk.bimeh;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.support.multidex.MultiDex;

import com.pixplicity.easyprefs.library.Prefs;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class EniacApplication extends Application
{
//    private NetComponent mNetComponent;


    @Override
    protected void attachBaseContext(Context base)
    {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate()
    {
        super.onCreate();
//        SingletonContext.Companion.getInstance().setContext(this);
//        SingletonService.getInstance().setContext(this);


//        mNetComponent = DaggerNetComponent.builder()
//                .appModule(new AppModule(this))
//                .netModule(new NetModule(Const.BASEURL))
//                .build();

//        SingletonService.getInstance().setNetComponent(mNetComponent).inject();

//        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
//                .setDefaultFontPath("fonts/iran_sans_normal.ttf")
//                .setFontAttrId(R.attr.fontPath)
//                .addCustomViewWithSetTypeface(CustomViewWithTypefaceSupport.class)
//                .addCustomStyle(TextField.class, R.attr.textFieldStyle)
//                .build()
//        );
        new Prefs.Builder()
                .setContext(this)
                .setMode(ContextWrapper.MODE_PRIVATE)
                .setPrefsName(getPackageName())
                .setUseDefaultSharedPreference(true)
                .build();


    }


    @Override
    public void onTerminate()
    {
        super.onTerminate();
    }


}