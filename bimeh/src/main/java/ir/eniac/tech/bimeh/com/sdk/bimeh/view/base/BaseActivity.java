package ir.eniac.tech.bimeh.com.sdk.bimeh.view.base;

import android.app.ProgressDialog;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import dagger.android.AndroidInjection;

import javax.inject.Inject;

import ir.eniac.tech.bimeh.com.sdk.bimeh.viewModel.BaseViewModel;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public abstract class BaseActivity<D extends ViewDataBinding, V extends BaseViewModel> extends AppCompatActivity
{
    private ProgressDialog mProgressDialog;
    protected D dataBinding;
    protected V viewModel;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @Override
    protected void attachBaseContext(Context newBase)
    {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
//        AndroidSupportInjection.inject(this);
//        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(getViewModel());
        dataBinding = DataBindingUtil.setContentView(this, getLayoutRes());
        dataBinding.setVariable(getBindingVariable(), viewModel);
        dataBinding.executePendingBindings();
    }

    public abstract int getBindingVariable();

    protected abstract Class<V> getViewModel();

    @LayoutRes
    protected abstract int getLayoutRes();


    public void hideLoading()
    {
        if (mProgressDialog != null && mProgressDialog.isShowing())
        {
            mProgressDialog.cancel();
        }
    }

    public void showLoading()
    {
        hideLoading();
//        mProgressDialog = CommonUtils.showLoadingDialog(this);
    }

}
