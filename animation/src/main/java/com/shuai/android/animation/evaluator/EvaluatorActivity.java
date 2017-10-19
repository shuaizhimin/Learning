package com.shuai.android.animation.evaluator;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.shuai.android.animation.R;

public class EvaluatorActivity extends AppCompatActivity {
    private EvaluatorView mEvaluatorView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluator);
        mEvaluatorView=(EvaluatorView)findViewById(R.id.mEvaluatorView);


        ObjectAnimator animator = ObjectAnimator.ofArgb(mEvaluatorView, "color", 0xffff0000, 0xff00ff00);
        animator.setEvaluator(new ArgbEvaluator());
        animator.start();

    }
}
