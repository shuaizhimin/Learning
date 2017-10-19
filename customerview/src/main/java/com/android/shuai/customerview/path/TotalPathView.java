package com.android.shuai.customerview.path;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created with Andrid Studio.
 * User:shuaizhimin
 * Date:17/10/19
 * Time:下午7:57
 */
public class TotalPathView extends View {
    private Paint mPaint=new Paint();
    //弧度的计算公式 2*Math.PI/360   六边形   2*Math.PI/360*60=Math.PI/3
    private float angle = (float) (Math.PI/3);

    private float radius=600;

    private Path mPath=new Path();
    private Paint mRegionPaint=new Paint();
    private double[] data = {100,60,60,60,100,50,10,20}; //各维度分值

    public TotalPathView(Context context) {
        super(context);
    }

    public TotalPathView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TotalPathView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init(){
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(2);
        mPaint.setStyle(Paint.Style.STROKE);


        mRegionPaint.setAntiAlias(true);
        mRegionPaint.setColor(Color.BLUE);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawRect(canvas);
        drawLine(canvas);
        drawRegion(canvas);
    }

    /**
     *
     * @param canvas
     */
    private void drawRect(Canvas canvas){
        if(canvas==null) return;
        float r = radius/(6-1);
        for(int i=1;i<6;i++){
            mPath.reset();
            float raduis = r*i;//当前半径
            for(int j=0;j<=6;j++) {
                float x = (float) (getWidth() / 2 + raduis * Math.cos(angle * j));
                float y = (float) (getHeight() / 2 + raduis * Math.sin(angle * j));
                if (j == 0) {
                    mPath.moveTo(x, getHeight() / 2);
                } else {
                    mPath.lineTo(x, y);
                }
            }
            mPath.close();//闭合路径
            canvas.drawPath(mPath, mPaint);
        }
    }


    private void drawLine(Canvas canvas){
        if(canvas==null) return;
        for(int i=0;i<6;i++){
            mPath.reset();
            mPath.moveTo(getWidth()/2,getHeight()/2);
            float x = (float) (getWidth()/2+radius*Math.cos(angle*i));
            float y = (float) (getHeight()/2+radius*Math.sin(angle*i));
            mPath.lineTo(x,y);
            canvas.drawPath(mPath,mPaint);
        }
    }

    private void drawRegion(Canvas canvas){
        if(canvas==null) return;
        Path path=new Path();

        mRegionPaint.setAlpha(255);
        for(int i=0;i<6;i++){
            double percent = data[i]/100;
            float x = (float) (getWidth()/2+radius*Math.cos(angle*i)*percent);
            float y = (float) (getHeight()/2+radius*Math.sin(angle*i)*percent);
            if(i==0){
                path.moveTo(x, getHeight()/2);
            }else{
                path.lineTo(x,y);
            }
            //绘制小圆点
            canvas.drawCircle(x,y,10,mRegionPaint);
        }
//        mRegionPaint.setStyle(Paint.Style.STROKE);
//        canvas.drawPath(path, mRegionPaint);
//        mRegionPaint.setAlpha(127);
//        //绘制填充区域
//        mRegionPaint.setStyle(Paint.Style.FILL_AND_STROKE);
//        canvas.drawPath(path, mRegionPaint);
    }


}
