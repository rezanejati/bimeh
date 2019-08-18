package ir.eniac.tech.bimeh.com.sdk.bimeh.view.activity.thirdParty;

//import android.app.DatePickerDialog;
import android.os.Bundle;
import android.preference.DialogPreference;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

import ir.eniac.tech.bimeh.com.sdk.bimeh.BR;
import ir.eniac.tech.bimeh.com.sdk.bimeh.R;
import ir.eniac.tech.bimeh.com.sdk.bimeh.databinding.ActivityThirdPartyBinding;
import ir.eniac.tech.bimeh.com.sdk.bimeh.view.base.BaseActivity;
import ir.eniac.tech.bimeh.com.sdk.bimeh.viewModel.thirdParty.ThirdPartyViewModel;
import library.android.calendar.mohamadamin.persianmaterialdatetimepicker.date.DatePickerDialog;
import library.android.calendar.mohamadamin.persianmaterialdatetimepicker.utils.PersianCalendar;

public class ThirdPartyActivity extends BaseActivity<ActivityThirdPartyBinding, ThirdPartyViewModel> implements ThirdPartyNavigator,
        DatePickerDialog.OnDateSetListener
{
    private DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        viewModel.setNavigator(this);

        initView();

        initDate();
//        viewModel.setSpinnerData(this);


//        arrayAdapter = new ArrayAdapter<String>(this, R.layout.my_spinner_item);
//        arrayAdapter.setDropDownViewResource(R.layout.my_spinner_textview);
//
//        dataBinding.spinnerBrand.setSelection(0);
//        dataBinding.spinnerBrand.setGravity(View.TEXT_ALIGNMENT_CENTER);
//        dataBinding.setSpinnerAdapterBrand(arrayAdapter);

        subscribeToLiveData();

//        dataBinding.tvDate.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View v)
//            {
//                String dateStr = "1398-05-02";
//                viewModel.updateTvDate(dateStr);
//            }
//        });
    }

    private void initDate()
    {
        PersianCalendar calendar = new PersianCalendar();

        datePickerDialog = DatePickerDialog.newInstance(this,
                calendar.getPersianYear(),
                calendar.getPersianMonth(),
                calendar.getPersianDay()
        );

        datePickerDialog.setMinDate(calendar);

    }

    @Override
    public int getBindingVariable()
    {
        return BR.viewModel;
    }

    private void initView()
    {


//        dataBinding.tvDate.setText(viewModel.getTvDate().getValue());



        dataBinding.spinnerBrandModel.setSelection(0);
        dataBinding.spinnerBrandModel.setGravity(View.TEXT_ALIGNMENT_CENTER);


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
        Toast.makeText(this, "open ThirdPartyInqueryActivity", Toast.LENGTH_LONG).show();
/*
        viewModel.setTest("1398/06/01");
        dataBinding.setViewModel(viewModel);*/
        //  dataBinding.tvDate.setText("1398/06/01");
//        Intent intent = MainActivity.newIntent(LoginActivity.this);
//        startActivity(intent);
    }

    @Override
    public void openDatePicker()
    {

        if (datePickerDialog.isAdded())
        {
            return;
        }

        datePickerDialog.setTitle("");
        datePickerDialog.show(getSupportFragmentManager(), "DatePickerDialog");
    }

    private void subscribeToLiveData()
    {
        viewModel.getBrandListEntriesLive().observe(this, viewModel::setBrandListEntries);

        viewModel.getBrandModelListEntriesLive().observe(this, list -> viewModel.setBrandModelListEntries(list));

        viewModel.getDamageStatusListEntriesLive().observe(this, list -> viewModel.setDamageStatusListEntries(list));

        viewModel.getFinancialDamageTypeListEntriesLive().observe(this, list -> viewModel.setFinancialDamageTypeListEntries(list));

        viewModel.getFullNoDamageYearListEntriesLive().observe(this, list -> viewModel.setFullNoDamageYearListEntries(list));

        viewModel.getLifeDamageTypeListEntriesLive().observe(this, list -> viewModel.setLifeDamageTypeListEntries(list));

        viewModel.getAvailableYearsEntriesLive().observe(this, list -> viewModel.setAvailableYearsEntries(list));
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth, int endYear, int endMonth, int endDay)
    {
        PersianCalendar calendar = new PersianCalendar();
        calendar.set(year, monthOfYear, dayOfMonth);
        datePickerDialog.setPersianCalendar(calendar);

        String date = year + "-" + (monthOfYear + 1) + "-" + dayOfMonth;
        viewModel.updateTvDate(date);
    }
}
