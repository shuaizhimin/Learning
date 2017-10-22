package com.android.shuai.customerview.pulltorefresh;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.View;

import com.android.shuai.customerview.R;


/**
 * Created with Andrid Studio.
 * User:shuaizhimin
 * Date:17/10/21
 * Time:下午8:37
 */
public class PullAnimationView extends Drawable {
    private static final float SCALE_START_PERCENT = 0.5f;
    private static final int ANIMATION_DURATION = 1000;

    private final static float SKY_RATIO = 0.65f;
    private static final float SKY_INITIAL_SCALE = 1.05f;

    private final static float TOWN_RATIO = 0.22f;
    private static final float TOWN_INITIAL_SCALE = 1.20f;
    private static final float TOWN_FINAL_SCALE = 1.30f;

    private static final float SUN_FINAL_SCALE = 0.75f;
    private static final float SUN_INITIAL_ROTATE_GROWTH = 1.2f;
    private static final float SUN_FINAL_ROTATE_GROWTH = 1.5f;

    private Bitmap mSkyBitmap;       //天空
    private Bitmap mSunBitmap;       //太阳
    private Bitmap mTownBitmap;      //城镇
    private Context mContext;
    private Matrix mMatrix=new Matrix();

    public PullAnimationView(final View parentView) {
        mContext=parentView.getContext();

        parentView.post(new Runnable() {
            @Override
            public void run() {
                initBitmap(parentView.getWidth());
            }
        });
    }

    private void initBitmap(int parentWidth){
        if (parentWidth <= 0) return;
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        mSkyBitmap= BitmapFactory.decodeResource(mContext.getResources(),R.drawable.sky,options);
        mSkyBitmap=Bitmap.createScaledBitmap(mSkyBitmap,parentWidth,(int)(SKY_RATIO*parentWidth),true);
        mSunBitmap= BitmapFactory.decodeResource(mContext.getResources(),R.drawable.sun,options);
        mSunBitmap= Bitmap.createScaledBitmap(mSunBitmap,100,100,true);
        mTownBitmap= BitmapFactory.decodeResource(mContext.getResources(),R.drawable.buildings,options);
        mTownBitmap= Bitmap.createScaledBitmap(mTownBitmap,parentWidth,(int)(TOWN_RATIO*parentWidth),true);
    }



    @Override
    public void draw(Canvas canvas) {
        final int saveCount = canvas.save();
        drawSky(canvas);
        drawTown(canvas);
        drawSun(canvas);
        canvas.restoreToCount(saveCount);
    }

    /**
     * 绘制太阳
     */
    private void drawSun(Canvas canvas) {
        canvas.drawBitmap(mSunBitmap,0,0, null);
    }

    /**
     * 绘制天空
     */
    private void drawSky(Canvas canvas) {
        Matrix matrix = mMatrix;
        matrix.reset();

        canvas.drawBitmap(mSkyBitmap,0,0,null);
    }

    /**
     * 绘制城镇
     */
    private void drawTown(Canvas canvas) {
        canvas.drawBitmap(mTownBitmap,0,0,null);

    }


    @Override
    public void setAlpha(int alpha) {

    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {

    }

    @Override
    public int getOpacity() {
        return 0;
    }
}
