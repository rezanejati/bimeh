package ir.eniac.tech.bimeh.com.sdk.bimeh.viewModel.thirdParty;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableList;

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
import ir.eniac.tech.bimeh.com.sdk.bimeh.viewModel.BaseViewModel;
import lombok.Getter;
import lombok.Setter;

public class ThirdPartyViewModel extends BaseViewModel<ThirdPartyNavigator> implements OnServiceStatus<ThirdPartyFirstResponse>
{
    @Getter
    private ObservableBoolean isBrandModelLoading = new ObservableBoolean();

    @Getter
    private ObservableBoolean isLoading = new ObservableBoolean();

    @Getter @Setter
    private ObservableField<String> tvDate = new ObservableField<>();
    //    public String tvDate;

//    @Getter @Setter
//    private ThirdPartySpinnerData spinnerData;

    private List<BrandList> brandList = new ArrayList<>();
    private List<DamageStatusList> damageStatusList = new ArrayList<>();
    private List<FullNoDamageYearList> fullNoDamageYearList = new ArrayList<>();
    private List<FinancialDamageTypeList> financialDamageTypeList = new ArrayList<>();
    private List<LifeDamageTypeList> lifeDamageTypeList = new ArrayList<>();
    private List<AvailableYear> availableYears = new ArrayList<>();

    @Getter
    private ObservableList<String> brandListEntries = new ObservableArrayList<>();
    @Getter
    private MutableLiveData<List<String>> brandListEntriesLive = new MutableLiveData<>();

    @Getter
    private ObservableList<String> damageStatusListEntries = new ObservableArrayList<>();
    @Getter
    private MutableLiveData<List<String>> damageStatusListEntriesLive = new MutableLiveData<>();

    @Getter
    private ObservableList<String> fullNoDamageYearListEntries = new ObservableArrayList<>();
    @Getter
    private MutableLiveData<List<String>> fullNoDamageYearListEntriesLive = new MutableLiveData<>();

    @Getter
    private ObservableList<String> financialDamageTypeListEntries = new ObservableArrayList<>();
    @Getter
    private MutableLiveData<List<String>> financialDamageTypeListEntriesLive = new MutableLiveData<>();

    @Getter
    private ObservableList<String> lifeDamageTypeListEntries = new ObservableArrayList<>();
    @Getter
    private MutableLiveData<List<String>> lifeDamageTypeListEntriesLive = new MutableLiveData<>();

    @Getter
    private ObservableList<String> availableYearsEntries = new ObservableArrayList<>();
    @Getter
    private MutableLiveData<List<String>> availableYearsEntriesLive = new MutableLiveData<>();


//    @Getter @Setter
//    private MutableLiveData<Integer> brandListItemPosition = new MutableLiveData<>();
//    @Getter @Setter
//    private MutableLiveData<Integer> damageStatusListItemPosition = new MutableLiveData<>();
//    @Getter @Setter
//    private MutableLiveData<Integer> fullNoDamageYearListItemPosition = new MutableLiveData<>();
//    @Getter @Setter
//    private MutableLiveData<Integer> financialDamageTypeListItemPosition = new MutableLiveData<>();
//    @Getter @Setter
//    private MutableLiveData<Integer> lifeDamageTypeListItemPosition = new MutableLiveData<>();
//    @Getter @Setter
//    private MutableLiveData<Integer> availableYearsItemPosition = new MutableLiveData<>();
//
//    @Getter @Setter
//    private MutableLiveData<String> brandListItemValue = new MutableLiveData<>();
//    @Getter @Setter
//    private MutableLiveData<String> damageStatusListItemValue = new MutableLiveData<>();
//    @Getter @Setter
//    private MutableLiveData<String> fullNoDamageYearListItemValue = new MutableLiveData<>();
//    @Getter @Setter
//    private MutableLiveData<String> financialDamageTypeListItemValue = new MutableLiveData<>();
//    @Getter @Setter
//    private MutableLiveData<String> lifeDamageTypeListItemValue = new MutableLiveData<>();
//    @Getter @Setter
//    private MutableLiveData<String> availableYearsItemValue = new MutableLiveData<>();

    public ThirdPartyViewModel()
    {
        super();
        setIsLoading(true);
        setIsBrandModelLoading(false);

        loadMainMenus();
    }

    public void setIsBrandModelLoading(boolean isLoading)
    {
        this.isBrandModelLoading.set(isLoading);
    }

    public void setIsLoading(boolean mIsLoading)
    {
        isLoading.set(mIsLoading);
    }

    public void setBrandListEntries(List<String> list)
    {
        brandListEntries.clear();
        brandListEntries.addAll(list);
    }

    public void setDamageStatusListEntries(List<String> list)
    {
        damageStatusListEntries.clear();
        damageStatusListEntries.addAll(list);
    }

    public void setFullNoDamageYearListEntries(List<String> list)
    {
        fullNoDamageYearListEntries.clear();
        fullNoDamageYearListEntries.addAll(list);
    }

    public void setFinancialDamageTypeListEntries(List<String> list)
    {
        financialDamageTypeListEntries.clear();
        financialDamageTypeListEntries.addAll(list);
    }

    public void setLifeDamageTypeListEntries(List<String> list)
    {
        lifeDamageTypeListEntries.clear();
        lifeDamageTypeListEntries.addAll(list);
    }

    public void setAvailableYearsEntries(List<String> list)
    {
        availableYearsEntries.clear();
        availableYearsEntries.addAll(list);
    }

    public void loadMainMenus()
    {
        setIsLoading(true);
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
        setIsLoading(false);

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

    @Override
    public void onError(String message)
    {
        setIsLoading(false);
        Logger.e("--onError--", "onError: " + message);
        //Show Error
    }

    private void loadData()
    {
//        brandListEntriesLive.setValue(getBrandListEntries());

//        spinnerData.setBrandData(brandList);
//        spinnerData.setDamageStatusData(damageStatusList);
//        spinnerData.setFullNoDamageYearData(fullNoDamageYearList);
//        spinnerData.setFinancialDamageTypeData(financialDamageTypeList);
//        spinnerData.setLifeDamageTypeData(lifeDamageTypeList);
////        spinnerData.setCompanyData(companyList);
//        spinnerData.setAvailableYearData(availableYears);

//
//
//
//
        List<String> list = new ArrayList<>();
        list.add("--انتخاب کنید--");
        for (BrandList item : brandList)
        {
            list.add(item.getText());
        }
        brandListEntriesLive.setValue(list);
        list.clear();

        list.add("--انتخاب کنید--");
        for (DamageStatusList item : damageStatusList)
        {
            list.add(item.getText());
        }
        damageStatusListEntriesLive.setValue(list);
        list.clear();

        list.add("--انتخاب کنید--");
        for (FullNoDamageYearList item : fullNoDamageYearList)
        {
            list.add(item.getText());
        }
        fullNoDamageYearListEntriesLive.setValue(list);
        list.clear();

        list.add("--انتخاب کنید--");
        for (FinancialDamageTypeList item : financialDamageTypeList)
        {
            list.add(item.getText());
        }
        financialDamageTypeListEntriesLive.setValue(list);
        list.clear();

        list.add("--انتخاب کنید--");
        for (LifeDamageTypeList item : lifeDamageTypeList)
        {
            list.add(item.getText());
        }
        lifeDamageTypeListEntriesLive.setValue(list);
        list.clear();

        list.add("--انتخاب کنید--");
        for (AvailableYear item : availableYears)
        {
            list.add(item.getText());
        }
        availableYearsEntriesLive.setValue(list);
        list.clear();

    }

    public void updateTvDate(String date)
    {
        tvDate.set(date);
    }

}
