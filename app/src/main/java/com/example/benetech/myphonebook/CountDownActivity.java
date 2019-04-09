package com.example.benetech.myphonebook;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class CountDownActivity extends AppCompatActivity {

    private TextView txtView;
    private long time=10;
    private String text1,text2,text3;
    public  BateryServicer bateryServicer;
    public  Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_down);
        txtView = (TextView)findViewById(R.id.txttime);
        handler.postDelayed(runnable, 1000);        // timeTask
        bateryServicer=new BateryServicer();
        context=this;
    }

    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            time--;
            if(time==9){
                startService(new Intent(context,MusiceService.class));
            }
            String formatLongToTimeStr = formatLongToTimeStr(time);
            String[] split = formatLongToTimeStr.split("：");
            for (int i = 0; i < split.length; i++) {
                if(i==0){
                    text1=split[0];
                }
                if(i==1){
                    text2=split[1];
                }
                if(i==2){
                    text3=split[2]+"秒";
                }
               txtView.setText(text1+text2+text3);
            }
            if(time>0){
                handler.postDelayed(this, 1000);
            }
            if(time==0){
                txtView.setTextSize(50);
                txtView.setText("No overtime, you can come to me");
            }
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    public String formatLongToTimeStr(Long l) {
        int hour = 0;
        int minute = 0;
        int second = 0;
        second = l.intValue() ;
        if (second > 60) {
            minute = second / 60;   //取整
            second = second % 60;   //取余
        }

        if (minute > 60) {
            hour = minute / 60;
            minute = minute % 60;
        }
        String strtime = hour+"："+minute+"："+second;
        return strtime;

    }

    public class BateryServicer extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.e("TAG", "onReceive: 5555555555" );
        }
    }
}
