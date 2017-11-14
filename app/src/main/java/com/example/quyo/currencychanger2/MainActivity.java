package com.example.quyo.currencychanger2;

//import android.icu.text.DecimalFormat;
//import android.icu.text.NumberFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    double conversionRate = .76;
    double measurmentEntered = 0.0;
    double convertedMeasurment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        final EditText measure = (EditText) findViewById(R.id.dollarAmount);
        final RadioButton ausToUs = (RadioButton) findViewById(R.id.ausTo);
        final RadioButton  usToAus= (RadioButton) findViewById(R.id.usTo);
        final TextView result = (TextView) findViewById(R.id.result);
        Button convert = (Button) findViewById(R.id.convertBtn);

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                measurmentEntered = Double.parseDouble(measure.getText().toString());
                DecimalFormat tenth = new DecimalFormat();
                if (ausToUs.isChecked()) {
                    convertedMeasurment = measurmentEntered * conversionRate;
                    result.setText(tenth.format(convertedMeasurment) + " U.S. Dollars");
                }
                if(usToAus.isChecked()){
                    convertedMeasurment = measurmentEntered / conversionRate;
                    result.setText(tenth.format(convertedMeasurment) + " Austrlian Dollars");
                }
            }
        });
    }
}
