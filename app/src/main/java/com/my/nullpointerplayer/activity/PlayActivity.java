package com.my.nullpointerplayer.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.my.nullpointerplayer.R;
import com.my.nullpointerplayer.eventbus.ChangePlayButton;
import com.my.nullpointerplayer.eventbus.IsPlayActivityCreate;
import com.my.nullpointerplayer.eventbus.LocalSong;
import com.my.nullpointerplayer.eventbus.NetSong;
import com.my.nullpointerplayer.eventbus.UpdateProgress;
import com.my.nullpointerplayer.service.PlayService;
import com.my.nullpointerplayer.utils.MediaUtils;

import java.util.ArrayList;

import de.greenrobot.event.EventBus;

/**
 * 播放音乐页面
 * 在onCreate页面开了一个线程是因为绑定服务是一个异步过程不是同步过程,
 * 中间有延迟,在getIntentValue()方法里面要直接用playService对象,
 * 会报空指针异常,所以要开一个线程以便直接用playService对象,时间间隔设置为0
 * <p/>
 * 此activity创建的时候需要从mainactivity接收传过来的值
 * <p/>
 * Created by dllo on 16/1/26.
 */
public class PlayActivity extends BaseActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {

    private ViewPager viewpager_play_music;
    private TextView tv_start_time, tv_end_time, tv_title;
    private ImageView iv_album, iv_previous, iv_play_pause, iv_next, iv_favorite, iv_play_mode;
    private SeekBar seekBar;
    private boolean isPause;
    private ArrayList<View> viewArrayList;
    private MyViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        final Handler handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        initFindViewById();
                        EventBus.getDefault().register(PlayActivity.this);  //注册EventBus
                        intoChangePlayModeImage();  //设置播放模式的图片
                        EventBus.getDefault().post(new IsPlayActivityCreate(true));
                        //getIntentValue();           //从mainactivity中获取歌曲信息来设置UI
                        addSetOnClickListener();    //添加监听事件的方法

                        // TODO 此处添加onCreate里面的内容
                        break;
                }
                return false;
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                bindPlayService();      //绑定服务
                try {
                    Thread.sleep(0);   // TODO 有时候还会出空指针
                    handler.sendEmptyMessage(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //EventBus.getDefault().post(new IsPlayActivityCreate(true));
//        if(playService.isPlaying()){
//            iv_play_pause.setImageResource(R.mipmap.player_btn_pause_normal);
//        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        unbindPlayService();    //解除绑定服务
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);     //取消注册EventBus
    }

    public void initFindViewById() {
        viewArrayList = new ArrayList<>();
        viewpager_play_music = (ViewPager) findViewById(R.id.viewpager_play_music);
        View view = getLayoutInflater().inflate(R.layout.album_image_viewpager, null);

        iv_album = (ImageView) view.findViewById(R.id.iv_album);
        tv_title = (TextView) view.findViewById(R.id.tv_title);
        tv_start_time = (TextView) findViewById(R.id.tv_start_time);
        tv_end_time = (TextView) findViewById(R.id.tv_end_time);
        iv_previous = (ImageView) findViewById(R.id.iv_previous);
        iv_play_pause = (ImageView) findViewById(R.id.iv_play_pause);
        iv_next = (ImageView) findViewById(R.id.iv_next);
        iv_favorite = (ImageView) findViewById(R.id.iv_favorite);
        iv_play_mode = (ImageView) findViewById(R.id.iv_play_mode);
        seekBar = (SeekBar) findViewById(R.id.seekBar);

        viewArrayList.add(view);
        viewArrayList.add(getLayoutInflater().inflate(R.layout.lrc_viewpager, null));
        adapter = new MyViewPagerAdapter(viewArrayList);
        viewpager_play_music.setAdapter(adapter);
    }

    /**
     * 添加监听事件的方法
     */
    public void addSetOnClickListener() {
        iv_previous.setOnClickListener(PlayActivity.this);
        iv_play_pause.setOnClickListener(PlayActivity.this);
        iv_next.setOnClickListener(PlayActivity.this);
        iv_favorite.setOnClickListener(PlayActivity.this);
        iv_play_mode.setOnClickListener(PlayActivity.this);
        seekBar.setOnSeekBarChangeListener(PlayActivity.this);
    }

    /**
     * EventBus接收从service中接收歌曲信息来实现更新UI(本地歌曲)
     *
     * @param localSong
     */
    public void onEventMainThread(LocalSong localSong) {
        if (playService.getChangePlayList() != PlayService.NET_MUSIC_LIST) {
            tv_title.setText(localSong.getSongInfo().getTitle());
            tv_end_time.setText(MediaUtils.formatTime(localSong.getSongInfo().getDuration()));
            Bitmap albumBitmap = MediaUtils.getArtwork(PlayActivity.this, localSong.getSongInfo().getId(), localSong.getSongInfo().getAlbumId(), true, false);
            iv_album.setImageBitmap(albumBitmap);
            seekBar.setProgress(0);     //设置当前进度
            seekBar.setMax((int) localSong.getSongInfo().getDuration());    //设置进度的最大值
        }

        if (localSong.isBool()) {
            iv_play_pause.setImageResource(R.mipmap.player_btn_pause_normal);
        } else {
            iv_play_pause.setImageResource(R.mipmap.player_btn_play_normal);
        }

    }

    /**
     * EventBus接收从service中接收歌曲信息来实现更新UI(网络歌曲)
     *
     * @param netSong
     */
    public void onEventMainThread(NetSong netSong) {
        String name = netSong.getBean().getSongs().get(netSong.getPosition()).getName();

        tv_title.setText(name);
        tv_end_time.setText(MediaUtils.formatTime(netSong.getBean().getSongs().get(netSong.getPosition()).getAuditionList().get(0).getDuration()));
        iv_album.setImageResource(R.mipmap.music_album);
        seekBar.setProgress(0);
        seekBar.setMax((int) netSong.getBean().getSongs().get(netSong.getPosition()).getAuditionList().get(0).getDuration());

        if (netSong.isBool()) {
            iv_play_pause.setImageResource(R.mipmap.player_btn_pause_normal);
        } else {
            iv_play_pause.setImageResource(R.mipmap.player_btn_play_normal);
        }
    }

    /**
     * EventBus接收从service中接收进度值来更新进度条的
     *
     * @param progress
     */
    public void onEventMainThread(UpdateProgress progress) {
        tv_start_time.setText(MediaUtils.formatTime(progress.getProgress()));
        seekBar.setProgress(progress.getProgress());
    }

    /**
     * EventBus接收从service中接收音乐是否是暂停更新播放按钮
     *
     * @param change
     */
    public void onEventMainThread(ChangePlayButton change) {
        if (change.isChangeUI()) {
            Log.e("---", "onEventMainThread方法执行");
            iv_play_pause.setImageResource(R.mipmap.player_btn_play_normal);
            playService.pause();
            isPause = false;
        }
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_previous:
                if (playService.getChangePlayList() != PlayService.NET_MUSIC_LIST) {
                    playService.prev();
                } else {
                    playService.netPrev();
                }
                break;

            case R.id.iv_play_pause:
                if (playService.isPlaying()) {  //如果是正在播放,换一张图片并且暂停
                    iv_play_pause.setImageResource(R.mipmap.player_btn_play_normal);
                    playService.pause();
                } else {
                    if (playService.isPause()) {
                        iv_play_pause.setImageResource(R.mipmap.player_btn_pause_normal);
                        playService.start();
                    } else {
                        playService.play(playService.getCurrentPosition());
                    }
                    isPause = false;
                }
                break;

            case R.id.iv_next:
                if (playService.getChangePlayList() != PlayService.NET_MUSIC_LIST) {
                    playService.next();
                } else {
                    playService.netNext();
                }
                break;

            case R.id.iv_favorite:
                Toast.makeText(PlayActivity.this, "暂不支持收藏功能~", Toast.LENGTH_SHORT).show();
                break;

            case R.id.iv_play_mode:
                changePlayMode();   //改变播放模式
                break;
        }
    }

    /**
     * 改变播放模式的方法
     */
    public void changePlayMode() {
        //int mode = (int) iv_play_mode.getTag();
        int mode = playService.getPlay_mode();
        Log.e("现在的播放模式是:", playService.getPlay_mode() + "");
        switch (mode) {
            case PlayService.ORDER_PLAY:
                iv_play_mode.setImageResource(R.mipmap.random);
                iv_play_mode.setTag(PlayService.RANDOM_PLAY);
                playService.setPlay_mode(PlayService.RANDOM_PLAY);
                Toast.makeText(PlayActivity.this, "随机播放", Toast.LENGTH_SHORT).show();
                break;

            case PlayService.RANDOM_PLAY:
                iv_play_mode.setImageResource(R.mipmap.single);
                iv_play_mode.setTag(PlayService.SINGLE_PLAY);
                playService.setPlay_mode(PlayService.SINGLE_PLAY);
                Toast.makeText(PlayActivity.this, "单曲循环", Toast.LENGTH_SHORT).show();
                break;

            case PlayService.SINGLE_PLAY:
                iv_play_mode.setImageResource(R.mipmap.order);
                iv_play_mode.setTag(PlayService.ORDER_PLAY);
                playService.setPlay_mode(PlayService.ORDER_PLAY);
                Toast.makeText(PlayActivity.this, "顺序播放", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    /**
     * 刚进入activity的时候从PlayService中读取播放模式,
     * 设置播放模式的图片
     */
    public void intoChangePlayModeImage() {
        int mode;
        if (null == playService) {
            mode=PlayService.ORDER_PLAY;
        }else {
            mode = playService.getPlay_mode();
        }
        // TODO 选择播放音乐不要马上点击PlayActivity
        switch (mode) {
            case PlayService.ORDER_PLAY:
                iv_play_mode.setImageResource(R.mipmap.order);
                break;

            case PlayService.RANDOM_PLAY:
                iv_play_mode.setImageResource(R.mipmap.random);
                break;

            case PlayService.SINGLE_PLAY:
                iv_play_mode.setImageResource(R.mipmap.single);
                break;
        }
    }

    /**
     * SeekBar.OnSeekBarChangeListener实现这个接口
     * 当进度条进度发生改变的方法
     *
     * @param seekBar
     * @param progress 进度
     * @param fromUser 表示是否是用户拖动的
     */
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if (fromUser) {
            playService.pause();
            playService.seekTo(progress);
        }
    }

    /**
     * SeekBar.OnSeekBarChangeListener实现这个接口
     * 开始拖动进度条的事件
     *
     * @param seekBar
     */
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    /**
     * SeekBar.OnSeekBarChangeListener实现这个接口
     * 结束拖动进度条的事件
     *
     * @param seekBar
     */
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        playService.start();
    }

    /**
     * ViewPager适配器
     */
    public class MyViewPagerAdapter extends PagerAdapter {

        private ArrayList<View> viewList = new ArrayList<>();

        public MyViewPagerAdapter(ArrayList<View> viewList) {
            this.viewList = viewList;
        }

        @Override
        public int getCount() {
            return viewList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(viewList.get(position));
            return viewList.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(viewList.get(position));
        }
    }
}