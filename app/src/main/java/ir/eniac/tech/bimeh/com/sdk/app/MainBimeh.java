package ir.eniac.tech.bimeh.com.sdk.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import ir.eniac.tech.bimeh.com.sdk.bimeh.view.activity.thirdPartyMain.ThirdPartyMainMainActivity;

public class MainBimeh extends AppCompatActivity
{

    private RelativeLayout layThirdParty;
    private Toolbar mToolbar;
    private TextView tvTitle;
    private ImageButton btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_insurance);
        //Adapter layout is R.layout.adapter_main_insurance.xml

        mToolbar = findViewById(R.id.toolbar);
        layThirdParty = findViewById(R.id.layThirdParty);
        btnBack = mToolbar.findViewById(R.id.imgMenu);
        tvTitle = mToolbar.findViewById(R.id.tvTitle);

        tvTitle.setText("بیمه");
        btnBack.setOnClickListener(v -> finish());

        layThirdParty.setOnClickListener(v ->
        {
            startActivity(new Intent(this, ThirdPartyMainMainActivity.class));
        });

    }
}
