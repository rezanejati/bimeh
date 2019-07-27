package ir.eniac.tech.bimeh.com.sdk.bimeh.viewModel.thirdParty;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableField;

import java.util.ArrayList;
import java.util.List;

import ir.eniac.tech.bimeh.com.sdk.bimeh.service.generator.SingletonService;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.listener.OnServiceStatus;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.model.thirdPartyFirstAPI.other.AvailableYear;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.model.thirdPartyFirstAPI.other.BrandList;
//import ir.eniac.tech.bimeh.com.sdk.bimeh.service.model.thirdPartyFirstAPI.other.CompanyList;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.model.thirdPartyFirstAPI.other.DamageStatusList;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.model.thirdPartyFirstAPI.other.FinancialDamageTypeList;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.model.thirdPartyFirstAPI.other.FullNoDamageYearList;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.model.thirdPartyFirstAPI.other.LifeDamageTypeList;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.model.thirdPartyFirstAPI.response.ThirdPartyFirstResponse;
import ir.eniac.tech.bimeh.com.sdk.bimeh.utility.Logger;
import ir.eniac.tech.bimeh.com.sdk.bimeh.view.activity.thirdParty.ThirdPartyNavigator;
import ir.eniac.tech.bimeh.com.sdk.bimeh.view.activity.thirdParty.ThirdPartySpinnerData;
import ir.eniac.tech.bimeh.com.sdk.bimeh.viewModel.BaseViewModel;
import lombok.Getter;
import lombok.Setter;

public class ThirdPartyViewModel extends BaseViewModel<ThirdPartyNavigator> implements OnServiceStatus<ThirdPartyFirstResponse>
{
    @Getter @Setter
    private ObservableField<String> tvDate = new ObservableField<>();
    //    public String tvDate;

    @Getter @Setter
    private ThirdPartySpinnerData spinnerData;

    private List<BrandList> brandList = new ArrayList<>();
    private List<DamageStatusList> damageStatusList = new ArrayList<>();
    private List<FullNoDamageYearList> fullNoDamageYearList = new ArrayList<>();
    private List<FinancialDamageTypeList> financialDamageTypeList = new ArrayList<>();
    private List<LifeDamageTypeList> lifeDamageTypeList = new ArrayList<>();
//    private List<CompanyList> companyList = new ArrayList<>();
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

//    @Getter @Setter
//    private MutableLiveData<List<String>> companyListEntries = new MutableLiveData<>();

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
//    @Getter @Setter
//    private MutableLiveData<Integer> companyListItemPosition = new MutableLiveData<>();
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
//    @Getter @Setter
//    private MutableLiveData<String> companyListItemValue = new MutableLiveData<>();
    @Getter @Setter
    private MutableLiveData<String> availableYearsItemValue = new MutableLiveData<>();

    public ThirdPartyViewModel()
    {
        super();

        loadMainMenus();
    }

    public void loadMainMenus()
    {
        SingletonService.getInstance().thirdPartyFirstService().setThirdPartyFirstAPIService(this);
    }

    public void OnClickInquery()
    {
        Logger.e("--VM onClick--", "OnClickInquery");
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
        String dateStr = "1398-05-02";
        updateTvDate(dateStr);
    }

    @Override
    public void onReady(ThirdPartyFirstResponse thirdPartyFirstResponse)
    {
        Logger.e("--onReady--", thirdPartyFirstResponse.getResponseStatus().getValue());
        if (!thirdPartyFirstResponse.getResponseStatus().getValue().equals("200"))
        {
            String errorMessage = "";
            try
            {
                for (String message : thirdPartyFirstResponse.getResponseStatus().getErrorList())
                {
                    errorMessage += message + "\n";
                }
                onError(errorMessage);
            } catch (NullPointerException e)
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
//        companyList = thirdPartyFirstResponse.getCompanyList();
        availableYears = thirdPartyFirstResponse.getAvailableYears();

//        spinnerData1.setData(brandList);

        loadData();


    }

    private void loadData()
    {

        spinnerData.setBrandData(brandList);
        spinnerData.setDamageStatusData(damageStatusList);
        spinnerData.setFullNoDamageYearData(fullNoDamageYearList);
        spinnerData.setFinancialDamageTypeData(financialDamageTypeList);
        spinnerData.setLifeDamageTypeData(lifeDamageTypeList);
//        spinnerData.setCompanyData(companyList);
        spinnerData.setAvailableYearData(availableYears);

//
//
//
//
//        List<String> list = new ArrayList<>();
//        for (BrandList item : brandList)
//        {
//            list.add(item.getText());
//        }
//        brandListEntries.setValue(list);
//        list.clear();
//
//        for (DamageStatusList item : damageStatusList)
//        {
//            list.add(item.getText());
//        }
//        damageStatusListEntries.setValue(list);
//        list.clear();
//
//        for (FullNoDamageYearList item : fullNoDamageYearList)
//        {
//            list.add(item.getText());
//        }
//        fullNoDamageYearListEntries.setValue(list);
//        list.clear();
//
//        for (FinancialDamageTypeList item : financialDamageTypeList)
//        {
//            list.add(item.getText());
//        }
//        financialDamageTypeListEntries.setValue(list);
//        list.clear();
//
//        for (LifeDamageTypeList item : lifeDamageTypeList)
//        {
//            list.add(item.getText());
//        }
//        lifeDamageTypeListEntries.setValue(list);
//        list.clear();
//
//        for (CompanyList item : companyList)
//        {
//            list.add(item.getText());
//        }
//        companyListEntries.setValue(list);
//        list.clear();
//
//        for (AvailableYear item : availableYears)
//        {
//            list.add(item.getText());
//        }
//        availableYearsEntries.setValue(list);
//        list.clear();

    }

    @Override
    public void onError(String message)
    {
        Logger.e("--onError--", "onError: " + message);
        //Show Error
    }

    public void updateTvDate(String date)
    {
        tvDate.set(date);
    }

}
