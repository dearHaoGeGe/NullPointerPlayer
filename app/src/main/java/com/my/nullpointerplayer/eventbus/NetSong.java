package com.my.nullpointerplayer.eventbus;

import com.my.nullpointerplayer.netbeans.AllNetSongBeans;

/**
 * EventBus发送网络歌曲的实体类
 * Created by dllo on 16/1/29.
 */
public class NetSong {
    private AllNetSongBeans bean;
    private boolean bool;   //判断是否正在播放和暂停的
    private int position;   //位置

    public NetSong(AllNetSongBeans bean, boolean bool, int position) {
        this.bean = bean;
        this.bool = bool;
        this.position = position;
    }

    public AllNetSongBeans getBean() {
        return bean;
    }

    public void setBean(AllNetSongBeans bean) {
        this.bean = bean;
    }

    public boolean isBool() {
        return bool;
    }

    public void setBool(boolean bool) {
        this.bool = bool;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
