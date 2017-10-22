package com.android.shuai.customerview.pulltorefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created with Andrid Studio.
 * User:shuaizhimin
 * Date:17/10/21
 * Time:下午10:01
 */
public class PullAnimationGroup extends ViewGroup {
    private ImageView mPullAnimationView;

    public PullAnimationGroup(Context context) {
        this(context, null);
    }

    public PullAnimationGroup(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PullAnimationGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mPullAnimationView = new ImageView(getContext());
        mPullAnimationView.setImageDrawable(new PullAnimationView(PullAnimationGroup.this));
        addView(mPullAnimationView);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        widthMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredWidth() - getPaddingRight() - getPaddingLeft(), MeasureSpec.EXACTLY);
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), MeasureSpec.EXACTLY);
        mPullAnimationView.measure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int height = getMeasuredHeight();
        int width = getMeasuredWidth();
        int left = getPaddingLeft();
        int top = getPaddingTop();
        int right = getPaddingRight();
        int bottom = getPaddingBottom();
        mPullAnimationView.layout(left, top, left + width - right, top + height - bottom);
    }
}
