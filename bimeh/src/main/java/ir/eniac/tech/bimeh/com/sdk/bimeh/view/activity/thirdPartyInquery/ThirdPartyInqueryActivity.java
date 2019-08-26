package ir.eniac.tech.bimeh.com.sdk.bimeh.view.activity.thirdPartyInquery;

import android.arch.lifecycle.Observer;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.TextView;

import java.util.List;

import ir.eniac.tech.bimeh.com.sdk.bimeh.BR;
import ir.eniac.tech.bimeh.com.sdk.bimeh.R;
import ir.eniac.tech.bimeh.com.sdk.bimeh.databinding.ActivityThirdPartyInqueryBinding;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.generator.SingletonService;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.listener.OnServiceStatus;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.model.thirdPartyInquiry.request.ThirdPartyInquiryRequest;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.model.thirdPartyInquiry.response.ThirdInquiryItem;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.model.thirdPartyInquiry.response.ThirdPartyInquiryResponse;
import ir.eniac.tech.bimeh.com.sdk.bimeh.utility.Logger;
import ir.eniac.tech.bimeh.com.sdk.bimeh.view.adapter.ThirdPartyInquiryAdapter;
import ir.eniac.tech.bimeh.com.sdk.bimeh.view.base.BaseActivity;
import ir.eniac.tech.bimeh.com.sdk.bimeh.viewModel.thirdPartyInquiry.ThirdPartyInquiryViewModel;

public class ThirdPartyInqueryActivity extends BaseActivity<ActivityThirdPartyInqueryBinding, ThirdPartyInquiryViewModel> implements ThirdPartyInqueryNavigator, OnServiceStatus<ThirdPartyInquiryResponse>
{
    private String BrandId;
    private String ModelId;
    private String BuildYear;
    private String PreviousExpiration;
    private String previousCompanyId;
    private String previousStartDate;
    private String DamageStatusId;
    private String NoDamageYearId;
    private String LifeDamageTypeId;
    private String FinancialDamageTypeId;

    private ThirdPartyInquiryAdapter adapter;
    private LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        BrandId = getIntent().getStringExtra("BrandId");
        ModelId = getIntent().getStringExtra("ModelId");
        BuildYear = getIntent().getStringExtra("BuildYear");
        PreviousExpiration = getIntent().getStringExtra("PreviousExpiration");
        previousCompanyId = getIntent().getStringExtra("previousCompanyId");
        previousStartDate = getIntent().getStringExtra("previousStartDate");
        DamageStatusId = getIntent().getStringExtra("DamageStatusId");
        NoDamageYearId = getIntent().getStringExtra("NoDamageYearId");
        LifeDamageTypeId = getIntent().getStringExtra("LifeDamageTypeId");
        FinancialDamageTypeId = getIntent().getStringExtra("FinancialDamageTypeId");

        viewModel.setNavigator(this);

        dataBinding.toolbar.findViewById(R.id.imgMenu).setOnClickListener(v -> finish());
        ((TextView) dataBinding.toolbar.findViewById(R.id.tvTitle)).setText("استعلام");

        viewModel.getData(BrandId, ModelId, BuildYear, PreviousExpiration, previousCompanyId, previousStartDate, DamageStatusId,
                NoDamageYearId, LifeDamageTypeId, FinancialDamageTypeId);

//        getData();

//        subscribeToLiveData();

//        Logger.e("--adapter size 1--", "size: " + viewModel.getThirdInqueryListLiveData().getValue().size());

        adapter = new ThirdPartyInquiryAdapter(viewModel.getThirdInqueryListLiveData().getValue());
//        adapter = new ThirdPartyInquiryAdapter(viewModel.getThirdInqueryListLiveData());
        layoutManager = new LinearLayoutManager(ThirdPartyInqueryActivity.this, LinearLayoutManager.VERTICAL, false);
        dataBinding.recyclerView.setLayoutManager(layoutManager);
        dataBinding.recyclerView.setItemAnimator(new DefaultItemAnimator());
        dataBinding.recyclerView.setAdapter(adapter);
    }

    private void subscribeToLiveData()
    {
        viewModel.getThirdInqueryListLiveData().observe(this, viewModel::setThirdInqueryListLiveData);
    }

    @Override
    public int getBindingVariable()
    {
        return BR.viewModel;
    }

    @Override
    protected Class<ThirdPartyInquiryViewModel> getViewModel()
    {
        return ThirdPartyInquiryViewModel.class;
    }

    @Override
    protected int getLayoutRes()
    {
        return R.layout.activity_third_party_inquery;
    }

    @Override
    public void openThirdPartyFillUserSpecActivity()
    {

    }
    public void getData()
    {
        ThirdPartyInquiryRequest request = new ThirdPartyInquiryRequest();
        request.setBrandId(BrandId);
        request.setModelId(ModelId);
        request.setBuildYear(BuildYear);
        request.setPreviousExpiration(PreviousExpiration);
        request.setPreviousCompanyId(previousCompanyId);
        request.setPreviousStartDate(previousStartDate);
        request.setDamageStatusId(DamageStatusId);
        request.setNoDamageYearId(NoDamageYearId);
        request.setLifeDamageTypeId(LifeDamageTypeId);
        request.setFinancialDamageTypeId(FinancialDamageTypeId);
        request.setUniqueTypeId(1);
        request.setInsurancePeriodId(null);

        SingletonService.getInstance().thirdPartyInquiryService().setThirdPartyInquiryService(request, this);
    }

    @Override
    public void onReady(ThirdPartyInquiryResponse thirdPartyInquiryResponse)
    {

        if (!thirdPartyInquiryResponse.getResponseStatus().getValue().equalsIgnoreCase("200"))
        {
            //Show Error
            return;
        }

        viewModel.setThirdInqueryListLiveData(thirdPartyInquiryResponse.getThirdInquiryList());

        subscribeToLiveData();

        adapter = new ThirdPartyInquiryAdapter(viewModel.getThirdInqueryListLiveData().getValue());
//        adapter = new ThirdPartyInquiryAdapter(viewModel.getThirdInqueryListLiveData());
        layoutManager = new LinearLayoutManager(ThirdPartyInqueryActivity.this, LinearLayoutManager.VERTICAL, false);
        dataBinding.recyclerView.setLayoutManager(layoutManager);
        dataBinding.recyclerView.setItemAnimator(new DefaultItemAnimator());
        dataBinding.recyclerView.setAdapter(adapter);
    }

    @Override
    public void onError(String message)
    {

        Logger.e("--onError--", "onError: " + message);
        //Show Error

    }
}
