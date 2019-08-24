package ir.eniac.tech.bimeh.com.sdk.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.pixplicity.easyprefs.library.Prefs;

public class MainActivity extends AppCompatActivity
{

    private Button buttonl;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Prefs.putString("insuranceToken", "da4aa2f8-70d9-4d56-b577-3162dfae2c0f");

        buttonl = findViewById(R.id.buttonl);
        buttonl.setOnClickListener(v ->
        {
            startActivity(new Intent(this, MainBimeh.class));
        });
    }
}
