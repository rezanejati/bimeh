package ir.eniac.tech.bimeh.com.sdk.bimeh.viewModel;

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableBoolean;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;
import ir.eniac.tech.bimeh.com.sdk.bimeh.view.activity.thirdParty.ThirdPartyActivity;

public abstract class BaseViewModel<N> extends ViewModel
{
    private N mNavigator;

    private final ObservableBoolean mIsLoading = new ObservableBoolean();

    private CompositeDisposable mCompositeDisposable;

    public BaseViewModel()
    {
        this.mCompositeDisposable = new CompositeDisposable();
    }

    @Override
    protected void onCleared()
    {
        mCompositeDisposable.dispose();
        super.onCleared();
    }

    public CompositeDisposable getCompositeDisposable()
    {
        return mCompositeDisposable;
    }

    public N getNavigator()
    {
        return mNavigator;
    }

    public void setNavigator(N mNavigator)
    {
        this.mNavigator = mNavigator;
    }

    public ObservableBoolean getIsLoading()
    {
        return mIsLoading;
    }

    public void setIsLoading(boolean isLoading)
    {
        mIsLoading.set(isLoading);
    }
}
