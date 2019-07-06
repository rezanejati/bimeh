package ir.eniac.tech.bimeh.com.sdk.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import ir.eniac.tech.bimeh.com.sdk.bimeh.view.activity.main.MainBimeh;

public class MainActivity extends AppCompatActivity
{

    private Button buttonl;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonl = findViewById(R.id.buttonl);
        buttonl.setOnClickListener(v ->
        {
            startActivity(new Intent(this, MainBimeh.class));
        });
    }
}
