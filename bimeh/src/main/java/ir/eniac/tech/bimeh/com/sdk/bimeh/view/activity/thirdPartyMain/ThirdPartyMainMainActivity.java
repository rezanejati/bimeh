package ir.eniac.tech.bimeh.com.sdk.bimeh.view.activity.thirdPartyMain;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import ir.eniac.tech.bimeh.com.sdk.bimeh.BR;
import ir.eniac.tech.bimeh.com.sdk.bimeh.R;
import ir.eniac.tech.bimeh.com.sdk.bimeh.databinding.ActivityThirdPartyBinding;
import ir.eniac.tech.bimeh.com.sdk.bimeh.utility.Tools;
import ir.eniac.tech.bimeh.com.sdk.bimeh.view.activity.thirdPartyInquery.ThirdPartyInqueryActivity;
import ir.eniac.tech.bimeh.com.sdk.bimeh.view.base.BaseActivity;
import ir.eniac.tech.bimeh.com.sdk.bimeh.viewModel.thirdParty.ThirdPartyViewModel;
import library.android.calendar.mohamadamin.persianmaterialdatetimepicker.date.DatePickerDialog;
import library.android.calendar.mohamadamin.persianmaterialdatetimepicker.utils.PersianCalendar;

public class ThirdPartyMainMainActivity extends BaseActivity<ActivityThirdPartyBinding, ThirdPartyViewModel> implements ThirdPartyMainNavigator,
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

        dataBinding.toolbar.findViewById(R.id.imgMenu).setOnClickListener(v -> finish());
        ((TextView) dataBinding.toolbar.findViewById(R.id.tvTitle)).setText("بیمه شخص ثالث");

        initDate();

        subscribeToLiveData();

    }

    private void initDate()
    {
        PersianCalendar calendar = new PersianCalendar();

        pickerDialogCreateDate = DatePickerDialog.newInstance(this,
                calendar.getPersianYear(),
                calendar.getPersianMonth(),
                calendar.getPersianDay()
        );

        pickerDialogFinalDate = DatePickerDialog.newInstance(this,
                calendar.getPersianYear(),
                calendar.getPersianMonth(),
                calendar.getPersianDay() + 1
        );
    }

    @Override
    public int getBindingVariable()
    {
        return BR.viewModel;
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

        if (setError())
        {
            Intent intent = new Intent(this, ThirdPartyInqueryActivity.class);

            startActivity(intent);
        }
    }

    private boolean setError()
    {
        boolean err = true;
        String errMessage = "";

        if (dataBinding.spinnerBrand.getSelectedItemPosition() == 0)
        {
            TextView errorText = (TextView) dataBinding.spinnerBrand.getSelectedView();
            errorText.setError("!");
            errorText.setTextColor(Color.RED);
            errorText.setTextSize(12);
            errorText.setText("یک آیتم را انتخاب کنید!");

            errMessage = errMessage + "برند خودرو، ";
            err = false;
        }
        else
        {
            if (dataBinding.spinnerBrandModel.getSelectedItemPosition() == 0)
            {
                TextView errorText = (TextView) dataBinding.spinnerBrandModel.getSelectedView();
                errorText.setError("!");
                errorText.setTextColor(Color.RED);
                errorText.setTextSize(12);
                errorText.setText("یک آیتم را انتخاب کنید!");

                errMessage = errMessage + "مدل برند خودرو، ";
                err = false;
            }
        }

        if (dataBinding.spinnerCreateDate.getSelectedItemPosition() == 0)
        {
            TextView errorText = (TextView) dataBinding.spinnerCreateDate.getSelectedView();
            errorText.setError("!");
            errorText.setTextColor(Color.RED);
            errorText.setTextSize(12);
            errorText.setText("یک آیتم را انتخاب کنید!");

            errMessage = errMessage + "سال ساخت، ";
            err = false;
        }

        if (dataBinding.spinnerLastCompany.getSelectedItemPosition() == 0)
        {
            TextView errorText = (TextView) dataBinding.spinnerLastCompany.getSelectedView();
            errorText.setError("!");
            errorText.setTextColor(Color.RED);
            errorText.setTextSize(12);
            errorText.setText("یک آیتم را انتخاب کنید!");

            errMessage = errMessage + "بیمه گر قبلی، ";
            err = false;
        }

        if (dataBinding.tvCreateDate.getText().toString().equalsIgnoreCase(""))
        {
            dataBinding.tvCreateDate.setError("تاریخ شروع بیمه نامه نمیتواند خالی باشد!");
            errMessage = errMessage + "تاریخ شروع بیمه نامه، ";
            err = false;
        }
        if (dataBinding.tvFinalDate.getText().toString().equalsIgnoreCase(""))
        {
            dataBinding.tvFinalDate.setError("تاریخ سررسید بیمه نامه نمیتواند خالی باشد!");
            errMessage = errMessage + "تاریخ سررسید بیمه نامه، ";
            err = false;
        }

        int spinnerDamageStatusPos = dataBinding.spinnerDamageStatus.getSelectedItemPosition();
        if (spinnerDamageStatusPos != 2)
        {
            if (dataBinding.spinnerDamageDiscount.getSelectedItemPosition() == 0)
            {
                TextView errorText = (TextView) dataBinding.spinnerDamageDiscount.getSelectedView();
                errorText.setError("!");
                errorText.setTextColor(Color.RED);
                errorText.setTextSize(12);
                errorText.setText("یک آیتم را انتخاب کنید!");

                errMessage = errMessage + "تخفیف عدم خسارت، ";
                err = false;
            }
        }
        if (spinnerDamageStatusPos == 1)
        {
            if (dataBinding.spinnerFinancialDamageCount.getSelectedItemPosition() == 0)
            {
                TextView errorText = (TextView) dataBinding.spinnerFinancialDamageCount.getSelectedView();
                errorText.setError("!");
                errorText.setTextColor(Color.RED);
                errorText.setTextSize(12);
                errorText.setText("یک آیتم را انتخاب کنید!");

                errMessage = errMessage + "تعداد خسارت مالی، ";
                err = false;
            }
            if (dataBinding.spinnerDeathDamageCount.getSelectedItemPosition() == 0)
            {
                TextView errorText = (TextView) dataBinding.spinnerDeathDamageCount.getSelectedView();
                errorText.setError("!");
                errorText.setTextColor(Color.RED);
                errorText.setTextSize(12);
                errorText.setText("یک آیتم را انتخاب کنید!");

                errMessage = errMessage + "تعداد خسارت جانی، ";
                err = false;
            }
        }
        errMessage = errMessage + " نمیتواند خالی باشد!";

        if (!err)
        {
            Tools.showToast(this, errMessage, 0, Tools.LONG_TOAST, R.color.colorRedToast);
        }

        return err;
    }

    @Override
    public void openCreateDatePicker()
    {
//        if (pickerDialogCreateDate.isAdded() || pickerDialogFinalDate.isAdded())
//        {
//            return;
//        }

        pickerDialogCreateDate.setTitle("");
        pickerDialogCreateDate.show(getSupportFragmentManager(), "CreateDate");

        dataBinding.tvCreateDate.setError(null);
        dataBinding.tvFinalDate.setError(null);
    }

    @Override
    public void openFinalDatePicker()
    {
        PersianCalendar calendar = new PersianCalendar();

        calendar.set(year, month, day+1);
        pickerDialogFinalDate.setPersianCalendar(calendar);

        try
        {
            if (year == 0)
            {
                dataBinding.tvFinalDate.setError("تاریخ شروع بیمه نامه نمیتواند خالی باشد!");
                Tools.showToast(this, "ابتدا باید تاریخ شروع بیمه نامه قبلی انتخاب گردد!", 0, Tools.LONG_TOAST, getResources().getColor(R.color.colorRedToast));
            }
            else
            {
                dataBinding.tvFinalDate.setError(null);
                pickerDialogFinalDate.setMinDate(calendar);
                pickerDialogFinalDate.show(getSupportFragmentManager(), "FinalDate");
            }
        }
        catch (NullPointerException e)
        {
            dataBinding.tvFinalDate.setError("تاریخ شروع بیمه نامه نمیتواند خالی باشد!");
            Tools.showToast(this, "ابتدا باید تاریخ شروع بیمه نامه قبلی انتخاب گردد!", 0, Tools.LONG_TOAST, getResources().getColor(R.color.colorRedToast));
        }
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

            String createDate = year + "-" + (monthOfYear + 1) + "-" + dayOfMonth;
            String finalDate = year + "-" + (monthOfYear + 1) + "-" + (dayOfMonth + 1);
            viewModel.updateTvCreateDate(createDate);

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
                viewModel.updateTvFinalDate(finalDate);
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
