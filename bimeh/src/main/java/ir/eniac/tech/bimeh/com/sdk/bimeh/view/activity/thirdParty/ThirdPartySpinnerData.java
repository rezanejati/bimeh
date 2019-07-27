package ir.eniac.tech.bimeh.com.sdk.bimeh.view.activity.thirdParty;

import java.util.List;

import ir.eniac.tech.bimeh.com.sdk.bimeh.service.model.thirdPartyFirstAPI.other.AvailableYear;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.model.thirdPartyFirstAPI.other.BrandList;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.model.thirdPartyFirstAPI.other.CompanyList;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.model.thirdPartyFirstAPI.other.DamageStatusList;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.model.thirdPartyFirstAPI.other.FinancialDamageTypeList;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.model.thirdPartyFirstAPI.other.FullNoDamageYearList;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.model.thirdPartyFirstAPI.other.LifeDamageTypeList;

public interface ThirdPartySpinnerData
{
    void setBrandData(List<BrandList> brandList);
    void setDamageStatusData(List<DamageStatusList> damageStatusList);
    void setFullNoDamageYearData(List<FullNoDamageYearList> fullNoDamageYearList);
    void setFinancialDamageTypeData(List<FinancialDamageTypeList> financialDamageTypeList);
    void setLifeDamageTypeData(List<LifeDamageTypeList> lifeDamageTypeList);
//    void setCompanyData(List<CompanyList> companyList);
    void setAvailableYearData(List<AvailableYear> availableYears);
}
