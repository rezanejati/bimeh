package ir.eniac.tech.bimeh.com.sdk.bimeh.utility.font;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.widget.TextView;

import ir.eniac.tech.bimeh.com.sdk.bimeh.R;


/**
 * Created by JavadAbadi on 7/2/2018.
 */

public class TextField extends AppCompatTextView
{

    public TextField(final Context context, final AttributeSet attrs) {
        super(context, attrs, R.attr.fontPathCalligraphyConfig);
    }

}
