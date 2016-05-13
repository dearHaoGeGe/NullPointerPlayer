package com.my.nullpointerplayer.netbeans;

import java.util.List;

/**
 * Created by dllo on 16/1/21.
 */
public class MiGuSongerBeans {


    /**
     * singers : [{"singerid":112,"singer":"周杰伦","img":"http://wlanwm.12530.com:8080/newcms/cms/2015/1126/1110/ARTS150423143523211.jpg"},{"singerid":1000001086,"singer":"李荣浩","img":"http://wlanwm.12530.com:8080/newcms/cms/2013/05/03/15/05/ART1304221034314891.jpg"},{"singerid":957295,"singer":"张杰","img":"http://wlanwm.12530.com:8080/newcms/cms/2013/05/13/00/00/ART1301102158008495.jpg"},{"singerid":116,"singer":"陈奕迅","img":"http://wlanwm.12530.com:8080/newcms/cms/2016/0112/1030/ARTS150209111450600.jpg"},{"singerid":18196,"singer":"许嵩","img":"http://wlanwm.12530.com:8080/newcms/cms/2013/05/13/00/00/ART1212131151214517.jpg"},{"singerid":270,"singer":"王力宏","img":"http://wlanwm.12530.com:8080/newcms/cms/2013/05/03/14/55/ART1301102020493613.jpg"},{"singerid":1000000461,"singer":"李宗盛","img":"http://wlanwm.12530.com:8080/newcms/cms/2013/05/12/14/00/ART130111162831916.jpg"},{"singerid":128322,"singer":"韩庚","img":"http://wlanwm.12530.com:8080/newcms/cms/2015/1020/1440/ARTS1510201432334634.jpg"},{"singerid":980012,"singer":"汪苏泷","img":"http://wlanwm.12530.com:8080/newcms/cms/2013/05/13/00/00/ART1301101707093383.jpg"},{"singerid":953012,"singer":"张学友","img":"http://wlanwm.12530.com:8080/newcms/cms/2015/1124/1120/ARTS1511241050059173.jpg"},{"singerid":388711,"singer":"冷漠","img":"http://wlanwm.12530.com:8080/newcms/cms/2015/1112/1430/ARTS1509021654388201.jpg"},{"singerid":429,"singer":"郑伊健","img":"http://wlanwm.12530.com:8080/newcms/cms/2016/0114/1100/ARTS1506010913055788.jpg"},{"singerid":1000006320,"singer":"范逸臣","img":"http://wlanwm.12530.com:8080/newcms/cms/2013/05/12/23/55/ART1212131149468493.jpg"},{"singerid":520,"singer":"张雨生","img":"http://wlanwm.12530.com:8080/newcms/cms/2013/05/13/00/05/ART1301101806048888.jpg"},{"singerid":1227,"singer":"方大同","img":"http://wlanwm.12530.com:8080/newcms/cms/2015/1225/1610/ARTS1402181457421129.jpg"},{"singerid":17652,"singer":"陈玉建","img":"http://wlanwm.12530.com:8080/newcms/cms/2013/05/03/16/35/ART130206143959449.jpg"},{"singerid":10479,"singer":"付辛博","img":"http://wlanwm.12530.com:8080/newcms/cms/2013/05/03/15/05/ART1303251013587040.png"},{"singerid":5680,"singer":"陈柏宇","img":"http://wlanwm.12530.com:8080/newcms/cms/2013/05/12/23/55/ART1302051419323028.jpg"},{"singerid":19233,"singer":"汪东城","img":"http://wlanwm.12530.com:8080/newcms/cms/2013/05/03/16/40/ART1303191738349412.jpg"},{"singerid":335,"singer":"杨坤","img":"http://wlanwm.12530.com:8080/newcms/cms/2013/05/13/00/00/ART1301101713045001.jpg"},{"singerid":472275,"singer":"小贱","img":"http://wlanwm.12530.com:8080/newcms/cms/2015/1105/0940/ARTS1505181206129948.jpg"},{"singerid":108,"singer":"罗大佑","img":"http://wlanwm.12530.com:8080/newcms/cms/2015/1202/1410/ARTS1307081015599945.jpg"},{"singerid":540,"singer":"吴奇隆","img":"http://wlanwm.12530.com:8080/newcms/cms/2015/1224/1620/ARTS1509281104205955.jpg"},{"singerid":10556,"singer":"Tank","img":"http://wlanwm.12530.com:8080/newcms/cms/2013/05/13/00/00/ART1301101743353805.jpg"},{"singerid":482513,"singer":"大张伟","img":"http://wlanwm.12530.com:8080/newcms/cms/2015/1124/1140/ARTS1412241056192747.jpg"},{"singerid":521,"singer":"黄义达","img":"http://wlanwm.12530.com:8080/newcms/cms/2013/05/12/14/00/ART1301101759428489.jpg"},{"singerid":147,"singer":"阿杜","img":"http://wlanwm.12530.com:8080/newcms/cms/2013/05/12/23/55/ART1301101947067039.jpg"},{"singerid":559,"singer":"许巍","img":"http://wlanwm.12530.com:8080/newcms/cms/2013/05/13/00/05/ART1301102008389321.jpg"},{"singerid":1854,"singer":"海鸣威","img":"http://wlanwm.12530.com:8080/newcms/cms/2013/05/03/19/40/ART1301102124397715.jpg"},{"singerid":357445,"singer":"徐良","img":"http://wlanwm.12530.com:8080/newcms/cms/2013/05/12/23/50/ART1301221603349794.jpg"},{"singerid":1212,"singer":"薛之谦","img":"http://wlanwm.12530.com:8080/newcms/cms/2015/1009/1530/ARTS1505201225272819.jpg"},{"singerid":1000006373,"singer":"林志炫","img":"http://wlanwm.12530.com:8080/newcms/cms/2013/05/13/00/05/ART1301102009324858.jpg"},{"singerid":31975,"singer":"萧敬腾","img":"http://wlanwm.12530.com:8080/newcms/cms/2015/1216/1000/ARTS1512151505232999.jpg"},{"singerid":666,"singer":"郑源","img":"http://wlanwm.12530.com:8080/newcms/cms/2013/05/12/23/55/ART1302031113013705.jpg"},{"singerid":266,"singer":"林俊杰","img":"http://wlanwm.12530.com:8080/newcms/cms/2015/1204/1520/ARTS1512041418106213.jpg"},{"singerid":955293,"singer":"刘德华","img":"http://wlanwm.12530.com:8080/newcms/cms/2016/0112/1330/ARTS1601121307409433.jpg"},{"singerid":1000006341,"singer":"胡彦斌","img":"http://wlanwm.12530.com:8080/newcms/cms/2015/1116/1020/ARTS1504211141316195.jpg"},{"singerid":1000006369,"singer":"沙宝亮","img":"http://wlanwm.12530.com:8080/newcms/cms/2013/05/12/23/50/ART1301102000167023.jpg"},{"singerid":1000006347,"singer":"蔡国庆","img":"http://wlanwm.12530.com:8080/newcms/cms/2013/05/12/14/00/ART1305062134462514.jpg"},{"singerid":1000006342,"singer":"姜育恒","img":"http://wlanwm.12530.com:8080/newcms/cms/2013/05/12/23/55/ART1301102007198840.jpg"},{"singerid":955278,"singer":"严爵","img":"http://wlanwm.12530.com:8080/newcms/cms/2015/1224/1120/ARTS1404241143122497.jpg"},{"singerid":276,"singer":"古巨基","img":"http://wlanwm.12530.com:8080/newcms/cms/2015/1104/1450/ARTS1412021539286673.jpg"},{"singerid":1000006375,"singer":"蔡旻佑","img":"http://wlanwm.12530.com:8080/newcms/cms/2015/1203/2320/ARTS1512031640383998.jpg"},{"singerid":415,"singer":"黎明","img":"http://wlanwm.12530.com:8080/newcms/cms/2016/0120/1020/ARTS1505281134407138.jpg"},{"singerid":6240,"singer":"杨培安","img":"http://wlanwm.12530.com:8080/newcms/cms/2015/1204/1030/ARTS1511261041177862.jpg"},{"singerid":262,"singer":"赵传","img":"http://wlanwm.12530.com:8080/newcms/cms/2016/0119/0950/ARTS1505191453316733.jpg"},{"singerid":1000010124,"singer":"张赫宣","img":"http://wlanwm.12530.com:8080/newcms/cms/2013/05/03/16/10/ART1301111634352605.jpg"},{"singerid":300,"singer":"游鸿明","img":"http://wlanwm.12530.com:8080/newcms/cms/2013/05/12/23/55/ART1301101712257962.jpg"},{"singerid":653,"singer":"黄品源","img":"http://wlanwm.12530.com:8080/newcms/cms/2013/05/12/23/50/ART1303081545087221.jpg"},{"singerid":299,"singer":"林志颖","img":"http://wlanwm.12530.com:8080/newcms/cms/2013/05/03/17/40/ART1301102230492587.jpg"},{"singerid":654,"singer":"费玉清","img":"http://wlanwm.12530.com:8080/newcms/cms/2015/1125/1030/ARTS1306242330042371.jpg"},{"singerid":61212,"singer":"严宽","img":"http://wlanwm.12530.com:8080/newcms/cms/2013/05/13/00/05/ART1304162225116219.jpg"},{"singerid":373,"singer":"童安格","img":"http://wlanwm.12530.com:8080/newcms/cms/2013/05/12/23/55/ART1301101622068275.jpg"},{"singerid":938,"singer":"张栋梁","img":"http://wlanwm.12530.com:8080/newcms/cms/2015/1118/0940/ARTS1506041627508838.jpg"},{"singerid":387453,"singer":"陈翔","img":"http://wlanwm.12530.com:8080/newcms/cms/2013/05/13/00/00/ART1301111633271060.jpg"},{"singerid":354,"singer":"谭咏麟","img":"http://wlanwm.12530.com:8080/newcms/cms/2016/0120/1120/ARTS1504201101572889.jpg"},{"singerid":1000006349,"singer":"庾澄庆","img":"http://wlanwm.12530.com:8080/newcms/cms/2013/05/12/13/45/ART130110195650899.jpg"},{"singerid":330934,"singer":"夏天","img":"http://wlanwm.12530.com:8080/newcms/cms/2015/1112/1430/ARTS1506101610156867.jpg"},{"singerid":296,"singer":"李克勤","img":"http://wlanwm.12530.com:8080/newcms/cms/2016/0115/1210/ARTS1412021412074637.jpg"},{"singerid":1000008196,"singer":"孙子涵","img":"http://wlanwm.12530.com:8080/newcms/cms/2015/1215/1110/ARTS1505221015111340.jpg"},{"singerid":712,"singer":"张震岳","img":"http://wlanwm.12530.com:8080/newcms/cms/2013/05/12/14/00/ART130110171422948.jpg"},{"singerid":1000001288,"singer":"单色凌","img":"http://wlanwm.12530.com:8080/newcms/cms/2015/1225/1010/ARTS1401182148529746.jpg"},{"singerid":13274,"singer":"平安","img":"http://wlanwm.12530.com:8080/newcms/cms/2016/0102/1750/ARTS1508311420582634.jpg"},{"singerid":1000023444,"singer":"回音哥","img":"http://wlanwm.12530.com:8080/newcms/cms/2013/05/12/23/55/ART1301231355027835.jpg"},{"singerid":376762,"singer":"梁博","img":"http://wlanwm.12530.com:8080/newcms/cms/2015/1103/1020/ARTS1511031012278765.jpg"},{"singerid":838,"singer":"林峰","img":"http://wlanwm.12530.com:8080/newcms/cms/2015/1207/1050/ARTS1512021019265173.jpg"},{"singerid":380,"singer":"老狼","img":"http://wlanwm.12530.com:8080/newcms/cms/2013/05/12/23/55/ART1301111631078953.jpg"},{"singerid":1152,"singer":"黄贯中","img":"http://wlanwm.12530.com:8080/newcms/cms/2013/05/12/23/55/ART1301101715253317.jpg"},{"singerid":292,"singer":"谢霆锋","img":"http://wlanwm.12530.com:8080/newcms/cms/2015/1110/1000/ARTS1504201443016679.jpg"},{"singerid":399,"singer":"伍思凯","img":"http://wlanwm.12530.com:8080/newcms/cms/2013/05/12/23/55/ART130109103333719.jpg"},{"singerid":1000006328,"singer":"信","img":"http://wlanwm.12530.com:8080/newcms/cms/2016/0119/0950/ARTS1504201458005498.jpg"},{"singerid":5205,"singer":"俞灏明","img":"http://wlanwm.12530.com:8080/newcms/cms/2016/0115/1010/ARTS1506231112393891.jpg"},{"singerid":1000012001,"singer":"何晟铭","img":"http://wlanwm.12530.com:8080/newcms/cms/2013/05/12/23/45/ART1301111634531550.jpg"},{"singerid":6638,"singer":"彭于晏","img":"http://wlanwm.12530.com:8080/newcms/cms/2013/05/12/23/45/ART1301111628474912.jpg"},{"singerid":1000006322,"singer":"后弦","img":"http://wlanwm.12530.com:8080/newcms/cms/2015/1016/2350/ARTS1505061512325954.jpg"},{"singerid":973,"singer":"谢军","img":"http://wlanwm.12530.com:8080/newcms/cms/2013/05/03/17/50/ART1301101830556641.jpg"},{"singerid":1000000460,"singer":"魏晨","img":"http://wlanwm.12530.com:8080/newcms/cms/2015/1224/1130/ARTS1504231053463083.jpg"},{"singerid":5389,"singer":"阿宝","img":"http://wlanwm.12530.com:8080/newcms/cms/2013/05/03/17/35/ART130223152018780.jpg"},{"singerid":19237,"singer":"炎亚纶","img":"http://wlanwm.12530.com:8080/newcms/cms/2013/05/03/20/08/ART1303111359171583.jpg"},{"singerid":5245,"singer":"高进","img":"http://wlanwm.12530.com:8080/newcms/cms/2013/05/12/23/55/ART1302191038261690.jpg"},{"singerid":669783,"singer":"黄渤","img":"http://wlanwm.12530.com:8080/newcms/cms/2015/1019/1740/ARTS1502171513131783.jpg"},{"singerid":306954,"singer":"小沈阳","img":"http://wlanwm.12530.com:8080/newcms/cms/2013/05/12/13/24/ART1304261458091566.jpg"},{"singerid":288822,"singer":"曾一鸣","img":"http://wlanwm.12530.com:8080/newcms/cms/2013/05/03/16/15/ART1301311511572656.jpg"},{"singerid":5201,"singer":"陈楚生","img":"http://wlanwm.12530.com:8080/newcms/cms/2013/05/13/00/00/ART1301101946172911.jpg"},{"singerid":1830,"singer":"马天宇","img":"http://wlanwm.12530.com:8080/newcms/cms/2013/05/03/15/50/ART1301291113459707.jpg"},{"singerid":400,"singer":"屠洪刚","img":"http://wlanwm.12530.com:8080/newcms/cms/2016/0112/1520/ARTS1403121251055877.jpg"},{"singerid":31013,"singer":"杨宗纬","img":"http://wlanwm.12530.com:8080/newcms/cms/2013/05/13/00/00/ART1301101812422968.jpg"},{"singerid":1000002548,"singer":"胡夏","img":"http://wlanwm.12530.com:8080/newcms/cms/2015/1102/1700/ARTS1511021622042942.jpg"},{"singerid":128561,"singer":"袁成杰","img":"http://wlanwm.12530.com:8080/newcms/cms/2015/1204/1000/ARTS1505291603397777.jpg"},{"singerid":125,"singer":"崔健","img":"http://wlanwm.12530.com:8080/newcms/cms/2015/1225/1030/ARTS1512251017503966.jpg"},{"singerid":265,"singer":"杜德伟","img":"http://wlanwm.12530.com:8080/newcms/cms/2016/0112/1320/ARTS1411271400455918.jpg"},{"singerid":1105,"singer":"胡歌","img":"http://wlanwm.12530.com:8080/newcms/cms/2013/05/03/17/50/ART1301101708551282.jpg"},{"singerid":515,"singer":"张卫健","img":"http://wlanwm.12530.com:8080/newcms/cms/2013/05/13/00/00/ART1301101736598493.jpg"},{"singerid":549,"singer":"郑中基","img":"http://wlanwm.12530.com:8080/newcms/cms/2013/05/12/23/55/ART1303291632356930.jpg"},{"singerid":264,"singer":"许志安","img":"http://wlanwm.12530.com:8080/newcms/cms/2015/1128/2120/ARTS1506091059024010.jpg"},{"singerid":14540,"singer":"李玉刚","img":"http://wlanwm.12530.com:8080/newcms/cms/2013/05/12/23/55/ART1301111002142440.jpg"},{"singerid":991,"singer":"吴克群","img":"http://wlanwm.12530.com:8080/newcms/cms/2013/05/13/00/00/ART1301101708014552.jpg"},{"singerid":131,"singer":"陈坤","img":"http://wlanwm.12530.com:8080/newcms/cms/2013/05/03/19/40/ART1301101704293944.jpg"},{"singerid":114,"singer":"陈百强","img":"http://wlanwm.12530.com:8080/newcms/cms/2013/05/03/18/16/ART1301101814374644.jpg"},{"singerid":353,"singer":"汪峰","img":"http://wlanwm.12530.com:8080/newcms/cms/2015/1028/1000/ARTS1411121429113464.jpg"}]
     * keys : A|B|C|D|E|F|G|H|J|K|L|M|N|O|P|Q|R|S|T|V|W|X|Y|Z
     * pagecount : 14
     * totalcount : 1355
     * groupcode : 1418/1551/1608
     * publishTime : 2016-01-21 12:30:22
     * code : 000000
     * info : 成功
     */

    private String keys;
    private int pagecount;
    private int totalcount;
    private String groupcode;
    private String publishTime;
    private String code;
    private String info;
    /**
     * singerid : 112
     * singer : 周杰伦
     * img : http://wlanwm.12530.com:8080/newcms/cms/2015/1126/1110/ARTS150423143523211.jpg
     */

    private List<SingersEntity> singers;

    public void setKeys(String keys) {
        this.keys = keys;
    }

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

    public void setSingers(List<SingersEntity> singers) {
        this.singers = singers;
    }

    public String getKeys() {
        return keys;
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

    public List<SingersEntity> getSingers() {
        return singers;
    }

    public static class SingersEntity {
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
}
