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
import com.my.nullpointerplayer.netbeans.MiGuSongListBeans;
import com.my.nullpointerplayer.utils.MyRequestQueue;
import com.my.nullpointerplayer.utils.ReadStringRequestUtf;

/**
 * 咪咕音乐列表Fragment
 * <p/>
 * Created by Administrator on 2016/2/15.
 */
public class MiGuSongListFragment extends BaseFragment implements AdapterView.OnItemClickListener, View.OnClickListener {

    private MiGuSongListBeans beans = new MiGuSongListBeans();
    private MainActivity mainActivity;
    private String url, title;
    private PullToZoomListView listView;
    private TextView textView_net_song_bar_title;
    private ImageView imageView_net_song_back;
    private MiGuSongListBaseAdapter adapter;

    public static MiGuSongListFragment newInstance() {
        MiGuSongListFragment miGuSongListFragment = new MiGuSongListFragment();
        return miGuSongListFragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_migu_song_list, container, false);
        url = getArguments().getString("url");
        title = getArguments().getString("title");

        imageView_net_song_back = (ImageView) view.findViewById(R.id.imageView_net_song_back);
        listView = (PullToZoomListView) view.findViewById(R.id.pullListview);
        textView_net_song_bar_title = (TextView) view.findViewById(R.id.textView_net_song_bar_title);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getBeans();

        listView.getHeaderView().setImageResource(R.mipmap.genre_5);
        listView.getHeaderView().setScaleType(ImageView.ScaleType.CENTER_CROP);

        listView.setOnItemClickListener(this);
        imageView_net_song_back.setOnClickListener(this);
    }

    private void getBeans(){
        url=url+"&ua=Android_sst&version=4.2280";
        ReadStringRequestUtf request = new ReadStringRequestUtf(url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Gson gson = new Gson();
                        beans =gson.fromJson(response,MiGuSongListBeans.class);

                        textView_net_song_bar_title.setText(title); //设置toolbar标题文字

                        //此方法需要开线程，是异步的过程，也就是在上面调用者方法时候，方法下面依然会执行，所以加数据的时候要写在这方法里面
                        adapter = new MiGuSongListBaseAdapter(mainActivity, beans);
                        listView.setAdapter(adapter);   //设置listView适配器
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

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imageView_net_song_back:
                goBack();
                break;
        }
    }

    /**
     * listview适配器
     */
    private class MiGuSongListBaseAdapter extends BaseAdapter {

        private Context context;
        private MiGuSongListBeans beans;

        public MiGuSongListBaseAdapter(Context context, MiGuSongListBeans beans) {
            this.context = context;
            this.beans = beans;
        }

        // 获取数量
        @Override
        public int getCount() {
            return beans.getSongs().size();
        }

        //获取内容
        @Override
        public Object getItem(int i) {
            return beans.getSongs().size() > 0 && beans.getSongs() != null ? beans.getSongs().get(i) : null;
        }

        //绑定id
        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (null == view) {
                view = LayoutInflater.from(context).inflate(R.layout.item_migu_music_listview, viewGroup, false);
                viewHolder = new ViewHolder();
                viewHolder.tv_SongName_item_net_music_listview = (TextView) view.findViewById(R.id.tv_SongName_item_net_music_listview);
                viewHolder.tv_songer_item_music_listview = (TextView) view.findViewById(R.id.tv_songer_item_music_listview);
                viewHolder.iv_item_music_listview = (NetworkImageView) view.findViewById(R.id.iv_item_music_listview);

                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            if (null != beans.getSongs()) {
                viewHolder.tv_SongName_item_net_music_listview.setText(beans.getSongs().get(i).getTitle());
                viewHolder.tv_songer_item_music_listview.setText(beans.getSongs().get(i).getSinger());
                MyRequestQueue.setNetImage(viewHolder.iv_item_music_listview, beans.getSongs().get(i).getAlbumIcon());
            }
            return view;
        }


        class ViewHolder {
            TextView tv_SongName_item_net_music_listview;
            TextView tv_songer_item_music_listview;
            NetworkImageView iv_item_music_listview;
        }
    }
}
