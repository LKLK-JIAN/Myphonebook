package com.example.benetech.myphonebook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.TextView;

public class Main6Activity extends AppCompatActivity {
    private TextView tv_main6_location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        tv_main6_location=findViewById(R.id.tv_main6_locatiom);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            /**
             * 点击的开始位置
             */
            case MotionEvent.ACTION_DOWN:
                tv_main6_location.setText("起始位置：(" + event.getX() + "," + event.getY());
                break;
            /**
             * 触屏实时位置
             */
            case MotionEvent.ACTION_MOVE:
                tv_main6_location.setText("实时位置：(" + event.getX() + "," + event.getY()+","+tv_main6_location.getBottom());
                break;
            /**
             * 离开屏幕的位置
             */
            case MotionEvent.ACTION_UP:
                //tv_main6_location.setText("结束位置：(" + event.getX() + "," + event.getY()+","+tv_main6_location.getTop());
                break;
            default:
                break;
        }
        /**
         *  注意返回值
         *  true： view继续响应Touch操作；
         *  false：view不再响应Touch操作，故此处若为false，只能显示起始位置，不能显示实时位置和结束位置
         */
        return super.onTouchEvent(event);
    }
}
