package ir.eniac.tech.bimeh.com.sdk.bimeh.view.activity.thirdPartyInquery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ir.eniac.tech.bimeh.com.sdk.bimeh.R;

public class ThirdPartyInqueryActivity extends AppCompatActivity implements ThirdPartyInqueryNavigator
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_party_inquery);
    }

    @Override
    public void openThirdPartyFillUserSpecActivity()
    {

    }
}
