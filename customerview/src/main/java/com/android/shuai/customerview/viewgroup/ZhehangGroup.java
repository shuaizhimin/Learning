package com.android.shuai.customerview.viewgroup;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created with Andrid Studio.
 * User:shuaizhimin
 * Date:17/10/19
 * Time:下午10:42
 */
public class ZhehangGroup extends ViewGroup {
    private final static int VIEW_MARGIN = 2;

    public ZhehangGroup(Context context) {
        super(context);
    }

    public ZhehangGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ZhehangGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        for (int index = 0; index < getChildCount(); index++) {
            final View child = getChildAt(index);
            // measure
            child.measure(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED);
        }

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        final int count = getChildCount();
        int row = 0;// which row lay you view relative to parent
        int lengthX = l;    // right position of child relative to parent
        int lengthY = t;    // bottom position of child relative to parent
        for (int i = 0; i < count; i++) {
            final View child = this.getChildAt(i);
            int width = child.getMeasuredWidth();
            int height = child.getMeasuredHeight();
            lengthX += width + VIEW_MARGIN;
            lengthY = row * (height + VIEW_MARGIN) + VIEW_MARGIN + height + t;
            //if it can't drawing on a same line , skip to next line
            if (lengthX > r) {
                lengthX = width + VIEW_MARGIN + l;
                row++;
                lengthY = row * (height + VIEW_MARGIN) + VIEW_MARGIN + height + t;
            }
            child.layout(lengthX - width, lengthY - height, lengthX, lengthY);
        }

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }


}
