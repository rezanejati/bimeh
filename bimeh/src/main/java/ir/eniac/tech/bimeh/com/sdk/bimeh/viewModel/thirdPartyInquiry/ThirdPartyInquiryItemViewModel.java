package ir.eniac.tech.bimeh.com.sdk.bimeh.viewModel.thirdPartyInquiry;

import android.databinding.ObservableField;
import android.support.annotation.Nullable;

import ir.eniac.tech.bimeh.com.sdk.bimeh.service.model.thirdPartyInquiry.response.ThirdInquiryItem;
import ir.eniac.tech.bimeh.com.sdk.bimeh.utility.Logger;

public class ThirdPartyInquiryItemViewModel
{
    public final ObservableField<String> tvDiscount;
    public final ObservableField<String> tvFinancialSupport;
    public final ObservableField<String> tvDeathSupport;
    public final ObservableField<String> tvDriverEvents;
    public final ObservableField<String> tvPriceOld;
    public final ObservableField<String> tvPriceFinally;
    public final ObservableField<String> imgLogo;
    @Nullable
    public ObservableField<Boolean> isInstallmentButtonVisible;
    public final ObservableField<Boolean> isDiscountVisible;

    public final InquiryAdapterOnItemClick adapterOnItemClick;

//    private final ThirdInquiryItem thirdInquiryItemItem;

    public ThirdPartyInquiryItemViewModel(ThirdInquiryItem thirdInquiryItem, InquiryAdapterOnItemClick adapterOnItemClick)
    {

        this.adapterOnItemClick = adapterOnItemClick;
//        this.thirdInquiryItem = thirdInquiryItem;
        if (thirdInquiryItem == null)
        {
            tvDiscount = new ObservableField<>("");
            tvFinancialSupport = new ObservableField<>("");
            tvDeathSupport = new ObservableField<>("");
            tvDriverEvents = new ObservableField<>("");
            tvPriceOld = new ObservableField<>("");
            tvPriceFinally = new ObservableField<>("");
            imgLogo = new ObservableField<>("https://www.fnordware.com/superpng/pnggrad16rgb.png");

            isInstallmentButtonVisible = new ObservableField<>(false);
            isDiscountVisible = new ObservableField<>(false);
        }
        else
        {
            tvDiscount = new ObservableField<>(String.valueOf(thirdInquiryItem.getDiscount()));
            tvFinancialSupport = new ObservableField<>(String.valueOf(thirdInquiryItem.getFinancialCoverage()));
            tvDeathSupport = new ObservableField<>(String.valueOf(thirdInquiryItem.getLifeCoverage()));
            tvDriverEvents = new ObservableField<>(String.valueOf(thirdInquiryItem.getDriverCoverage()));
            tvPriceOld = new ObservableField<>(String.valueOf(thirdInquiryItem.getFirstAmount()));
            tvPriceFinally = new ObservableField<>(String.valueOf(thirdInquiryItem.getFinalAmount()));
//        imgLogo = new ObservableField<>(String.valueOf(thirdInquiryItem.get()));
            imgLogo = new ObservableField<>("https://www.fnordware.com/superpng/pnggrad16rgb.png");

            isInstallmentButtonVisible = new ObservableField<>(thirdInquiryItem.getHasInstallmentPayment());
            isDiscountVisible = new ObservableField<>(thirdInquiryItem.getHasDiscount());
        }
        notifyAll();
    }

    public void onCashButtonClick()
    {
        adapterOnItemClick.onCashButtonClick();
    }

    public void onInstallmentButtonClick()
    {
        adapterOnItemClick.onInstallmentButtonClick();
    }

    public interface InquiryAdapterOnItemClick
    {
        void onCashButtonClick();

        void onInstallmentButtonClick();
    }
}
