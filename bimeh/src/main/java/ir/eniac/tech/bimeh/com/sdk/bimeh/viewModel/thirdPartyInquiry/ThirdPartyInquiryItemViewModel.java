package ir.eniac.tech.bimeh.com.sdk.bimeh.viewModel.thirdPartyInquiry;

import android.databinding.ObservableField;
import android.support.annotation.Nullable;

import ir.eniac.tech.bimeh.com.sdk.bimeh.service.model.thirdPartyInquiry.response.ThirdInquiryItem;

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

    public ThirdPartyInquiryItemViewModel(ThirdInquiryItem thirdInquiryItemItem, InquiryAdapterOnItemClick adapterOnItemClick)
    {
        this.adapterOnItemClick = adapterOnItemClick;
//        this.thirdInquiryItemItem = thirdInquiryItemItem;
        tvDiscount = new ObservableField<>(String.valueOf(thirdInquiryItemItem.getDiscount()));
        tvFinancialSupport = new ObservableField<>(String.valueOf(thirdInquiryItemItem.getFinancialCoverage()));
        tvDeathSupport = new ObservableField<>(String.valueOf(thirdInquiryItemItem.getLifeCoverage()));
        tvDriverEvents = new ObservableField<>(String.valueOf(thirdInquiryItemItem.getDriverCoverage()));
        tvPriceOld = new ObservableField<>(String.valueOf(thirdInquiryItemItem.getFirstAmount()));
        tvPriceFinally = new ObservableField<>(String.valueOf(thirdInquiryItemItem.getFinalAmount()));
//        imgLogo = new ObservableField<>(String.valueOf(thirdInquiryItemItem.get()));
        imgLogo = new ObservableField<>("https://www.fnordware.com/superpng/pnggrad16rgb.png");

        isInstallmentButtonVisible = new ObservableField<>();
        try
        {
            isInstallmentButtonVisible.set(thirdInquiryItemItem.getHasInstallmentPayment());
        }
        catch (NullPointerException e)
        {
            isInstallmentButtonVisible.set(false);
        }
        isDiscountVisible = new ObservableField<>(thirdInquiryItemItem.getHasDiscount());
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
