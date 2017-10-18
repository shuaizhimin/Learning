package com.android.shuai.customerview;

import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

/**
 * Created with Andrid Studio.
 * User:shuaizhimin
 * Date:17/10/17
 * Time:下午6:28
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class AgreeView extends View {
    private int middleX;
    private int topY=0;
    private int middleY=0;
    private int bottomY=0;
    private Bitmap unSelectBitmap;
    private Bitmap selectBitmap;
    private Bitmap selectShinBitmap;
    private ObjectAnimator bitmapAnimator= ObjectAnimator.ofFloat(this,"scale",1,0.8f,1.2f,1);

    public AgreeView(Context context) {
        this(context,null);
    }

    public AgreeView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public AgreeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    private void init(){
        bitmapAnimator.setDuration(300);
        bitmapAnimator.setInterpolator(new LinearInterpolator());
        unSelectBitmap= BitmapFactory.decodeResource(getResources(),R.drawable.ic_messages_like_unselected);
        selectBitmap=BitmapFactory.decodeResource(getResources(),R.drawable.ic_messages_like_selected);
        selectShinBitmap=BitmapFactory.decodeResource(getResources(),R.drawable.ic_messages_like_selected_shining);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        middleX=getWidth()/2;
        middleY=getHeight()/2;
        int bitmapWidth=unSelectBitmap.getWidth();
        int bitmapHeight=unSelectBitmap.getHeight();
        int drawBitmapWidth=middleX-100;
        int drawBitmapHeight=middleY-70;

        canvas.scale(1.0f,1.0f,drawBitmapWidth+bitmapWidth/2,drawBitmapHeight+bitmapHeight/2);

        canvas.drawBitmap(selectBitmap,drawBitmapWidth,drawBitmapHeight,new Paint());
    }
}
