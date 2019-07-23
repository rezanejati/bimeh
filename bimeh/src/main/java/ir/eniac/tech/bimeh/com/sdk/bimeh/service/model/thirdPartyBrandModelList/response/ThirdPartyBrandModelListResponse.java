
package ir.eniac.tech.bimeh.com.sdk.bimeh.service.model.thirdPartyBrandModelList.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import ir.eniac.tech.bimeh.com.sdk.bimeh.service.model.thirdPartyBrandModelList.others.CarModelList;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.model.thirdPartyFirstAPI.other.ResponseStatus;

public class ThirdPartyBrandModelListResponse
{

    @SerializedName("CarModelList")
    @Expose
    private List<CarModelList> carModelList = null;
    @SerializedName("ResponseStatus")
    @Expose
    private ResponseStatus responseStatus;

    public List<CarModelList> getCarModelList()
    {
        return carModelList;
    }

    public void setCarModelList(List<CarModelList> carModelList)
    {
        this.carModelList = carModelList;
    }

    public ResponseStatus getResponseStatus()
    {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus)
    {
        this.responseStatus = responseStatus;
    }

}
