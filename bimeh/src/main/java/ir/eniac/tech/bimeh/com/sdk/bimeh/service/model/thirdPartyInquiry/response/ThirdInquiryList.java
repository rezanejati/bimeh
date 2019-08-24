
package ir.eniac.tech.bimeh.com.sdk.bimeh.service.model.thirdPartyInquiry.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ThirdInquiryList {

    @SerializedName("InsThirdpartyPriceID")
    @Expose
    private Integer insThirdpartyPriceID;
    @SerializedName("CompensationBranchCount")
    @Expose
    private Integer compensationBranchCount;
    @SerializedName("HasPenalty")
    @Expose
    private Boolean hasPenalty;
    @SerializedName("PenaltyDayCount")
    @Expose
    private Integer penaltyDayCount;
    @SerializedName("CoverageTypeId")
    @Expose
    private Integer coverageTypeId;
    @SerializedName("LifeCoverage")
    @Expose
    private String lifeCoverage;
    @SerializedName("FinancialCoverage")
    @Expose
    private String financialCoverage;
    @SerializedName("DriverCoverage")
    @Expose
    private String driverCoverage;
    @SerializedName("InsurancePeriodId")
    @Expose
    private Integer insurancePeriodId;
    @SerializedName("DelayPenalty")
    @Expose
    private Double delayPenalty;
    @SerializedName("UniqueId")
    @Expose
    private String uniqueId;
    @SerializedName("EmpCompanyId")
    @Expose
    private Integer empCompanyId;
    @SerializedName("CompanyName")
    @Expose
    private String companyName;
    @SerializedName("CompanyEnName")
    @Expose
    private String companyEnName;
    @SerializedName("InsCompanyBranchId")
    @Expose
    private Integer insCompanyBranchId;
    @SerializedName("Priority")
    @Expose
    private Integer priority;
    @SerializedName("PrivateConditions")
    @Expose
    private String privateConditions;
    @SerializedName("FinancialStrength")
    @Expose
    private Integer financialStrength;
    @SerializedName("HasPermissionForOnlineIssue")
    @Expose
    private Boolean hasPermissionForOnlineIssue;
    @SerializedName("HasDiscount")
    @Expose
    private Boolean hasDiscount;
    @SerializedName("Discount")
    @Expose
    private Double discount;
    @SerializedName("FinalAmount")
    @Expose
    private Double finalAmount;
    @SerializedName("FirstAmount")
    @Expose
    private Double firstAmount;
    @SerializedName("Price")
    @Expose
    private Double price;
    @SerializedName("PayablePrice")
    @Expose
    private Double payablePrice;
    @SerializedName("Vat")
    @Expose
    private Double vat;
    @SerializedName("HasInstallmentPayment")
    @Expose
    private Boolean hasInstallmentPayment;
    @SerializedName("DeliveryCost")
    @Expose
    private Double deliveryCost;

    public Integer getInsThirdpartyPriceID() {
        return insThirdpartyPriceID;
    }

    public void setInsThirdpartyPriceID(Integer insThirdpartyPriceID) {
        this.insThirdpartyPriceID = insThirdpartyPriceID;
    }

    public Integer getCompensationBranchCount() {
        return compensationBranchCount;
    }

    public void setCompensationBranchCount(Integer compensationBranchCount) {
        this.compensationBranchCount = compensationBranchCount;
    }

    public Boolean getHasPenalty() {
        return hasPenalty;
    }

    public void setHasPenalty(Boolean hasPenalty) {
        this.hasPenalty = hasPenalty;
    }

    public Integer getPenaltyDayCount() {
        return penaltyDayCount;
    }

    public void setPenaltyDayCount(Integer penaltyDayCount) {
        this.penaltyDayCount = penaltyDayCount;
    }

    public Integer getCoverageTypeId() {
        return coverageTypeId;
    }

    public void setCoverageTypeId(Integer coverageTypeId) {
        this.coverageTypeId = coverageTypeId;
    }

    public String getLifeCoverage() {
        return lifeCoverage;
    }

    public void setLifeCoverage(String lifeCoverage) {
        this.lifeCoverage = lifeCoverage;
    }

    public String getFinancialCoverage() {
        return financialCoverage;
    }

    public void setFinancialCoverage(String financialCoverage) {
        this.financialCoverage = financialCoverage;
    }

    public String getDriverCoverage() {
        return driverCoverage;
    }

    public void setDriverCoverage(String driverCoverage) {
        this.driverCoverage = driverCoverage;
    }

    public Integer getInsurancePeriodId() {
        return insurancePeriodId;
    }

    public void setInsurancePeriodId(Integer insurancePeriodId) {
        this.insurancePeriodId = insurancePeriodId;
    }

    public Double getDelayPenalty() {
        return delayPenalty;
    }

    public void setDelayPenalty(Double delayPenalty) {
        this.delayPenalty = delayPenalty;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public Integer getEmpCompanyId() {
        return empCompanyId;
    }

    public void setEmpCompanyId(Integer empCompanyId) {
        this.empCompanyId = empCompanyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyEnName() {
        return companyEnName;
    }

    public void setCompanyEnName(String companyEnName) {
        this.companyEnName = companyEnName;
    }

    public Integer getInsCompanyBranchId() {
        return insCompanyBranchId;
    }

    public void setInsCompanyBranchId(Integer insCompanyBranchId) {
        this.insCompanyBranchId = insCompanyBranchId;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getPrivateConditions() {
        return privateConditions;
    }

    public void setPrivateConditions(String privateConditions) {
        this.privateConditions = privateConditions;
    }

    public Integer getFinancialStrength() {
        return financialStrength;
    }

    public void setFinancialStrength(Integer financialStrength) {
        this.financialStrength = financialStrength;
    }

    public Boolean getHasPermissionForOnlineIssue() {
        return hasPermissionForOnlineIssue;
    }

    public void setHasPermissionForOnlineIssue(Boolean hasPermissionForOnlineIssue) {
        this.hasPermissionForOnlineIssue = hasPermissionForOnlineIssue;
    }

    public Boolean getHasDiscount() {
        return hasDiscount;
    }

    public void setHasDiscount(Boolean hasDiscount) {
        this.hasDiscount = hasDiscount;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getFinalAmount() {
        return finalAmount;
    }

    public void setFinalAmount(Double finalAmount) {
        this.finalAmount = finalAmount;
    }

    public Double getFirstAmount() {
        return firstAmount;
    }

    public void setFirstAmount(Double firstAmount) {
        this.firstAmount = firstAmount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPayablePrice() {
        return payablePrice;
    }

    public void setPayablePrice(Double payablePrice) {
        this.payablePrice = payablePrice;
    }

    public Double getVat() {
        return vat;
    }

    public void setVat(Double vat) {
        this.vat = vat;
    }

    public Boolean getHasInstallmentPayment() {
        return hasInstallmentPayment;
    }

    public void setHasInstallmentPayment(Boolean hasInstallmentPayment) {
        this.hasInstallmentPayment = hasInstallmentPayment;
    }

    public Double getDeliveryCost() {
        return deliveryCost;
    }

    public void setDeliveryCost(Double deliveryCost) {
        this.deliveryCost = deliveryCost;
    }

}
