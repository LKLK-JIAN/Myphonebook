package com.example.benetech.myphonebook;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.benetech.myphonebook.fragment.Test1Fragment;
import com.example.benetech.myphonebook.fragment.Test2Fragment;
import com.example.benetech.myphonebook.fragment.Test3Fragment;
import com.example.benetech.myphonebook.fragment.Test4Fragment;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    private MyViewPager pager;
    private MyViewPagerAdapter pagerAdapter;
    private List<Fragment> fragments = null;
    private TextView value;
    private Test1Fragment test1Fragment;
    private Test2Fragment test2Fragment;
    private Test3Fragment test3Fragment;
    private Test4Fragment test4Fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        pager=findViewById(R.id.mv_main2_content);
        value=findViewById(R.id.value);
        pager.setOffscreenPageLimit(4);
        fragments=new ArrayList<>();
        test1Fragment=new Test1Fragment();
        test2Fragment=new Test2Fragment();
        test3Fragment=new Test3Fragment();
        test4Fragment=new Test4Fragment();

        fragments.add(test1Fragment);
        fragments.add(test2Fragment);
        fragments.add(test3Fragment);
        fragments.add(test4Fragment);
        pagerAdapter = new MyViewPagerAdapter(getSupportFragmentManager(),
                fragments);
        pagerAdapter.notifyDataSetChanged();
        pager.setAdapter(pagerAdapter);
        setCurrentPage(0);
        value.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pager.setVisibility(View.VISIBLE);
//                test4Fragment.sett();
//                test1Fragment.sett();
//                test2Fragment.sett();
//                test3Fragment.sett();

               Test1Fragment.test1.setText("1111111");
               Test2Fragment.test1.setText("1111111");
               Test3Fragment.test1.setText("1111111");
               Test4Fragment.test1.setText("4444444");
            }
        });
    }

    public void setCurrentPage(int pageIndex) {
        pager.setCurrentItem(pageIndex);
    }
}






