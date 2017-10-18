package com.shuai.android.animation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class AnimationActivity extends AppCompatActivity {
    private ImageView mImageView;
    private Button mButton;

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        mImageView = (ImageView) findViewById(R.id.image);
        mImageView.setVisibility(View.GONE);
        mButton = (Button) findViewById(R.id.btn);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mImageView.setVisibility(View.VISIBLE);
                //ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mImageView, "translationX", 0f, 200f);
                //afterAnimatorSet(objectAnimator, mImageView);
                propertyValueHolder();
            }
        });

    }


    /**
     * after(Animator anim)  将现有动画插入到传入的动画之后执行
     *
     * @param animator 传入的动画
     * @param view
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void afterAnimatorSet(ObjectAnimator animator, View view) {
        ObjectAnimator rotate = ObjectAnimator.ofFloat(view, "scaleY", 0.5f, 1f);
        AnimatorSet animSet = new AnimatorSet();
        //animSet.play(rotate).with(animator);
        animSet.playSequentially(rotate,animator);
        animSet.setDuration(2000);
        animSet.start();
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
    private void propertyValueHolder(){
        mImageView.animate()
                .scaleX(2)
                .scaleY(2)
                .translationX(300)
                .alpha(1);
    }
}
