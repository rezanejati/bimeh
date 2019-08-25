package ir.eniac.tech.bimeh.com.sdk.bimeh.service.model.thirdPartyInquiry.response;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ThirdPartyInquiryResponse {

    @SerializedName("ThirdInquiryList")
    @Expose
    private List<ThirdInquiryItem> thirdInquiryList = null;
    @SerializedName("CompanyList")
    @Expose
    private List<CompanyList> companyList = null;
    @SerializedName("PeriodList")
    @Expose
    private List<PeriodList> periodList = null;
    @SerializedName("CoverageList")
    @Expose
    private List<CoverageList> coverageList = null;
    @SerializedName("ResponseStatus")
    @Expose
    private ResponseStatus responseStatus;

    public List<ThirdInquiryItem> getThirdInquiryList() {
        return thirdInquiryList;
    }

    public void setThirdInquiryList(List<ThirdInquiryItem> thirdInquiryList) {
        this.thirdInquiryList = thirdInquiryList;
    }

    public List<CompanyList> getCompanyList() {
        return companyList;
    }

    public void setCompanyList(List<CompanyList> companyList) {
        this.companyList = companyList;
    }

    public List<PeriodList> getPeriodList() {
        return periodList;
    }

    public void setPeriodList(List<PeriodList> periodList) {
        this.periodList = periodList;
    }

    public List<CoverageList> getCoverageList() {
        return coverageList;
    }

    public void setCoverageList(List<CoverageList> coverageList) {
        this.coverageList = coverageList;
    }

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

}
