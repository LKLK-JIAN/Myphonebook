package com.example.benetech.myphonebook;


import java.io.InputStream;
import java.util.List;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {

    private Context mContext;
    private List<ContactVo> mData;

    public MyAdapter(Context mContext, List<ContactVo> mData) {
        super();
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return mData.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder mHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(
                    R.layout.list, null);
            mHolder = new ViewHolder();
            mHolder.name = (TextView) convertView.findViewById(R.id.name);
            mHolder.moble = (TextView) convertView.findViewById(R.id.moble);
            mHolder.imgV = (ImageView) convertView.findViewById(R.id.image);

            convertView.setTag(mHolder);

        } else {
            mHolder = (ViewHolder) convertView.getTag();
            mHolder.imgV.setImageResource(R.drawable.ic_launcher_background);
        }

        ContactVo cv = mData.get(position);
        mHolder.name.setText(cv.getName());
//		Log.i("info", "22222222" + cv.getName());
        mHolder.moble.setText(cv.getMoble());
        mHolder.imgV.setImageBitmap(cv.getImg());

        return convertView;
    }

    class ViewHolder {
        TextView name, moble;
        ImageView imgV;
    }

}
