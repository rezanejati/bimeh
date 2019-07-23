package ir.eniac.tech.bimeh.com.sdk.bimeh.service.part.thirdPartyFirstAPI;

import ir.eniac.tech.bimeh.com.sdk.bimeh.service.generator.ServiceGenerator;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.listener.OnServiceStatus;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.mock.Mock;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.model.thirdPartyFirstAPI.response.ThirdPartyFirstResponse;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.part.BasePart;

public class ThirdPartyFirstAPIService extends BasePart
{
    public ThirdPartyFirstAPIService(ServiceGenerator serviceGenerator)
    {
        super(serviceGenerator);
    }

    @Override
    protected BasePart getPart()
    {
        return this;
    }

//    @Mock(jsonName = "cancellation_policies", response = ThirdPartyFirstResponse.class)
    public void setThirdPartyFirstAPIService(OnServiceStatus<ThirdPartyFirstResponse> listener)
    {
        start(getServiceGenerator().createService().GetThirdPartyFirstAPI(), listener);
    }
}
