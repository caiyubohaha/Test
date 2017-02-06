package cn.comcyb.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

import cn.comcyb.myclass.R;

import static android.R.attr.type;

/**
 * Created by user on 2016/10/27.
 */

public class chatitemadapter extends BaseListAdapter<String>{
    LayoutInflater minflater;
    Context mcontext;

    public chatitemadapter(ArrayList<String> list, Context context) {
        super(list, context);
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView==null){
            if(type==1){
                convertView = minflater.inflate(R.layout.layout_chatleft,null);
            }else{
                convertView = minflater.inflate(R.layout.layout_chatright,null);
            }
            viewHolder = new ViewHolder();
            viewHolder.iv = (ImageView) convertView.findViewById(R.id.iv);
            convertView.setTag(viewHolder);

        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        return null;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }



    class ViewHolder{
        public ImageView iv;
    }
}
