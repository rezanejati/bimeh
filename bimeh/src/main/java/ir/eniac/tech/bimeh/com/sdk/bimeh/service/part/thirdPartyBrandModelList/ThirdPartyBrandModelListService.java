package ir.eniac.tech.bimeh.com.sdk.bimeh.service.part.thirdPartyBrandModelList;

import ir.eniac.tech.bimeh.com.sdk.bimeh.service.generator.ServiceGenerator;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.listener.OnServiceStatus;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.model.thirdPartyBrandModelList.response.ThirdPartyBrandModelListResponse;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.model.thirdPartyFirstAPI.response.ThirdPartyFirstResponse;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.part.BasePart;

public class ThirdPartyBrandModelListService extends BasePart
{
    public ThirdPartyBrandModelListService(ServiceGenerator serviceGenerator)
    {
        super(serviceGenerator);
    }

    @Override
    protected BasePart getPart()
    {
        return this;
    }

//    @Mock(jsonName = "cancellation_policies", response = ThirdPartyFirstResponse.class)
    public void setThirdPartyBrandModelListService(String brandId, OnServiceStatus<ThirdPartyBrandModelListResponse> listener)
    {
        start(getServiceGenerator().createService().GetBrandModelList(brandId), listener);
    }
}
