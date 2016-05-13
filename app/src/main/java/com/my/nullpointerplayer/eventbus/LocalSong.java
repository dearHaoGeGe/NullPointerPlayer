package com.my.nullpointerplayer.eventbus;

import com.my.nullpointerplayer.songbeans.SongInfo;

/**
 * 传送本地歌曲信息的EventBus类
 *
 * Created by dllo on 16/1/27.
 */
public class LocalSong{

    private SongInfo songInfo;
    private boolean bool;   /** 判断是否正在播放和暂停的 **/

    public LocalSong(boolean bool, SongInfo songInfo) {
        this.bool = bool;
        this.songInfo = songInfo;
    }

    public SongInfo getSongInfo() {
        return songInfo;
    }

    public void setSongInfo(SongInfo songInfo) {
        this.songInfo = songInfo;
    }

    public boolean isBool() {
        return bool;
    }

    public void setBool(boolean bool) {
        this.bool = bool;
    }
}
