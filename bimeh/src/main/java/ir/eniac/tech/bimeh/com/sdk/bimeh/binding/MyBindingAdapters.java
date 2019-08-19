package ir.eniac.tech.bimeh.com.sdk.bimeh.binding;

import android.databinding.BindingAdapter;
import android.databinding.InverseBindingAdapter;
import android.databinding.InverseBindingListener;
import android.support.v7.widget.AppCompatSpinner;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import ir.eniac.tech.bimeh.com.sdk.bimeh.R;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.model.thirdPartyBrandModelList.others.CarModelList;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.model.thirdPartyFirstAPI.other.ItemsList;
import ir.eniac.tech.bimeh.com.sdk.bimeh.utility.Logger;
import ir.eniac.tech.bimeh.com.sdk.bimeh.viewModel.thirdParty.SpinnerBrandChangeListener;

public class MyBindingAdapters
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

    @BindingAdapter("bind:modelAdapter")
    public static void setModelAdapter(AppCompatSpinner spinner, List<CarModelList> list)
    {
        List<String> listStr =  new ArrayList<>();
        for (CarModelList item: list)
        {
            listStr.add(item.getModelName());
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(spinner.getContext(), R.layout.my_spinner_item, listStr);
        arrayAdapter.setDropDownViewResource(R.layout.my_spinner_textview);

        spinner.setSelection(0);
        spinner.setGravity(View.TEXT_ALIGNMENT_CENTER);
        spinner.setAdapter(arrayAdapter);
    }

//    @BindingAdapter("bind:onSelectChange")
//    @BindingAdapter(value = {"bind:onSelectChange", "spinnerBrandChangeListener"})
//    public static void setOnSelectChanged(AppCompatSpinner spinner, Integer brandPosition, final SpinnerBrandChangeListener spinnerBrandChangeListener)
//    {
//        Logger.e("-bind:onSelectChange-", "spinnerBrandChangeListener");
//        if (spinnerBrandChangeListener != null)
//        {
//            if (spinner.getId() == R.id.spinnerBrand)
//            {
//                int pos = spinner.getSelectedItemPosition();
//                if (pos != 0)
//                {
//                    spinnerBrandChangeListener.onBrandChange(pos);
//                }
//            }
//        }
//
//    }

    @BindingAdapter(value = {"bind:selectedPosition", "selectedPositionAttrChanged"}, requireAll = false)
    public static void bindSpinnerData(AppCompatSpinner spinner, Integer newSelectedPosition,
                                       final InverseBindingListener newTextAttrChanged)
    {
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                newTextAttrChanged.onChange();
                spinner.setSelection(position, true);

                Logger.e("--spinnerBrand ID--", "ID: " + R.id.spinnerBrand);
                Logger.e("--spinner ID--", "ID: " + spinner.getId());

//                if (spinnerBrandChangeListener != null)
//                {
//                    if (spinner.getId() == R.id.spinnerBrand)
//                    {
//                        spinnerBrandChangeListener.onBrandChange(position);
//                    }
//                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            { }
        });

//        if (newSelectedValue != null)
//        {
//            int position = ((ArrayAdapter<String>) spinner.getAdapter()).getPosition(newSelectedValue);
//            spinner.setSelection(position, true);
//        }
    }

    @InverseBindingAdapter(attribute = "bind:selectedPosition", event = "selectedPositionAttrChanged")
    public static Integer captureSelectedValue(AppCompatSpinner spinner)
    {
        int pos = spinner.getSelectedItemPosition();
        Logger.e("--brand Pos changed--", "Spinner Pos = " + pos);

        return pos;
    }

//    @InverseBindingAdapter(attribute = "bind:selectedPosition", event = "spinnerBrandChangeListener")
//    public static Integer setOnSpinnerBrandChanged(AppCompatSpinner spinner)
//    {
//        int pos = spinner.getSelectedItemPosition();
//        Logger.e("--position--", "Spinner Pos = " + pos);
//
//        return pos;
//    }


    @BindingAdapter("bind:visible")
    public static void setVisibility(View view, Boolean isVisible)
    {
        view.setVisibility(isVisible ? View.VISIBLE : View.GONE);
    }

    @BindingAdapter("bind:activate")
    public static void setActivate(View view, Boolean isActive)
    {
        view.setActivated(isActive);
        view.setEnabled(isActive);
        view.setAlpha(isActive ? 1f : 0.5f);

        if (view.getId() == R.id.spinnerBrandModel)
        {
            view.setVisibility(isActive ? View.VISIBLE : View.INVISIBLE);
        }
    }


}
