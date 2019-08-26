
package ir.eniac.tech.bimeh.com.sdk.bimeh.service.model.thirdPartyInquiry.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PeriodList {

    @SerializedName("Value")
    @Expose
    private String value;
    @SerializedName("Text")
    @Expose
    private String text;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
