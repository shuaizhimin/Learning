package com.shuai.android.app;

import android.app.IntentService;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created with Andrid Studio.
 * User:shuaizhimin
 * Date:17/10/23
 * Time:下午11:31
 */
public class CIntentService extends IntentService {
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public CIntentService() {
        super("CIntentService");
        Log.e("IntentService", "CIntentService");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return super.onBind(intent);
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Log.e("IntentService", "onStart");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        DateFormat format = DateFormat.getTimeInstance();
        Log.e("IntentService", "onHandleIntent开始:" + format.format(new Date()));
        String stringExtra = intent.getStringExtra("content");
        Log.e("IntentService", "onHandleIntent:" + stringExtra);
    }
}
