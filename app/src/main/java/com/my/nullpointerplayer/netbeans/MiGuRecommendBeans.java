package com.my.nullpointerplayer.netbeans;

import java.util.List;

/**
 * 咪咕推荐网络实体类
 * <p/>
 * Created by dllo on 16/1/16.
 */
public class MiGuRecommendBeans {
    private String groupcode;
    private String publishTime;
    private String code;
    private String info;
    private List<Groups> groups;

    public class Groups {
        private String title;
        private int type;
        private int sort;
        private List<Banners> banners;          //viewpager的内容的Banners类
        private List<HotSpots> hotSpots;        //音乐之声的hotSpots类
        private List<Recommends> recommends;    //每日推荐的recommends类
        private String url;                         //热门歌曲的url
        private List<Songs> songs;              //热门歌曲的songs类
        private List<MiguColumns> miguColumns;  //咪咕专栏的miguColumns类

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public List<Banners> getBanners() {
            return banners;
        }

        public void setBanners(List<Banners> banners) {
            this.banners = banners;
        }

        public List<HotSpots> getHotSpots() {
            return hotSpots;
        }

        public void setHotSpots(List<HotSpots> hotSpots) {
            this.hotSpots = hotSpots;
        }

        public List<Recommends> getRecommends() {
            return recommends;
        }

        public void setRecommends(List<Recommends> recommends) {
            this.recommends = recommends;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public List<Songs> getSongs() {
            return songs;
        }

        public void setSongs(List<Songs> songs) {
            this.songs = songs;
        }

        public List<MiguColumns> getMiguColumns() {
            return miguColumns;
        }

        public void setMiguColumns(List<MiguColumns> miguColumns) {
            this.miguColumns = miguColumns;
        }
    }

    /**
     * viewpager的内容的Banners类
     */
    public class Banners {
        private String title;
        private int type;
        private String img;
        private String url;
        private String groupcode;
        private String sourceId;
        private String shareUrl;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getGroupcode() {
            return groupcode;
        }

        public void setGroupcode(String groupcode) {
            this.groupcode = groupcode;
        }

        public String getSourceId() {
            return sourceId;
        }

        public void setSourceId(String sourceId) {
            this.sourceId = sourceId;
        }

        public String getShareUrl() {
            return shareUrl;
        }

        public void setShareUrl(String shareUrl) {
            this.shareUrl = shareUrl;
        }
    }

    /**
     * 音乐之声的hotSpots类
     */
    public class HotSpots {
        private int type;
        private String title;
        private String img;
        private String summary;
        private String url;
        private String groupcode;
        private String sourceId;
        private String shareUrl;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getGroupcode() {
            return groupcode;
        }

        public void setGroupcode(String groupcode) {
            this.groupcode = groupcode;
        }

        public String getSourceId() {
            return sourceId;
        }

        public void setSourceId(String sourceId) {
            this.sourceId = sourceId;
        }

        public String getShareUrl() {
            return shareUrl;
        }

        public void setShareUrl(String shareUrl) {
            this.shareUrl = shareUrl;
        }
    }

    /**
     * 每日推荐的recommends类
     */
    public class Recommends {
        private int type;
        private String title;
        private String contentid;
        private String summary;
        private String img;
        private String url;
        private int playNums;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContentid() {
            return contentid;
        }

        public void setContentid(String contentid) {
            this.contentid = contentid;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getPlayNums() {
            return playNums;
        }

        public void setPlayNums(int playNums) {
            this.playNums = playNums;
        }
    }

    /**
     * 热门歌曲的songs类
     */
    public class Songs {
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

    /**
     * 咪咕专栏的miguColumns类
     */
    public class MiguColumns {
        private int type;
        private String title;
        private String img;
        private String summary;
        private String url;
        private String groupcode;
        private String sourceId;
        private String shareUrl;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getGroupcode() {
            return groupcode;
        }

        public void setGroupcode(String groupcode) {
            this.groupcode = groupcode;
        }

        public String getSourceId() {
            return sourceId;
        }

        public void setSourceId(String sourceId) {
            this.sourceId = sourceId;
        }

        public String getShareUrl() {
            return shareUrl;
        }

        public void setShareUrl(String shareUrl) {
            this.shareUrl = shareUrl;
        }
    }

    /**
     * 以下是HomePagerBeans的get、set方法
     *
     * @return
     */

    public String getGroupcode() {
        return groupcode;
    }

    public void setGroupcode(String groupcode) {
        this.groupcode = groupcode;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public List<Groups> getGroups() {
        return groups;
    }

    public void setGroups(List<Groups> groups) {
        this.groups = groups;
    }

}
