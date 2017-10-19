package com.shuai.android.animation;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.shuai.android.animation.evaluator.EvaluatorActivity;


public class MainActivity extends AppCompatActivity {
    private Button mEvaluatorBtn;



    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEvaluatorBtn=(Button)findViewById(R.id.mEvaluatorBtn);
        mEvaluatorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, EvaluatorActivity.class));
            }
        });
    }
}
