package com.android.shuai.customerview.progress;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * 进度条View
 * Created with Andrid Studio.
 * User:shuaizhimin
 * Date:17/10/22
 * Time:下午4:03
 */
public class NumberProgressView extends View {
    private int mProgress=0;                          //进度显示
    private int mMaxProgress = 100;

    private Paint mLinePaint = new Paint();           //线条Line
    private Paint mTextPaint = new Paint();           //数字Line
    private RectF mRectF = new RectF();
    private RectF mTextRectF=new RectF();


    public NumberProgressView(Context context) {
        this(context, null);
    }

    public NumberProgressView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NumberProgressView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mLinePaint.setAntiAlias(true);
        mLinePaint.setColor(Color.BLUE);

        mTextPaint.setAntiAlias(true);
        mTextPaint.setColor(Color.RED);
        mTextPaint.setTextSize(20);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mRectF.left = getPaddingLeft();
        mRectF.right =(getWidth()-getPaddingLeft()-getPaddingRight())/(mMaxProgress*1.0f)
                *getProgress()+getPaddingLeft();
        mRectF.top = getPaddingTop();
        mRectF.bottom = getHeight() + getPaddingBottom();



        mTextRectF.left = getPaddingLeft();
        mTextRectF.right =(getWidth()-getPaddingLeft()-getPaddingRight())/(mMaxProgress*1.0f)
                *getProgress()+getPaddingLeft();
        mTextRectF.top = getPaddingTop();
        mTextRectF.bottom = getHeight() + getPaddingBottom();



        canvas.drawRect(mRectF, mLinePaint);
        canvas.drawText("20",50,30,mTextPaint);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(measure(widthMeasureSpec), measure(heightMeasureSpec));
    }

    private int measure(int measureSpec) {
        int result;
        //1.获取specMode，注意此时是父类的spec mode
        int mode = MeasureSpec.getMode(measureSpec);
        //获取view的size
        int size = MeasureSpec.getSize(measureSpec);
        int padding = getPaddingLeft() + getPaddingRight();
        if (mode == MeasureSpec.EXACTLY) {
            // 父容器已经测量出具体大小(Layout.MatchParent/多少dp)
            result = size;
        } else {
            result = getSuggestedMinimumWidth();
            result += padding;
            if (mode == MeasureSpec.AT_MOST) {
                //父容器指定了一个可用大小即SpecSize，View大小不能大于这个值(Layout.wrapcontent)
                result = Math.max(result, size);
            }
        }
        return result;
    }


    public int getProgress() {
        return mProgress;
    }

    public void setProgress(int progress) {
        if (progress <= mMaxProgress && progress >= 0) {
            mProgress = progress;
            invalidate();
        }

    }


    public interface OnProgressBarListener {
        void onProgress(int progress);
    }
}
