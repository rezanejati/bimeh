package ir.eniac.tech.bimeh.com.sdk.bimeh.service.part.thirdPartyInquiryService;

import ir.eniac.tech.bimeh.com.sdk.bimeh.service.generator.ServiceGenerator;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.listener.OnServiceStatus;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.model.thirdPartyFirstAPI.response.ThirdPartyFirstResponse;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.model.thirdPartyInquiry.request.ThirdPartyInquiryRequest;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.model.thirdPartyInquiry.response.ThirdPartyInquiryResponse;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.part.BasePart;

public class ThirdPartyInquiryService extends BasePart
{
    public ThirdPartyInquiryService(ServiceGenerator serviceGenerator)
    {
        super(serviceGenerator);
    }

    @Override
    protected BasePart getPart()
    {
        return this;
    }

//    @Mock(jsonName = "cancellation_policies", response = ThirdPartyFirstResponse.class)
    public void setThirdPartyInquiryService(ThirdPartyInquiryRequest request, OnServiceStatus<ThirdPartyInquiryResponse> listener)
    {
        start(getServiceGenerator().createService().SearchThirdPartyInquiry(request), listener);
    }
}
