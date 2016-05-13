package com.my.nullpointerplayer.songbeans;

import java.io.Serializable;

/**
 * 本地歌曲实体类
 * implements Serializable接口是因为activity和activity传对象
 * 实现这个接口才能传
 * Created by dllo on 16/1/26.
 */
public class SongInfo implements Serializable {
    private long id;
    private long songInfoId;//在收藏音乐时用于保存原始ID
    private long playTime;  //最近播放时间(毫秒形式储存)
    private int isLike;     //1.喜欢    0.默认
    private String title;   //歌名
    private String artist;  //艺术家
    private String album;   //专辑
    private long albumId;   //
    private long duration;  //时长
    private long size;      //大小
    private String url;     //路径
    private int isMusic;    //是否为音乐

    public long getPlayTime() {
        return playTime;
    }

    public void setPlayTime(long playTime) {
        this.playTime = playTime;
    }

    public int getIsLike() {
        return isLike;
    }

    public void setIsLike(int isLike) {
        this.isLike = isLike;
    }

    public long getSongInfoId() {
        return songInfoId;
    }

    public void setSongInfoId(long songInfoId) {
        this.songInfoId = songInfoId;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(long albumId) {
        this.albumId = albumId;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getIsMusic() {
        return isMusic;
    }

    public void setIsMusic(int isMusic) {
        this.isMusic = isMusic;
    }
}
