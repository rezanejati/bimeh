package ir.eniac.tech.bimeh.com.sdk.bimeh.service.generator;

import javax.inject.Inject;

import ir.eniac.tech.bimeh.com.sdk.bimeh.EniacApplication;
import ir.eniac.tech.bimeh.com.sdk.bimeh.di.component.NetComponent;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.part.thirdPartyBrandModelList.ThirdPartyBrandModelListService;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.part.thirdPartyFirstAPI.ThirdPartyFirstAPIService;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.part.thirdPartyInquiryService.ThirdPartyInquiryService;
import okhttp3.OkHttpClient;

/**
 * Created by Javad.Abadi on 3/26/2018.
 */
public class SingletonService
{
    private NetComponent netComponent;
    @Inject
    ServiceGenerator serviceGenerator;
    @Inject
    OkHttpClient okHttpClient;
    private EniacApplication serviceApplication;
    private static final SingletonService ourInstance = new SingletonService();

    public static SingletonService getInstance()
    {
        return ourInstance;
    }

    public SingletonService setNetComponent(NetComponent netComponent)
    {
        this.netComponent = netComponent;
        return this;
    }

    public void inject()
    {
        ComponentService componentService = DaggerComponentService.builder().netComponent(netComponent).build();
        componentService.inject(this);
    }

    public OkHttpClient getOkHttpClient()
    {
        return okHttpClient;
    }

    private SingletonService()
    {
    }

    public EniacApplication getContext()
    {
        return serviceApplication;
    }

    public void setContext(EniacApplication context)
    {
        this.serviceApplication = context;
    }

    public ThirdPartyFirstAPIService thirdPartyFirstService()
    {
        return new ThirdPartyFirstAPIService(serviceGenerator);
    }

    public ThirdPartyBrandModelListService thirdPartyBrandModelService()
    {
        return new ThirdPartyBrandModelListService(serviceGenerator);
    }

    public ThirdPartyInquiryService thirdPartyInquiryService()
    {
        return new ThirdPartyInquiryService(serviceGenerator);
    }


}