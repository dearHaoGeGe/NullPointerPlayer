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
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.NetworkImageView;
import com.google.gson.Gson;
import com.my.nullpointerplayer.R;
import com.my.nullpointerplayer.activity.MainActivity;
import com.my.nullpointerplayer.custom.PullToZoomListView;
import com.my.nullpointerplayer.netbeans.AllNetSongBeans;
import com.my.nullpointerplayer.service.PlayService;
import com.my.nullpointerplayer.utils.MyRequestQueue;
import com.my.nullpointerplayer.utils.ReadStringRequestUtf;

/**
 * 排行榜中点击进去的歌单的listview
 * Created by Administrator on 2016/2/13.
 */
public class BangNetListFragment extends BaseFragment implements AdapterView.OnItemClickListener {

    private MainActivity mainActivity;
    private AllNetSongBeans beans=new AllNetSongBeans();
    private PullToZoomListView listView;
    private BangNetListBaseAdapter adapter;
    private String url;

    public static BangNetListFragment newInstance() {
        BangNetListFragment bangNetListFragment = new BangNetListFragment();
        return bangNetListFragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mainActivity= (MainActivity) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_net_song_list_zero, container, false);
        listView = (PullToZoomListView) view.findViewById(R.id.pullToZoomListView);
        url=getArguments().getString("url");
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getBeans();
        listView.getHeaderView().setImageResource(R.mipmap.genre_2);
        listView.getHeaderView().setScaleType(ImageView.ScaleType.CENTER_CROP);

        listView.setOnItemClickListener(this);
    }

    private void getBeans(){
        ReadStringRequestUtf request = new ReadStringRequestUtf(url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Gson gson = new Gson();
                        beans=gson.fromJson(response, AllNetSongBeans.class);

                        adapter = new BangNetListBaseAdapter(mainActivity,beans);
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
        int pos = position - 1;   //自定义listview中position要减1
        if (pos >= 0) {
            if(mainActivity.playService.getChangePlayList()!= PlayService.NET_MUSIC_LIST){
                mainActivity.playService.setBeans(beans);
                mainActivity.playService.setChangePlayList(PlayService.NET_MUSIC_LIST);
            }
            mainActivity.playService.setBeans(beans);
            mainActivity.playService.netPlay(pos);
        }
    }

    private class BangNetListBaseAdapter extends BaseAdapter{

        private Context context;
        private AllNetSongBeans bean;

        public BangNetListBaseAdapter(Context context, AllNetSongBeans bean) {
            this.context = context;
            this.bean = bean;
        }

        @Override
        public int getCount() {
            return bean.getSongs().size();
        }

        @Override
        public Object getItem(int position) {
            return bean.getSongs().get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder=null;
            if(null==convertView){
                convertView=LayoutInflater.from(context).inflate(R.layout.item_net_music_list,parent,false);
                viewHolder=new ViewHolder();
                viewHolder.tv_SongName_item= (TextView) convertView.findViewById(R.id.tv_SongName_item);
                viewHolder.tv_songer_item= (TextView) convertView.findViewById(R.id.tv_songer_item);
                viewHolder.iv_item_album= (NetworkImageView) convertView.findViewById(R.id.iv_item_album);

                convertView.setTag(viewHolder);
            }else {
                viewHolder= (ViewHolder) convertView.getTag();
            }
            if(null!=bean){
                viewHolder.tv_SongName_item.setText(bean.getSongs().get(position).getName());
                viewHolder.tv_songer_item.setText(bean.getSongs().get(position).getSingerName());
                MyRequestQueue.setNetImage(viewHolder.iv_item_album,bean.getSongs().get(position).getPicUrl());
            }
            return convertView;
        }

        class ViewHolder{
            NetworkImageView iv_item_album;
            TextView tv_SongName_item;
            TextView tv_songer_item;
        }
    }
}
