package ir.eniac.tech.bimeh.com.sdk.bimeh.view.activity.main;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ir.eniac.tech.bimeh.com.sdk.bimeh.R;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainBimeh extends AppCompatActivity
{

    protected void attachBaseContext(Context newBase)
    {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bimeh);
    }
}
