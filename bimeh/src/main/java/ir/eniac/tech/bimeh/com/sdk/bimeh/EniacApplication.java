package ir.eniac.tech.bimeh.com.sdk.bimeh;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.support.multidex.MultiDex;

import com.pixplicity.easyprefs.library.Prefs;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import ir.eniac.tech.bimeh.com.sdk.bimeh.di.component.DaggerNetComponent;
import ir.eniac.tech.bimeh.com.sdk.bimeh.di.component.DaggerViewModelComponent;
import ir.eniac.tech.bimeh.com.sdk.bimeh.di.component.NetComponent;
import ir.eniac.tech.bimeh.com.sdk.bimeh.di.module.AppModule;
import ir.eniac.tech.bimeh.com.sdk.bimeh.di.module.NetModule;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.generator.SingletonService;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.helper.Const;
import ir.eniac.tech.bimeh.com.sdk.bimeh.singleton.SingletonContext;
import ir.eniac.tech.bimeh.com.sdk.bimeh.utility.font.CustomViewWithTypefaceSupport;
import ir.eniac.tech.bimeh.com.sdk.bimeh.utility.font.TextField;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class EniacApplication extends Application
//        implements HasActivityInjector
{
    private NetComponent mNetComponent;

//    @Inject
//    DispatchingAndroidInjector<Activity> activityDispatchingInjector;

//    @Inject
//    CalligraphyConfig mCalligraphyConfig;

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
        SingletonContext.Companion.getInstance().setContext(this);
        SingletonService.getInstance().setContext(this);

        mNetComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule(Const.BASEURL))
                .build();

        DaggerViewModelComponent.builder()
                .application(this)
                .build()
                .inject(this);

        SingletonService.getInstance().setNetComponent(mNetComponent).inject();

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("font/iran_sans_normal.ttf")
                .setFontAttrId(R.attr.fontPath)
                .addCustomViewWithSetTypeface(CustomViewWithTypefaceSupport.class)
                .addCustomStyle(TextField.class, R.attr.textFieldStyle)
                .build()
        );

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


//    @Override
//    public AndroidInjector<Activity> activityInjector()
//    {
//        return activityDispatchingInjector;
//    }
}