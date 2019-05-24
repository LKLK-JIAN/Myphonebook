package com.example.benetech.myphonebook;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.benetech.myphonebook.until.CacheUtils;

import java.io.File;
import java.io.IOException;

public class Main7Activity extends AppCompatActivity {
    private TextView tv_main7_getdsize;
    private String DATABASE_PATH = Environment
            .getExternalStorageDirectory()+"/AnemoMates";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        addPermissin1();
        tv_main7_getdsize=findViewById(R.id.tv_main7_getdsize);
        tv_main7_getdsize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long size= CacheUtils.getDirSize(new File(DATABASE_PATH));
                long filesize= 1;

                try {
                    filesize = CacheUtils.getFileSize(new File(DATABASE_PATH));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                tv_main7_getdsize.setText(CacheUtils.formatFileSize(size)+""+CacheUtils.formatFileSize(filesize));
            }
        });
    }
    

    private void addPermissin1() {
        final int REQUEST_CODE_ACCESS_COARSE_LOCATION = 1;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {//如果 API level 是大于等于 23(Android 6.0) 时
            //判断是否具有权限
            if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

                //判断是否需要向用户解释为什么需要申请该权限
                if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE)) {

                }
                //请求权限
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        REQUEST_CODE_ACCESS_COARSE_LOCATION);
            }

            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED) {

                if (ActivityCompat.shouldShowRequestPermissionRationale(
                        this, Manifest.permission.ACCESS_COARSE_LOCATION)) {
                }

                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
            }
        }
    }
}
