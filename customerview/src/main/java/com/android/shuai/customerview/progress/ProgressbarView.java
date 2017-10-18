package com.android.shuai.customerview.progress;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;

/**
 *
 * 圆形进度条
 * Created with Andrid Studio.
 * User:shuaizhimin
 * Date:17/10/18
 * Time:下午12:26
 */
public class ProgressbarView extends View{
    private RectF mRectF;
    private Paint mPaint=new Paint();
    private Paint mTextPaint=new Paint();
    private SweepGradient mSweepGradient;
    private int[] colors = new int[]{Color.GREEN, Color.YELLOW, Color.RED, Color.RED};

    public ProgressbarView(Context context) {
        this(context,null);
    }

    public ProgressbarView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ProgressbarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    private void init(){
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(20);
        mPaint.setColor(Color.RED);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mRectF=new RectF(40,40,300,300);

        mTextPaint.setAntiAlias(true);
        mTextPaint.setTextSize(50);
        mTextPaint.setColor(Color.BLACK);
        mTextPaint.setTextAlign(Paint.Align.CENTER);


        mSweepGradient=new SweepGradient(mRectF.centerX(),mRectF.centerY(),colors,null);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        init();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //设置渐变色
        Matrix rotateMatrix=new Matrix();
        rotateMatrix.setRotate(130, mRectF.centerX(), mRectF.centerY());
        mSweepGradient.setLocalMatrix(rotateMatrix);
        mPaint.setShader(mSweepGradient);

        canvas.drawArc(mRectF,-90,180,false,mPaint);
        canvas.drawText("20", mRectF.centerX(), mRectF.centerY(), mTextPaint);
    }
}
