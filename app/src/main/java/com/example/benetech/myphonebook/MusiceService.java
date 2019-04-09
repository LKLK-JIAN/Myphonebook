package com.example.benetech.myphonebook;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MusiceService extends Service {
    public int time=10;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Timer timer=new Timer();
        timer.schedule(task,100,1000);

    }
    TimerTask task=new TimerTask() {
        @Override
        public void run() {
            time--;
                  if(time==6){
                      MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.alarm1);
                      mp.setLooping(true);
                      mp.start();
                      //Toast.makeText(getApplicationContext(),"123",Toast.LENGTH_LONG).show();
                  }
        }
    };
}
