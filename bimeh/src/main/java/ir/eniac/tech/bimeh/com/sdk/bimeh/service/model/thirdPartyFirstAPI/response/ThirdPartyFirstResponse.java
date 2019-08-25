
package ir.eniac.tech.bimeh.com.sdk.bimeh.service.model.thirdPartyFirstAPI.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import ir.eniac.tech.bimeh.com.sdk.bimeh.service.model.thirdPartyFirstAPI.other.ItemsList;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.model.thirdPartyFirstAPI.other.ResponseStatus;

public class ThirdPartyFirstResponse
{
    public ThirdPartyFirstResponse(List<ItemsList> brandList,
                                   List<ItemsList> damageStatusList,
                                   List<ItemsList> fullNoDamageYearList,
                                   List<ItemsList> financialDamageTypeList,
                                   List<ItemsList> lifeDamageTypeList,
                                   List<ItemsList> companyList,
                                   List<ItemsList> availableYears,
                                   ResponseStatus responseStatus)
    {
        this.brandList = brandList;
        this.damageStatusList = damageStatusList;
        this.fullNoDamageYearList = fullNoDamageYearList;
        this.financialDamageTypeList = financialDamageTypeList;
        this.lifeDamageTypeList = lifeDamageTypeList;
        this.companyList = companyList;
        this.availableYears = availableYears;
        this.responseStatus = responseStatus;
    }

    @SerializedName("BrandList")
    @Expose
    private List<ItemsList> brandList = null;
    @SerializedName("DamageStatusList")
    @Expose
    private List<ItemsList> damageStatusList = null;
    @SerializedName("FullNoDamageYearList")
    @Expose
    private List<ItemsList> fullNoDamageYearList = null;
    @SerializedName("FinancialDamageTypeList")
    @Expose
    private List<ItemsList> financialDamageTypeList = null;
    @SerializedName("LifeDamageTypeList")
    @Expose
    private List<ItemsList> lifeDamageTypeList = null;
    @SerializedName("CompanyList")
    @Expose
    private List<ItemsList> companyList = null;
    @SerializedName("AvailableYears")
    @Expose
    private List<ItemsList> availableYears = null;
    @SerializedName("ResponseStatus")
    @Expose
    private ResponseStatus responseStatus;

    public List<ItemsList> getBrandList()
    {
        return brandList;
    }

    public void setBrandList(List<ItemsList> brandList)
    {
        this.brandList = brandList;
    }

    public List<ItemsList> getDamageStatusList()
    {
        return damageStatusList;
    }

    public void setDamageStatusList(List<ItemsList> damageStatusList)
    {
        this.damageStatusList = damageStatusList;
    }

    public List<ItemsList> getFullNoDamageYearList()
    {
        return fullNoDamageYearList;
    }

    public void setFullNoDamageYearList(List<ItemsList> fullNoDamageYearList)
    {
        this.fullNoDamageYearList = fullNoDamageYearList;
    }

    public List<ItemsList> getFinancialDamageTypeList()
    {
        return financialDamageTypeList;
    }

    public void setFinancialDamageTypeList(List<ItemsList> financialDamageTypeList)
    {
        this.financialDamageTypeList = financialDamageTypeList;
    }

    public List<ItemsList> getLifeDamageTypeList()
    {
        return lifeDamageTypeList;
    }

    public void setLifeDamageTypeList(List<ItemsList> lifeDamageTypeList)
    {
        this.lifeDamageTypeList = lifeDamageTypeList;
    }

    public List<ItemsList> getCompanyList()
    {
        return companyList;
    }

    public void setCompanyList(List<ItemsList> companyList)
    {
        this.companyList = companyList;
    }

    public List<ItemsList> getAvailableYears()
    {
        return availableYears;
    }

    public void setAvailableYears(List<ItemsList> availableYears)
    {
        this.availableYears = availableYears;
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
