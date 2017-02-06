package cn.comcyb.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by user on 2016/10/27.
 */

public class  BaseListAdapter<T> extends BaseAdapter {
    ArrayList<T> mlist;
    Context mContext;
    LayoutInflater mInflater;
    public BaseListAdapter(ArrayList<T> list, Context context){
        mlist = list;
        mInflater = LayoutInflater.from(context);
        mContext = context;
    }

    @Override
    public int getCount() {
        return mlist==null?0:mlist.size();
    }

    @Override
    public Object getItem(int position) {
        return mlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
