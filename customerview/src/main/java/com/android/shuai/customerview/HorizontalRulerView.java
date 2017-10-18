package com.android.shuai.customerview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 横向刻度尺
 * Created with Andrid Studio.
 * User:shuaizhimin
 * Date:17/10/16
 * Time:下午11:27
 */
public class HorizontalRulerView extends View {


    public interface OnValueChangeListener {
        public void onValueChange(float value);
    }

    public HorizontalRulerView(Context context) {
        super(context);
    }

    public HorizontalRulerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HorizontalRulerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }



}

