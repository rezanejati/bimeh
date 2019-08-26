
package ir.eniac.tech.bimeh.com.sdk.bimeh.service.model.thirdPartyInquiry.response;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseStatus {

    @SerializedName("Value")
    @Expose
    private String value;
    @SerializedName("ErrorList")
    @Expose
    private List<Object> errorList = null;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<Object> getErrorList() {
        return errorList;
    }

    public void setErrorList(List<Object> errorList) {
        this.errorList = errorList;
    }

}
