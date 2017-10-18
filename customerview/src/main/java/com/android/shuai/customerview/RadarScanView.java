package com.android.shuai.customerview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created with Andrid Studio.
 * User:shuaizhimin
 * Date:17/10/18
 * Time:下午12:32
 */
public class RadarScanView extends View {
    private Paint mCirclePaint=new Paint();            //圆形View
    private Paint mRadarPaint=new Paint();
    private RectF mRectF;
    private float mRadus=160;
    private Matrix mMatrix;
    private int start;

    private int circleColor = Color.parseColor("#a2a2a2");
    private int radarColor = Color.parseColor("#99a2a2a2");
    private int tailColor = Color.parseColor("#50aaaaaa");
    private Handler handler = new Handler();
    private Runnable run = new Runnable()
    {
        @Override
        public void run()
        {
            start+=2;
            mMatrix = new Matrix();
            mMatrix.postRotate(start, mRectF.centerX(), mRectF.centerY());
            postInvalidate();
            handler.postDelayed(run, 10);
        }
    };

    public RadarScanView(Context context) {
        this(context,null);
    }

    public RadarScanView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public RadarScanView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    private void init(){
        mRectF=new RectF(0,0,getWidth(),getHeight());
        mCirclePaint.setStyle(Paint.Style.STROKE);
        mCirclePaint.setColor(circleColor);
        mCirclePaint.setAntiAlias(true);
        mCirclePaint.setStrokeWidth(2);


        //mCirclePaint.setStyle(Paint.Style.FILL);
        mCirclePaint.setColor(radarColor);
        mCirclePaint.setAntiAlias(true);

        mMatrix=new Matrix();
        handler.post(run);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(mRectF.centerX(),mRectF.centerY(),mRadus,mCirclePaint);
        canvas.drawCircle(mRectF.centerX(),mRectF.centerY(),mRadus*2,mCirclePaint);
        canvas.drawCircle(mRectF.centerX(),mRectF.centerY(),mRadus*3,mCirclePaint);
        canvas.drawCircle(mRectF.centerX(),mRectF.centerY(),mRadus*4,mCirclePaint);

        Shader shader = new SweepGradient(mRectF.centerX(),mRectF.centerY(), Color.parseColor("#00A8D7A7"),
                Color.parseColor("#ffA8D7A7"));
        mRadarPaint.setShader(shader);
        canvas.concat(mMatrix);
        canvas.drawCircle(mRectF.centerX(),mRectF.centerY(), mRadus*4, mRadarPaint);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        init();
    }
}
