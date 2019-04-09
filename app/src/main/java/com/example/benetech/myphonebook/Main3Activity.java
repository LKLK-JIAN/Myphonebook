package com.example.benetech.myphonebook;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener {

    private Button on, off;
    private NotificationManager notificationManager = null;
    private Notification myNotification;
    private static final int NOTIFICATION_ID_1 = 1;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        //取消标题栏

        //由于主要是用于测试，并且便于新手理解，所以activity_main布局写的很简单
        setContentView(R.layout.activity_main);

        notificationManager  = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        context=getApplicationContext();

        on = findViewById(R.id.on);
        off = findViewById(R.id.off);
        on.setOnClickListener(this);
        off.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在Activity被关闭后，关闭Service

    }

    @Override
    public void onClick(View v) {
       switch(v.getId()){
           case R.id.on:
//               PendingIntent pi = PendingIntent.getActivity(
//                       getApplicationContext(),
//                       100,
//                       new Intent(context, Main3Activity.class),
//                       PendingIntent.FLAG_CANCEL_CURRENT
//               );
//
//               //2.通过Notification.Builder来创建通知
//               Notification.Builder myBuilder = new Notification.Builder(context);
//               myBuilder.setContentTitle("QQ")
//                       .setContentText("这是内容")
//                       .setSubText("这是补充小行内容")
//                       .setTicker("您收到新的消息")
//                       //设置状态栏中的小图片，尺寸一般建议在24×24，这个图片同样也是在下拉状态栏中所显示
//                       .setSmallIcon(R.mipmap.ic_launcher)
//
//                       //设置默认声音和震动
//                       .setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_VIBRATE)
//                       .setAutoCancel(true)//点击后取消
//                       .setWhen(System.currentTimeMillis())//设置通知时间
//                       .setPriority(Notification.PRIORITY_HIGH)//高优先级
//                       //android5.0加入了一种新的模式Notification的显示等级，共有三种：
//                       //VISIBILITY_PUBLIC  只有在没有锁屏时会显示通知
//                       //VISIBILITY_PRIVATE 任何情况都会显示通知
//                       //VISIBILITY_SECRET  在安全锁和没有锁屏的情况下显示通知
//                       .setContentIntent(pi);  //3.关联PendingIntent
//               myNotification = myBuilder.build();
//               //4.通过通知管理器来发起通知，ID区分通知
//               myManager.notify(NOTIFICATION_ID_1, myNotification);

               String id = "my_channel_01";
               String name="我是渠道名字";
               notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
               Notification notification = null;
               if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                   NotificationChannel mChannel = new NotificationChannel(id, name, NotificationManager.IMPORTANCE_LOW);
                   Toast.makeText(this, mChannel.toString(), Toast.LENGTH_SHORT).show();

                   notificationManager.createNotificationChannel(mChannel);
                   notification = new Notification.Builder(this)
                           .setChannelId(id)
                           .setContentTitle("5 new messages")
                           .setContentText("hahaha")
                           .setSmallIcon(R.mipmap.ic_launcher).build();
               } else {
                   NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                           .setContentTitle("5 new messages")
                           .setContentText("hahaha")
                           .setSmallIcon(R.mipmap.ic_launcher)
                           .setOngoing(true);//无效
                   notification = notificationBuilder.build();
               }
               notificationManager.notify(111123, notification);



               break;
           case R.id.off:
               notificationManager.cancel(NOTIFICATION_ID_1);
               break;
       }
    }
}

