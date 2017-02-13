package com.ysered.customspinnerexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner) findViewById(R.id.spinner);
        final String[] items = getResources().getStringArray(R.array.spinner_items);
        spinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items));
    }
}
