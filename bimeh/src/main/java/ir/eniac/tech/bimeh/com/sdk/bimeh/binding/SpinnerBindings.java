package ir.eniac.tech.bimeh.com.sdk.bimeh.binding;

import android.databinding.BindingAdapter;
import android.databinding.InverseBindingAdapter;
import android.support.v7.widget.AppCompatSpinner;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import ir.eniac.tech.bimeh.com.sdk.bimeh.R;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.model.thirdPartyFirstAPI.other.ItemsList;

public class SpinnerBindings
{
////    @BindingAdapter("bind:entries")
//    public static void setSpinnerEntries(Spinner spinner, View view)
//    {
//
//    }

//    @BindingAdapter(value = "bind:onItemSelected")
//    public static void setSpinnerItemPos(Spinner spinner, View view, int position, long id)
//    {
//        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
//        {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
//            {
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent)
//            {
//
//            }
//        });
//    }

//    @InverseBindingAdapter(attribute = "bind:onItemSelected")
//    public static String getSelectedValue(Spinner spinner)
//    {
//        return (String) spinner.getSelectedItem();
//    }

    @BindingAdapter("bind:my_adapter")
    public static void setAdapter(AppCompatSpinner spinner, List<ItemsList> list)
    {
        List<String> listStr =  new ArrayList<>();
        for (ItemsList item: list)
        {
            listStr.add(item.getText());
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(spinner.getContext(), R.layout.my_spinner_item, listStr);
        arrayAdapter.setDropDownViewResource(R.layout.my_spinner_textview);

        spinner.setSelection(0);
        spinner.setGravity(View.TEXT_ALIGNMENT_CENTER);
        spinner.setAdapter(arrayAdapter);
    }

    @BindingAdapter("bind:visibile")
    public static void setVisiblity(View view, Boolean isVisible)
    {
        view.setVisibility(isVisible ? View.VISIBLE : View.GONE);
    }

    @BindingAdapter("bind:activate")
    public static void setActivate(View view, Boolean isActive)
    {
        view.setActivated(isActive);
        view.setEnabled(isActive);
        view.setAlpha(isActive ? 1f : 0.5f);
    }


}
