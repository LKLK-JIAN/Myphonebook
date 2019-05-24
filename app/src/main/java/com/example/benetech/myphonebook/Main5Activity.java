package com.example.benetech.myphonebook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.benetech.myphonebook.R;
import com.example.benetech.myphonebook.softkeyboard.SoftKeyboardStateHelper;

public class Main5Activity extends AppCompatActivity {
     private EditText et_main5_value;
     private EditText et_main5_value2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        et_main5_value=findViewById(R.id.et_main5_value);
        et_main5_value2=findViewById(R.id.et_main5_value2);
        setListenerFotEditText(et_main5_value);
    }

     private void setListenerFotEditText(View view){
         SoftKeyboardStateHelper softKeyboardStateHelper = new SoftKeyboardStateHelper(view);
         softKeyboardStateHelper.addSoftKeyboardStateListener(new SoftKeyboardStateHelper.SoftKeyboardStateListener() {
             @Override
             public void onSoftKeyboardOpened(int keyboardHeightInPx) {
                 //键盘打开
                 Toast.makeText(Main5Activity.this,  et_main5_value.getText().toString() +et_main5_value2.getText().toString()+ "打开", Toast.LENGTH_SHORT).show();
             }

             @Override
             public void onSoftKeyboardClosed() {
                 //键盘关闭
                 Toast.makeText(Main5Activity.this, et_main5_value.getText().toString()+et_main5_value2.getText().toString() + "关闭", Toast.LENGTH_SHORT).show();
             }
         });
     }

}
