package com.android.shuai.customerview;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.shuai.customerview.progress.ProgressActivity;
import com.android.shuai.customerview.pulltorefresh.PullRefreshActivity;
import com.android.shuai.customerview.viewgroup.ZhehangGroup;

public class MainActivity extends AppCompatActivity {
    private Button mRadarScanBtn;
    private Button mProgessBtn;
    private Button mPathBtn;
    private Button mViewGroupBtn;
    private Button mPullToRefreshBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRadarScanBtn=(Button)findViewById(R.id.mRadarScanBtn);
        mProgessBtn=(Button)findViewById(R.id.mProgressBtn);
        mPathBtn=(Button)findViewById(R.id.mPathBtn);
        mViewGroupBtn=(Button)findViewById(R.id.mViewGroupBtn);
        mPullToRefreshBtn=(Button)findViewById(R.id.mPullToRefreshBtn);
        mRadarScanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,RadarScanViewActivity.class));
            }
        });
        mProgessBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ProgressActivity.class));
            }
        });
        mPathBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PathActivity.class));
            }
        });
        mViewGroupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ViewGroupActivity.class));
            }
        });
        mPullToRefreshBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PullRefreshActivity.class));
            }
        });


//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                Looper.prepare();
//
//                Handler mHandler=new Handler(){
//                    @Override
//                    public void handleMessage(Message msg) {
//                        super.handleMessage(msg);
//                    }
//                };
//
//                Looper.loop();//4、启动消息循环
//            }
//        }).start();
    }




}
