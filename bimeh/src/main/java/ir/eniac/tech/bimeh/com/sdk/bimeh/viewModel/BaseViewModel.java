package ir.eniac.tech.bimeh.com.sdk.bimeh.viewModel;

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableBoolean;

import io.reactivex.disposables.CompositeDisposable;
import lombok.Getter;

//public abstract class BaseViewModel<N> extends ViewModel
public abstract class BaseViewModel<N> extends ViewModel
{
    private N mNavigator;

//    @Getter
//    private ObservableBoolean isLoading = new ObservableBoolean();

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

//    public void setIsLoading(boolean isLoading)
//    {
//        this.isLoading.set(isLoading);
//    }
}
