package com.my.nullpointerplayer.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.my.nullpointerplayer.R;
import com.my.nullpointerplayer.eventbus.ChangePlayButton;
import com.my.nullpointerplayer.eventbus.IsMainActivityCreate;
import com.my.nullpointerplayer.eventbus.LocalSong;
import com.my.nullpointerplayer.eventbus.NetSong;
import com.my.nullpointerplayer.fragment.MainFragment;
import com.my.nullpointerplayer.service.PlayService;
import com.my.nullpointerplayer.utils.MediaUtils;

import de.greenrobot.event.EventBus;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private FrameLayout frameLayout;
    private FragmentManager fragmentManager;
    private LinearLayout linearLayout_main_activity;
    private ImageView iv_album, iv_pre_music, iv_play_music, iv_next_music;
    private TextView tv_SongName, tv_singer;
    private boolean isPause = false;    //是否是暂停状态
    private LocalSong localSong;
    private NetSong netSong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindPlayService();      //绑定播放服务

        initFindViewById();

        EventBus.getDefault().register(this);   //注册EventBus
        //如果MainActivity创建发送一个EventBus给PlayService,这时PlayService会给MainActivity发一个EventBus来更新UI
        EventBus.getDefault().post(new IsMainActivityCreate(true));

        initFragmentManager();

        initSetOnClickListener();
    }

    /**
     * 初始化findViewById
     */
    public void initFindViewById() {
        frameLayout = (FrameLayout) findViewById(R.id.frameLayout);
        linearLayout_main_activity = (LinearLayout) findViewById(R.id.linearLayout_main_activity);
        iv_album = (ImageView) findViewById(R.id.iv_album);
        iv_pre_music = (ImageView) findViewById(R.id.iv_pre_music);
        iv_play_music = (ImageView) findViewById(R.id.iv_play_music);
        iv_next_music = (ImageView) findViewById(R.id.iv_next_music);
        tv_SongName = (TextView) findViewById(R.id.tv_SongName);
        tv_singer = (TextView) findViewById(R.id.tv_singer);
    }

    /**
     * 初始化setOnClickListener
     */
    public void initSetOnClickListener() {
        linearLayout_main_activity.setOnClickListener(this);
        iv_pre_music.setOnClickListener(this);
        iv_play_music.setOnClickListener(this);
        iv_next_music.setOnClickListener(this);
    }

    /**
     * 把MainFragment添加到MainActivity上面
     */
    public void initFragmentManager() {
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.frameLayout, MainFragment.newInstance());
        //ft.addToBackStack(null);    //添加赞内存
        ft.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        EventBus.getDefault().post(new IsMainActivityCreate(true));
//        bindPlayService();      //绑定播放服务
//        if(playService.isPlaying()){
//            iv_play_music.setImageResource(R.mipmap.player_btn_pause_normal);
//        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        unbindPlayService();    //解除绑定播放服务
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);     //取消注册EventBus
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.linearLayout_main_activity:
                goToPlayActivity();     //跳转到PlayActivity
                break;

            case R.id.iv_pre_music:
                if(playService.getChangePlayList()!=PlayService.NET_MUSIC_LIST){    //如果不是网络列表正常下一曲,否则的话播放网络列表下一曲
                    playService.prev();
                }else {
                    playService.netPrev();
                }

                break;

            case R.id.iv_play_music:
                changPlayMusicBtn();    //改变播放按钮的方法
                break;

            case R.id.iv_next_music:
                if(playService.getChangePlayList()!=PlayService.NET_MUSIC_LIST){    //如果不是网络列表正常上一曲,否则的话播放网络列表上一曲
                    playService.next();
                }else {
                    playService.netNext();
                }
                break;
        }
    }

    /**
     * 从service接收的EventBus,用来更改MainActivity下面的歌曲信息UI(本地歌曲)
     *
     * @param localSong
     */
    public void onEventMainThread(LocalSong localSong) {
        this.localSong = localSong;
        String songName = localSong.getSongInfo().getTitle();
        String singer = localSong.getSongInfo().getArtist();

        //更新UI
        tv_SongName.setText(songName);
        tv_singer.setText(singer);
        Bitmap albumBitmap = MediaUtils.getArtwork(this, localSong.getSongInfo().getId(), localSong.getSongInfo().getAlbumId(), true, true);
        iv_album.setImageBitmap(albumBitmap);

        if (localSong.isBool()) {     /** 由于service绑定是异步的,所以加了一个boolean值来判断音乐是否是在播放或者暂停状态的 **/
            iv_play_music.setImageResource(R.mipmap.player_btn_pause_normal);    /**如果是暂停状态的话更换图片**/
        } else {
            iv_play_music.setImageResource(R.mipmap.player_btn_play_normal);
        }
    }

    /**
     * 从service接收的EventBus,用来更改MainActivity下面的歌曲信息UI(网络歌曲)
     *
     * @param netSong
     */
    public void onEventMainThread(NetSong netSong) {
        this.netSong = netSong;
        String songName = netSong.getBean().getSongs().get(netSong.getPosition()).getName();
        String singer = netSong.getBean().getSongs().get(netSong.getPosition()).getSingerName();

        //更新UI
        tv_SongName.setText(songName);
        tv_singer.setText(singer);
        iv_album.setImageResource(R.mipmap.app_logo2);

        if (netSong.isBool()) {
            iv_play_music.setImageResource(R.mipmap.player_btn_pause_normal);
        } else {
            iv_play_music.setImageResource(R.mipmap.player_btn_play_normal);
        }

    }

    /**
     * 此EventBus用来接收耳机拔出、时间到了音乐暂停和更新播放按钮
     *
     * @param change
     */
    public void onEventMainThread(ChangePlayButton change) {
        if (change.isChangeUI()) {
            changPlayMusicBtn();
        }
    }

    /**
     * 改变播放按钮的方法
     */
    public void changPlayMusicBtn() {
        if (playService.isPlaying()) {
            //如果是正在播放的话换为暂停图片,并且暂停音乐
            iv_play_music.setImageResource(R.mipmap.player_btn_play_normal);
            playService.pause();
            isPause = true;
        } else {
            if (playService.isPause()) {
                //如果是暂停的话就换成播放图片,并且开始播放音乐
                iv_play_music.setImageResource(R.mipmap.player_btn_pause_normal);
                playService.start();    //开始播放音乐

            } else {
                playService.play(playService.getCurrentPosition());
                iv_play_music.setImageResource(R.mipmap.player_btn_pause_normal);
            }
            isPause = false;
        }
    }

    /**
     * 跳转到PlayActivity
     */
    public void goToPlayActivity() {
        Intent intent = new Intent(this, PlayActivity.class);
        startActivity(intent);
    }
}
