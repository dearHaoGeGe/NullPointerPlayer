package com.my.nullpointerplayer.service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import com.my.nullpointerplayer.eventbus.ChangePlayButton;
import com.my.nullpointerplayer.eventbus.SleepTime;
import com.my.nullpointerplayer.netbeans.AllNetSongBeans;
import com.my.nullpointerplayer.songbeans.SongInfo;
import com.my.nullpointerplayer.eventbus.IsMainActivityCreate;
import com.my.nullpointerplayer.eventbus.IsPlayActivityCreate;
import com.my.nullpointerplayer.eventbus.LocalSong;
import com.my.nullpointerplayer.eventbus.NetSong;
import com.my.nullpointerplayer.eventbus.UpdateProgress;
import com.my.nullpointerplayer.utils.MediaUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import de.greenrobot.event.EventBus;

/**
 * 本类所有播放音乐的核心，本地音乐、网络音乐、
 * 暂停及播放等
 * <p>
 * Created by dllo on 16/1/26.
 */
public class PlayService extends Service implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener {

    private MediaPlayer mediaPlayer;
    private int currentPosition;        //当前正在播放本地歌曲的位置
    private int netCurrentPosition;     //当前正在播放网络歌曲的位置
    private ArrayList<SongInfo> songInfos;  //本地歌曲
    //private SongListBeans beans;        //网络歌曲
    private AllNetSongBeans beans;
    private ExecutorService executorService = Executors.newSingleThreadExecutor();   //线程池
    private Random random = new Random();   //控制随机播放的Random对象
    private boolean isPause = false;  //用来确定歌曲是否是在暂停状态
    private HeadsetPlugReceiver headsetPlugReceiver;    //接收是否拔出耳机的广播
    private AudioManager audioManager;

    //用来切换播放列表的
    public static final int LOCAL_MUSIC_LIST = 1;       //本地音乐列表
    public static final int LIKE_MUSIC_LIST = 2;        //我喜欢的列表
    public static final int PLAY_RECORD_MUSIC_LIST = 3; //最近播放的列表
    public static final int NET_MUSIC_LIST = 4;         //网络在线播放
    private int changePlayList = LOCAL_MUSIC_LIST;      //默认为本地音乐

    //三种播放模式
    public static final int ORDER_PLAY = 1;     //顺序
    public static final int RANDOM_PLAY = 2;    //随机
    public static final int SINGLE_PLAY = 3;    //单曲循环
    private int play_mode = ORDER_PLAY;         //默认为顺序播放

    //接收定时停止音乐的handler
    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    Toast.makeText(PlayService.this, "时间已到,歌曲停止！", Toast.LENGTH_SHORT).show();
                    break;
            }
            EventBus.getDefault().post(new ChangePlayButton(true));    //发送EventBus
            pause();
            return false;
        }
    });

    public MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    public void setMediaPlayer(MediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public int getNetCurrentPosition() {
        return netCurrentPosition;
    }

    public void setNetCurrentPosition(int netCurrentPosition) {
        this.netCurrentPosition = netCurrentPosition;
    }

    public ArrayList<SongInfo> getSongInfos() {
        return songInfos;
    }

    public void setSongInfos(ArrayList<SongInfo> songInfos) {
        this.songInfos = songInfos;
    }

    public ExecutorService getExecutorService() {
        return executorService;
    }

    public void setExecutorService(ExecutorService executorService) {
        this.executorService = executorService;
    }

    public boolean isPause() {
        return isPause;
    }

    public void setIsPause(boolean isPause) {
        this.isPause = isPause;
    }

    public static int getLocalMusicList() {
        return LOCAL_MUSIC_LIST;
    }

    public static int getLikeMusicList() {
        return LIKE_MUSIC_LIST;
    }

    public static int getPlayRecordMusicList() {
        return PLAY_RECORD_MUSIC_LIST;
    }

    public static int getNetMusicList() {
        return NET_MUSIC_LIST;
    }

    public int getChangePlayList() {
        return changePlayList;
    }

    public void setChangePlayList(int changePlayList) {
        this.changePlayList = changePlayList;
    }

    public static int getOrderPlay() {
        return ORDER_PLAY;
    }

    public static int getRandomPlay() {
        return RANDOM_PLAY;
    }

    public static int getSinglePlay() {
        return SINGLE_PLAY;
    }

    public int getPlay_mode() {
        return play_mode;
    }

    public void setPlay_mode(int play_mode) {
        this.play_mode = play_mode;
    }

//    public SongListBeans getBeans() {
//        return beans;
//    }
//
//    public void setBeans(SongListBeans beans) {
//        this.beans = beans;
//    }


    public AllNetSongBeans getBeans() {
        return beans;
    }

    public void setBeans(AllNetSongBeans beans) {
        this.beans = beans;
    }

    public PlayService() {

    }

    @Override
    public IBinder onBind(Intent intent) {
        return new PlayBinder();
    }


    public class PlayBinder extends Binder {

        public PlayService getPlayService() {
            return PlayService.this;
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        EventBus.getDefault().register(this);   //注册EventBus
        registerHeadsetPlugReceiver();          //注册广播接受者
        Toast.makeText(PlayService.this, "服务创建成功", Toast.LENGTH_SHORT).show();
        mediaPlayer = new MediaPlayer();

        if (!isPlaying()) {     // TODO 还要判断本地没有歌曲的情况
            ArrayList<SongInfo> songInfos = MediaUtils.getSongInfos(this);
            setSongInfos(songInfos);
            //setChangePlayList(PlayService.LOCAL_MUSIC_LIST);
            setCurrentPosition(0);
        }

        mediaPlayer.setOnCompletionListener(this);
        mediaPlayer.setOnErrorListener(this);

        executorService.execute(updateStatusRunnable);
    }

    /**
     * EventBus接收MainActivity发过来的创建成功的消息,
     * 当接收到消息后,把service中歌曲的信息发送到MainActivity,
     * MainActivity接收到消息后更新UI
     *
     * @param bool
     */
    public void onEventMainThread(IsMainActivityCreate bool) {
        Log.e("------", "PlayService已经接收到MainActivity创建的消息");
        if (getChangePlayList() != PlayService.NET_MUSIC_LIST) {
//            if (isPlaying()) {
//                SongInfo songInfo = songInfos.get(currentPosition);
//                EventBus.getDefault().post(new LocalSong(true, songInfo));    //播放的时候发送EventBus
//            }
//            if (!isPlaying() || isPause()) {    //如果音乐在暂停状态的话,播放按钮图片不更换
//                EventBus.getDefault().post(new LocalSong(false, songInfos.get(currentPosition)));
//            }
            if (isPlaying()) {
                SongInfo songInfo = songInfos.get(currentPosition);
                EventBus.getDefault().post(new LocalSong(true, songInfo));    //播放的时候发送EventBus
            } else {    //如果音乐在暂停状态的话,播放按钮图片不更换
                EventBus.getDefault().post(new LocalSong(false, songInfos.get(currentPosition)));
            }

        } else {
//            if (isPlaying()) {
//                EventBus.getDefault().post(new NetSong(beans, true, getNetCurrentPosition()));    //播放的时候发送EventBus
//            }
//            if (!isPlaying() || isPause()) {    //如果音乐在暂停状态的话,播放按钮图片不更换
//                EventBus.getDefault().post(new NetSong(beans, false, getNetCurrentPosition()));
//            }
            if (isPlaying()) {
                EventBus.getDefault().post(new NetSong(beans, true, getNetCurrentPosition()));    //播放的时候发送EventBus
            } else {    //如果音乐在暂停状态的话,播放按钮图片不更换
                EventBus.getDefault().post(new NetSong(beans, false, getNetCurrentPosition()));
            }
        }

    }

    /**
     * EventBus接收PlayActivity发过来的创建成功的消息,
     * 当接收到消息后,把service中歌曲的信息发送到PlayActivity,
     * PlayActivity接收到消息后更新UI
     *
     * @param bool
     */
    public void onEventMainThread(IsPlayActivityCreate bool) {
        Log.e("------", "PlayService已经接收到PlayActivity创建的消息");
        if (getChangePlayList() != PlayService.NET_MUSIC_LIST) {
//            if (isPlaying() && bool.isBool()) {
//                SongInfo songInfo = songInfos.get(currentPosition);
//                EventBus.getDefault().post(new LocalSong(true, songInfo));    //播放的时候发送EventBus
//            }
//            if (!isPlaying() || isPause()) {    //如果音乐在暂停状态的话,播放按钮图片不更换
//                EventBus.getDefault().post(new LocalSong(false, songInfos.get(currentPosition)));
//            }
            if (isPlaying()) {
                SongInfo songInfo = songInfos.get(currentPosition);
                EventBus.getDefault().post(new LocalSong(true, songInfo));    //播放的时候发送EventBus
            } else {
                EventBus.getDefault().post(new LocalSong(false, songInfos.get(currentPosition)));
            }

        } else {
//            if (isPlaying() && bool.isBool()) {
//                EventBus.getDefault().post(new NetSong(beans, true, getNetCurrentPosition()));    //播放的时候发送EventBus
//            }
//            if (!isPlaying() || isPause()) {    //如果音乐在暂停状态的话,播放按钮图片不更换
//                EventBus.getDefault().post(new NetSong(beans, false, getCurrentPosition()));
//            }
            if (isPlaying()) {
                EventBus.getDefault().post(new NetSong(beans, true, getNetCurrentPosition()));    //播放的时候发送EventBus
            } else {    //如果音乐在暂停状态的话,播放按钮图片不更换
                EventBus.getDefault().post(new NetSong(beans, false, getNetCurrentPosition()));
            }
        }
    }


    /**
     * 这个是从SettingFragment接收时间的
     *
     * @param sleepTime
     */
    public void onEventMainThread(SleepTime sleepTime) {

        timedShutdownService(sleepTime.getSleepTime());
    }

    /**
     * 设置音乐暂停
     *
     * @param time
     */
    public void timedShutdownService(int time) {
        final int sleepTime = time * 1000;
        Log.e("sleepTime=", sleepTime + "");
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(sleepTime);
                    handler.sendEmptyMessage(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    /**
     * 控制耳机拔出音乐暂停的广播接收者
     */
    public class HeadsetPlugReceiver extends BroadcastReceiver {

        private static final String TAG = "HeadsetPlugReceiver";

        @Override
        public void onReceive(Context context, Intent intent) {

            audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
            boolean isHeadsetOn = audioManager.isWiredHeadsetOn();

            if (intent.hasExtra("state")) {
                if (intent.getIntExtra("state", 0) == 0) {
                    Toast.makeText(context, "耳机未连接" + isHeadsetOn, Toast.LENGTH_LONG).show();
                } else if (intent.getIntExtra("state", 0) == 1) {
                    Toast.makeText(context, "耳机连接" + isHeadsetOn, Toast.LENGTH_LONG).show();
                }

                //判断耳机拔出的状态值改变
                if (!isHeadsetOn && isPlaying()) {
                    EventBus.getDefault().post(new ChangePlayButton(true));    //发送EventBus
                    pause();
                }
            }
        }
    }

    /**
     * 注册耳机广播方法
     */
    private void registerHeadsetPlugReceiver() {
        headsetPlugReceiver = new HeadsetPlugReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.HEADSET_PLUG");
        registerReceiver(headsetPlugReceiver, intentFilter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //回收线程
        if (null != executorService && !executorService.isShutdown()) {
            executorService.shutdown();
            executorService = null;
        }
        unregisterReceiver(headsetPlugReceiver);
        EventBus.getDefault().unregister(this);     //取消注册EventBus
    }

    @Override
    public boolean onError(MediaPlayer mediaPlayer, int i, int i1) {
        mediaPlayer.reset();
        return false;
    }


    /**
     * 当一首歌播放完成之后怎么做
     *
     * @param mediaPlayer
     */
    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {
        switch (play_mode) {
            case ORDER_PLAY:
                //next();
                if (getChangePlayList() != PlayService.NET_MUSIC_LIST) {
                    next();
                } else {
                    netNext();
                }
                break;

            case RANDOM_PLAY:
                //play(random.nextInt(songInfos.size()));
                if (getChangePlayList() != PlayService.NET_MUSIC_LIST) {
                    play(random.nextInt(songInfos.size()));
                } else {
                    play(random.nextInt(getBeans().getSongs().size()));
                }
                break;

            case SINGLE_PLAY:
                //play(currentPosition);
                if (getChangePlayList() != PlayService.NET_MUSIC_LIST) {
                    play(currentPosition);
                } else {
                    netPlay(netCurrentPosition);
                }
                break;
        }
    }

    /**
     * 控制进度条的刷新进度的线程
     */
    Runnable updateStatusRunnable = new Runnable() {
        @Override
        public void run() {
            while (true) {
                if (null != mediaPlayer && mediaPlayer.isPlaying()) {
                    EventBus.getDefault().post(new UpdateProgress(getCurrentProgress()));   //EventBus往PlayActivity中传递进度
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    };

    /**
     * 播放
     *
     * @param position
     */
    public void play(int position) {
        SongInfo songInfo = null;
        if (position < 0 || position >= songInfos.size()) {
            position = 0;
        }
        songInfo = songInfos.get(position);
        try {
            mediaPlayer.reset();
            mediaPlayer.setDataSource(this, Uri.parse(songInfo.getUrl()));
            mediaPlayer.prepare();
            mediaPlayer.start();
            currentPosition = position;
        } catch (IOException e) {
            e.printStackTrace();
        }
        EventBus.getDefault().post(new LocalSong(true, songInfo));    //播放的时候发送EventBus
    }

    /**
     * 暂停
     */
    public void pause() {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
            isPause = true;
        }
    }

    /**
     * 下一首
     */
    public void next() {
        if (currentPosition + 1 > songInfos.size() - 1) {
            currentPosition = 0;
        } else {
            currentPosition++;
        }
        play(currentPosition);
    }

    /**
     * 上一首
     */
    public void prev() {
        if (currentPosition - 1 < 0) {
            currentPosition = songInfos.size() - 1;
        } else {
            currentPosition--;
        }
        play(currentPosition);
    }

    /**
     * 开始
     */
    public void start() {
        //如果mediaPlayer不是正在播放的状态并且不等于空,开始播放
        if (null != mediaPlayer && !mediaPlayer.isPlaying()) {
            mediaPlayer.start();
        }
    }


    /**
     * 判断音乐是否是正在播放
     *
     * @return
     */
    public boolean isPlaying() {
        if (mediaPlayer != null) {
            return mediaPlayer.isPlaying();
        }
        return false;
    }

    /**
     * 获取进度条位置
     *
     * @return
     */
    public int getCurrentProgress() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            return mediaPlayer.getCurrentPosition();
        }
        return 0;
    }

    /**
     * 控制进度条调到哪
     *
     * @param mesc
     */
    public void seekTo(int mesc) {
        mediaPlayer.seekTo(mesc);
    }

    /**
     * 网络播放
     *
     * @param position
     */
    public void netPlay(int position) {
        //final String url = beans.getSongs().get(position).getAuditionList().get(0).getUrl();
        final int pos = position;
        if (position < 0 || position >= getBeans().getSongs().size()) {
            netCurrentPosition = 0;
        }

        // 网络加载时耗时工作所以要开一个线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    mediaPlayer.reset();
                    mediaPlayer.setDataSource(PlayService.this, Uri.parse(getBeans().getSongs().get(pos).getAuditionList().get(0).getUrl()));
                    //Log.e("playService =", getBeans().getSongs().get(pos).getName() + "");
                    mediaPlayer.prepare();
                    mediaPlayer.start();
                    netCurrentPosition = pos;
                    EventBus.getDefault().post(new NetSong(beans, true, pos));    //播放的时候发送EventBus
                    isPause = false;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    /**
     * 网络播放下一首
     */
    public void netNext() {
        if (netCurrentPosition + 1 > beans.getSongs().size() - 1) {
            netCurrentPosition = 0;
        } else {
            netCurrentPosition++;
        }
        netPlay(netCurrentPosition);
    }

    /**
     * 网络播放上一首
     */
    public void netPrev() {
        if (netCurrentPosition - 1 < 0) {
            netCurrentPosition = beans.getSongs().size() - 1;
        } else {
            netCurrentPosition--;
        }
        netPlay(netCurrentPosition);
    }
}
