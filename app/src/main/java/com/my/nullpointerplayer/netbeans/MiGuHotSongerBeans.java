package com.my.nullpointerplayer.netbeans;

import java.util.List;

/**
 * 咪咕歌手的网络实体类
 * Created by dllo on 16/1/21.
 */
public class MiGuHotSongerBeans {


    /**
     * hots : [{"singerid":290049,"singer":"徐佳莹","img":"http://wlanwm.12530.com:8080/newcms/cms/2013/05/13/00/05/ART1301111633574035.jpg"},{"singerid":1002143102,"singer":"鹿晗","img":"http://wlanwm.12530.com:8080/newcms/cms/2015/1225/0930/ARTS1412031134067826.jpg"},{"singerid":957295,"singer":"张杰","img":"http://wlanwm.12530.com:8080/newcms/cms/2013/05/13/00/00/ART1301102158008495.jpg"},{"singerid":112,"singer":"周杰伦","img":"http://wlanwm.12530.com:8080/newcms/cms/2015/1126/1110/ARTS150423143523211.jpg"},{"singerid":116,"singer":"陈奕迅","img":"http://wlanwm.12530.com:8080/newcms/cms/2016/0112/1030/ARTS150209111450600.jpg"},{"singerid":627,"singer":"张靓颖","img":"http://wlanwm.12530.com:8080/newcms/cms/2015/1126/1650/ARTS140520092512408.jpg"},{"singerid":1000000747,"singer":"G.E.M.邓紫棋","img":"http://wlanwm.12530.com:8080/newcms/cms/2016/0120/1550/ARTS150423113642738.jpg"},{"singerid":1000001086,"singer":"李荣浩","img":"http://wlanwm.12530.com:8080/newcms/cms/2013/05/03/15/05/ART1304221034314891.jpg"},{"singerid":266,"singer":"林俊杰","img":"http://wlanwm.12530.com:8080/newcms/cms/2015/1204/1520/ARTS1512041418106213.jpg"},{"singerid":1000030332,"singer":"庄心妍","img":"http://wlanwm.12530.com:8080/newcms/cms/2013/05/12/23/45/ART130209091039181.jpg"},{"singerid":18196,"singer":"许嵩","img":"http://wlanwm.12530.com:8080/newcms/cms/2013/05/13/00/00/ART1212131151214517.jpg"},{"singerid":270,"singer":"王力宏","img":"http://wlanwm.12530.com:8080/newcms/cms/2013/05/03/14/55/ART1301102020493613.jpg"},{"singerid":1024431,"singer":"曲婉婷","img":"http://wlanwm.12530.com:8080/newcms/cms/2013/05/13/00/00/ART130228092544878.jpg"},{"singerid":335,"singer":"杨坤","img":"http://wlanwm.12530.com:8080/newcms/cms/2013/05/13/00/00/ART1301101713045001.jpg"}]
     * categories : [{"title":"华语男歌手","group":1,"url":"http://218.200.160.29/rdp2/v5.5/singer_categoryinfo.do?groupcode=1418/1551/1608"},{"title":"华语女歌手","group":1,"url":"http://218.200.160.29/rdp2/v5.5/singer_categoryinfo.do?groupcode=1418/1551/1623"},{"title":"华语组合","group":1,"url":"http://218.200.160.29/rdp2/v5.5/singer_categoryinfo.do?groupcode=1418/1551/6211"},{"title":"欧美男歌手","group":2,"url":"http://218.200.160.29/rdp2/v5.5/singer_categoryinfo.do?groupcode=1418/1551/6148"},{"title":"欧美女歌手","group":2,"url":"http://218.200.160.29/rdp2/v5.5/singer_categoryinfo.do?groupcode=1418/1551/6162"},{"title":"欧美组合","group":2,"url":"http://218.200.160.29/rdp2/v5.5/singer_categoryinfo.do?groupcode=1418/1551/6200"},{"title":"日韩男歌手","group":3,"url":"http://218.200.160.29/rdp2/v5.5/singer_categoryinfo.do?groupcode=1418/1551/35075"},{"title":"日韩女歌手","group":3,"url":"http://218.200.160.29/rdp2/v5.5/singer_categoryinfo.do?groupcode=1418/1551/35240"},{"title":"日韩组合","group":3,"url":"http://218.200.160.29/rdp2/v5.5/singer_categoryinfo.do?groupcode=1418/1551/35268"}]
     * pagecount : 1
     * totalcount : 10
     * groupcode : 1418/1551
     * publishTime : 2016-01-19 14:00:23
     * code : 000000
     * info : 成功
     */

    private int pagecount;
    private int totalcount;
    private String groupcode;
    private String publishTime;
    private String code;
    private String info;
    /**
     * singerid : 290049
     * singer : 徐佳莹
     * img : http://wlanwm.12530.com:8080/newcms/cms/2013/05/13/00/05/ART1301111633574035.jpg
     */

    private List<HotsEntity> hots;
    /**
     * title : 华语男歌手
     * group : 1
     * url : http://218.200.160.29/rdp2/v5.5/singer_categoryinfo.do?groupcode=1418/1551/1608
     */

    private List<CategoriesEntity> categories;

    public void setPagecount(int pagecount) {
        this.pagecount = pagecount;
    }

    public void setTotalcount(int totalcount) {
        this.totalcount = totalcount;
    }

    public void setGroupcode(String groupcode) {
        this.groupcode = groupcode;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setHots(List<HotsEntity> hots) {
        this.hots = hots;
    }

    public void setCategories(List<CategoriesEntity> categories) {
        this.categories = categories;
    }

    public int getPagecount() {
        return pagecount;
    }

    public int getTotalcount() {
        return totalcount;
    }

    public String getGroupcode() {
        return groupcode;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public String getCode() {
        return code;
    }

    public String getInfo() {
        return info;
    }

    public List<HotsEntity> getHots() {
        return hots;
    }

    public List<CategoriesEntity> getCategories() {
        return categories;
    }

    public static class HotsEntity {
        private int singerid;
        private String singer;
        private String img;

        public void setSingerid(int singerid) {
            this.singerid = singerid;
        }

        public void setSinger(String singer) {
            this.singer = singer;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public int getSingerid() {
            return singerid;
        }

        public String getSinger() {
            return singer;
        }

        public String getImg() {
            return img;
        }
    }

    public static class CategoriesEntity {
        private String title;
        private int group;
        private String url;

        public void setTitle(String title) {
            this.title = title;
        }

        public void setGroup(int group) {
            this.group = group;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getTitle() {
            return title;
        }

        public int getGroup() {
            return group;
        }

        public String getUrl() {
            return url;
        }
    }
}
