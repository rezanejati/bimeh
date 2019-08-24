package ir.eniac.tech.bimeh.com.sdk.bimeh.viewModel.thirdPartyInquiry;

import android.arch.lifecycle.MutableLiveData;

import java.util.List;

import ir.eniac.tech.bimeh.com.sdk.bimeh.service.generator.ServiceGenerator;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.generator.SingletonService;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.listener.OnServiceStatus;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.model.thirdPartyInquiry.request.ThirdPartyInquiryRequest;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.model.thirdPartyInquiry.response.ThirdInquiryList;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.model.thirdPartyInquiry.response.ThirdPartyInquiryResponse;
import ir.eniac.tech.bimeh.com.sdk.bimeh.view.activity.thirdPartyInquery.ThirdPartyInqueryNavigator;
import ir.eniac.tech.bimeh.com.sdk.bimeh.viewModel.BaseViewModel;

public class ThirdPartyInquiryViewModel extends BaseViewModel<ThirdPartyInqueryNavigator> implements OnServiceStatus<ThirdPartyInquiryResponse>
{
    private final MutableLiveData<List<ThirdInquiryList>> thirdInqueryListLiveData;

    public String BrandId;
    public String ModelId;
    public String BuildYear;
    public String PreviousExpiration;
    public String previousCompanyId;
    public String previousStartDate;
    public String DamageStatusId;
    public String NoDamageYearId;
    public String LifeDamageTypeId;
    public String FinancialDamageTypeId;

    public ThirdPartyInquiryViewModel()
    {
        super();
        thirdInqueryListLiveData = new MutableLiveData<>();
        getData();
    }

    private void getData()
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

    }

    @Override
    public void onError(String message)
    {

    }
}
