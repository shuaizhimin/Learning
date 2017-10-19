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
 * Time:下午6:17
 */
public class PathView extends View{
    private Paint mPaint=new Paint();


    public PathView(Context context) {
        this(context,null);
    }

    public PathView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public PathView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    private void init(){
        mPaint.setColor(Color.RED);           // 画笔颜色 - 黑色
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);    // 填充模式 - 描边
        mPaint.setStrokeWidth(10);              // 边框宽度 - 10
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(getWidth() / 2, getHeight() / 2);  // 移动坐标系到屏幕中心(宽高数据在onSizeChanged中获取)

        Path path = new Path();                     // 创建Path


//        path.lineTo(200, 200);                      // lineTo
//        path.setLastPoint(200,100);                 // moveTo
//        path.lineTo(200,0);                         // lineTo

        //绘制圆 Path.Direction.CW 方向 顺时针
       // path.addOval(-200,-200,200,200, Path.Direction.CW);
        path.addRect(-200,-200,200,200, Path.Direction.CW);
        path.setLastPoint(-300,300);                // <-- 重置最后一个点的位置

        canvas.drawPath(path, mPaint);              // 绘制Path

    }



}
