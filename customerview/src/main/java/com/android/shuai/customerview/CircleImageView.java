package com.android.shuai.customerview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created with Andrid Studio.
 * User:shuaizhimin
 * Date:17/10/18
 * Time:上午8:19
 */
public class CircleImageView extends View{
    private BitmapShader mBitmapShader;
    private Bitmap mBitmap;
    private Paint mCicleBackgroundPaint=new Paint();   //圆形Paint;
    private Paint mBitmapPaint=new Paint();
    private RectF mDrawableRect;
    private Matrix mMatrix=new Matrix();
    private float mDrawableRadius;

    public CircleImageView(Context context) {
        this(context,null);
    }

    public CircleImageView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CircleImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //init();
    }
    private void init(){
        mBitmap= BitmapFactory.decodeResource(getResources(),R.drawable.ic_img);
        mBitmapShader=new BitmapShader(mBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        mCicleBackgroundPaint.setStyle(Paint.Style.STROKE);
        mCicleBackgroundPaint.setStrokeWidth(3);
        mCicleBackgroundPaint.setAntiAlias(true);
        mCicleBackgroundPaint.setColor(Color.BLUE);
        mDrawableRect=new RectF(0,0,getWidth(),getHeight());

        mDrawableRadius = Math.min(mDrawableRect.height() / 2.0f, mDrawableRect.width() / 2.0f);

        int mBitmapWidth=mBitmap.getWidth();
        int mBitmapHeight=mBitmap.getHeight();
        float scale;
        float dx = 0;
        float dy = 0;
        if (mBitmapWidth * mDrawableRect.height() > mDrawableRect.width() * mBitmapHeight) {
            scale = mDrawableRect.height() / (float) mBitmapHeight;
            dx = (mDrawableRect.width() - mBitmapWidth * scale) * 0.5f;
        } else {
            scale = mDrawableRect.width() / (float) mBitmapWidth;
            dy = (mDrawableRect.height() - mBitmapHeight * scale) * 0.5f;
        }

        mMatrix.setScale(scale, scale);
        mMatrix.postTranslate((int) (dx + 0.5f) + mDrawableRect.left, (int) (dy + 0.5f) + mDrawableRect.top);
        mBitmapShader.setLocalMatrix(mMatrix);

        mBitmapPaint.setAntiAlias(true);
        mBitmapPaint.setShader(mBitmapShader);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(mDrawableRect.centerX(),mDrawableRect.centerY(),mDrawableRadius,mCicleBackgroundPaint);
        canvas.drawCircle(mDrawableRect.centerX(), mDrawableRect.centerY(), mDrawableRadius, mBitmapPaint);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        init();
    }
}
