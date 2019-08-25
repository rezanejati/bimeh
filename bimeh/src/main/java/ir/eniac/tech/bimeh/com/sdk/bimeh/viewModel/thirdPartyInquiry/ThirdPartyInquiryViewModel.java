package ir.eniac.tech.bimeh.com.sdk.bimeh.viewModel.thirdPartyInquiry;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.databinding.ObservableList;
import android.util.Log;

import java.util.List;

import ir.eniac.tech.bimeh.com.sdk.bimeh.service.generator.SingletonService;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.listener.OnServiceStatus;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.model.thirdPartyInquiry.request.ThirdPartyInquiryRequest;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.model.thirdPartyInquiry.response.ThirdInquiryItem;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.model.thirdPartyInquiry.response.ThirdPartyInquiryResponse;
import ir.eniac.tech.bimeh.com.sdk.bimeh.utility.Logger;
import ir.eniac.tech.bimeh.com.sdk.bimeh.view.activity.thirdPartyInquery.ThirdPartyInqueryNavigator;
import ir.eniac.tech.bimeh.com.sdk.bimeh.viewModel.BaseViewModel;
import lombok.Getter;

public class ThirdPartyInquiryViewModel extends BaseViewModel<ThirdPartyInqueryNavigator> implements OnServiceStatus<ThirdPartyInquiryResponse>
{
    @Getter
//    private final MutableLiveData<List<ThirdInquiryItem>> thirdInqueryListLiveData;
    private final ObservableList<ThirdInquiryItem> thirdInqueryListLiveData;

    public ThirdPartyInquiryViewModel()
    {
        super();
//        thirdInqueryListLiveData = new MutableLiveData<>();
        thirdInqueryListLiveData = new ObservableArrayList<>();
    }

    public void getData(String BrandId, String ModelId, String BuildYear, String PreviousExpiration, String previousCompanyId,
            String previousStartDate, String DamageStatusId, String NoDamageYearId, String LifeDamageTypeId, String FinancialDamageTypeId)
    {
        ThirdPartyInquiryRequest request = new ThirdPartyInquiryRequest();
        request.setBrandId(BrandId);
        request.setModelId(ModelId);
        request.setBuildYear(BuildYear);
        request.setPreviousExpiration(PreviousExpiration);
        request.setPreviousCompanyId(previousCompanyId);
        request.setPreviousStartDate(previousStartDate);
        request.setDamageStatusId(DamageStatusId);
        request.setNoDamageYearId(NoDamageYearId);
        request.setLifeDamageTypeId(LifeDamageTypeId);
        request.setFinancialDamageTypeId(FinancialDamageTypeId);
        request.setUniqueTypeId(1);
        request.setInsurancePeriodId(null);

        SingletonService.getInstance().thirdPartyInquiryService().setThirdPartyInquiryService(request, this);
    }

    @Override
    public void onReady(ThirdPartyInquiryResponse thirdPartyInquiryResponse)
    {

        if (!thirdPartyInquiryResponse.getResponseStatus().getValue().equalsIgnoreCase("200"))
        {
            //Show Error
            return;
        }

        setThirdInqueryListLiveData(thirdPartyInquiryResponse.getThirdInquiryList());
    }

    @Override
    public void onError(String message)
    {

        Logger.e("--onError--", "onError: " + message);
        //Show Error

    }

    public void setThirdInqueryListLiveData(List<ThirdInquiryItem> thirdInquiryList)
    {
//        thirdInqueryListLiveData.setValue(thirdInquiryList);
        thirdInqueryListLiveData.addAll(thirdInquiryList);
    }

}
