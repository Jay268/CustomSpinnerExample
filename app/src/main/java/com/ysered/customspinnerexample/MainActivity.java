package com.ysered.customspinnerexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.ysered.customspinnerexample.view.CompoundSpinner;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private CompoundSpinner spinner;
    private TextView errorsText;
    private Button validateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (CompoundSpinner) findViewById(R.id.compoundSpinner);
        errorsText = (TextView) findViewById(R.id.errorsText);
        validateButton = (Button) findViewById(R.id.validateButton);

        validateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String text = spinner.getSelectedItemText();
                Log.d(TAG, "Selected text: " + text);
                if (text == null) {
                    errorsText.setVisibility(View.VISIBLE);
                    errorsText.setText(getString(R.string.error_select_item));
                } else if (text.isEmpty()) {
                    errorsText.setVisibility(View.VISIBLE);
                    errorsText.setText(getString(R.string.error_enter_text));
                } else {
                    errorsText.setVisibility(View.GONE);
                }
            }
        });
    }
}
