package ir.eniac.tech.bimeh.com.sdk.bimeh.view.activity.thirdParty;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ir.eniac.tech.bimeh.com.sdk.bimeh.BR;
import ir.eniac.tech.bimeh.com.sdk.bimeh.R;
import ir.eniac.tech.bimeh.com.sdk.bimeh.databinding.ActivityThirdPartyBinding;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.model.thirdPartyFirstAPI.other.AvailableYear;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.model.thirdPartyFirstAPI.other.BrandList;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.model.thirdPartyFirstAPI.other.CompanyList;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.model.thirdPartyFirstAPI.other.DamageStatusList;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.model.thirdPartyFirstAPI.other.FinancialDamageTypeList;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.model.thirdPartyFirstAPI.other.FullNoDamageYearList;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.model.thirdPartyFirstAPI.other.LifeDamageTypeList;
import ir.eniac.tech.bimeh.com.sdk.bimeh.utility.Logger;
import ir.eniac.tech.bimeh.com.sdk.bimeh.view.adapter.SpinnerArrayAdapter;
import ir.eniac.tech.bimeh.com.sdk.bimeh.view.base.BaseActivity;
import ir.eniac.tech.bimeh.com.sdk.bimeh.viewModel.thirdParty.ThirdPartyViewModel;

public class ThirdPartyActivity extends BaseActivity<ActivityThirdPartyBinding, ThirdPartyViewModel> implements ThirdPartyNavigator
{
    private SpinnerArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        viewModel.setNavigator(this);
        initView();
//        viewModel.setSpinnerData(this);


        arrayAdapter = new SpinnerArrayAdapter(this, R.layout.my_spinner_item);
        arrayAdapter.setDropDownViewResource(R.layout.my_spinner_textview);

        dataBinding.spinnerBrand.setSelection(0);
        dataBinding.spinnerBrand.setGravity(View.TEXT_ALIGNMENT_CENTER);
        dataBinding.setSpinnerAdapterBrand(arrayAdapter);

        subscribeToLiveData();

//        dataBinding.tvDate.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View v)
//            {
//                String dateStr = "1398-05-02";
//                viewModel.updateTvDate(dateStr);
//            }
//        });
    }

    @Override
    public int getBindingVariable()
    {
        return BR.viewModel;
    }

    private void initView()
    {


//        dataBinding.tvDate.setText(viewModel.getTvDate().getValue());



        dataBinding.spinnerBrandModel.setSelection(0);
        dataBinding.spinnerBrandModel.setGravity(View.TEXT_ALIGNMENT_CENTER);


//        viewModel.loadMainMenus();
//        dataBinding.tvDate.setText(viewModel.getTvDate().getValue());
//        dataBinding.tvDate.setText("1398/06/01");
//        viewModel.getTvDate().
    }

    @Override
    protected Class<ThirdPartyViewModel> getViewModel()
    {
        return ThirdPartyViewModel.class;
    }

    @Override
    protected int getLayoutRes()
    {
        return R.layout.activity_third_party;
    }

    @Override
    public void openThirdPartyInqueryActivity()
    {
        Toast.makeText(this, "open ThirdPartyInqueryActivity", Toast.LENGTH_LONG).show();
/*
        viewModel.setTest("1398/06/01");
        dataBinding.setViewModel(viewModel);*/
        //  dataBinding.tvDate.setText("1398/06/01");
//        Intent intent = MainActivity.newIntent(LoginActivity.this);
//        startActivity(intent);
    }

    private void subscribeToLiveData()
    {
        viewModel.getBrandListEntriesLive().observe(this, list ->
        {
//            dataBinding.spinnerBrand.setSelection(0);
//            dataBinding.spinnerBrand.setGravity(View.TEXT_ALIGNMENT_CENTER);
//            dataBinding.setSpinnerAdapterBrand(arrayAdapter);

            viewModel.setBrandListEntries(list);
        });

        viewModel.getDamageStatusListEntriesLive().observe(this, list -> viewModel.setDamageStatusListEntries(list));

        viewModel.getFinancialDamageTypeListEntriesLive().observe(this, list -> viewModel.setFinancialDamageTypeListEntries(list));

        viewModel.getFullNoDamageYearListEntriesLive().observe(this, list -> viewModel.setFullNoDamageYearListEntries(list));

        viewModel.getLifeDamageTypeListEntriesLive().observe(this, list -> viewModel.setLifeDamageTypeListEntries(list));

        viewModel.getAvailableYearsEntriesLive().observe(this, list -> viewModel.setAvailableYearsEntries(list));
    }
}
