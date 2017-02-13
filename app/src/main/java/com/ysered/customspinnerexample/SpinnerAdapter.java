package com.ysered.customspinnerexample;

import android.content.Context;
import android.widget.ArrayAdapter;

/**
 * Spinner adapter.
 */
public class SpinnerAdapter extends ArrayAdapter<String> {

    public SpinnerAdapter(Context context, String[] items) {
        super(context, android.R.layout.simple_spinner_item, items);
        setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    }
}
