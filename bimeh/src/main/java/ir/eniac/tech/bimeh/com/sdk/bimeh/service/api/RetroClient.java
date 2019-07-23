package ir.eniac.tech.bimeh.com.sdk.bimeh.service.api;

import io.reactivex.Single;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.helper.Const;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.model.thirdPartyFirstAPI.response.ThirdPartyFirstResponse;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.model.thirdPartyBrandModelList.response.ThirdPartyBrandModelListResponse;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetroClient
{
    @GET(Const.ThirdPartyFirstAPI)
    Single<Response<ThirdPartyFirstResponse>> GetThirdPartyFirstAPI();

    @GET(Const.ThirdPartyBrandModelList + "/{brandId}")
    Single<Response<ThirdPartyBrandModelListResponse>> GetBrandModelList(@Path("brandId") int brandId);
}
