package com.my.nullpointerplayer.netbeans;

import java.util.List;

/**
 * Created by Administrator on 2016/2/12.
 */
public class AllNetSongBeans {

    /**
     * songId : 40621698
     * name : 绿罗裙
     * alias : 电视剧《大汉情缘之云中歌》片尾曲
     * remarks :
     * firstHit : false
     * librettistId : 53463
     * librettistName : null
     * composerId : 6364
     * composerName : null
     * singerId : 53463
     * singerName : Angelababy
     * singerSFlag : 1
     * albumId : 1137492
     * albumName : 大汉情缘之云中歌 电视原声带
     * favorites : 28755
     * originalId : 40621698
     * type : 0
     * tags : null
     * releaseYear : 2015
     * producer : 0
     * publisher : 0
     * status : 1
     * audit : 0
     * lang : 7
     * auditionList : [{"bitRate":32,"duration":240000,"size":999660,"suffix":"m4a","url":"http://om32.alicdn.com/695/78695/2100196736/1774739728_58761042_l.m4a?auth_key=3bef9fcb579a2ac9f4d2b21ec5958f1a-1455321600-0-null","typeDescription":"流畅品质"},{"bitRate":128,"duration":240000,"size":3856563,"suffix":"mp3","url":"http://m5.file.xiami.com/695/78695/2100196736/1774739728_58761042_l.mp3?auth_key=06c92d092fe5a1b1c5485062e05a636c-1455321600-0-null","typeDescription":"标准品质"},{"bitRate":320,"duration":240000,"size":9640563,"suffix":"mp3","url":"http://m6.file.xiami.com/695/78695/2100196736/1774739728_58761042_h.mp3?auth_key=6b0d9e33a336e1d1ca6115925522fdb9-1455321600-0-null","typeDescription":"超高品质"}]
     * urlList : [{"bitRate":32,"duration":240000,"size":999660,"suffix":"m4a","url":"http://om32.alicdn.com/695/78695/2100196736/1774739728_58761042_l.m4a?auth_key=3bef9fcb579a2ac9f4d2b21ec5958f1a-1455321600-0-null","typeDescription":"流畅品质"},{"bitRate":128,"duration":240000,"size":3856563,"suffix":"mp3","url":"http://m5.file.xiami.com/695/78695/2100196736/1774739728_58761042_l.mp3?auth_key=06c92d092fe5a1b1c5485062e05a636c-1455321600-0-null","typeDescription":"标准品质"},{"bitRate":320,"duration":240000,"size":9640563,"suffix":"mp3","url":"http://m6.file.xiami.com/695/78695/2100196736/1774739728_58761042_h.mp3?auth_key=6b0d9e33a336e1d1ca6115925522fdb9-1455321600-0-null","typeDescription":"超高品质"}]
     * llList : null
     * mvList : [{"id":0,"songId":0,"videoId":2001204,"picUrl":"http://3p.pic.ttdtweb.com/3p.ttpod.com/video/mv_pic/mv_pic_20/160_90/7847/285886/2001204.jpg","durationMilliSecond":120000,"duration":120000,"bitRate":6040,"path":"21d90ab442909651281e3a27897190fa","size":93469470,"suffix":"mp4","horizontal":1280,"vertical":720,"url":"http://otmv.alicdn.com/new/mv_12_20/21/fa/21d90ab442909651281e3a27897190fa.mp4?k=393c995711d40528&t=1455693373","type":2,"typeDescription":"1080P"},{"id":0,"songId":0,"videoId":2001204,"picUrl":"http://3p.pic.ttdtweb.com/3p.ttpod.com/video/mv_pic/mv_pic_20/160_90/7847/285886/2001204.jpg","durationMilliSecond":120000,"duration":120000,"bitRate":500,"path":"e356dbae72388909a6526d0d415d588b","size":10400028,"suffix":"mp4","horizontal":852,"vertical":480,"url":"http://otmv.alicdn.com/new/mv_1_20/e3/8b/e356dbae72388909a6526d0d415d588b.mp4?k=e9b33b3ae3adcd8a&t=1455693373","type":0,"typeDescription":"标清"}]
     * mvPickCount : 0
     * mvBulletCount : 0
     * outFlag : 0
     * outList : null
     * commentCount : 0
     * riskRank : 11
     * outLinks : []
     * rightKey : {"price":0,"vipFree":null,"paymentUnite":0,"orderType":0,"songRights":[{"bitRate":32,"downFlag":true,"listenFlag":true,"downBuyFlag":false,"listenBuyFlag":false,"downloadRightFlag":0,"auditionRightFlag":0},{"bitRate":320,"downFlag":true,"listenFlag":true,"downBuyFlag":false,"listenBuyFlag":false,"downloadRightFlag":0,"auditionRightFlag":0},{"bitRate":128,"downFlag":true,"listenFlag":true,"downBuyFlag":false,"listenBuyFlag":false,"downloadRightFlag":0,"auditionRightFlag":0}],"loginStatus":0,"musicPackage":[],"albumPackage":[],"promotionPackage":null}
     * operType : 0
     * level : 2
     * isExclusive : 0
     * picUrl : http://img.xiami.net/images/album/img12/123712/7084153911444888823_4.jpg
     * listenCount : 0
     * singers : [{"singerId":53463,"singerName":"Angelababy","singerSFlag":1,"shopId":0}]
     */

    private List<SongsEntity> songs;

    public void setSongs(List<SongsEntity> songs) {
        this.songs = songs;
    }

    public List<SongsEntity> getSongs() {
        return songs;
    }

    public static class SongsEntity {
        private int songId;
        private String name;
        private String alias;
        private String remarks;
        private boolean firstHit;
        private int librettistId;
        private Object librettistName;
        private int composerId;
        private Object composerName;
        private int singerId;
        private String singerName;
        private int singerSFlag;
        private int albumId;
        private String albumName;
        private int favorites;
        private int originalId;
        private int type;
        private Object tags;
        private int releaseYear;
        private int producer;
        private int publisher;
        private int status;
        private int audit;
        private int lang;
        private Object llList;
        private int mvPickCount;
        private int mvBulletCount;
        private int outFlag;
        private Object outList;
        private int commentCount;
        private int riskRank;
        /**
         * price : 0
         * vipFree : null
         * paymentUnite : 0
         * orderType : 0
         * songRights : [{"bitRate":32,"downFlag":true,"listenFlag":true,"downBuyFlag":false,"listenBuyFlag":false,"downloadRightFlag":0,"auditionRightFlag":0},{"bitRate":320,"downFlag":true,"listenFlag":true,"downBuyFlag":false,"listenBuyFlag":false,"downloadRightFlag":0,"auditionRightFlag":0},{"bitRate":128,"downFlag":true,"listenFlag":true,"downBuyFlag":false,"listenBuyFlag":false,"downloadRightFlag":0,"auditionRightFlag":0}]
         * loginStatus : 0
         * musicPackage : []
         * albumPackage : []
         * promotionPackage : null
         */

        private RightKeyEntity rightKey;
        private int operType;
        private String level;
        private int isExclusive;
        private String picUrl;
        private int listenCount;
        /**
         * bitRate : 32
         * duration : 240000
         * size : 999660
         * suffix : m4a
         * url : http://om32.alicdn.com/695/78695/2100196736/1774739728_58761042_l.m4a?auth_key=3bef9fcb579a2ac9f4d2b21ec5958f1a-1455321600-0-null
         * typeDescription : 流畅品质
         */

        private List<AuditionListEntity> auditionList;
        /**
         * bitRate : 32
         * duration : 240000
         * size : 999660
         * suffix : m4a
         * url : http://om32.alicdn.com/695/78695/2100196736/1774739728_58761042_l.m4a?auth_key=3bef9fcb579a2ac9f4d2b21ec5958f1a-1455321600-0-null
         * typeDescription : 流畅品质
         */

        private List<UrlListEntity> urlList;
        /**
         * id : 0
         * songId : 0
         * videoId : 2001204
         * picUrl : http://3p.pic.ttdtweb.com/3p.ttpod.com/video/mv_pic/mv_pic_20/160_90/7847/285886/2001204.jpg
         * durationMilliSecond : 120000
         * duration : 120000
         * bitRate : 6040
         * path : 21d90ab442909651281e3a27897190fa
         * size : 93469470
         * suffix : mp4
         * horizontal : 1280
         * vertical : 720
         * url : http://otmv.alicdn.com/new/mv_12_20/21/fa/21d90ab442909651281e3a27897190fa.mp4?k=393c995711d40528&t=1455693373
         * type : 2
         * typeDescription : 1080P
         */

        private List<MvListEntity> mvList;
        private List<?> outLinks;
        /**
         * singerId : 53463
         * singerName : Angelababy
         * singerSFlag : 1
         * shopId : 0
         */

        private List<SingersEntity> singers;

        public void setSongId(int songId) {
            this.songId = songId;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public void setRemarks(String remarks) {
            this.remarks = remarks;
        }

        public void setFirstHit(boolean firstHit) {
            this.firstHit = firstHit;
        }

        public void setLibrettistId(int librettistId) {
            this.librettistId = librettistId;
        }

        public void setLibrettistName(Object librettistName) {
            this.librettistName = librettistName;
        }

        public void setComposerId(int composerId) {
            this.composerId = composerId;
        }

        public void setComposerName(Object composerName) {
            this.composerName = composerName;
        }

        public void setSingerId(int singerId) {
            this.singerId = singerId;
        }

        public void setSingerName(String singerName) {
            this.singerName = singerName;
        }

        public void setSingerSFlag(int singerSFlag) {
            this.singerSFlag = singerSFlag;
        }

        public void setAlbumId(int albumId) {
            this.albumId = albumId;
        }

        public void setAlbumName(String albumName) {
            this.albumName = albumName;
        }

        public void setFavorites(int favorites) {
            this.favorites = favorites;
        }

        public void setOriginalId(int originalId) {
            this.originalId = originalId;
        }

        public void setType(int type) {
            this.type = type;
        }

        public void setTags(Object tags) {
            this.tags = tags;
        }

        public void setReleaseYear(int releaseYear) {
            this.releaseYear = releaseYear;
        }

        public void setProducer(int producer) {
            this.producer = producer;
        }

        public void setPublisher(int publisher) {
            this.publisher = publisher;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public void setAudit(int audit) {
            this.audit = audit;
        }

        public void setLang(int lang) {
            this.lang = lang;
        }

        public void setLlList(Object llList) {
            this.llList = llList;
        }

        public void setMvPickCount(int mvPickCount) {
            this.mvPickCount = mvPickCount;
        }

        public void setMvBulletCount(int mvBulletCount) {
            this.mvBulletCount = mvBulletCount;
        }

        public void setOutFlag(int outFlag) {
            this.outFlag = outFlag;
        }

        public void setOutList(Object outList) {
            this.outList = outList;
        }

        public void setCommentCount(int commentCount) {
            this.commentCount = commentCount;
        }

        public void setRiskRank(int riskRank) {
            this.riskRank = riskRank;
        }

        public void setRightKey(RightKeyEntity rightKey) {
            this.rightKey = rightKey;
        }

        public void setOperType(int operType) {
            this.operType = operType;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public void setIsExclusive(int isExclusive) {
            this.isExclusive = isExclusive;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public void setListenCount(int listenCount) {
            this.listenCount = listenCount;
        }

        public void setAuditionList(List<AuditionListEntity> auditionList) {
            this.auditionList = auditionList;
        }

        public void setUrlList(List<UrlListEntity> urlList) {
            this.urlList = urlList;
        }

        public void setMvList(List<MvListEntity> mvList) {
            this.mvList = mvList;
        }

        public void setOutLinks(List<?> outLinks) {
            this.outLinks = outLinks;
        }

        public void setSingers(List<SingersEntity> singers) {
            this.singers = singers;
        }

        public int getSongId() {
            return songId;
        }

        public String getName() {
            return name;
        }

        public String getAlias() {
            return alias;
        }

        public String getRemarks() {
            return remarks;
        }

        public boolean isFirstHit() {
            return firstHit;
        }

        public int getLibrettistId() {
            return librettistId;
        }

        public Object getLibrettistName() {
            return librettistName;
        }

        public int getComposerId() {
            return composerId;
        }

        public Object getComposerName() {
            return composerName;
        }

        public int getSingerId() {
            return singerId;
        }

        public String getSingerName() {
            return singerName;
        }

        public int getSingerSFlag() {
            return singerSFlag;
        }

        public int getAlbumId() {
            return albumId;
        }

        public String getAlbumName() {
            return albumName;
        }

        public int getFavorites() {
            return favorites;
        }

        public int getOriginalId() {
            return originalId;
        }

        public int getType() {
            return type;
        }

        public Object getTags() {
            return tags;
        }

        public int getReleaseYear() {
            return releaseYear;
        }

        public int getProducer() {
            return producer;
        }

        public int getPublisher() {
            return publisher;
        }

        public int getStatus() {
            return status;
        }

        public int getAudit() {
            return audit;
        }

        public int getLang() {
            return lang;
        }

        public Object getLlList() {
            return llList;
        }

        public int getMvPickCount() {
            return mvPickCount;
        }

        public int getMvBulletCount() {
            return mvBulletCount;
        }

        public int getOutFlag() {
            return outFlag;
        }

        public Object getOutList() {
            return outList;
        }

        public int getCommentCount() {
            return commentCount;
        }

        public int getRiskRank() {
            return riskRank;
        }

        public RightKeyEntity getRightKey() {
            return rightKey;
        }

        public int getOperType() {
            return operType;
        }

        public String getLevel() {
            return level;
        }

        public int getIsExclusive() {
            return isExclusive;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public int getListenCount() {
            return listenCount;
        }

        public List<AuditionListEntity> getAuditionList() {
            return auditionList;
        }

        public List<UrlListEntity> getUrlList() {
            return urlList;
        }

        public List<MvListEntity> getMvList() {
            return mvList;
        }

        public List<?> getOutLinks() {
            return outLinks;
        }

        public List<SingersEntity> getSingers() {
            return singers;
        }

        public static class RightKeyEntity {
            private int price;
            private Object vipFree;
            private int paymentUnite;
            private int orderType;
            private int loginStatus;
            private Object promotionPackage;
            /**
             * bitRate : 32
             * downFlag : true
             * listenFlag : true
             * downBuyFlag : false
             * listenBuyFlag : false
             * downloadRightFlag : 0
             * auditionRightFlag : 0
             */

            private List<SongRightsEntity> songRights;
            private List<?> musicPackage;
            private List<?> albumPackage;

            public void setPrice(int price) {
                this.price = price;
            }

            public void setVipFree(Object vipFree) {
                this.vipFree = vipFree;
            }

            public void setPaymentUnite(int paymentUnite) {
                this.paymentUnite = paymentUnite;
            }

            public void setOrderType(int orderType) {
                this.orderType = orderType;
            }

            public void setLoginStatus(int loginStatus) {
                this.loginStatus = loginStatus;
            }

            public void setPromotionPackage(Object promotionPackage) {
                this.promotionPackage = promotionPackage;
            }

            public void setSongRights(List<SongRightsEntity> songRights) {
                this.songRights = songRights;
            }

            public void setMusicPackage(List<?> musicPackage) {
                this.musicPackage = musicPackage;
            }

            public void setAlbumPackage(List<?> albumPackage) {
                this.albumPackage = albumPackage;
            }

            public int getPrice() {
                return price;
            }

            public Object getVipFree() {
                return vipFree;
            }

            public int getPaymentUnite() {
                return paymentUnite;
            }

            public int getOrderType() {
                return orderType;
            }

            public int getLoginStatus() {
                return loginStatus;
            }

            public Object getPromotionPackage() {
                return promotionPackage;
            }

            public List<SongRightsEntity> getSongRights() {
                return songRights;
            }

            public List<?> getMusicPackage() {
                return musicPackage;
            }

            public List<?> getAlbumPackage() {
                return albumPackage;
            }

            public static class SongRightsEntity {
                private int bitRate;
                private boolean downFlag;
                private boolean listenFlag;
                private boolean downBuyFlag;
                private boolean listenBuyFlag;
                private int downloadRightFlag;
                private int auditionRightFlag;

                public void setBitRate(int bitRate) {
                    this.bitRate = bitRate;
                }

                public void setDownFlag(boolean downFlag) {
                    this.downFlag = downFlag;
                }

                public void setListenFlag(boolean listenFlag) {
                    this.listenFlag = listenFlag;
                }

                public void setDownBuyFlag(boolean downBuyFlag) {
                    this.downBuyFlag = downBuyFlag;
                }

                public void setListenBuyFlag(boolean listenBuyFlag) {
                    this.listenBuyFlag = listenBuyFlag;
                }

                public void setDownloadRightFlag(int downloadRightFlag) {
                    this.downloadRightFlag = downloadRightFlag;
                }

                public void setAuditionRightFlag(int auditionRightFlag) {
                    this.auditionRightFlag = auditionRightFlag;
                }

                public int getBitRate() {
                    return bitRate;
                }

                public boolean isDownFlag() {
                    return downFlag;
                }

                public boolean isListenFlag() {
                    return listenFlag;
                }

                public boolean isDownBuyFlag() {
                    return downBuyFlag;
                }

                public boolean isListenBuyFlag() {
                    return listenBuyFlag;
                }

                public int getDownloadRightFlag() {
                    return downloadRightFlag;
                }

                public int getAuditionRightFlag() {
                    return auditionRightFlag;
                }
            }
        }

        public static class AuditionListEntity {
            private int bitRate;
            private int duration;
            private int size;
            private String suffix;
            private String url;
            private String typeDescription;

            public void setBitRate(int bitRate) {
                this.bitRate = bitRate;
            }

            public void setDuration(int duration) {
                this.duration = duration;
            }

            public void setSize(int size) {
                this.size = size;
            }

            public void setSuffix(String suffix) {
                this.suffix = suffix;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public void setTypeDescription(String typeDescription) {
                this.typeDescription = typeDescription;
            }

            public int getBitRate() {
                return bitRate;
            }

            public int getDuration() {
                return duration;
            }

            public int getSize() {
                return size;
            }

            public String getSuffix() {
                return suffix;
            }

            public String getUrl() {
                return url;
            }

            public String getTypeDescription() {
                return typeDescription;
            }
        }

        public static class UrlListEntity {
            private int bitRate;
            private int duration;
            private int size;
            private String suffix;
            private String url;
            private String typeDescription;

            public void setBitRate(int bitRate) {
                this.bitRate = bitRate;
            }

            public void setDuration(int duration) {
                this.duration = duration;
            }

            public void setSize(int size) {
                this.size = size;
            }

            public void setSuffix(String suffix) {
                this.suffix = suffix;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public void setTypeDescription(String typeDescription) {
                this.typeDescription = typeDescription;
            }

            public int getBitRate() {
                return bitRate;
            }

            public int getDuration() {
                return duration;
            }

            public int getSize() {
                return size;
            }

            public String getSuffix() {
                return suffix;
            }

            public String getUrl() {
                return url;
            }

            public String getTypeDescription() {
                return typeDescription;
            }
        }

        public static class MvListEntity {
            private int id;
            private int songId;
            private int videoId;
            private String picUrl;
            private int durationMilliSecond;
            private int duration;
            private int bitRate;
            private String path;
            private int size;
            private String suffix;
            private int horizontal;
            private int vertical;
            private String url;
            private int type;
            private String typeDescription;

            public void setId(int id) {
                this.id = id;
            }

            public void setSongId(int songId) {
                this.songId = songId;
            }

            public void setVideoId(int videoId) {
                this.videoId = videoId;
            }

            public void setPicUrl(String picUrl) {
                this.picUrl = picUrl;
            }

            public void setDurationMilliSecond(int durationMilliSecond) {
                this.durationMilliSecond = durationMilliSecond;
            }

            public void setDuration(int duration) {
                this.duration = duration;
            }

            public void setBitRate(int bitRate) {
                this.bitRate = bitRate;
            }

            public void setPath(String path) {
                this.path = path;
            }

            public void setSize(int size) {
                this.size = size;
            }

            public void setSuffix(String suffix) {
                this.suffix = suffix;
            }

            public void setHorizontal(int horizontal) {
                this.horizontal = horizontal;
            }

            public void setVertical(int vertical) {
                this.vertical = vertical;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public void setType(int type) {
                this.type = type;
            }

            public void setTypeDescription(String typeDescription) {
                this.typeDescription = typeDescription;
            }

            public int getId() {
                return id;
            }

            public int getSongId() {
                return songId;
            }

            public int getVideoId() {
                return videoId;
            }

            public String getPicUrl() {
                return picUrl;
            }

            public int getDurationMilliSecond() {
                return durationMilliSecond;
            }

            public int getDuration() {
                return duration;
            }

            public int getBitRate() {
                return bitRate;
            }

            public String getPath() {
                return path;
            }

            public int getSize() {
                return size;
            }

            public String getSuffix() {
                return suffix;
            }

            public int getHorizontal() {
                return horizontal;
            }

            public int getVertical() {
                return vertical;
            }

            public String getUrl() {
                return url;
            }

            public int getType() {
                return type;
            }

            public String getTypeDescription() {
                return typeDescription;
            }
        }

        public static class SingersEntity {
            private int singerId;
            private String singerName;
            private int singerSFlag;
            private int shopId;

            public void setSingerId(int singerId) {
                this.singerId = singerId;
            }

            public void setSingerName(String singerName) {
                this.singerName = singerName;
            }

            public void setSingerSFlag(int singerSFlag) {
                this.singerSFlag = singerSFlag;
            }

            public void setShopId(int shopId) {
                this.shopId = shopId;
            }

            public int getSingerId() {
                return singerId;
            }

            public String getSingerName() {
                return singerName;
            }

            public int getSingerSFlag() {
                return singerSFlag;
            }

            public int getShopId() {
                return shopId;
            }
        }
    }
}
