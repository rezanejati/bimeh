package ir.eniac.tech.bimeh.com.sdk.bimeh.di.component;

import android.app.Application;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import ir.eniac.tech.bimeh.com.sdk.bimeh.EniacApplication;
import ir.eniac.tech.bimeh.com.sdk.bimeh.di.module.ViewModelModule;

@Singleton
@Component(modules = {ViewModelModule.class, AndroidInjectionModule.class})
public interface ViewModelComponent
{

    @Component.Builder
    interface Builder
    {
        @BindsInstance
        Builder application(Application application);

        ViewModelComponent build();
    }

    void inject(EniacApplication App);
}
