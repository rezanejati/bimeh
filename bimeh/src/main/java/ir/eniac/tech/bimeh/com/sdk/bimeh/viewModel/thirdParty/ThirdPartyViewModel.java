package ir.eniac.tech.bimeh.com.sdk.bimeh.viewModel.thirdParty;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.databinding.ObservableList;

import java.util.ArrayList;
import java.util.List;

import ir.eniac.tech.bimeh.com.sdk.bimeh.service.generator.SingletonService;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.listener.OnServiceStatus;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.model.thirdPartyBrandModelList.others.CarModelList;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.model.thirdPartyBrandModelList.response.ThirdPartyBrandModelListResponse;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.model.thirdPartyFirstAPI.other.ItemsList;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.model.thirdPartyFirstAPI.response.ThirdPartyFirstResponse;
import ir.eniac.tech.bimeh.com.sdk.bimeh.utility.Logger;
import ir.eniac.tech.bimeh.com.sdk.bimeh.view.activity.thirdParty.ThirdPartyNavigator;
import ir.eniac.tech.bimeh.com.sdk.bimeh.viewModel.BaseViewModel;
import lombok.Getter;
import lombok.Setter;

public class ThirdPartyViewModel extends BaseViewModel<ThirdPartyNavigator> implements OnServiceStatus<ThirdPartyFirstResponse>,
        SpinnerBrandChangeListener
{
    @Getter @Setter
    private ObservableField<String> tvCreateDate = new ObservableField<>();

    @Getter @Setter
    private ObservableField<String> tvFinalDate = new ObservableField<>();

    @Getter
    private ObservableField<Boolean> progressBrandModelVisible = new ObservableField<>();
    @Getter
    private ObservableField<Boolean> spnBrandModelActivate = new ObservableField<>();

    @Getter
    private ObservableField<Boolean> isLoading = new ObservableField<>();

    private List<ItemsList> brandList = new ArrayList<>();
    private List<CarModelList> brandModelList = new ArrayList<>();
    private List<ItemsList> companyList = new ArrayList<>();
    private List<ItemsList> damageStatusList = new ArrayList<>();
    private List<ItemsList> fullNoDamageYearList = new ArrayList<>();
    private List<ItemsList> financialDamageTypeList = new ArrayList<>();
    private List<ItemsList> lifeDamageTypeList = new ArrayList<>();
    private List<ItemsList> availableYears = new ArrayList<>();

    @Getter
    private ObservableList<ItemsList> brandListEntries = new ObservableArrayList<>();
    @Getter
    private MutableLiveData<List<ItemsList>> brandListEntriesLive = new MutableLiveData<>();

    @Getter
    private ObservableList<CarModelList> brandModelListEntries = new ObservableArrayList<>();
    @Getter
    private MutableLiveData<List<CarModelList>> brandModelListEntriesLive = new MutableLiveData<>();

    @Getter
    private ObservableList<ItemsList> damageStatusListEntries = new ObservableArrayList<>();
    @Getter
    private MutableLiveData<List<ItemsList>> damageStatusListEntriesLive = new MutableLiveData<>();

    @Getter
    private ObservableList<ItemsList> companyListEntries = new ObservableArrayList<>();
    @Getter
    private MutableLiveData<List<ItemsList>> companyListEntriesLive = new MutableLiveData<>();

    @Getter
    private ObservableList<ItemsList> fullNoDamageYearListEntries = new ObservableArrayList<>();
    @Getter
    private MutableLiveData<List<ItemsList>> fullNoDamageYearListEntriesLive = new MutableLiveData<>();

    @Getter
    private ObservableList<ItemsList> financialDamageTypeListEntries = new ObservableArrayList<>();
    @Getter
    private MutableLiveData<List<ItemsList>> financialDamageTypeListEntriesLive = new MutableLiveData<>();

    @Getter
    private ObservableList<ItemsList> lifeDamageTypeListEntries = new ObservableArrayList<>();
    @Getter
    private MutableLiveData<List<ItemsList>> lifeDamageTypeListEntriesLive = new MutableLiveData<>();

    @Getter
    private ObservableList<ItemsList> availableYearsEntries = new ObservableArrayList<>();
    @Getter
    private MutableLiveData<List<ItemsList>> availableYearsEntriesLive = new MutableLiveData<>();


    @Getter @Setter
    private ObservableField<Integer> brandListItemPosition = new ObservableField<>();

    @Getter
    private ObservableField<Integer> brandModelListItemPosition = new ObservableField<>();

    @Getter
    private ObservableField<Integer> damageStatusListItemPosition = new ObservableField<>();

    @Getter
    private ObservableField<Integer> companyListItemPosition = new ObservableField<>();

    @Getter
    private ObservableField<Integer> fullNoDamageYearListItemPosition = new ObservableField<>();

    @Getter
    private ObservableField<Integer> financialDamageTypeListItemPosition = new ObservableField<>();

    @Getter
    private ObservableField<Integer> lifeDamageTypeListItemPosition = new ObservableField<>();

    @Getter
    private ObservableField<Integer> availableYearsItemPosition = new ObservableField<>();




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

        setProgressBrandModelVisible(false);
        spnBrandModelActivate.set(false);
//        setIsLoading(true);

        loadMainMenus();
    }

    public void setIsLoading(Boolean loading)
    {
        isLoading.set(loading);
    }

    public void setProgressBrandModelVisible(Boolean isVisible)
    {
        progressBrandModelVisible.set(isVisible);
    }

    public void setBrandListEntries(List<ItemsList> list)
    {
        brandListEntries.clear();
        brandListEntries.addAll(list);
    }

    public void setBrandModelListEntries(List<CarModelList> list)
    {
        brandModelListEntries.clear();
        brandModelListEntries.addAll(list);
    }

    public void setDamageStatusListEntries(List<ItemsList> list)
    {
        damageStatusListEntries.clear();
        damageStatusListEntries.addAll(list);
    }

    public void setCompanyListEntries(List<ItemsList> list)
    {
        companyListEntries.clear();
        companyListEntries.addAll(list);
    }

    public void setFullNoDamageYearListEntries(List<ItemsList> list)
    {
        fullNoDamageYearListEntries.clear();
        fullNoDamageYearListEntries.addAll(list);
    }

    public void setFinancialDamageTypeListEntries(List<ItemsList> list)
    {
        financialDamageTypeListEntries.clear();
        financialDamageTypeListEntries.addAll(list);
    }

    public void setLifeDamageTypeListEntries(List<ItemsList> list)
    {
        lifeDamageTypeListEntries.clear();
        lifeDamageTypeListEntries.addAll(list);
    }

    public void setAvailableYearsEntries(List<ItemsList> list)
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

    @Override
    public void onBrandChange(int position)
    {
        brandListItemPosition.set(position);
        if (position != 0)
        {
            setProgressBrandModelVisible(true);
            spnBrandModelActivate.set(true);
            OnModelBrandItemSelected(brandList.get(position).getValue());
        }
        else
        {
            setProgressBrandModelVisible(false);
            spnBrandModelActivate.set(false);




        }
    }

    private void OnModelBrandItemSelected(String brandId)
    {
        SingletonService.getInstance().thirdBrandModelService().setThirdPartyBrandModelListService(brandId, new OnServiceStatus<ThirdPartyBrandModelListResponse>()
        {
            @Override
            public void onReady(ThirdPartyBrandModelListResponse thirdPartyBrandModelListResponse)
            {
                setProgressBrandModelVisible(false);

                CarModelList items = new CarModelList();
                items.setInsCarModelId(0);
                items.setInsCarTypeId(0);
                items.setPassengerCount(0);
                items.setModelName("--انتخاب کنید--");
                items.setInsCarType("");

                brandModelList.clear();

                brandModelList.add(items);
                brandModelList.addAll(thirdPartyBrandModelListResponse.getCarModelList());
                brandModelListEntriesLive.setValue(brandModelList);

            }

            @Override
            public void onError(String message)
            {
                setProgressBrandModelVisible(false);
                spnBrandModelActivate.set(false);

                Logger.e("--onError--", "onError: " + message);
                //Show Error
            }
        });
    }

    public void onCreateDatePickerClick()
    {
        getNavigator().openCreateDatePicker();
    }

    public void onFinalDatePickerClick()
    {
        getNavigator().openFinalDatePicker();
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

        loadData(thirdPartyFirstResponse);


    }

    private void loadData(ThirdPartyFirstResponse thirdPartyFirstResponse)
    {

        ItemsList items = new ItemsList();
        items.setValue("0");
        items.setText("--انتخاب کنید--");

        brandList.add(items);
        brandList.addAll(thirdPartyFirstResponse.getBrandList());
        brandListEntriesLive.setValue(brandList);

        damageStatusList.add(items);
        damageStatusList.addAll(thirdPartyFirstResponse.getDamageStatusList());
        damageStatusListEntriesLive.setValue(damageStatusList);

        companyList.add(items);
        companyList.addAll(thirdPartyFirstResponse.getCompanyList());
        companyListEntriesLive.setValue(companyList);

//        fullNoDamageYearList.add(items);
        fullNoDamageYearList.addAll(thirdPartyFirstResponse.getFullNoDamageYearList());
        fullNoDamageYearListEntriesLive.setValue(fullNoDamageYearList);

        financialDamageTypeList.add(items);
        financialDamageTypeList.addAll(thirdPartyFirstResponse.getFinancialDamageTypeList());
        financialDamageTypeListEntriesLive.setValue(financialDamageTypeList);

        lifeDamageTypeList.add(items);
        lifeDamageTypeList.addAll(thirdPartyFirstResponse.getLifeDamageTypeList());
        lifeDamageTypeListEntriesLive.setValue(lifeDamageTypeList);

        availableYears.add(items);
        availableYears.addAll(thirdPartyFirstResponse.getAvailableYears());
        availableYearsEntriesLive.setValue(availableYears);

//        companyList = thirdPartyFirstResponse.getCompanyList();

    }

    @Override
    public void onError(String message)
    {
        setIsLoading(false);

        Logger.e("--onError--", "onError: " + message);
        //Show Error
    }

    public void updateTvCreateDate(String date)
    {
        tvCreateDate.set(date);
    }

    public void updateTvFinalDate(String date)
    {
        tvFinalDate.set(date);
    }

}
