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
import ir.eniac.tech.bimeh.com.sdk.bimeh.view.base.BaseActivity;
import ir.eniac.tech.bimeh.com.sdk.bimeh.viewModel.thirdParty.ThirdPartyViewModel;

public class ThirdPartyActivity extends BaseActivity<ActivityThirdPartyBinding, ThirdPartyViewModel> implements ThirdPartyNavigator,
        ThirdPartySpinnerData
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        viewModel.setNavigator(this);
        initView();
//        viewModel.setSpinnerData1(this);
        viewModel.setSpinnerData(this);

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
//        dataBinding.setViewModel(viewModel);


        dataBinding.spinnerBrand.setSelection(0);
        dataBinding.spinnerBrand.setGravity(View.TEXT_ALIGNMENT_CENTER);
        dataBinding.spinnerBrandModel.setSelection(0);
        dataBinding.spinnerBrandModel.setGravity(View.TEXT_ALIGNMENT_CENTER);
        dataBinding.spinnerCreateDate.setSelection(0);
        dataBinding.spinnerCreateDate.setGravity(View.TEXT_ALIGNMENT_CENTER);
        dataBinding.spinnerDamageDiscount.setSelection(0);
        dataBinding.spinnerDamageDiscount.setGravity(View.TEXT_ALIGNMENT_CENTER);
        dataBinding.spinnerDeathDamageCount.setSelection(0);
        dataBinding.spinnerDeathDamageCount.setGravity(View.TEXT_ALIGNMENT_CENTER);
        dataBinding.spinnerDamageStatus.setSelection(0);
        dataBinding.spinnerDamageStatus.setGravity(View.TEXT_ALIGNMENT_CENTER);
        dataBinding.spinnerFinancialDamageCount.setSelection(0);
        dataBinding.spinnerFinancialDamageCount.setGravity(View.TEXT_ALIGNMENT_CENTER);

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


//    @Override
//    public void setData(List<BrandList> getBrandList)
//    {
////        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
//        ArrayList<String> strings = new ArrayList<>();
//
//        for (int i = 0; i < getBrandList.size(); i++)
//        {
//            strings.add(getBrandList.get(i).getText());
//        }
//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.my_spinner_item, strings);
//        arrayAdapter.setDropDownViewResource(R.layout.my_spinner_textview);
////        dataBinding.setSpinnerAdapter1(arrayAdapter);
//
//    }

    @Override
    public void setBrandData(List<BrandList> brandList)
    {
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < brandList.size(); i++)
        {
            list.add(brandList.get(i).getText());
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.my_spinner_item, list);
        arrayAdapter.setDropDownViewResource(R.layout.my_spinner_textview);
        dataBinding.setSpinnerAdapterBrand(arrayAdapter);
    }

    @Override
    public void setDamageStatusData(List<DamageStatusList> damageStatusList)
    {
        List<String> list = new ArrayList<>();
        for (DamageStatusList item : damageStatusList)
        {
            list.add(item.getText());
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.my_spinner_item, list);
        arrayAdapter.setDropDownViewResource(R.layout.my_spinner_textview);
        dataBinding.setSpinnerAdapterDamageStatus(arrayAdapter);
    }

    @Override
    public void setFullNoDamageYearData(List<FullNoDamageYearList> fullNoDamageYearList)
    {
        List<String> list = new ArrayList<>();
        for (FullNoDamageYearList item : fullNoDamageYearList)
        {
            list.add(item.getText());
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.my_spinner_item, list);
        arrayAdapter.setDropDownViewResource(R.layout.my_spinner_textview);
        dataBinding.setSpinnerAdapterFullNoDamageYear(arrayAdapter);
    }

    @Override
    public void setFinancialDamageTypeData(List<FinancialDamageTypeList> financialDamageTypeList)
    {
        List<String> list = new ArrayList<>();
        for (FinancialDamageTypeList item : financialDamageTypeList)
        {
            list.add(item.getText());
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.my_spinner_item, list);
        arrayAdapter.setDropDownViewResource(R.layout.my_spinner_textview);
        dataBinding.setSpinnerAdapterFinancialDamageType(arrayAdapter);
    }

    @Override
    public void setLifeDamageTypeData(List<LifeDamageTypeList> lifeDamageTypeList)
    {
        List<String> list = new ArrayList<>();
        for (LifeDamageTypeList item : lifeDamageTypeList)
        {
            list.add(item.getText());
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.my_spinner_item, list);
        arrayAdapter.setDropDownViewResource(R.layout.my_spinner_textview);
        dataBinding.setSpinnerAdapterLifeDamageType(arrayAdapter);
    }

    @Override
    public void setCompanyData(List<CompanyList> companyList)
    {
        List<String> list = new ArrayList<>();
        for (CompanyList item : companyList)
        {
            list.add(item.getText());
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.my_spinner_item, list);
        arrayAdapter.setDropDownViewResource(R.layout.my_spinner_textview);
        dataBinding.setSpinnerAdapterCompany(arrayAdapter);
    }

    @Override
    public void setAvailableYearData(List<AvailableYear> availableYears)
    {
        List<String> list = new ArrayList<>();
        for (AvailableYear item : availableYears)
        {
            list.add(item.getText());
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.my_spinner_item, list);
        arrayAdapter.setDropDownViewResource(R.layout.my_spinner_textview);
        dataBinding.setSpinnerAdapterAvailableYears(arrayAdapter);
    }
}
