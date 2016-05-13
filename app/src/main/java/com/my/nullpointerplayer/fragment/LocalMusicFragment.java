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

import com.my.nullpointerplayer.R;
import com.my.nullpointerplayer.songbeans.SongInfo;
import com.my.nullpointerplayer.activity.MainActivity;
import com.my.nullpointerplayer.application.BaseApplication;
import com.my.nullpointerplayer.service.PlayService;
import com.my.nullpointerplayer.utils.MediaUtils;

import java.util.ArrayList;


/**
 * 本地歌曲的列表Fragment
 * Created by dllo on 16/1/26.
 */
public class LocalMusicFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {

    private MainActivity mainActivity;
    private ImageView imageView_net_song_back;
    private ListView listView;
    private ArrayList<SongInfo> songInfos;
    private LocalMusicBaseAdapter adapter;
    private BaseApplication application;
    private boolean isPause = false;    //判断是否是暂停状态

    public static LocalMusicFragment newInstance() {
        LocalMusicFragment localMusicFragment = new LocalMusicFragment();
        return localMusicFragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_local_music, container, false);

        imageView_net_song_back = (ImageView) view.findViewById(R.id.imageView_net_song_back);
        listView = (ListView) view.findViewById(R.id.listview);
        loadData();
        imageView_net_song_back.setOnClickListener(this);
        listView.setOnItemClickListener(this);
        return view;
    }

    /**
     * 加载本地音乐列表
     */
    public void loadData() {
        songInfos = MediaUtils.getSongInfos(mainActivity);
        adapter = new LocalMusicBaseAdapter(mainActivity, songInfos);
        listView.setAdapter(adapter);
    }


    /**
     * ListView监听item事件
     *
     * @param adapterView
     * @param view
     * @param i
     * @param l
     */
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if (mainActivity.playService.getChangePlayList() != PlayService.LOCAL_MUSIC_LIST) {
            mainActivity.playService.setSongInfos(songInfos);
            mainActivity.playService.setChangePlayList(PlayService.LOCAL_MUSIC_LIST);
        }
        mainActivity.playService.play(i);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imageView_net_song_back:
                goBack();
                break;
        }
    }

    /**
     * 本地音乐列表listview适配器
     */
    public class LocalMusicBaseAdapter extends BaseAdapter {

        private Context context;
        private ArrayList<SongInfo> songInfos;

        public LocalMusicBaseAdapter(Context context, ArrayList<SongInfo> songInfos) {
            this.context = context;
            this.songInfos = songInfos;
        }

        @Override
        public int getCount() {
            return songInfos.size();
        }

        @Override
        public Object getItem(int i) {
            return songInfos.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder = null;
            if (null == view) {
                view = LayoutInflater.from(context).inflate(R.layout.item_local_music_list, viewGroup, false);
                viewHolder = new ViewHolder();
                viewHolder.tv_SongName_item = (TextView) view.findViewById(R.id.tv_SongName_item);
                viewHolder.tv_songer_item = (TextView) view.findViewById(R.id.tv_songer_item);
                viewHolder.tv_time_item = (TextView) view.findViewById(R.id.tv_time_item);
                viewHolder.iv_item_album = (ImageView) view.findViewById(R.id.iv_item_album);
                view.setTag(viewHolder);
            }
            viewHolder = (ViewHolder) view.getTag();
            SongInfo songInfo = songInfos.get(i);
            viewHolder.tv_SongName_item.setText(songInfo.getTitle());
            viewHolder.tv_songer_item.setText(songInfo.getArtist());
            viewHolder.tv_time_item.setText(MediaUtils.formatTime(songInfo.getDuration()));
            /*加载图片太卡,暂时注释掉*/
//            Bitmap albumBitmap = MediaUtils.getArtwork(mainActivity, songInfo.getId(), songInfo.getAlbumId(), true, true);
//            viewHolder.iv_item_album.setImageBitmap(albumBitmap);
            return view;
        }

        private class ViewHolder {
            TextView tv_SongName_item;
            TextView tv_songer_item;
            TextView tv_time_item;
            ImageView iv_item_album;
        }
    }
}
