package com.zhy.lovelymsg.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.zhy.lovelymsg.R;


public class ContentAdapter extends BaseAdapter {

    private Context context;

    public ContentAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

       return View.inflate(context, R.layout.content_item,null);
    }
}

