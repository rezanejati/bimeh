package ir.eniac.tech.bimeh.com.sdk.bimeh.service.model.thirdPartyBrandModelList.others;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CarModelList
{

    @SerializedName("InsCarModelId")
    @Expose
    private Integer insCarModelId;
    @SerializedName("ModelName")
    @Expose
    private String modelName;
    @SerializedName("PassengerCount")
    @Expose
    private Integer passengerCount;
    @SerializedName("InsCarTypeId")
    @Expose
    private Integer insCarTypeId;
    @SerializedName("InsCarType")
    @Expose
    private String insCarType;

    public Integer getInsCarModelId()
    {
        return insCarModelId;
    }

    public void setInsCarModelId(Integer insCarModelId)
    {
        this.insCarModelId = insCarModelId;
    }

    public String getModelName()
    {
        return modelName;
    }

    public void setModelName(String modelName)
    {
        this.modelName = modelName;
    }

    public Integer getPassengerCount()
    {
        return passengerCount;
    }

    public void setPassengerCount(Integer passengerCount)
    {
        this.passengerCount = passengerCount;
    }

    public Integer getInsCarTypeId()
    {
        return insCarTypeId;
    }

    public void setInsCarTypeId(Integer insCarTypeId)
    {
        this.insCarTypeId = insCarTypeId;
    }

    public String getInsCarType()
    {
        return insCarType;
    }

    public void setInsCarType(String insCarType)
    {
        this.insCarType = insCarType;
    }

}
