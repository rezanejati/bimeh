package ir.eniac.tech.bimeh.com.sdk.bimeh.di.component;

import javax.inject.Singleton;

import dagger.Component;
import ir.eniac.tech.bimeh.com.sdk.bimeh.di.module.AppModule;
import ir.eniac.tech.bimeh.com.sdk.bimeh.di.module.NetModule;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by Javad.Abadi on 3/26/2018.
 */

@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent
{
    Retrofit retrofit();
    OkHttpClient okhttp();

}

