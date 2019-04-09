package com.example.benetech.myphonebook.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.benetech.myphonebook.R;

public class Test2Fragment extends Fragment {

    private View v;
    public static  TextView test1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_test2, null);
        // test= (TextView) v.findViewById(R.id.test);
        test1=v.findViewById(R.id.test2);

        return v;
    }

    public void sett(){
        test1.setText("1111");
    }
}
