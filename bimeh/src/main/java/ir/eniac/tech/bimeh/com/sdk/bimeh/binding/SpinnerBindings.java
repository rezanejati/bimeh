package ir.eniac.tech.bimeh.com.sdk.bimeh.binding;

import android.databinding.BindingAdapter;
import android.databinding.InverseBindingAdapter;
import android.support.v7.widget.AppCompatSpinner;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

public class SpinnerBindings
{
////    @BindingAdapter("bind:entries")
//    public static void setSpinnerEntries(Spinner spinner, View view)
//    {
//
//    }

    @BindingAdapter(value = "bind:onItemSelected")
    public static void setSpinnerItemPos(Spinner spinner, View view, int position, long id)
    {
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });
    }
    @InverseBindingAdapter(attribute = "bind:onItemSelected")
    public static String getSelectedValue(Spinner spinner)
    {
        return (String) spinner.getSelectedItem();
    }
}
