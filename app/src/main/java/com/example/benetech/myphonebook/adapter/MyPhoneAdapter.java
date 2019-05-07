package com.example.benetech.myphonebook.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.benetech.myphonebook.R;
import com.example.benetech.myphonebook.bean.PhoneInfo;

import java.util.List;

public class MyPhoneAdapter extends BaseAdapter {
    private List<PhoneInfo> list;
    private Context context;

    public MyPhoneAdapter(List<PhoneInfo> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        if (convertView == null) {
            ViewHolder viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.myadapteritem, null);
            viewHolder.name = (TextView) convertView.findViewById(R.id.tv_adapteritem_name);
            viewHolder.number = (TextView) convertView.findViewById(R.id.tv_adapteritem_number);
            viewHolder.name.setText(list.get(position).getName());
            viewHolder.number.setText(list.get(position).getNumber());
        }
        return convertView;
    }

    public class ViewHolder {

        TextView name;
        TextView number;
    }

}
