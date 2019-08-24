package ir.eniac.tech.bimeh.com.sdk.bimeh.view.base;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class BaseViewHolder extends RecyclerView.ViewHolder
{
    public BaseViewHolder(@NonNull View itemView)
    {
        super(itemView);
    }

    public abstract void onBind(int position);
}
