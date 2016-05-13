package com.my.nullpointerplayer.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.NetworkImageView;
import com.google.gson.Gson;
import com.my.nullpointerplayer.R;
import com.my.nullpointerplayer.activity.MainActivity;
import com.my.nullpointerplayer.netbeans.SongerBeans;
import com.my.nullpointerplayer.utils.MyRequestQueue;
import com.my.nullpointerplayer.utils.ReadStringRequestUtf;

/**
 * 歌手Fragment
 * Created by Administrator on 2016/2/11.
 */
public class SongerFragment extends BaseFragment implements AdapterView.OnItemClickListener, View.OnClickListener {

    private MainActivity mainActivity;
    private ListView listView;
    private ImageView imageView_back;
    private SongerBaseAdapter adapter;
    private SongerBeans beans = new SongerBeans();

    public static SongerFragment newInstance() {
        SongerFragment songerFragment = new SongerFragment();
        return songerFragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_songer, container, false);
        listView= (ListView) view.findViewById(R.id.listView);
        imageView_back= (ImageView) view.findViewById(R.id.imageView_back);
        listView.setOnItemClickListener(this);
        imageView_back.setOnClickListener(this);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getBeans();
    }

    private void getBeans() {
        String url = "http://api.dongting.com/misc/singer/top";
        ReadStringRequestUtf request = new ReadStringRequestUtf(url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Gson gson = new Gson();
                        beans=gson.fromJson(response, SongerBeans.class);

                        adapter = new SongerBaseAdapter(mainActivity,beans);
                        listView.setAdapter(adapter);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        MyRequestQueue.addRequest(request);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(mainActivity, "已经点击了", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imageView:
                goBack();
                break;
        }
    }


    /**
     * 适配器
     */
    private class SongerBaseAdapter extends BaseAdapter {

        private Context context;
        private SongerBeans bean;

        public SongerBaseAdapter(Context context, SongerBeans bean) {
            this.context = context;
            this.bean = bean;
        }

        @Override
        public int getCount() {
            return bean.getData().size();
        }

        @Override
        public Object getItem(int position) {
            return bean.getData().get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder = null;
            if (null == convertView) {
                convertView = LayoutInflater.from(context).inflate(R.layout.item_songer_fragment, parent, false);
                viewHolder = new ViewHolder();
                viewHolder.textView = (TextView) convertView.findViewById(R.id.textView);
                viewHolder.imageView = (NetworkImageView) convertView.findViewById(R.id.imageView);

                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            if (null != bean) {
                viewHolder.textView.setText(bean.getData().get(position).getSinger_name());
                MyRequestQueue.setNetImage(viewHolder.imageView, bean.getData().get(position).getPic_url());
            }
            return convertView;
        }

        class ViewHolder {
            NetworkImageView imageView;
            TextView textView;
        }
    }
}
