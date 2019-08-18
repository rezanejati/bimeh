
package ir.eniac.tech.bimeh.com.sdk.bimeh.service.model.thirdPartyFirstAPI.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import ir.eniac.tech.bimeh.com.sdk.bimeh.service.model.thirdPartyFirstAPI.other.AvailableYear;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.model.thirdPartyFirstAPI.other.BrandList;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.model.thirdPartyFirstAPI.other.CompanyList;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.model.thirdPartyFirstAPI.other.DamageStatusList;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.model.thirdPartyFirstAPI.other.FinancialDamageTypeList;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.model.thirdPartyFirstAPI.other.FullNoDamageYearList;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.model.thirdPartyFirstAPI.other.LifeDamageTypeList;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.model.thirdPartyFirstAPI.other.ResponseStatus;

public class ThirdPartyFirstResponse
{
    public ThirdPartyFirstResponse(List<BrandList> brandList,
                                   List<DamageStatusList> damageStatusList,
                                   List<FullNoDamageYearList> fullNoDamageYearList,
                                   List<FinancialDamageTypeList> financialDamageTypeList,
                                   List<LifeDamageTypeList> lifeDamageTypeList,
                                   List<CompanyList> companyList,
                                   List<AvailableYear> availableYears,
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
    private List<BrandList> brandList = null;
    @SerializedName("DamageStatusList")
    @Expose
    private List<DamageStatusList> damageStatusList = null;
    @SerializedName("FullNoDamageYearList")
    @Expose
    private List<FullNoDamageYearList> fullNoDamageYearList = null;
    @SerializedName("FinancialDamageTypeList")
    @Expose
    private List<FinancialDamageTypeList> financialDamageTypeList = null;
    @SerializedName("LifeDamageTypeList")
    @Expose
    private List<LifeDamageTypeList> lifeDamageTypeList = null;
    @SerializedName("CompanyList")
    @Expose
    private List<CompanyList> companyList = null;
    @SerializedName("AvailableYears")
    @Expose
    private List<AvailableYear> availableYears = null;
    @SerializedName("ResponseStatus")
    @Expose
    private ResponseStatus responseStatus;

    public List<BrandList> getBrandList()
    {
        return brandList;
    }

    public void setBrandList(List<BrandList> brandList)
    {
        this.brandList = brandList;
    }

    public List<DamageStatusList> getDamageStatusList()
    {
        return damageStatusList;
    }

    public void setDamageStatusList(List<DamageStatusList> damageStatusList)
    {
        this.damageStatusList = damageStatusList;
    }

    public List<FullNoDamageYearList> getFullNoDamageYearList()
    {
        return fullNoDamageYearList;
    }

    public void setFullNoDamageYearList(List<FullNoDamageYearList> fullNoDamageYearList)
    {
        this.fullNoDamageYearList = fullNoDamageYearList;
    }

    public List<FinancialDamageTypeList> getFinancialDamageTypeList()
    {
        return financialDamageTypeList;
    }

    public void setFinancialDamageTypeList(List<FinancialDamageTypeList> financialDamageTypeList)
    {
        this.financialDamageTypeList = financialDamageTypeList;
    }

    public List<LifeDamageTypeList> getLifeDamageTypeList()
    {
        return lifeDamageTypeList;
    }

    public void setLifeDamageTypeList(List<LifeDamageTypeList> lifeDamageTypeList)
    {
        this.lifeDamageTypeList = lifeDamageTypeList;
    }

    public List<CompanyList> getCompanyList()
    {
        return companyList;
    }

    public void setCompanyList(List<CompanyList> companyList)
    {
        this.companyList = companyList;
    }

    public List<AvailableYear> getAvailableYears()
    {
        return availableYears;
    }

    public void setAvailableYears(List<AvailableYear> availableYears)
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
