package com.my.nullpointerplayer.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.NetworkImageView;
import com.google.gson.Gson;
import com.my.nullpointerplayer.R;
import com.my.nullpointerplayer.activity.MainActivity;
import com.my.nullpointerplayer.netbeans.SongSheetBeans;
import com.my.nullpointerplayer.utils.MyRequestQueue;
import com.my.nullpointerplayer.utils.ReadStringRequestUtf;

/**
 * 歌单fragment
 * Created by Administrator on 2016/2/5.
 */
public class SongSheetFragment extends BaseFragment implements AdapterView.OnItemClickListener, View.OnClickListener {

    private MainActivity mainActivity;
    private GridView gridView;
    private ImageView imageView_back;
    private SongSheetBeans beans = new SongSheetBeans();
    private GridViewBaseAdapter adapter;

    public static SongSheetFragment newInstance() {
        SongSheetFragment songSheetFragment = new SongSheetFragment();
        return songSheetFragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_song_sheet, container, false);
        gridView = (GridView) view.findViewById(R.id.gridView);
        imageView_back = (ImageView) view.findViewById(R.id.imageView_back);

        gridView.setOnItemClickListener(this);
        imageView_back.setOnClickListener(this);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getBeans();
    }

    private void getBeans() {
        String url = "http://search.dongting.com/songlist/search?s=s200&size=10&hid=2103235630591830&utdid=VqTof1UU%2FvIDAJwcljAsz8ky&q=tag%3A%E6%9C%80%E7%83%AD&net=2&app=ttpod&v=v8.3.2.2015121811&alf=alf700633&tid=0&uid=000000000000000&f=f1&page=1&imsi=310260000000000";

        ReadStringRequestUtf request = new ReadStringRequestUtf(url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Gson gson = new Gson();
                        beans = gson.fromJson(response, SongSheetBeans.class);

                        adapter = new GridViewBaseAdapter(mainActivity,beans);
                        gridView.setAdapter(adapter);
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
        int url =beans.getData().get(position).get_id();

        FragmentManager fragmentManager = mainActivity.getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        NetSongListOneFragment fragment = new NetSongListOneFragment();
        Bundle bundle = new Bundle();
        bundle.putString("url", url+"");
        fragment.setArguments(bundle);
        ft.replace(R.id.frameLayout, fragment);
        ft.addToBackStack("");
        ft.commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imageView_back:
                goBack();
                break;
        }
    }

    /**
     * 适配器
     */
    private class GridViewBaseAdapter extends BaseAdapter {

        private Context context;
        private SongSheetBeans bean;

        public GridViewBaseAdapter(Context context, SongSheetBeans bean) {
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
                convertView = LayoutInflater.from(context).inflate(R.layout.item_gridview_songsheet, parent, false);
                viewHolder = new ViewHolder();
                viewHolder.textView_author = (TextView) convertView.findViewById(R.id.textView_author);
                viewHolder.textView_title = (TextView) convertView.findViewById(R.id.textView_title);
                viewHolder.imageView = (NetworkImageView) convertView.findViewById(R.id.imageView);

                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            if (null != bean) {
                viewHolder.textView_author.setText(bean.getData().get(position).getAuthor());
                viewHolder.textView_title.setText(bean.getData().get(position).getTitle());
                MyRequestQueue.setNetImage(viewHolder.imageView, bean.getData().get(position).getPic_url());
            }
            return convertView;
        }

        class ViewHolder {
            NetworkImageView imageView;
            TextView textView_author;
            TextView textView_title;
        }
    }
}
