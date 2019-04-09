package com.example.benetech.myphonebook;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;


public class BatteryReceiver extends BroadcastReceiver {

    private static final String TAG ="  " ;

    @Override
        public void onReceive(Context context, Intent intent) {
            // TODO Auto-generated method stub
            Bundle bundle=intent.getExtras();
//            int current=bundle.getInt("level");//key=level是当前电量
//            int total=bundle.getInt("scale");//key=scale是总电量
            Log.e(TAG, "onReceive: 22222222222222222" );
            //context.startActivity(new Intent(context,ChannelActivity.class));
        }
}
