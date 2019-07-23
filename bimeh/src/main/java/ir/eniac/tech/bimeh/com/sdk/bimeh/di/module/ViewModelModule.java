package ir.eniac.tech.bimeh.com.sdk.bimeh.di.module;

import android.arch.lifecycle.ViewModelProvider;

import java.util.List;

import dagger.Binds;
import dagger.Module;
import ir.eniac.tech.bimeh.com.sdk.bimeh.viewModel.ViewModelFactory;

@Module
public abstract class ViewModelModule
{


    @Binds
    @SuppressWarnings("unused")
    abstract ViewModelProvider.Factory bindsViewModelFactory(ViewModelFactory viewModelFactory);
}
