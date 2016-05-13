package com.my.nullpointerplayer.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;
import com.my.nullpointerplayer.R;
import com.my.nullpointerplayer.netbeans.FindNetBeans;
import com.my.nullpointerplayer.utils.MyRequestQueue;

/**
 * ListviewType = 13的适配器
 * Created by Administrator on 2016/2/4.
 */
public class FindListviewType13BaseAdapter extends BaseAdapter {

    private Context context;
    private FindNetBeans bean;
    private int position;

    public FindListviewType13BaseAdapter(Context context, FindNetBeans bean, int position) {
        this.context = context;
        this.bean = bean;
        this.position = position;
    }

    @Override
    public int getCount() {
        return bean.getData().get(this.position).getData().size();
    }

    @Override
    public Object getItem(int position) {
        return bean.getData().get(this.position).getData().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (null == convertView) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_find_listview_type_13, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.textView_name = (TextView) convertView.findViewById(R.id.textView_name);
            viewHolder.textView_desc = (TextView) convertView.findViewById(R.id.textView_desc);
            viewHolder.imageView = (NetworkImageView) convertView.findViewById(R.id.imageView);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        if (null != bean) {
            viewHolder.textView_name.setText(bean.getData().get(this.position).getData().get(position).getName());
            viewHolder.textView_desc.setText(bean.getData().get(this.position).getData().get(position).getDesc());
            MyRequestQueue.setNetImage(viewHolder.imageView, bean.getData().get(this.position).getData().get(position).getPicUrl());
        }
        return convertView;
    }

    class ViewHolder {
        TextView textView_name;
        TextView textView_desc;
        NetworkImageView imageView;
    }
}
