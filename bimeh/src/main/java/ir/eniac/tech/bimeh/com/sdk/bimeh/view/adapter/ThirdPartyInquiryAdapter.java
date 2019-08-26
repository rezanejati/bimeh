package ir.eniac.tech.bimeh.com.sdk.bimeh.view.adapter;

import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import ir.eniac.tech.bimeh.com.sdk.bimeh.databinding.AdapterThirdPartyInqueryBinding;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.model.thirdPartyInquiry.response.ThirdInquiryItem;
import ir.eniac.tech.bimeh.com.sdk.bimeh.utility.Logger;
import ir.eniac.tech.bimeh.com.sdk.bimeh.view.base.BaseAdapter;
import ir.eniac.tech.bimeh.com.sdk.bimeh.view.base.BaseViewHolder;
import ir.eniac.tech.bimeh.com.sdk.bimeh.viewModel.thirdPartyInquiry.ThirdPartyInquiryItemViewModel;

public class ThirdPartyInquiryAdapter extends BaseAdapter<BaseViewHolder, ThirdInquiryItem>
{
    private List<ThirdInquiryItem> thirdInquiryItems;
//    private InquiryAdapterOnItemClick adapterOnItemClick;

    public ThirdPartyInquiryAdapter(List<ThirdInquiryItem> thirdInquiryItems)
    {
        this.thirdInquiryItems = thirdInquiryItems;
    }

    @Override
    public void setData(List<ThirdInquiryItem> data)
    {
        thirdInquiryItems.addAll(data);
        Logger.e("--adapter size 2--", "size: " + data.size());
        notifyDataSetChanged();
    }

    public void onClearItems()
    {
        thirdInquiryItems.clear();
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType)
    {
        AdapterThirdPartyInqueryBinding adapterBinding = AdapterThirdPartyInqueryBinding.inflate(LayoutInflater.from(viewGroup.getContext()),
                viewGroup, false);

        return new ThirdPartyInquiryViewHolder(adapterBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position)
    {
        holder.onBind(position);
    }

    @Override
    public int getItemCount()
    {
        if (thirdInquiryItems != null && thirdInquiryItems.size() > 0)
        {
            return thirdInquiryItems.size();
        } else
        {
            return 1;
        }
    }

    public class ThirdPartyInquiryViewHolder extends BaseViewHolder implements ThirdPartyInquiryItemViewModel.InquiryAdapterOnItemClick
    {
        private AdapterThirdPartyInqueryBinding adapterBinding;

        private ThirdPartyInquiryItemViewModel itemViewModel;

        public ThirdPartyInquiryViewHolder(AdapterThirdPartyInqueryBinding binding)
        {
            super(binding.getRoot());
            adapterBinding = binding;
        }

        @Override
        public void onBind(int position)
        {
            if (thirdInquiryItems != null)
            {
                if (thirdInquiryItems.size() > 0)
                {
                    ThirdInquiryItem inquiryListItem = thirdInquiryItems.get(position);
                    itemViewModel = new ThirdPartyInquiryItemViewModel(inquiryListItem, this);
                    adapterBinding.setViewModel(itemViewModel);

                    adapterBinding.tvPriceOld.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);

                    adapterBinding.executePendingBindings();
                }
            }
        }

        @Override
        public void onCashButtonClick()
        {

        }

        @Override
        public void onInstallmentButtonClick()
        {

        }
    }
}