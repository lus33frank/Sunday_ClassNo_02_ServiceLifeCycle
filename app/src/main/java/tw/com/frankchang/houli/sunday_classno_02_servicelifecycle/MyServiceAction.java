package tw.com.frankchang.houli.sunday_classno_02_servicelifecycle;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by 張景翔 on 2017/4/30.
 */

public class MyServiceAction extends Service {

    private Timer timer;
    private int values;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public MyServiceAction(){
        timer = new Timer();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        MyTimerTask task = new MyTimerTask();
        timer.schedule(task, 1000, 1000);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Bundle bundle = intent.getExtras();
        values = bundle.getInt(getString(R.string.bundle_01), -1);

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        timer.cancel();
    }

    private class MyTimerTask extends TimerTask{

        @Override
        public void run() {
            values++;
            Log.d("Frank", "value:" + values);
        }
    }
}
