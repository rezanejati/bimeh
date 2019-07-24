package ir.eniac.tech.bimeh.com.sdk.bimeh.view.activity.thirdParty;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ir.eniac.tech.bimeh.com.sdk.bimeh.BR;
import ir.eniac.tech.bimeh.com.sdk.bimeh.R;
import ir.eniac.tech.bimeh.com.sdk.bimeh.databinding.ActivityThirdPartyBinding;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.model.thirdPartyFirstAPI.other.BrandList;
import ir.eniac.tech.bimeh.com.sdk.bimeh.view.base.BaseActivity;
import ir.eniac.tech.bimeh.com.sdk.bimeh.viewModel.thirdParty.ThirdPartyViewModel;

public class ThirdPartyActivity extends BaseActivity<ActivityThirdPartyBinding, ThirdPartyViewModel> implements ThirdPartyNavigator,ThirdPartyViewModel.SpinnerData
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        viewModel.setNavigator(this);
        initView();
        viewModel.setSpinnerData(this);
    }

    @Override
    public int getBindingVariable()
    {
        return BR.viewModel;
    }

    private void initView()
    {


        dataBinding.tvDate.setText(viewModel.getTvDate().getValue());
//        dataBinding.setViewModel(viewModel);


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
//        dataBinding.tvDate.setText(viewModel.getTvDate().getValue());
//        dataBinding.tvDate.setText("1398/06/01");
//        viewModel.getTvDate().
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
       // Toast.makeText(this, "open ThirdPartyInqueryActivity", Toast.LENGTH_LONG).show();
/*
        viewModel.setTest("1398/06/01");
        dataBinding.setViewModel(viewModel);*/
   //  dataBinding.tvDate.setText("1398/06/01");
//        Intent intent = MainActivity.newIntent(LoginActivity.this);
//        startActivity(intent);
    }


    @Override
    public void setData(List<BrandList> getBrandList) {
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        ArrayList<String>strings= new ArrayList<>();

        for (int i = 0; i < getBrandList.size(); i++) {
            strings.add(getBrandList.get(i).getText());
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.my_spinner_item,strings);
        arrayAdapter.setDropDownViewResource(R.layout.my_spinner_textview);
        dataBinding.setSpinnerAdapter1(arrayAdapter);

    }
}
