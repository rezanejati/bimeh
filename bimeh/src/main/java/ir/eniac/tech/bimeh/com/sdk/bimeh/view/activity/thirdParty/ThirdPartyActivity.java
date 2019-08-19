package ir.eniac.tech.bimeh.com.sdk.bimeh.view.activity.thirdParty;

//import android.app.DatePickerDialog;
import android.os.Bundle;
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
    private DatePickerDialog pickerDialogCreateDate, pickerDialogFinalDate;

    private int year = 0;
    private int month = 0;
    private int day = 0;
    private int year_today = 0;
    private int month_today = 0;
    private int day_today = 0;

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

//        dataBinding.tvCreateDate.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View v)
//            {
//                String dateStr = "1398-05-02";
//                viewModel.updateTvCreateDate(dateStr);
//            }
//        });
    }

    private void initDate()
    {
        PersianCalendar calendar = new PersianCalendar();

        pickerDialogCreateDate = DatePickerDialog.newInstance(this,
                calendar.getPersianYear(),
                calendar.getPersianMonth(),
                calendar.getPersianDay()
        );

//        pickerDialogCreateDate.setMinDate(calendar);

    }

    @Override
    public int getBindingVariable()
    {
        return BR.viewModel;
    }

    private void initView()
    {


//        dataBinding.tvCreateDate.setText(viewModel.getTvCreateDate().getValue());



//        dataBinding.spinnerBrandModel.setSelection(0);
//        dataBinding.spinnerBrandModel.setGravity(View.TEXT_ALIGNMENT_CENTER);

//        viewModel.setIsLoading(false);

//        viewModel.loadMainMenus();
//        dataBinding.tvCreateDate.setText(viewModel.getTvCreateDate().getValue());
//        dataBinding.tvCreateDate.setText("1398/06/01");
//        viewModel.getTvCreateDate().
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
        //  dataBinding.tvCreateDate.setText("1398/06/01");
//        Intent intent = MainActivity.newIntent(LoginActivity.this);
//        startActivity(intent);
    }

    @Override
    public void openCreateDatePicker()
    {

        if (pickerDialogCreateDate.isAdded() || pickerDialogFinalDate.isAdded())
        {
            return;
        }

        pickerDialogCreateDate.setTitle("");
        pickerDialogCreateDate.show(getSupportFragmentManager(), "CreateDate");
    }

    @Override
    public void openFinalDatePicker()
    {

    }

    private void subscribeToLiveData()
    {
        viewModel.getBrandListEntriesLive().observe(this, viewModel::setBrandListEntries);

        viewModel.getBrandModelListEntriesLive().observe(this, viewModel::setBrandModelListEntries);

        viewModel.getCompanyListEntriesLive().observe(this, viewModel::setCompanyListEntries);

        viewModel.getDamageStatusListEntriesLive().observe(this, viewModel::setDamageStatusListEntries);

        viewModel.getFinancialDamageTypeListEntriesLive().observe(this, viewModel::setFinancialDamageTypeListEntries);

        viewModel.getFullNoDamageYearListEntriesLive().observe(this, viewModel::setFullNoDamageYearListEntries);

        viewModel.getLifeDamageTypeListEntriesLive().observe(this, viewModel::setLifeDamageTypeListEntries);

        viewModel.getAvailableYearsEntriesLive().observe(this, viewModel::setAvailableYearsEntries);
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth, int endYear, int endMonth, int endDay)
    {
        if (view.getTag().equals("CreateDate"))
        {
            PersianCalendar calendar = new PersianCalendar();
            calendar.set(year, monthOfYear, dayOfMonth);
            pickerDialogCreateDate.setPersianCalendar(calendar);

            String date = year + "-" + (monthOfYear + 1) + "-" + dayOfMonth;
            viewModel.updateTvCreateDate(date);

            this.year = year;
            this.month = monthOfYear;
            this.day = dayOfMonth;

            PersianCalendar calendar1 = new PersianCalendar();
            PersianCalendar calendar2 = new PersianCalendar();
            calendar1.set(year, monthOfYear, dayOfMonth);
            calendar2.set(year_today, month_today, day_today);

            pickerDialogCreateDate.setPersianCalendar(calendar1);

            if (calendar1.getTimeInMillis() > calendar2.getTimeInMillis())
            {
                viewModel.updateTvFinalDate(date);
            }

        }
        else if (view.getTag().equals("FinalDate"))
        {
            PersianCalendar calendar = new PersianCalendar();

            String date = year + "-" + (monthOfYear + 1) + "-" + dayOfMonth;
            viewModel.updateTvFinalDate(date);

            this.year_today = year;
            this.month_today = monthOfYear;
            this.day_today = dayOfMonth;

            calendar.set(year_today, month_today, day_today);
            pickerDialogFinalDate.setPersianCalendar(calendar);

            return;
        }
    }
}
