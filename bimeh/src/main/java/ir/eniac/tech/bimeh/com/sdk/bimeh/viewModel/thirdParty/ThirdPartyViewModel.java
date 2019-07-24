package ir.eniac.tech.bimeh.com.sdk.bimeh.viewModel.thirdParty;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.Bindable;
import android.databinding.ObservableField;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ir.eniac.tech.bimeh.com.sdk.bimeh.service.generator.SingletonService;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.listener.OnServiceStatus;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.model.thirdPartyFirstAPI.other.AvailableYear;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.model.thirdPartyFirstAPI.other.BrandList;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.model.thirdPartyFirstAPI.other.CompanyList;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.model.thirdPartyFirstAPI.other.DamageStatusList;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.model.thirdPartyFirstAPI.other.FinancialDamageTypeList;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.model.thirdPartyFirstAPI.other.FullNoDamageYearList;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.model.thirdPartyFirstAPI.other.LifeDamageTypeList;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.model.thirdPartyFirstAPI.response.ThirdPartyFirstResponse;
import ir.eniac.tech.bimeh.com.sdk.bimeh.view.activity.thirdParty.ThirdPartyNavigator;
import ir.eniac.tech.bimeh.com.sdk.bimeh.viewModel.BaseViewModel;
import lombok.Getter;
import lombok.Setter;

public class ThirdPartyViewModel extends BaseViewModel<ThirdPartyNavigator> implements OnServiceStatus<ThirdPartyFirstResponse>
{
    @Getter @Setter
    private MutableLiveData<String> tvDate;
//    public String tvDate;

    private List<BrandList> brandList = new ArrayList<>();
    private List<DamageStatusList> damageStatusList = new ArrayList<>();
    private List<FullNoDamageYearList> fullNoDamageYearList = new ArrayList<>();
    private List<FinancialDamageTypeList> financialDamageTypeList = new ArrayList<>();
    private List<LifeDamageTypeList> lifeDamageTypeList = new ArrayList<>();
    private List<CompanyList> companyList = new ArrayList<>();
    private List<AvailableYear> availableYears = new ArrayList<>();

    @Getter @Setter
    private MutableLiveData<List<String>> brandListEntries = new MutableLiveData<>();

    @Getter @Setter
    private MutableLiveData<List<String>> damageStatusListEntries = new MutableLiveData<>();

    @Getter @Setter
    private MutableLiveData<List<String>> fullNoDamageYearListEntries = new MutableLiveData<>();

    @Getter @Setter
    private MutableLiveData<List<String>> financialDamageTypeListEntries = new MutableLiveData<>();

    @Getter @Setter
    private MutableLiveData<List<String>> lifeDamageTypeListEntries = new MutableLiveData<>();

    @Getter @Setter
    private MutableLiveData<List<String>> companyListEntries = new MutableLiveData<>();

    @Getter @Setter
    private MutableLiveData<List<String>> availableYearsEntries = new MutableLiveData<>();

    @Getter @Setter
    private MutableLiveData<Integer> brandListItemPosition = new MutableLiveData<>();
    @Getter @Setter
    private MutableLiveData<Integer> damageStatusListItemPosition = new MutableLiveData<>();
    @Getter @Setter
    private MutableLiveData<Integer> fullNoDamageYearListItemPosition = new MutableLiveData<>();
    @Getter @Setter
    private MutableLiveData<Integer> financialDamageTypeListItemPosition = new MutableLiveData<>();
    @Getter @Setter
    private MutableLiveData<Integer> lifeDamageTypeListItemPosition = new MutableLiveData<>();
    @Getter @Setter
    private MutableLiveData<Integer> companyListItemPosition = new MutableLiveData<>();
    @Getter @Setter
    private MutableLiveData<Integer> availableYearsItemPosition = new MutableLiveData<>();

    @Getter @Setter
    private MutableLiveData<String> brandListItemValue = new MutableLiveData<>();
    @Getter @Setter
    private MutableLiveData<String> damageStatusListItemValue = new MutableLiveData<>();
    @Getter @Setter
    private MutableLiveData<String> fullNoDamageYearListItemValue = new MutableLiveData<>();
    @Getter @Setter
    private MutableLiveData<String> financialDamageTypeListItemValue = new MutableLiveData<>();
    @Getter @Setter
    private MutableLiveData<String> lifeDamageTypeListItemValue = new MutableLiveData<>();
    @Getter @Setter
    private MutableLiveData<String> companyListItemValue = new MutableLiveData<>();
    @Getter @Setter
    private MutableLiveData<String> availableYearsItemValue = new MutableLiveData<>();

    public ThirdPartyViewModel()
    {
        super();
        tvDate = new MutableLiveData<>();

        loadMainMenus();
    }

    public void loadMainMenus()
    {
        SingletonService.getInstance().thirdPartyFirstService().setThirdPartyFirstAPIService(this);
    }

    public void OnClickInquery()
    {
        Log.e("--VM onClick--", "OnClickInquery");
        getNavigator().openThirdPartyInqueryActivity();
    }

    private void OnModelBrandItemSelected(int brandId)
    {

    }

    public void onSelectItemSpinner()
    {

    }

    public void onDatePickerClick()
    {
        Log.e("--VM--", "onDatePickerClick()");
        //for test
        tvDate.postValue("1398/06/02");
        setTvDate(tvDate);
//        tvDate = "1398/06/01";
    }

    @Override
    public void onReady(ThirdPartyFirstResponse thirdPartyFirstResponse)
    {
        Log.e("--onReady--", thirdPartyFirstResponse.getResponseStatus().getValue());
        if (thirdPartyFirstResponse == null || !thirdPartyFirstResponse.getResponseStatus().getValue().equals("200"))
        {
            String errorMessage = "";
            try
            {
                for (String message: thirdPartyFirstResponse.getResponseStatus().getErrorList())
                {
                    errorMessage += message + "\n";
                }
                onError(errorMessage);
            }
            catch (NullPointerException e)
            {
                onError("خطای داخلی!");
            }
            return;
        }

        brandList = thirdPartyFirstResponse.getBrandList();
        damageStatusList = thirdPartyFirstResponse.getDamageStatusList();
        fullNoDamageYearList = thirdPartyFirstResponse.getFullNoDamageYearList();
        financialDamageTypeList = thirdPartyFirstResponse.getFinancialDamageTypeList();
        lifeDamageTypeList = thirdPartyFirstResponse.getLifeDamageTypeList();
        companyList = thirdPartyFirstResponse.getCompanyList();
        availableYears = thirdPartyFirstResponse.getAvailableYears();

        loadData();


    }

    private void loadData()
    {
        List<String> list = new ArrayList<>();
        for (BrandList item: brandList)
        {
            list.add(item.getText());
        }
        brandListEntries.setValue(list);
        list.clear();

        for (DamageStatusList item: damageStatusList)
        {
            list.add(item.getText());
        }
        damageStatusListEntries.setValue(list);
        list.clear();

        for (FullNoDamageYearList item: fullNoDamageYearList)
        {
            list.add(item.getText());
        }
        fullNoDamageYearListEntries.setValue(list);
        list.clear();

        for (FinancialDamageTypeList item: financialDamageTypeList)
        {
            list.add(item.getText());
        }
        financialDamageTypeListEntries.setValue(list);
        list.clear();

        for (LifeDamageTypeList item: lifeDamageTypeList)
        {
            list.add(item.getText());
        }
        lifeDamageTypeListEntries.setValue(list);
        list.clear();

        for (CompanyList item: companyList)
        {
            list.add(item.getText());
        }
        companyListEntries.setValue(list);
        list.clear();

        for (AvailableYear item: availableYears)
        {
            list.add(item.getText());
        }
        availableYearsEntries.setValue(list);
        list.clear();

    }

    @Override
    public void onError(String message)
    {
        Log.e("--onError--", "onError: " + message);
        //Show Error
    }
}
