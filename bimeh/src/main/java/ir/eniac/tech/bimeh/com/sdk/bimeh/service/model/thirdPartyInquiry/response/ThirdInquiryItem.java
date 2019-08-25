
package ir.eniac.tech.bimeh.com.sdk.bimeh.service.model.thirdPartyInquiry.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;

public class ThirdInquiryItem
{
    @SerializedName("InsThirdpartyPriceID")
    @Expose @Getter @Setter
    private Integer insThirdpartyPriceID;
    @SerializedName("CompensationBranchCount")
    @Expose @Getter @Setter
    private Integer compensationBranchCount;
    @SerializedName("HasPenalty")
    @Expose @Getter @Setter
    private Boolean hasPenalty;
    @SerializedName("PenaltyDayCount")
    @Expose @Getter @Setter
    private Integer penaltyDayCount;
    @SerializedName("CoverageTypeId")
    @Expose @Getter @Setter
    private Integer coverageTypeId;
    @SerializedName("LifeCoverage")
    @Expose @Getter @Setter
    private String lifeCoverage;
    @SerializedName("FinancialCoverage")
    @Expose @Getter @Setter
    private String financialCoverage;
    @SerializedName("DriverCoverage")
    @Expose @Getter @Setter
    private String driverCoverage;
    @SerializedName("InsurancePeriodId")
    @Expose @Getter @Setter
    private Integer insurancePeriodId;
    @SerializedName("DelayPenalty")
    @Expose @Getter @Setter
    private Double delayPenalty;
    @SerializedName("UniqueId")
    @Expose @Getter @Setter
    private String uniqueId;
    @SerializedName("EmpCompanyId")
    @Expose @Getter @Setter
    private Integer empCompanyId;
    @SerializedName("CompanyName")
    @Expose @Getter @Setter
    private String companyName;
    @SerializedName("CompanyEnName")
    @Expose @Getter @Setter
    private String companyEnName;
    @SerializedName("InsCompanyBranchId")
    @Expose @Getter @Setter
    private Integer insCompanyBranchId;
    @SerializedName("Priority")
    @Expose @Getter @Setter
    private Integer priority;
    @SerializedName("PrivateConditions")
    @Expose @Getter @Setter
    private String privateConditions;
    @SerializedName("FinancialStrength")
    @Expose @Getter @Setter
    private Integer financialStrength;
    @SerializedName("HasPermissionForOnlineIssue")
    @Expose @Getter @Setter
    private Boolean hasPermissionForOnlineIssue;
    @SerializedName("HasDiscount")
    @Expose @Getter @Setter
    private Boolean hasDiscount;
    @SerializedName("Discount")
    @Expose @Getter @Setter
    private Double discount;
    @SerializedName("FinalAmount")
    @Expose @Getter @Setter
    private Double finalAmount;
    @SerializedName("FirstAmount")
    @Expose @Getter @Setter
    private Double firstAmount;
    @SerializedName("Price")
    @Expose @Getter @Setter
    private Double price;
    @SerializedName("PayablePrice")
    @Expose @Getter @Setter
    private Double payablePrice;
    @SerializedName("Vat")
    @Expose @Getter @Setter
    private Double vat;
    @SerializedName("HasInstallmentPayment")
    @Expose @Getter @Setter
    private Boolean hasInstallmentPayment;
    @SerializedName("DeliveryCost")
    @Expose @Getter @Setter
    private Double deliveryCost;

}
