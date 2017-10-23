package com.shuai.android.app;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created with Andrid Studio.
 * User:shuaizhimin
 * Date:17/10/24
 * Time:上午12:31
 */
public class CommonService extends Service{
    @Override
    public void onCreate() {
        super.onCreate();

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("CommonService","onStartCommand");
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Log.e("CommonService","睡眠");
                    Thread.sleep(60000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


        return super.onStartCommand(intent, flags, startId);
    }
}
