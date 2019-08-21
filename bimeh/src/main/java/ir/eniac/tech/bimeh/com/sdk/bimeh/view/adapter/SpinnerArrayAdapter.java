package ir.eniac.tech.bimeh.com.sdk.bimeh.view.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Movie;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import ir.eniac.tech.bimeh.com.sdk.bimeh.R;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.model.thirdPartyFirstAPI.other.BrandList;

public class SpinnerArrayAdapter extends ArrayAdapter {

    public SpinnerArrayAdapter(Context context, int textViewResourceId,
                               List<BrandList> lis) {
        super(context, textViewResourceId, lis);
    }

    public View getCustomView(int position, View convertView,
                              ViewGroup parent) {
        BrandList rowItem = (BrandList) getItem(position);
        getItem(position);
        LayoutInflater inflater =(LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);;
        View layout = inflater.inflate(R.layout.my_spinner_item, parent, false);





        return layout;
    }

    // It gets a View that displays in the drop down popup the data at the specified position
    @Override
    public View getDropDownView(int position, View convertView,
                                ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    // It gets a View that displays the data at the specified position
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }
}





