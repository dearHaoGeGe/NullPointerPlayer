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
 * GridviewType = 12的适配器
 * Created by Administrator on 2016/2/4.
 */
public class FindGridviewType12BaseAdapter extends BaseAdapter {

    private Context context;
    private FindNetBeans bean;
    private int position;

    public FindGridviewType12BaseAdapter(Context context, FindNetBeans bean, int position) {
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_find_gridview_type_12, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.textView = (TextView) convertView.findViewById(R.id.textView);
            viewHolder.imageView = (NetworkImageView) convertView.findViewById(R.id.imageView);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        if (null != bean) {
            viewHolder.textView.setText(bean.getData().get(this.position).getData().get(position).getName());
            MyRequestQueue.setNetImage(viewHolder.imageView, bean.getData().get(this.position).getData().get(position).getPicUrl());
        }
        return convertView;
    }

    class ViewHolder {
        NetworkImageView imageView;
        TextView textView;
    }
}
