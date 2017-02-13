package com.ysered.customspinnerexample.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

import com.ysered.customspinnerexample.R;

public class SpinnerEditText extends EditText {
    private static final String TAG = SpinnerEditText.class.getSimpleName();

    private static final int DRAWABLE_RIGHT = 2;
    private Drawable arrowDrawable;
    private OnClickListener onClickListener;

    public SpinnerEditText(Context context) {
        super(context);
        init();
    }

    public SpinnerEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SpinnerEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    private void init() {
        arrowDrawable = ContextCompat.getDrawable(getContext(), R.drawable.ic_arrow_drop_down);
        setCompoundDrawables(null, null, arrowDrawable, null);
        setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP) {
                    if(event.getRawX() >= (getRight() - getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                        Log.d(TAG, "onTouch: touched on drawable");
                        if (onClickListener != null) {
                            onClickListener.onClick(SpinnerEditText.this);
                        }
                        return true;
                    }
                }
                return false;
            }
        });
    }

    public interface OnClickListener {
        void onClick(EditText editText);
    }
}
