package com.my.nullpointerplayer.netbeans;

import java.util.List;

/**
 * 咪咕音乐列表的网络实体类
 * Created by dllo on 16/1/19.
 */
public class MiGuSongListBeans {

    private String id;
    private String img;
    private int playNums;
    private int keepNums;
    private int keeped;
    private String summary;
    private List<Songs> songs;
    private String groupcode;
    private String shareTitle;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getPlayNums() {
        return playNums;
    }

    public void setPlayNums(int playNums) {
        this.playNums = playNums;
    }

    public int getKeepNums() {
        return keepNums;
    }

    public void setKeepNums(int keepNums) {
        this.keepNums = keepNums;
    }

    public int getKeeped() {
        return keeped;
    }

    public void setKeeped(int keeped) {
        this.keeped = keeped;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getGroupcode() {
        return groupcode;
    }

    public void setGroupcode(String groupcode) {
        this.groupcode = groupcode;
    }

    public List<Songs> getSongs() {
        return songs;
    }

    public void setSongs(List<Songs> songs) {
        this.songs = songs;
    }

    public String getShareTitle() {
        return shareTitle;
    }

    public void setShareTitle(String shareTitle) {
        this.shareTitle = shareTitle;
    }

    public class Songs{
        private String contentid;
        private String groupcode;
        private String title;
        private String singerid;
        private String singer;
        private String singerIcon;
        private String singerImg;
        private String albumid;
        private String album;
        private String albumIcon;
        private String albumImg;
        private String url;
        private String control;
        private String toneControl;
        private int hqFlag;
        private String isring_cid;
        private String isring_sid;

        public String getContentid() {
            return contentid;
        }

        public void setContentid(String contentid) {
            this.contentid = contentid;
        }

        public String getGroupcode() {
            return groupcode;
        }

        public void setGroupcode(String groupcode) {
            this.groupcode = groupcode;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSingerid() {
            return singerid;
        }

        public void setSingerid(String singerid) {
            this.singerid = singerid;
        }

        public String getSinger() {
            return singer;
        }

        public void setSinger(String singer) {
            this.singer = singer;
        }

        public String getSingerIcon() {
            return singerIcon;
        }

        public void setSingerIcon(String singerIcon) {
            this.singerIcon = singerIcon;
        }

        public String getSingerImg() {
            return singerImg;
        }

        public void setSingerImg(String singerImg) {
            this.singerImg = singerImg;
        }

        public String getAlbumid() {
            return albumid;
        }

        public void setAlbumid(String albumid) {
            this.albumid = albumid;
        }

        public String getAlbum() {
            return album;
        }

        public void setAlbum(String album) {
            this.album = album;
        }

        public String getAlbumIcon() {
            return albumIcon;
        }

        public void setAlbumIcon(String albumIcon) {
            this.albumIcon = albumIcon;
        }

        public String getAlbumImg() {
            return albumImg;
        }

        public void setAlbumImg(String albumImg) {
            this.albumImg = albumImg;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getControl() {
            return control;
        }

        public void setControl(String control) {
            this.control = control;
        }

        public String getToneControl() {
            return toneControl;
        }

        public void setToneControl(String toneControl) {
            this.toneControl = toneControl;
        }

        public int getHqFlag() {
            return hqFlag;
        }

        public void setHqFlag(int hqFlag) {
            this.hqFlag = hqFlag;
        }

        public String getIsring_cid() {
            return isring_cid;
        }

        public void setIsring_cid(String isring_cid) {
            this.isring_cid = isring_cid;
        }

        public String getIsring_sid() {
            return isring_sid;
        }

        public void setIsring_sid(String isring_sid) {
            this.isring_sid = isring_sid;
        }
    }
}
