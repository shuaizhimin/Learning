package com.android.shuai.customerview.progress;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.shuai.customerview.R;

public class ProgressActivity extends AppCompatActivity {
    private NumberProgressView mProgressView;
    private int i = 0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        mProgressView = (NumberProgressView) findViewById(R.id.mNumberProgress);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (i <= 100) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mProgressView.setProgress(i);
                        }
                    });
                    i++;
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }


}
