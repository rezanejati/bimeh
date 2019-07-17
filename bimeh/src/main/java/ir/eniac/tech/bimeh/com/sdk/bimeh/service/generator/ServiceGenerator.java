package ir.eniac.tech.bimeh.com.sdk.bimeh.service.generator;

import javax.inject.Inject;

import ir.eniac.tech.bimeh.com.sdk.bimeh.service.api.RetroClient;
import retrofit2.Retrofit;

/**
 * Created by Javad.Abadi on 3/26/2018.
 */

public class ServiceGenerator
{
    private Retrofit retrofit;

    @Inject
    public ServiceGenerator(Retrofit retrofit)
    {
        this.retrofit = retrofit;
    }

    public RetroClient createService()
    {
        return retrofit.create(RetroClient.class);
    }


}