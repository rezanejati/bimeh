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

public class SpinnerArrayAdapter extends ArrayAdapter<String>
{
    private Context context;
    private List<String> list;

    public SpinnerArrayAdapter(@NonNull Context context, @SuppressLint("SupportAnnotationUsage") @LayoutRes ArrayList<String> list)
    {
        super(context, 0, list);
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        View listItem = convertView;

        if(listItem == null)
        {
            listItem = LayoutInflater.from(context).inflate(R.layout.my_spinner_item,parent,false);
        }

        return listItem;
    }
}
