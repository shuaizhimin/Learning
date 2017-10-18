package com.android.shuai.customerview.matrix;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.android.shuai.customerview.R;

/**
 * Created with Andrid Studio.
 * User:shuaizhimin
 * Date:17/10/18
 * Time:下午3:26
 */
public class MatrixView extends View {
    private Matrix mMatrix;
    private Bitmap mBitmap;
    private Paint mPaint = new Paint();

    public MatrixView(Context context) {
        this(context, null);
    }

    public MatrixView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MatrixView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //init();
    }

    private void init() {
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_img);
        mPaint.setAntiAlias(true);
        mMatrix = new Matrix();
        printMatrix();
        //skewMatrix();
        //scaleMatrix(0.5f, 0.5f);
        //mMatrix.postTranslate((getWidth()-mBitmap.getWidth())/2,(getHeight()-mBitmap.getHeight())/2);
    }

    /**
     * 缩放
     *
     * @param sx 缩放x
     * @param sy 缩放y
     */
    public void scaleMatrix(float sx, float sy) {
        mMatrix.postScale(sx, sy);
        invalidate();
        printMatrix();
    }

    /**
     * 平移
     *
     * @param dx
     * @param dy
     */
    public void translateMatrix(float dx, float dy) {
        mMatrix.postTranslate(dx, dy);
        invalidate();
        printMatrix();
    }

    public void skewMatrix() {
        mMatrix.postSkew(0.2f, 0.2f);
        invalidate();
        printMatrix();
    }

    private void printMatrix() {
        float[] matrixValues = new float[9];
        mMatrix.getValues(matrixValues);
        for (int i = 0; i < 3; ++i) {
            String temp = new String();
            for (int j = 0; j < 3; ++j) {
                temp += matrixValues[3 * i + j] + "\t";
            }
            Log.e(getClass().getSimpleName(), temp);
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(mBitmap, mMatrix, mPaint);
    }
}
