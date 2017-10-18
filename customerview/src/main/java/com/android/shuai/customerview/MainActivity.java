package com.android.shuai.customerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.shuai.customerview.progress.ProgressActivity;

public class MainActivity extends AppCompatActivity {
    private Button mRadarScanBtn;
    private Button mProgessBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRadarScanBtn=(Button)findViewById(R.id.mRadarScanBtn);
        mProgessBtn=(Button)findViewById(R.id.mProgressBtn);
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
    }




}
