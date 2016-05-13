package com.my.nullpointerplayer.fragment;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.NetworkImageView;
import com.google.gson.Gson;
import com.my.nullpointerplayer.R;
import com.my.nullpointerplayer.activity.MainActivity;
import com.my.nullpointerplayer.db.DaoMaster;
import com.my.nullpointerplayer.db.DaoSession;
import com.my.nullpointerplayer.db.RecommendFragmentData;
import com.my.nullpointerplayer.db.RecommendFragmentDataDao;
import com.my.nullpointerplayer.netbeans.MiGuRecommendBeans;
import com.my.nullpointerplayer.utils.MyRequestQueue;
import com.my.nullpointerplayer.utils.ReadStringRequestUtf;

import java.util.ArrayList;

import de.greenrobot.dao.query.QueryBuilder;

/**
 * 咪咕推荐Fragment
 * Created by dllo on 16/1/26.
 */
public class RecommendFragment extends BaseFragment implements View.OnClickListener {

    private TextView tv_title_music_sound, textview_music_sound_guangliang, textview_music_sound_jindan,
            textview2_title_everyday_recommend, textview2_summary_everyday_recommend,
            textview3_title_everyday_recommend, textview3_summary_everyday_recommend,
            textview4_title_everyday_recommend, textview4_summary_everyday_recommend,
            textview5_title_everyday_recommend, textview5_summary_everyday_recommend,
            textview6_title_everyday_recommend, textview6_summary_everyday_recommend,
            tv_item_hot_song_title1, tv_item_hot_song_songer1,
            tv_item_hot_song_title2, tv_item_hot_song_songer2,
            tv_item_hot_song_title3, tv_item_hot_song_songer3,
            tv_item_hot_song_title4, tv_item_hot_song_songer4,
            tv_item_hot_song_title5, tv_item_hot_song_songer5,
            tv_item_title_Special_column1, tv_item_summary_Special_column1,
            tv_item_title_Special_column2, tv_item_summary_Special_column2,
            tv_item_title_Special_column3, tv_item_summary_Special_column3,
            tv_item_title_Special_column4, tv_item_summary_Special_column4,
            tv_item_title_Special_column5, tv_item_summary_Special_column5,
            textView_more;
    private NetworkImageView imageview_music_sound_guangliang, imageview_music_sound_jindan,
            imageview1_everyday_recommend, imageview2_everyday_recommend, imageview3_everyday_recommend,
            imageview4_everyday_recommend, imageview5_everyday_recommend, imageview6_everyday_recommend,
            iv_item_albumIcon1, iv_item_albumIcon2, iv_item_albumIcon3, iv_item_albumIcon4, iv_item_albumIcon5,
            iv_item_Special_column1, iv_item_Special_column2, iv_item_Special_column3, iv_item_Special_column4, iv_item_Special_column5;
    private ImageView iv_san_dian_menu1, iv_san_dian_menu2, iv_san_dian_menu3, iv_san_dian_menu4, iv_san_dian_menu5;
    private LinearLayout linearLayout1_everyday_recommend, linearLayout2_everyday_recommend, linearLayout3_everyday_recommend,
            linearLayout4_everyday_recommend, linearLayout5_everyday_recommend, linearLayout6_everyday_recommend,
            linearLayout_Special_column1, linearLayout_Special_column2, linearLayout_Special_column3, linearLayout_Special_column4, linearLayout_Special_column5;
    private ViewPager viewPager;
    private GuMiViewPagerAdapter adapter;

    private MiGuRecommendBeans bean = new MiGuRecommendBeans();
    private MainActivity mainActivity;

    /* greendao数据库的变量 */
    private RecommendFragmentDataDao recommendFragmentDataDao;
    private DaoSession mDaoSession;
    private DaoMaster mDaoMaster;
    private SQLiteDatabase db;
    private DaoMaster.OpenHelper helper;

    public static RecommendFragment newInstance() {
        RecommendFragment recommendFragment = new RecommendFragment();
        return recommendFragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recommend, container, false);
        initFindViewById(view);     //初始化findViewById
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        String response = getResponse("RecommendFragmentData");     //如果网络请求错误的话从数据库中拉取上次存进去的数据
        if(!response.equals("")){   //如果数据库中的网络数据不为空的话
            Gson gson = new Gson();
            bean = gson.fromJson(response, MiGuRecommendBeans.class);

            addNetData(bean);   //添加网络数据

            addViewPagerData(bean); //为轮播图添加网络数据
        }
        
        getBeans();     //获取网络数据
    }

    /**
     * 获取网络数据
     */
    private void getBeans() {
        String url = "http://218.200.160.29/rdp2/v5.5/index.do?&pageno=1&ua=Android_sst&version=4.2280";
        ReadStringRequestUtf request = new ReadStringRequestUtf(url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        putIn("RecommendFragmentData", response);  //从网上拉取到数据要放在数据库里面

                        Gson gson = new Gson();
                        bean = gson.fromJson(response, MiGuRecommendBeans.class);

                        addNetData(bean);   //添加网络数据

                        addViewPagerData(bean); //为轮播图添加网络数据
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        String response = getResponse("RecommendFragmentData");     //如果网络请求错误的话从数据库中拉取上次存进去的数据
                        if(!response.equals("")){   //如果数据库中的网络数据不为空的话
                            Gson gson = new Gson();
                            bean = gson.fromJson(response, MiGuRecommendBeans.class);

                            addNetData(bean);   //添加网络数据

                            addViewPagerData(bean); //为轮播图添加网络数据
                        }
                    }
                });
        MyRequestQueue.addRequest(request);
    }

    /**
     * 网数据库中存
     *
     * @param name
     * @param response
     */
    public void putIn(String name, String response) {
        helper = new DaoMaster.DevOpenHelper(mainActivity, "MyDB2.db", null);
        db = helper.getWritableDatabase();
        mDaoMaster = new DaoMaster(db);
        mDaoSession = mDaoMaster.newSession();
        recommendFragmentDataDao = mDaoSession.getRecommendFragmentDataDao();

        RecommendFragmentData myData = new RecommendFragmentData(name, response);
        recommendFragmentDataDao.insertOrReplace(myData);
    }

    /**
     * 从数据库中取
     *
     * @param name
     * @return
     */
    public String getResponse(String name) {
        helper = new DaoMaster.DevOpenHelper(mainActivity, "MyDB2.db", null);
        db = helper.getWritableDatabase();
        mDaoMaster = new DaoMaster(db);
        mDaoSession = mDaoMaster.newSession();
        QueryBuilder queryBuilder = mDaoSession.getRecommendFragmentDataDao().queryBuilder();
        queryBuilder.where(RecommendFragmentDataDao.Properties.Name.eq(name));
        ArrayList<RecommendFragmentData> datas = (ArrayList<RecommendFragmentData>) queryBuilder.list();
        return datas.get(0).getResponse();
    }

    /**
     * 为轮播图填充数据
     * @param bean
     */
    public void addViewPagerData(MiGuRecommendBeans bean) {
        adapter = new GuMiViewPagerAdapter(bean, mainActivity);
        viewPager.setAdapter(adapter);
    }

    private void addNetData(MiGuRecommendBeans bean) {
        //每日推荐
        MyRequestQueue.setNetImage(imageview1_everyday_recommend, bean.getGroups().get(2).getRecommends().get(0).getImg());//每日推荐第一个图片内容

        textview2_title_everyday_recommend.setText(bean.getGroups().get(2).getRecommends().get(1).getTitle());  //每日推荐第二个图片内容
        textview2_summary_everyday_recommend.setText(bean.getGroups().get(2).getRecommends().get(1).getSummary());
        MyRequestQueue.setNetImage(imageview2_everyday_recommend, bean.getGroups().get(2).getRecommends().get(1).getImg());

        textview3_title_everyday_recommend.setText(bean.getGroups().get(2).getRecommends().get(2).getTitle());   //每日推荐第三个图片内容
        textview3_summary_everyday_recommend.setText(bean.getGroups().get(2).getRecommends().get(2).getSummary());
        MyRequestQueue.setNetImage(imageview3_everyday_recommend, bean.getGroups().get(2).getRecommends().get(2).getImg());

        textview4_title_everyday_recommend.setText(bean.getGroups().get(2).getRecommends().get(3).getTitle());   //每日推荐第四个图片内容
        textview4_summary_everyday_recommend.setText(bean.getGroups().get(2).getRecommends().get(3).getSummary());
        MyRequestQueue.setNetImage(imageview4_everyday_recommend, bean.getGroups().get(2).getRecommends().get(3).getImg());

        textview5_title_everyday_recommend.setText(bean.getGroups().get(2).getRecommends().get(4).getTitle());   //每日推荐第五个图片内容
        textview5_summary_everyday_recommend.setText(bean.getGroups().get(2).getRecommends().get(4).getSummary());
        MyRequestQueue.setNetImage(imageview5_everyday_recommend, bean.getGroups().get(2).getRecommends().get(4).getImg());

        textview6_title_everyday_recommend.setText(bean.getGroups().get(2).getRecommends().get(5).getTitle());   //每日推荐第六个图片内容
        textview6_summary_everyday_recommend.setText(bean.getGroups().get(2).getRecommends().get(5).getSummary());
        MyRequestQueue.setNetImage(imageview6_everyday_recommend, bean.getGroups().get(2).getRecommends().get(5).getImg());

        //热门歌曲
        tv_item_hot_song_title1.setText(bean.getGroups().get(3).getSongs().get(0).getTitle());  //歌名
        tv_item_hot_song_songer1.setText(bean.getGroups().get(3).getSongs().get(0).getSinger()); //歌手
        MyRequestQueue.setNetImage(iv_item_albumIcon1, bean.getGroups().get(3).getSongs().get(0).getAlbumIcon());    //图片

        tv_item_hot_song_title2.setText(bean.getGroups().get(3).getSongs().get(1).getTitle());  //歌名
        tv_item_hot_song_songer2.setText(bean.getGroups().get(3).getSongs().get(1).getSinger()); //歌手
        MyRequestQueue.setNetImage(iv_item_albumIcon2, bean.getGroups().get(3).getSongs().get(1).getAlbumIcon());    //图片

        tv_item_hot_song_title3.setText(bean.getGroups().get(3).getSongs().get(2).getTitle());  //歌名
        tv_item_hot_song_songer3.setText(bean.getGroups().get(3).getSongs().get(2).getSinger()); //歌手
        MyRequestQueue.setNetImage(iv_item_albumIcon3, bean.getGroups().get(3).getSongs().get(2).getAlbumIcon());    //图片

        tv_item_hot_song_title4.setText(bean.getGroups().get(3).getSongs().get(3).getTitle());  //歌名
        tv_item_hot_song_songer4.setText(bean.getGroups().get(3).getSongs().get(3).getSinger()); //歌手
        MyRequestQueue.setNetImage(iv_item_albumIcon4, bean.getGroups().get(3).getSongs().get(3).getAlbumIcon());    //图片

        tv_item_hot_song_title5.setText(bean.getGroups().get(3).getSongs().get(4).getTitle());  //歌名
        tv_item_hot_song_songer5.setText(bean.getGroups().get(3).getSongs().get(4).getSinger()); //歌手
        MyRequestQueue.setNetImage(iv_item_albumIcon5, bean.getGroups().get(3).getSongs().get(4).getAlbumIcon());    //图片

        //咪咕专栏
        tv_item_title_Special_column1.setText(bean.getGroups().get(10).getMiguColumns().get(0).getTitle());
        tv_item_summary_Special_column1.setText(bean.getGroups().get(10).getMiguColumns().get(0).getSummary());
        MyRequestQueue.setNetImage(iv_item_Special_column1, bean.getGroups().get(10).getMiguColumns().get(0).getImg());

        tv_item_title_Special_column2.setText(bean.getGroups().get(10).getMiguColumns().get(1).getTitle());
        tv_item_summary_Special_column2.setText(bean.getGroups().get(10).getMiguColumns().get(1).getSummary());
        MyRequestQueue.setNetImage(iv_item_Special_column2, bean.getGroups().get(10).getMiguColumns().get(1).getImg());

        tv_item_title_Special_column3.setText(bean.getGroups().get(10).getMiguColumns().get(2).getTitle());
        tv_item_summary_Special_column3.setText(bean.getGroups().get(10).getMiguColumns().get(2).getSummary());
        MyRequestQueue.setNetImage(iv_item_Special_column3, bean.getGroups().get(10).getMiguColumns().get(2).getImg());

        tv_item_title_Special_column4.setText(bean.getGroups().get(10).getMiguColumns().get(3).getTitle());
        tv_item_summary_Special_column4.setText(bean.getGroups().get(10).getMiguColumns().get(3).getSummary());
        MyRequestQueue.setNetImage(iv_item_Special_column4, bean.getGroups().get(10).getMiguColumns().get(3).getImg());

        tv_item_title_Special_column5.setText(bean.getGroups().get(10).getMiguColumns().get(4).getTitle());
        tv_item_summary_Special_column5.setText(bean.getGroups().get(10).getMiguColumns().get(4).getSummary());
        MyRequestQueue.setNetImage(iv_item_Special_column5, bean.getGroups().get(10).getMiguColumns().get(4).getImg());
    }

    /**
     * 初始化findViewById方法
     * @param view
     */
    private void initFindViewById(View view) {

        viewPager = (ViewPager) view.findViewById(R.id.viewpager_fragment_gumi_recommend_music);

//        tv_title_music_sound = (TextView) view.findViewById(R.id.tv_title_music_sound);
//        textview_music_sound_guangliang = (TextView) view.findViewById(R.id.textview_music_sound_guangliang);
//        textview_music_sound_jindan = (TextView) view.findViewById(R.id.textview_music_sound_jindan);
        textview2_title_everyday_recommend = (TextView) view.findViewById(R.id.textview2_title_everyday_recommend);
        textview2_summary_everyday_recommend = (TextView) view.findViewById(R.id.textview2_summary_everyday_recommend);
        textview3_title_everyday_recommend = (TextView) view.findViewById(R.id.textview3_title_everyday_recommend);
        textview3_summary_everyday_recommend = (TextView) view.findViewById(R.id.textview3_summary_everyday_recommend);
        textview4_title_everyday_recommend = (TextView) view.findViewById(R.id.textview4_title_everyday_recommend);
        textview4_summary_everyday_recommend = (TextView) view.findViewById(R.id.textview4_summary_everyday_recommend);
        textview5_title_everyday_recommend = (TextView) view.findViewById(R.id.textview5_title_everyday_recommend);
        textview5_summary_everyday_recommend = (TextView) view.findViewById(R.id.textview5_summary_everyday_recommend);
        textview6_title_everyday_recommend = (TextView) view.findViewById(R.id.textview6_title_everyday_recommend);
        textview6_summary_everyday_recommend = (TextView) view.findViewById(R.id.textview6_summary_everyday_recommend);
        tv_item_hot_song_title1 = (TextView) view.findViewById(R.id.tv_item_hot_song_title1);
        tv_item_hot_song_songer1 = (TextView) view.findViewById(R.id.tv_item_hot_song_songer1);
        tv_item_hot_song_title2 = (TextView) view.findViewById(R.id.tv_item_hot_song_title2);
        tv_item_hot_song_songer2 = (TextView) view.findViewById(R.id.tv_item_hot_song_songer2);
        tv_item_hot_song_title3 = (TextView) view.findViewById(R.id.tv_item_hot_song_title3);
        tv_item_hot_song_songer3 = (TextView) view.findViewById(R.id.tv_item_hot_song_songer3);
        tv_item_hot_song_title4 = (TextView) view.findViewById(R.id.tv_item_hot_song_title4);
        tv_item_hot_song_songer4 = (TextView) view.findViewById(R.id.tv_item_hot_song_songer4);
        tv_item_hot_song_title5 = (TextView) view.findViewById(R.id.tv_item_hot_song_title5);
        tv_item_hot_song_songer5 = (TextView) view.findViewById(R.id.tv_item_hot_song_songer5);
        tv_item_title_Special_column1 = (TextView) view.findViewById(R.id.tv_item_title_Special_column1);
        tv_item_summary_Special_column1 = (TextView) view.findViewById(R.id.tv_item_summary_Special_column1);
        tv_item_title_Special_column2 = (TextView) view.findViewById(R.id.tv_item_title_Special_column2);
        tv_item_summary_Special_column2 = (TextView) view.findViewById(R.id.tv_item_summary_Special_column2);
        tv_item_title_Special_column3 = (TextView) view.findViewById(R.id.tv_item_title_Special_column3);
        tv_item_summary_Special_column3 = (TextView) view.findViewById(R.id.tv_item_summary_Special_column3);
        tv_item_title_Special_column4 = (TextView) view.findViewById(R.id.tv_item_title_Special_column4);
        tv_item_summary_Special_column4 = (TextView) view.findViewById(R.id.tv_item_summary_Special_column4);
        tv_item_title_Special_column5 = (TextView) view.findViewById(R.id.tv_item_title_Special_column5);
        tv_item_summary_Special_column5 = (TextView) view.findViewById(R.id.tv_item_summary_Special_column5);

        textView_more = (TextView) view.findViewById(R.id.textView_more);
        textView_more.setOnClickListener(this);

//        imageview_music_sound_guangliang = (NetworkImageView) view.findViewById(R.id.imageview_music_sound_guangliang);
//        imageview_music_sound_jindan = (NetworkImageView) view.findViewById(R.id.imageview_music_sound_jindan);
        imageview1_everyday_recommend = (NetworkImageView) view.findViewById(R.id.imageview1_everyday_recommend);
        imageview2_everyday_recommend = (NetworkImageView) view.findViewById(R.id.imageview2_everyday_recommend);
        imageview3_everyday_recommend = (NetworkImageView) view.findViewById(R.id.imageview3_everyday_recommend);
        imageview4_everyday_recommend = (NetworkImageView) view.findViewById(R.id.imageview4_everyday_recommend);
        imageview5_everyday_recommend = (NetworkImageView) view.findViewById(R.id.imageview5_everyday_recommend);
        imageview6_everyday_recommend = (NetworkImageView) view.findViewById(R.id.imageview6_everyday_recommend);
        iv_item_albumIcon1 = (NetworkImageView) view.findViewById(R.id.iv_item_albumIcon1);
        iv_item_albumIcon2 = (NetworkImageView) view.findViewById(R.id.iv_item_albumIcon2);
        iv_item_albumIcon3 = (NetworkImageView) view.findViewById(R.id.iv_item_albumIcon3);
        iv_item_albumIcon4 = (NetworkImageView) view.findViewById(R.id.iv_item_albumIcon4);
        iv_item_albumIcon5 = (NetworkImageView) view.findViewById(R.id.iv_item_albumIcon5);
        iv_item_Special_column1 = (NetworkImageView) view.findViewById(R.id.iv_item_Special_column1);
        iv_item_Special_column2 = (NetworkImageView) view.findViewById(R.id.iv_item_Special_column2);
        iv_item_Special_column3 = (NetworkImageView) view.findViewById(R.id.iv_item_Special_column3);
        iv_item_Special_column4 = (NetworkImageView) view.findViewById(R.id.iv_item_Special_column4);
        iv_item_Special_column5 = (NetworkImageView) view.findViewById(R.id.iv_item_Special_column5);

        //每日推荐
        linearLayout1_everyday_recommend = (LinearLayout) view.findViewById(R.id.linearLayout1_everyday_recommend);
        linearLayout2_everyday_recommend = (LinearLayout) view.findViewById(R.id.linearLayout2_everyday_recommend);
        linearLayout3_everyday_recommend = (LinearLayout) view.findViewById(R.id.linearLayout3_everyday_recommend);
        linearLayout4_everyday_recommend = (LinearLayout) view.findViewById(R.id.linearLayout4_everyday_recommend);
        linearLayout5_everyday_recommend = (LinearLayout) view.findViewById(R.id.linearLayout5_everyday_recommend);
        linearLayout6_everyday_recommend = (LinearLayout) view.findViewById(R.id.linearLayout6_everyday_recommend);

        //咪咕专栏
        linearLayout_Special_column1 = (LinearLayout) view.findViewById(R.id.linearLayout_Special_column1);
        linearLayout_Special_column2 = (LinearLayout) view.findViewById(R.id.linearLayout_Special_column2);
        linearLayout_Special_column3 = (LinearLayout) view.findViewById(R.id.linearLayout_Special_column3);
        linearLayout_Special_column4 = (LinearLayout) view.findViewById(R.id.linearLayout_Special_column4);
        linearLayout_Special_column5 = (LinearLayout) view.findViewById(R.id.linearLayout_Special_column5);
        //每日推荐，线性布局监听
        linearLayout1_everyday_recommend.setOnClickListener(this);
        linearLayout2_everyday_recommend.setOnClickListener(this);
        linearLayout3_everyday_recommend.setOnClickListener(this);
        linearLayout4_everyday_recommend.setOnClickListener(this);
        linearLayout5_everyday_recommend.setOnClickListener(this);
        linearLayout6_everyday_recommend.setOnClickListener(this);
        //咪咕专栏，线性布局监听
        linearLayout_Special_column1.setOnClickListener(this);
        linearLayout_Special_column2.setOnClickListener(this);
        linearLayout_Special_column3.setOnClickListener(this);
        linearLayout_Special_column4.setOnClickListener(this);
        linearLayout_Special_column5.setOnClickListener(this);

        iv_san_dian_menu1 = (ImageView) view.findViewById(R.id.iv_san_dian_menu1);
        iv_san_dian_menu2 = (ImageView) view.findViewById(R.id.iv_san_dian_menu2);
        iv_san_dian_menu3 = (ImageView) view.findViewById(R.id.iv_san_dian_menu3);
        iv_san_dian_menu4 = (ImageView) view.findViewById(R.id.iv_san_dian_menu4);
        iv_san_dian_menu5 = (ImageView) view.findViewById(R.id.iv_san_dian_menu5);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.linearLayout1_everyday_recommend:
                if (null != bean.getGroups().get(2).getRecommends().get(0).getUrl()) {
                    FragmentManager fragmentManager = mainActivity.getSupportFragmentManager();
                    FragmentTransaction ft = fragmentManager.beginTransaction();
                    MiGuSongListFragment fragment = new MiGuSongListFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("url", bean.getGroups().get(2).getRecommends().get(0).getUrl());
                    bundle.putString("title", bean.getGroups().get(2).getRecommends().get(0).getTitle());
                    fragment.setArguments(bundle);
                    ft.replace(R.id.frameLayout, fragment);
                    ft.addToBackStack("");
                    ft.commit();
                }
                break;

            case R.id.linearLayout2_everyday_recommend:
                if (null != bean.getGroups().get(2).getRecommends().get(1).getUrl()) {
                    FragmentManager fragmentManager = mainActivity.getSupportFragmentManager();
                    FragmentTransaction ft = fragmentManager.beginTransaction();
                    MiGuSongListFragment fragment = new MiGuSongListFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("url", bean.getGroups().get(2).getRecommends().get(1).getUrl());
                    bundle.putString("title", bean.getGroups().get(2).getRecommends().get(1).getTitle());
                    fragment.setArguments(bundle);
                    ft.replace(R.id.frameLayout, fragment);
                    ft.addToBackStack("");
                    ft.commit();
                }
                break;

            case R.id.linearLayout3_everyday_recommend:
                if (null != bean.getGroups().get(2).getRecommends().get(2).getUrl()) {
//                    Intent intent = new Intent(mainActivity, NetSongListActivity.class);
//                    intent.putExtra("title", bean.getGroups().get(2).getRecommends().get(2).getTitle());
//                    intent.putExtra("url", bean.getGroups().get(2).getRecommends().get(2).getUrl());
//                    startActivity(intent);
                    FragmentManager fragmentManager = mainActivity.getSupportFragmentManager();
                    FragmentTransaction ft = fragmentManager.beginTransaction();
                    MiGuSongListFragment fragment = new MiGuSongListFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("url", bean.getGroups().get(2).getRecommends().get(2).getUrl());
                    bundle.putString("title", bean.getGroups().get(2).getRecommends().get(2).getTitle());
                    fragment.setArguments(bundle);
                    ft.replace(R.id.frameLayout, fragment);
                    ft.addToBackStack("");
                    ft.commit();
                }
                break;

            case R.id.linearLayout4_everyday_recommend:
                if (null != bean.getGroups().get(2).getRecommends().get(3).getUrl()) {
//                    Intent intent = new Intent(mainActivity, NetSongListActivity.class);
//                    intent.putExtra("title", bean.getGroups().get(2).getRecommends().get(3).getTitle());
//                    intent.putExtra("url", bean.getGroups().get(2).getRecommends().get(3).getUrl());
//                    startActivity(intent);
                    FragmentManager fragmentManager = mainActivity.getSupportFragmentManager();
                    FragmentTransaction ft = fragmentManager.beginTransaction();
                    MiGuSongListFragment fragment = new MiGuSongListFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("url", bean.getGroups().get(2).getRecommends().get(3).getUrl());
                    bundle.putString("title", bean.getGroups().get(2).getRecommends().get(3).getTitle());
                    fragment.setArguments(bundle);
                    ft.replace(R.id.frameLayout, fragment);
                    ft.addToBackStack("");
                    ft.commit();
                }
                break;

            case R.id.linearLayout5_everyday_recommend:
                if (null != bean.getGroups().get(2).getRecommends().get(4).getUrl()) {
//                    Intent intent = new Intent(mainActivity, NetSongListActivity.class);
//                    intent.putExtra("title", bean.getGroups().get(2).getRecommends().get(4).getTitle());
//                    intent.putExtra("url", bean.getGroups().get(2).getRecommends().get(4).getUrl());
//                    startActivity(intent);
                    FragmentManager fragmentManager = mainActivity.getSupportFragmentManager();
                    FragmentTransaction ft = fragmentManager.beginTransaction();
                    MiGuSongListFragment fragment = new MiGuSongListFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("url", bean.getGroups().get(2).getRecommends().get(4).getUrl());
                    bundle.putString("title", bean.getGroups().get(2).getRecommends().get(4).getTitle());
                    fragment.setArguments(bundle);
                    ft.replace(R.id.frameLayout, fragment);
                    ft.addToBackStack("");
                    ft.commit();
                }
                break;

            case R.id.linearLayout6_everyday_recommend:
                if (null != bean.getGroups().get(2).getRecommends().get(5).getUrl()) {
//                    Intent intent = new Intent(mainActivity, NetSongListActivity.class);
//                    intent.putExtra("title", bean.getGroups().get(2).getRecommends().get(5).getTitle());
//                    intent.putExtra("url", bean.getGroups().get(2).getRecommends().get(5).getUrl());
//                    startActivity(intent);
                    FragmentManager fragmentManager = mainActivity.getSupportFragmentManager();
                    FragmentTransaction ft = fragmentManager.beginTransaction();
                    MiGuSongListFragment fragment = new MiGuSongListFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("url", bean.getGroups().get(2).getRecommends().get(5).getUrl());
                    bundle.putString("title", bean.getGroups().get(2).getRecommends().get(5).getTitle());
                    fragment.setArguments(bundle);
                    ft.replace(R.id.frameLayout, fragment);
                    ft.addToBackStack("");
                    ft.commit();
                }
                break;

            case R.id.textView_more:
                if (null != bean.getGroups().get(3).getTitle() && null != bean.getGroups().get(3).getUrl()) {
//                    Intent intent = new Intent(mainActivity, NetSongListActivity.class);
//                    intent.putExtra("title", bean.getGroups().get(3).getTitle());
//                    intent.putExtra("url", bean.getGroups().get(3).getUrl());
//                    startActivity(intent);
                    FragmentManager fragmentManager = mainActivity.getSupportFragmentManager();
                    FragmentTransaction ft = fragmentManager.beginTransaction();
                    MiGuSongListFragment fragment = new MiGuSongListFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("url", bean.getGroups().get(3).getUrl());
                    bundle.putString("title", bean.getGroups().get(3).getTitle());
                    fragment.setArguments(bundle);
                    ft.replace(R.id.frameLayout, fragment);
                    ft.addToBackStack("");
                    ft.commit();
                }

                break;

            case R.id.linearLayout_Special_column1:
                if (null != bean.getGroups().get(10).getMiguColumns().get(0).getTitle() && null != bean.getGroups().get(10).getMiguColumns().get(0).getUrl()) {
//                    Intent intent = new Intent(mainActivity, WebViewActivity.class);
//                    intent.putExtra("title", bean.getGroups().get(10).getMiguColumns().get(0).getTitle());
//                    intent.putExtra("url", bean.getGroups().get(10).getMiguColumns().get(0).getUrl());
//                    startActivity(intent);
                    FragmentManager fragmentManager = mainActivity.getSupportFragmentManager();
                    FragmentTransaction ft = fragmentManager.beginTransaction();
                    MiGuWebViewFragment fragment = new MiGuWebViewFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("url", bean.getGroups().get(10).getMiguColumns().get(0).getUrl());
                    bundle.putString("title", bean.getGroups().get(10).getMiguColumns().get(0).getTitle());
                    fragment.setArguments(bundle);
                    ft.replace(R.id.frameLayout, fragment);
                    ft.addToBackStack("");
                    ft.commit();
                }
                break;

            case R.id.linearLayout_Special_column2:
                if (null != bean.getGroups().get(10).getMiguColumns().get(1).getTitle() && null != bean.getGroups().get(10).getMiguColumns().get(1).getUrl()) {
//                    Intent intent = new Intent(mainActivity, WebViewActivity.class);
//                    intent.putExtra("title", bean.getGroups().get(10).getMiguColumns().get(1).getTitle());
//                    intent.putExtra("url", bean.getGroups().get(10).getMiguColumns().get(1).getUrl());
//                    startActivity(intent);
                    FragmentManager fragmentManager = mainActivity.getSupportFragmentManager();
                    FragmentTransaction ft = fragmentManager.beginTransaction();
                    MiGuWebViewFragment fragment = new MiGuWebViewFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("url", bean.getGroups().get(10).getMiguColumns().get(1).getUrl());
                    bundle.putString("title", bean.getGroups().get(10).getMiguColumns().get(1).getTitle());
                    fragment.setArguments(bundle);
                    ft.replace(R.id.frameLayout, fragment);
                    ft.addToBackStack("");
                    ft.commit();
                }
                break;

            case R.id.linearLayout_Special_column3:
                if (null != bean.getGroups().get(10).getMiguColumns().get(2).getTitle() && null != bean.getGroups().get(10).getMiguColumns().get(2).getUrl()) {
//                    Intent intent = new Intent(mainActivity, WebViewActivity.class);
//                    intent.putExtra("title", bean.getGroups().get(10).getMiguColumns().get(2).getTitle());
//                    intent.putExtra("url", bean.getGroups().get(10).getMiguColumns().get(2).getUrl());
//                    startActivity(intent);
                    FragmentManager fragmentManager = mainActivity.getSupportFragmentManager();
                    FragmentTransaction ft = fragmentManager.beginTransaction();
                    MiGuWebViewFragment fragment = new MiGuWebViewFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("url", bean.getGroups().get(10).getMiguColumns().get(2).getUrl());
                    bundle.putString("title", bean.getGroups().get(10).getMiguColumns().get(2).getTitle());
                    fragment.setArguments(bundle);
                    ft.replace(R.id.frameLayout, fragment);
                    ft.addToBackStack("");
                    ft.commit();
                }
                break;

            case R.id.linearLayout_Special_column4:
                if (null != bean.getGroups().get(10).getMiguColumns().get(3).getTitle() && null != bean.getGroups().get(10).getMiguColumns().get(3).getUrl()) {
//                    Intent intent = new Intent(mainActivity, WebViewActivity.class);
//                    intent.putExtra("title", bean.getGroups().get(10).getMiguColumns().get(3).getTitle());
//                    intent.putExtra("url", bean.getGroups().get(10).getMiguColumns().get(3).getUrl());
//                    startActivity(intent);
                    FragmentManager fragmentManager = mainActivity.getSupportFragmentManager();
                    FragmentTransaction ft = fragmentManager.beginTransaction();
                    MiGuWebViewFragment fragment = new MiGuWebViewFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("url", bean.getGroups().get(10).getMiguColumns().get(3).getUrl());
                    bundle.putString("title", bean.getGroups().get(10).getMiguColumns().get(3).getTitle());
                    fragment.setArguments(bundle);
                    ft.replace(R.id.frameLayout, fragment);
                    ft.addToBackStack("");
                    ft.commit();
                }
                break;

            case R.id.linearLayout_Special_column5:
                Log.e("title", bean.getGroups().get(10).getMiguColumns().get(4).getTitle());
                if (null != bean.getGroups().get(10).getMiguColumns().get(4).getTitle() && null != bean.getGroups().get(10).getMiguColumns().get(4).getUrl()) {
//                    Intent intent = new Intent(mainActivity, WebViewActivity.class);
//                    intent.putExtra("title", bean.getGroups().get(10).getMiguColumns().get(4).getTitle());
//                    intent.putExtra("url", bean.getGroups().get(10).getMiguColumns().get(4).getUrl());
//                    startActivity(intent);
                    FragmentManager fragmentManager = mainActivity.getSupportFragmentManager();
                    FragmentTransaction ft = fragmentManager.beginTransaction();
                    MiGuWebViewFragment fragment = new MiGuWebViewFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("url", bean.getGroups().get(10).getMiguColumns().get(4).getUrl());
                    bundle.putString("title", bean.getGroups().get(10).getMiguColumns().get(4).getTitle());
                    fragment.setArguments(bundle);
                    ft.replace(R.id.frameLayout, fragment);
                    ft.addToBackStack("");
                    ft.commit();
                }
                break;

            default:
                break;
        }
    }


    /**
     * 无限轮播ViewPager适配器
     */
    private class GuMiViewPagerAdapter extends PagerAdapter {

        private MiGuRecommendBeans bean;
        private Context context;

        public GuMiViewPagerAdapter(MiGuRecommendBeans bean, Context context) {
            this.bean = bean;
            this.context = context;
        }

        //返回页数
        @Override
        public int getCount() {
            if (bean.getGroups().get(0).getBanners().size() > 1) {
                return Integer.MAX_VALUE;
            }
            return bean.getGroups().get(0).getBanners().size();
        }

        /**
         * 判断view是否和object相关
         * 判断view是否和增加页卡的object相关
         */
        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        /**
         * 增加页卡方法
         */
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            int index = position % bean.getGroups().get(0).getBanners().size();
            View view = LayoutInflater.from(context).inflate(R.layout.lunbo_viewpager,container,false);
            NetworkImageView imageView= (NetworkImageView) view.findViewById(R.id.imageView_lunbo_viewPager);
            MyRequestQueue.setNetImage(imageView,bean.getGroups().get(0).getBanners().get(index).getImg());
            container.addView(view);
            return view;
        }

        /**
         * 删除页卡方法
         */
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {

            container.removeView((View) object);
        }
    }
}
