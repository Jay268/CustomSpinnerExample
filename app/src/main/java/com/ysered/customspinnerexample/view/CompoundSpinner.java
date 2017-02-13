package com.ysered.customspinnerexample.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.ysered.customspinnerexample.R;

public class CompoundSpinner extends FrameLayout {
    private static final String TAG = CompoundSpinner.class.getSimpleName();

    private boolean isSelected = false;
    private TextView placeholderText;
    private Spinner spinner;
    private SpinnerEditText spinnerEditText;

    public CompoundSpinner(Context context) {
        super(context);
        init();
    }

    public CompoundSpinner(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CompoundSpinner(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public String getSelectedItemText() {
        String text = null;
        final boolean isPlaceholderShown = placeholderText.getVisibility() != VISIBLE;
        if (!isPlaceholderShown && spinnerEditText.getVisibility() == VISIBLE) {
            text = spinnerEditText.getText().toString();
        } else if (!isPlaceholderShown && spinner.getVisibility() == VISIBLE) {
            text = spinner.getSelectedItem().toString();
        }
        return text;
    }

    private void init() {
        final View view = inflate(getContext(), R.layout.view_compound_spinner, this);
        placeholderText = (TextView) view.findViewById(R.id.placeholderText);
        placeholderText.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                placeholderText.setVisibility(INVISIBLE);
                spinner.setVisibility(VISIBLE);
                spinner.performClick();
            }
        });
        spinner = (Spinner) view.findViewById(R.id.spinner);
        spinnerEditText = (SpinnerEditText) view.findViewById(R.id.spinnerEditText);
        spinnerEditText.setOnClickListener(new SpinnerEditText.OnClickListener() {
            @Override
            public void onClick(EditText editText) {
                editText.setVisibility(INVISIBLE);
                spinner.performClick();
            }
        });
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0 && !isSelected) {
                    placeholderText.setVisibility(VISIBLE);
                    spinner.setVisibility(INVISIBLE);
                } else {
                    isSelected = true;
                    if (position == parent.getCount() - 1) {
                        spinnerEditText.setVisibility(VISIBLE);
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
