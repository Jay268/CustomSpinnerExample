package com.ysered.customspinnerexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner) findViewById(R.id.spinner);
        final String[] items = getResources().getStringArray(R.array.spinner_items);
        final SpinnerAdapter adapter = new SpinnerAdapter(this, items);
        spinner.setAdapter(adapter);
    }
}
