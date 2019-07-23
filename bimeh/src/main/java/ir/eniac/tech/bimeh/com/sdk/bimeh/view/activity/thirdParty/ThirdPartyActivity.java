package ir.eniac.tech.bimeh.com.sdk.bimeh.view.activity.thirdParty;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import ir.eniac.tech.bimeh.com.sdk.bimeh.BR;
import ir.eniac.tech.bimeh.com.sdk.bimeh.R;
import ir.eniac.tech.bimeh.com.sdk.bimeh.databinding.ActivityThirdPartyBinding;
import ir.eniac.tech.bimeh.com.sdk.bimeh.view.base.BaseActivity;
import ir.eniac.tech.bimeh.com.sdk.bimeh.viewModel.thirdParty.ThirdPartyViewModel;

public class ThirdPartyActivity extends BaseActivity<ActivityThirdPartyBinding, ThirdPartyViewModel> implements ThirdPartyNavigator
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        viewModel.setNavigator(this);
        initView();
    }

    @Override
    public int getBindingVariable()
    {
        return BR.viewModel;
    }

    private void initView()
    {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.my_spinner_item);
        arrayAdapter.setDropDownViewResource(R.layout.my_spinner_textview);

//        dataBinding.setViewModel(viewModel);
        dataBinding.setSpinnerAdapter(arrayAdapter);

        dataBinding.spinnerBrand.setSelection(0);
        dataBinding.spinnerBrand.setGravity(View.TEXT_ALIGNMENT_CENTER);
        dataBinding.spinnerBrandModel.setSelection(0);
        dataBinding.spinnerBrandModel.setGravity(View.TEXT_ALIGNMENT_CENTER);
        dataBinding.spinnerCreateDate.setSelection(0);
        dataBinding.spinnerCreateDate.setGravity(View.TEXT_ALIGNMENT_CENTER);
        dataBinding.spinnerDamageDiscount.setSelection(0);
        dataBinding.spinnerDamageDiscount.setGravity(View.TEXT_ALIGNMENT_CENTER);
        dataBinding.spinnerDeathDamageCount.setSelection(0);
        dataBinding.spinnerDeathDamageCount.setGravity(View.TEXT_ALIGNMENT_CENTER);
        dataBinding.spinnerDamageStatus.setSelection(0);
        dataBinding.spinnerDamageStatus.setGravity(View.TEXT_ALIGNMENT_CENTER);
        dataBinding.spinnerFinancialDamageCount.setSelection(0);
        dataBinding.spinnerFinancialDamageCount.setGravity(View.TEXT_ALIGNMENT_CENTER);

//        viewModel.loadMainMenus();
    }

    @Override
    protected Class<ThirdPartyViewModel> getViewModel()
    {
        return ThirdPartyViewModel.class;
    }

    @Override
    protected int getLayoutRes()
    {
        return R.layout.activity_third_party;
    }

    @Override
    public void openThirdPartyInqueryActivity()
    {
        Toast.makeText(this, "open ThirdPartyInqueryActivity", Toast.LENGTH_LONG).show();

//        Intent intent = MainActivity.newIntent(LoginActivity.this);
//        startActivity(intent);
    }
}
