package com.my.nullpointerplayer.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.NetworkImageView;
import com.google.gson.Gson;
import com.my.nullpointerplayer.R;
import com.my.nullpointerplayer.activity.MainActivity;
import com.my.nullpointerplayer.netbeans.AllNetSongBeans;
import com.my.nullpointerplayer.service.PlayService;
import com.my.nullpointerplayer.utils.MyRequestQueue;
import com.my.nullpointerplayer.utils.ReadStringRequestUtf;

/**
 * 测试网络播放Fragment
 * Created by dllo on 16/1/28.
 */
public class TestNetFragment extends BaseFragment implements AdapterView.OnItemClickListener {

    private MainActivity mainActivity;
    private ListView listView;
    //private SongListBeans beans = new SongListBeans();
    private AllNetSongBeans beans = new AllNetSongBeans();
    private TestNetBaseAdapter adapter;

    public static TestNetFragment newInstance() {
        TestNetFragment testNetFragment = new TestNetFragment();
        return testNetFragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test_net, container, false);

        listView = (ListView) view.findViewById(R.id.listView);
        listView.setOnItemClickListener(this);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getBeans();
    }

    private void getBeans() {
        String url = "http://api.songlist.ttpod.com/ranklists/111/current?f=1&os=4.4.4&alf=700633&imei=000000000000000&from=android&resolution=1080x1776&net=2&api_version=1.0&agent=none&v=v8.3.2.2015121811&utdid=VZ4wel5vHx8DAJwcljDPrh%2FZ&longitude=0.0&user_id=0&latitude=0.0&language=zh";
        ReadStringRequestUtf request = new ReadStringRequestUtf(url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Gson gson = new Gson();
                        //beans = gson.fromJson(response, SongListBeans.class);
                        beans = gson.fromJson(response, AllNetSongBeans.class);

                        adapter = new TestNetBaseAdapter(mainActivity, beans);
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
        // TODO 网络播放点击添加事件
        if(mainActivity.playService.getChangePlayList()!= PlayService.NET_MUSIC_LIST){
            mainActivity.playService.setBeans(beans);
            mainActivity.playService.setChangePlayList(PlayService.NET_MUSIC_LIST);
        }
        mainActivity.playService.setBeans(beans);
        mainActivity.playService.netPlay(position);
    }

    /**
     * 适配器
     */
    private class TestNetBaseAdapter extends BaseAdapter {

        private Context context;
        //private SongListBeans bean;
        private AllNetSongBeans bean;

        public TestNetBaseAdapter(Context context, AllNetSongBeans bean) {
            this.context = context;
            this.bean = bean;
        }

        //获得数量
        @Override
        public int getCount() {
            return bean.getSongs().size();
        }

        //获取内容
        @Override
        public Object getItem(int i) {
            return bean.getSongs().size() > 0 && bean.getSongs() != null ? bean.getSongs().get(i) : null;
        }

        //绑定ID
        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder = null;
            if (null == view) {
                view = LayoutInflater.from(context).inflate(R.layout.item_net_music_list, viewGroup, false);
                viewHolder = new ViewHolder();
                viewHolder.tv_SongName_item = (TextView) view.findViewById(R.id.tv_SongName_item);
                viewHolder.tv_songer_item = (TextView) view.findViewById(R.id.tv_songer_item);
                viewHolder.iv_item_album = (NetworkImageView) view.findViewById(R.id.iv_item_album);

                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            if (null != bean.getSongs()) {
                String songName = bean.getSongs().get(i).getName();
                String singer = bean.getSongs().get(i).getSingerName();

                viewHolder.tv_SongName_item.setText(songName);
                viewHolder.tv_songer_item.setText(singer);
                MyRequestQueue.setNetImage(viewHolder.iv_item_album, bean.getSongs().get(i).getPicUrl());
            }
            return view;
        }

        class ViewHolder {
            TextView tv_SongName_item;
            TextView tv_songer_item;
            NetworkImageView iv_item_album;
        }
    }
}
