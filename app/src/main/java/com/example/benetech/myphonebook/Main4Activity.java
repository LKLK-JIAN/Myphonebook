package com.example.benetech.myphonebook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.benetech.myphonebook.until.BigDecimalUtils;


public class Main4Activity extends AppCompatActivity implements View.OnClickListener {
    private EditText et_main_first, et_main_second;
    private Button btn_main4_add, btn_main4_subtract, btn_main4_multiply, btn_main4_divide,
            btn_main4_firstround, btn_main4_roundstring, btn_main4_remainder, btn_main4_compare;
    private TextView result;
    private int scale=8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        et_main_first = findViewById(R.id.et_main4_first);
        et_main_second = findViewById(R.id.et_main4_second);
        btn_main4_add = findViewById(R.id.btn_main4_add);
        btn_main4_add.setOnClickListener(this);
        btn_main4_subtract = findViewById(R.id.btn_main4_subtract);
        btn_main4_subtract.setOnClickListener(this);
        btn_main4_multiply = findViewById(R.id.btn_main4_multiply);
        btn_main4_multiply.setOnClickListener(this);
        btn_main4_divide = findViewById(R.id.btn_main4_divide);
        btn_main4_divide.setOnClickListener(this);
        btn_main4_firstround = findViewById(R.id.btn_main4_firstround);
        btn_main4_firstround.setOnClickListener(this);
        btn_main4_roundstring = findViewById(R.id.btn_main4_roundString);
        btn_main4_roundstring.setOnClickListener(this);
        btn_main4_remainder = findViewById(R.id.btn_main4_remainder);
        btn_main4_remainder.setOnClickListener(this);
        btn_main4_compare = findViewById(R.id.btn_main4_compare);
        btn_main4_compare.setOnClickListener(this);
        result = findViewById(R.id.result);

    }

    @Override
    public void onClick(View v) {
        String b1 = et_main_first.getText().toString();
        String b2 = et_main_second.getText().toString();
        switch (v.getId()) {
            case R.id.btn_main4_add:
                result.setText("");
                short one=Short.parseShort(b1);
                short two=Short.parseShort(b2);
                long three=  one*two;
                result.setText(  three+" ");
               // result.setText(  BigDecimalUtils.add(b1,b2,scale));
                break;
            case R.id.btn_main4_subtract:
                result.setText("");

                result.setText(  BigDecimalUtils.sub(b1,b2,scale));
                break;
            case R.id.btn_main4_multiply:
                result.setText("");
                result.setText(  BigDecimalUtils.mul(b1,b2,scale));
                break;
            case R.id.btn_main4_divide:
                result.setText("");
                result.setText(  BigDecimalUtils.div(b1,b2,scale));
                break;
            case R.id.btn_main4_firstround:
                result.setText("");
                result.setText(  BigDecimalUtils.round(0.08222,scale)+"");
                break;
            case R.id.btn_main4_roundString:
                result.setText("");
                result.setText(  BigDecimalUtils.round(b1,scale));
                break;
            case R.id.btn_main4_remainder:
                result.setText("");
                result.setText(  BigDecimalUtils.remainder(b1,b2,scale));
                break;
            case R.id.btn_main4_compare:
                result.setText("");
                if(BigDecimalUtils.compare(b1,b2)){
                    result.setText(  "true");
                }
                else {
                    result.setText(  "false");
                }
                break;


        }
    }
}
