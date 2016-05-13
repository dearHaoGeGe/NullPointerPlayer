package com.my.nullpointerplayer.netbeans;

import java.util.List;

/**
 * 歌手网络实体类
 * Created by Administrator on 2016/2/11.
 */
public class SongerBeans {


    /**
     * code : 1
     * msg : ok
     * data : [{"singer_id":50530,"singer_name":"陈奕迅","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/50530/7030798.jpg"},{"singer_id":1022065,"singer_name":"G.E.M.邓紫棋","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/1022065/566191.jpg"},{"singer_id":1766358,"singer_name":"张学友","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/1766358/517441.jpg"},{"singer_id":140941,"singer_name":"张杰","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/140941/521984.jpg"},{"singer_id":161,"singer_name":"刘德华","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/161/166120.jpg"},{"singer_id":69591,"singer_name":"庄心妍","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/69591/7023418.jpg"},{"singer_id":1022413,"singer_name":"TFBOYS","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/1022413/6997380.jpg"},{"singer_id":1765796,"singer_name":"王菲","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/1765796/524611.jpg"},{"singer_id":50131,"singer_name":"许嵩","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/50131/505179.jpg"},{"singer_id":1712371,"singer_name":"Beyond","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/1712371/567116.jpg"},{"singer_id":44,"singer_name":"梁静茹","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/44/510847.jpg"},{"singer_id":4094,"singer_name":"郑源","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/4094/118620.jpg"},{"singer_id":5131,"singer_name":"凤凰传奇","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/5131/76645.jpg"},{"singer_id":113364,"singer_name":"李荣浩","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/113364/567004.jpg"},{"singer_id":9606,"singer_name":"筷子兄弟","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/9606/568002.jpg"},{"singer_id":230220,"singer_name":"冷漠","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/230220/111458.jpg"},{"singer_id":3989,"singer_name":"汪峰","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/3989/111504.jpg"},{"singer_id":4092,"singer_name":"邓丽君","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/4092/114842.jpg"},{"singer_id":140,"singer_name":"张惠妹","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/140/516511.jpg"},{"singer_id":53,"singer_name":"莫文蔚","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/53/114655.jpg"},{"singer_id":260,"singer_name":"王力宏","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/260/182964.jpg"},{"singer_id":1116974,"singer_name":"刘若英","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/1116974/111703.jpg"},{"singer_id":269264,"singer_name":"周传雄","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/269264/108243.jpg"},{"singer_id":1766605,"singer_name":"卓依婷","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/1766605/6916791.jpg"},{"singer_id":86,"singer_name":"张国荣","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/86/513294.jpg"},{"singer_id":95,"singer_name":"周华健","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/95/178649.jpg"},{"singer_id":1854651,"singer_name":"张碧晨","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/1854651/7018492.jpg"},{"singer_id":1088094,"singer_name":"孙露","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/1088094/7038550.jpg"},{"singer_id":9806,"singer_name":"丁当","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/9806/7006450.jpg"},{"singer_id":148,"singer_name":"谭咏麟","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/148/69124.jpg"},{"singer_id":108,"singer_name":"孙燕姿","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/108/67591.jpg"},{"singer_id":165,"singer_name":"张信哲","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/165/7053585.jpg"},{"singer_id":71052,"singer_name":"A-Lin","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/71052/42920.jpg"},{"singer_id":166,"singer_name":"张宇","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/166/86485.jpg"},{"singer_id":222,"singer_name":"蔡依林","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/222/167120.jpg"},{"singer_id":9464,"singer_name":"杨宗纬","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/9464/517345.jpg"},{"singer_id":136,"singer_name":"那英","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/136/166245.jpg"},{"singer_id":3933,"singer_name":"本兮","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/3933/154912.jpg"},{"singer_id":38602,"singer_name":"EXO","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/38602/510832.jpg"},{"singer_id":3838,"singer_name":"朴树","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/3838/7017499.jpg"},{"singer_id":1000882,"singer_name":"田馥甄","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/1000882/567208.jpg"},{"singer_id":44740,"singer_name":"Maroon 5","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/44740/6997420.jpg"},{"singer_id":1768082,"singer_name":"林宥嘉","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/1768082/41993.jpg"},{"singer_id":230,"singer_name":"李克勤","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/230/7050575.jpg"},{"singer_id":239,"singer_name":"刀郎","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/239/509480.jpg"},{"singer_id":1005899,"singer_name":"S.H.E","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/1005899/7008637.jpg"},{"singer_id":163,"singer_name":"萧亚轩","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/163/122874.jpg"},{"singer_id":30124,"singer_name":"曲婉婷","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/30124/97738.jpg"},{"singer_id":50378,"singer_name":"汪苏泷","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/50378/517339.jpg"},{"singer_id":16767,"singer_name":"郁可唯","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/16767/514175.jpg"},{"singer_id":1796923,"singer_name":"Avril Lavigne","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/1796923/91777.jpg"},{"singer_id":242958,"singer_name":"降央卓玛","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/242958/55990.jpg"},{"singer_id":1489527,"singer_name":"姚贝娜","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/1489527/1424023.jpg"},{"singer_id":1766357,"singer_name":"六哲","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/1766357/109916.jpg"},{"singer_id":231679,"singer_name":"Justin Bieber","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/231679/517808.jpg"},{"singer_id":138,"singer_name":"王杰","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/138/111809.jpg"},{"singer_id":1770097,"singer_name":"张敬轩","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/1770097/107001.jpg"},{"singer_id":2862,"singer_name":"许巍","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/2862/42864.jpg"},{"singer_id":6207,"singer_name":"欢子","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/6207/509362.jpg"},{"singer_id":1001499,"singer_name":"徐良","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/1001499/507596.jpg"},{"singer_id":1225435,"singer_name":"逃跑计划","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/1225435/517747.jpg"},{"singer_id":1073155,"singer_name":"陈小春","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/1073155/75778.jpg"},{"singer_id":1191215,"singer_name":"陈瑞","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/1191215/162025.jpg"},{"singer_id":1700161,"singer_name":"林志炫","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/1700161/517289.jpg"},{"singer_id":50914,"singer_name":"王心凌","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/50914/516348.jpg"},{"singer_id":47,"singer_name":"林忆莲","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/47/71026.jpg"},{"singer_id":88,"singer_name":"张震岳","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/88/57351.jpg"},{"singer_id":9555,"singer_name":"李易峰","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/9555/520038.jpg"},{"singer_id":4035,"singer_name":"罗志祥","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/4035/1433960.jpg"},{"singer_id":19643,"singer_name":"李行亮","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/19643/6999555.jpg"},{"singer_id":13521,"singer_name":"小贱","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/13521/516719.jpg"},{"singer_id":4000,"singer_name":"李宇春","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/4000/166884.jpg"},{"singer_id":1767072,"singer_name":"光良","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/1767072/1433932.jpg"},{"singer_id":11170,"singer_name":"By2","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/11170/513128.jpg"},{"singer_id":23025,"singer_name":"五月天","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/23025/7035607.jpg"},{"singer_id":243835,"singer_name":"Adele","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/243835/89054.jpg"},{"singer_id":21220,"singer_name":"胡夏","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/21220/6286883.jpg"},{"singer_id":124290,"singer_name":"소녀시대","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/124290/182865.jpg"},{"singer_id":1767395,"singer_name":"韩红","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/1767395/7017503.jpg"},{"singer_id":4004,"singer_name":"齐秦","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/4004/79473.jpg"},{"singer_id":1501351,"singer_name":"胡歌","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/1501351/521885.jpg"},{"singer_id":52237,"singer_name":"单色凌","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/52237/508424.jpg"},{"singer_id":3823,"singer_name":"信乐团","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/3823/114850.jpg"},{"singer_id":91192,"singer_name":"高胜美","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/91192/71730.jpg"},{"singer_id":1768016,"singer_name":"伍佰&China Blue","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/1768016/184201.jpg"},{"singer_id":157,"singer_name":"胡彦斌","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/157/514004.jpg"},{"singer_id":1001589,"singer_name":"刘明湘","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/1001589/521730.jpg"},{"singer_id":61087,"singer_name":"李宗盛","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/61087/54524.jpg"},{"singer_id":160969,"singer_name":"T-ara","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/160969/7055127.jpg"},{"singer_id":237854,"singer_name":"Katy Perry","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/237854/1425462.jpg"},{"singer_id":9352,"singer_name":"魏晨","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/9352/522195.jpg"},{"singer_id":4042,"singer_name":"杨丞琳","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/4042/1438976.jpg"},{"singer_id":1499941,"singer_name":"蔡健雅","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/1499941/77835.jpg"},{"singer_id":1700638,"singer_name":"梅艳芳","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/1700638/7031614.jpg"},{"singer_id":216,"singer_name":"庞龙","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/216/79352.jpg"},{"singer_id":50232,"singer_name":"杨千嬅","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/50232/97460.jpg"},{"singer_id":5368,"singer_name":"韩宝仪","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/5368/7031558.jpg"},{"singer_id":142631,"singer_name":"崔子格","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/142631/7046681.jpg"},{"singer_id":50239,"singer_name":"夏天Alex","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/50239/90829.jpg"},{"singer_id":10268,"singer_name":"龚玥","live_id":0,"pic_url":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/10268/7032795.jpg"}]
     * extra : {"all_page":1,"size":100,"curr_page":1}
     * pageCount : 1
     * totalCount : 100
     * page : 1
     * size : 100
     */

    private int code;
    private String msg;
    /**
     * all_page : 1
     * size : 100
     * curr_page : 1
     */

    private ExtraEntity extra;
    private int pageCount;
    private int totalCount;
    private int page;
    private int size;
    /**
     * singer_id : 50530
     * singer_name : 陈奕迅
     * live_id : 0
     * pic_url : http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/50530/7030798.jpg
     */

    private List<DataEntity> data;

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setExtra(ExtraEntity extra) {
        this.extra = extra;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setData(List<DataEntity> data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public ExtraEntity getExtra() {
        return extra;
    }

    public int getPageCount() {
        return pageCount;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public int getPage() {
        return page;
    }

    public int getSize() {
        return size;
    }

    public List<DataEntity> getData() {
        return data;
    }

    public static class ExtraEntity {
        private int all_page;
        private int size;
        private int curr_page;

        public void setAll_page(int all_page) {
            this.all_page = all_page;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public void setCurr_page(int curr_page) {
            this.curr_page = curr_page;
        }

        public int getAll_page() {
            return all_page;
        }

        public int getSize() {
            return size;
        }

        public int getCurr_page() {
            return curr_page;
        }
    }

    public static class DataEntity {
        private int singer_id;
        private String singer_name;
        private int live_id;
        private String pic_url;

        public void setSinger_id(int singer_id) {
            this.singer_id = singer_id;
        }

        public void setSinger_name(String singer_name) {
            this.singer_name = singer_name;
        }

        public void setLive_id(int live_id) {
            this.live_id = live_id;
        }

        public void setPic_url(String pic_url) {
            this.pic_url = pic_url;
        }

        public int getSinger_id() {
            return singer_id;
        }

        public String getSinger_name() {
            return singer_name;
        }

        public int getLive_id() {
            return live_id;
        }

        public String getPic_url() {
            return pic_url;
        }
    }
}
