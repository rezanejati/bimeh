package ir.eniac.tech.bimeh.com.sdk.bimeh.service.api;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.helper.Const;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.model.thirdPartyFirstAPI.response.ThirdPartyFirstResponse;
import retrofit2.Response;
import retrofit2.http.GET;

public interface RetroClient
{
    @GET(Const.ThirdPartyFirstAPI)
    Single<Response<ThirdPartyFirstResponse>> GetThirdPartyFirstAPI();
}
