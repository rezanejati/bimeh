package ir.eniac.tech.bimeh.com.sdk.bimeh.service.model.thirdPartyInquiry.request;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;

public class ThirdPartyInquiryRequest
{
    @SerializedName("BrandId")
    @Getter @Setter
    private String BrandId;

    @SerializedName("ModelId")
    @Getter @Setter
    private String ModelId;

    @SerializedName("BuildYear")
    @Getter @Setter
    private String BuildYear;

    @SerializedName("PreviousExpiration")
    @Getter @Setter
    private String PreviousExpiration;

    @SerializedName("previousCompanyId")
    @Getter @Setter
    private String previousCompanyId;

    @SerializedName("previousStartDate")
    @Getter @Setter
    private String previousStartDate;

    @SerializedName("DamageStatusId")
    @Getter @Setter
    private String DamageStatusId;

    @SerializedName("NoDamageYearId")
    @Getter @Setter
    private String NoDamageYearId;

    @SerializedName("LifeDamageTypeId")
    @Getter @Setter
    private String LifeDamageTypeId;

    @SerializedName("FinancialDamageTypeId")
    @Getter @Setter
    private String FinancialDamageTypeId;

    @SerializedName("UniqueTypeId")
    @Getter @Setter
    private Integer UniqueTypeId;

    @SerializedName("InsurancePeriodId")
    @Getter @Setter
    @Nullable
    private String InsurancePeriodId;

}
