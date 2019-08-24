package ir.eniac.tech.bimeh.com.sdk.bimeh.view.activity.thirdPartyInquery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import ir.eniac.tech.bimeh.com.sdk.bimeh.BR;
import ir.eniac.tech.bimeh.com.sdk.bimeh.R;
import ir.eniac.tech.bimeh.com.sdk.bimeh.databinding.ActivityThirdPartyInqueryBinding;
import ir.eniac.tech.bimeh.com.sdk.bimeh.view.base.BaseActivity;
import ir.eniac.tech.bimeh.com.sdk.bimeh.viewModel.thirdPartyInquiry.ThirdPartyInquiryViewModel;

public class ThirdPartyInqueryActivity extends BaseActivity<ActivityThirdPartyInqueryBinding, ThirdPartyInquiryViewModel> implements ThirdPartyInqueryNavigator
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        viewModel.BrandId = getIntent().getStringExtra("BrandId");
        viewModel.ModelId = getIntent().getStringExtra("ModelId");
        viewModel.BuildYear = getIntent().getStringExtra("BuildYear");
        viewModel.PreviousExpiration = getIntent().getStringExtra("PreviousExpiration");
        viewModel.previousCompanyId = getIntent().getStringExtra("previousCompanyId");
        viewModel.previousStartDate = getIntent().getStringExtra("previousStartDate");
        viewModel.DamageStatusId = getIntent().getStringExtra("DamageStatusId");
        viewModel.NoDamageYearId = getIntent().getStringExtra("NoDamageYearId");
        viewModel.LifeDamageTypeId = getIntent().getStringExtra("LifeDamageTypeId");
        viewModel.FinancialDamageTypeId = getIntent().getStringExtra("FinancialDamageTypeId");

        viewModel.setNavigator(this);

        dataBinding.toolbar.findViewById(R.id.imgMenu).setOnClickListener(v -> finish());
        ((TextView) dataBinding.toolbar.findViewById(R.id.tvTitle)).setText("استعلام");


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
}
