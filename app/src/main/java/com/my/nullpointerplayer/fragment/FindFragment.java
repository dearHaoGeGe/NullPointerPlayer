package com.my.nullpointerplayer.fragment;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.my.nullpointerplayer.R;
import com.my.nullpointerplayer.activity.MainActivity;
import com.my.nullpointerplayer.adapter.FindGridviewType12BaseAdapter;
import com.my.nullpointerplayer.adapter.FindGridviewType5BaseAdapter;
import com.my.nullpointerplayer.adapter.FindListviewType13BaseAdapter;
import com.my.nullpointerplayer.adapter.FindListviewType2BaseAdapter;
import com.my.nullpointerplayer.custom.BannerLayout;
import com.my.nullpointerplayer.custom.MyGridView;
import com.my.nullpointerplayer.custom.MyListView;
import com.my.nullpointerplayer.db.DaoMaster;
import com.my.nullpointerplayer.db.DaoSession;
import com.my.nullpointerplayer.db.FindFragmentData;
import com.my.nullpointerplayer.db.FindFragmentDataDao;
import com.my.nullpointerplayer.netbeans.FindNetBeans;
import com.my.nullpointerplayer.utils.MyRequestQueue;
import com.my.nullpointerplayer.utils.ReadStringRequestUtf;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.dao.query.QueryBuilder;

/**
 * 发现Fragment
 * Created by dllo on 16/1/26.
 */
public class FindFragment extends BaseFragment {

    private MainActivity mainActivity;
    private FindNetBeans beans = new FindNetBeans();
    private FindBaseAdapter adapter;
    private ListView listView;

    /* greendao数据库的变量 */
    private FindFragmentDataDao findFragmentDataDao;
    private DaoSession mDaoSession;
    private DaoMaster mDaoMaster;
    private SQLiteDatabase db;
    private DaoMaster.OpenHelper helper;

    public static FindFragment newInstance() {
        FindFragment findFragment = new FindFragment();
        return findFragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) context;
    }

    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_find, container, false);
        listView = (ListView) view.findViewById(R.id.listView);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getBeans();
    }

    /**
     * 获取网络数据类
     */
    private void getBeans() {
        String url = "http://api.dongting.com/frontpage/frontpage?location=0&version=1453541260911&app=ttpod&v=v8.1.4.2016011318&user_id=0&mid=iPhone5S&f=f320&s=s310&imsi=&hid=&splus=9.2&active=1&net=2&openudid=1320e380b9b2f879587531a841bd2709b0fe0b43&idfa=1797AE83-E11D-40E8-BF4A-51688F9D8197&utdid=VcqZd7Bai40DAKYNvRHg4TLh&alf=201200&bundle_id=com.ttpod.music&latitude=&longtitude=%22";

        ReadStringRequestUtf request = new ReadStringRequestUtf(url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        putIn("FindFragmentDataDao", response);  //从网上拉取到数据要放在数据库里面

                        Gson gson = new Gson();
                        beans = gson.fromJson(response, FindNetBeans.class);

                        adapter = new FindBaseAdapter(mainActivity, beans);
                        listView.setAdapter(adapter);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        String response = getResponse("FindFragmentDataDao");     //如果网络请求错误的话从数据库中拉取上次存进去的数据
                        if (!response.equals("")) {   //如果数据库中的网络数据不为空的话
                            Gson gson = new Gson();
                            beans = gson.fromJson(response, FindNetBeans.class);

                            adapter = new FindBaseAdapter(mainActivity, beans);
                            listView.setAdapter(adapter);
                        }
                    }
                });
        MyRequestQueue.addRequest(request);
    }

    /**
     * 向数据库中存
     *
     * @param name
     * @param response
     */
    public void putIn(String name, String response) {
        helper = new DaoMaster.DevOpenHelper(mainActivity, "MyDB1.db", null);
        db = helper.getWritableDatabase();
        mDaoMaster = new DaoMaster(db);
        mDaoSession = mDaoMaster.newSession();
        findFragmentDataDao = mDaoSession.getFindFragmentDataDao();

        FindFragmentData myData = new FindFragmentData(name, response);
        findFragmentDataDao.insertOrReplace(myData);
    }

    /**
     * 向数据库中取
     *
     * @param name
     * @return
     */
    public String getResponse(String name) {
        helper = new DaoMaster.DevOpenHelper(mainActivity, "MyDB1.db", null);
        db = helper.getWritableDatabase();
        mDaoMaster = new DaoMaster(db);
        mDaoSession = mDaoMaster.newSession();
        QueryBuilder queryBuilder = mDaoSession.getFindFragmentDataDao().queryBuilder();
        queryBuilder.where(FindFragmentDataDao.Properties.Name.eq(name));
        ArrayList<FindFragmentData> datas = (ArrayList<FindFragmentData>) queryBuilder.list();
        return datas.get(0).getResponse();
    }

    /**
     * 适配器
     */
    private class FindBaseAdapter extends BaseAdapter {

        private Context context;
        private FindNetBeans bean;

        private final int TYPE_2 = 2;
        private final int TYPE_5 = 5;
        private final int TYPE_8 = 8;
        private final int TYPE_12 = 12;
        private final int TYPE_13 = 13;

        public FindBaseAdapter(Context context, FindNetBeans bean) {
            this.context = context;
            this.bean = bean;
        }

        @Override
        public int getCount() {
            return bean.getData().size();
        }

        @Override
        public Object getItem(int position) {
            return bean.getData().get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder2 viewHolder2 = null;
            ViewHolder5 viewHolder5 = null;
            ViewHolder8 viewHolder8 = null;
            ViewHolder12 viewHolder12 = null;
            ViewHolder13 viewHolder13 = null;

            convertView = LayoutInflater.from(context).inflate(R.layout.default_layout_find_listview, parent, false);

            int type = bean.getData().get(position).getStyle();
            switch (type) {
                case TYPE_2:    //亚洲新歌榜
                    convertView = LayoutInflater.from(context).inflate(R.layout.find_listview_type_2, parent, false);
                    viewHolder2 = new ViewHolder2();
                    viewHolder2.textView = (TextView) convertView.findViewById(R.id.textView);
                    viewHolder2.listView = (MyListView) convertView.findViewById(R.id.listView);

                    viewHolder2.textView.setText(bean.getData().get(position).getName());
                    FindListviewType2BaseAdapter findListviewType2BaseAdapter = new FindListviewType2BaseAdapter(context, bean, position);
                    viewHolder2.listView.setAdapter(findListviewType2BaseAdapter);

                    final int pos2 = position;
                    viewHolder2.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            // TODO 添加点击事件
//                            Toast.makeText(context, bean.getData().get(pos2).getData().get(position).getAction().getValue() + "", Toast.LENGTH_SHORT).show();
                            FragmentManager fragmentManager = mainActivity.getSupportFragmentManager();
                            FragmentTransaction ft = fragmentManager.beginTransaction();
                            WebViewFragment fragment = new WebViewFragment();
                            Bundle bundle = new Bundle();
                            bundle.putString("url", bean.getData().get(pos2).getData().get(position).getAction().getValue());
                            bundle.putString("title", bean.getData().get(pos2).getData().get(position).getName());
                            fragment.setArguments(bundle);
                            ft.replace(R.id.frameLayout, fragment);
                            ft.addToBackStack("");
                            ft.commit();
                        }
                    });
                    break;

                case TYPE_5:
                    //热门歌单
                    convertView = LayoutInflater.from(context).inflate(R.layout.find_gridview_type_5, parent, false);
                    viewHolder5 = new ViewHolder5();
                    viewHolder5.textView = (TextView) convertView.findViewById(R.id.textView);
                    viewHolder5.gridView = (MyGridView) convertView.findViewById(R.id.gridView);

                    viewHolder5.textView.setText(bean.getData().get(position).getName());
                    FindGridviewType5BaseAdapter findGridviewType5BaseAdapter = new FindGridviewType5BaseAdapter(bean, context, position);
                    viewHolder5.gridView.setAdapter(findGridviewType5BaseAdapter);

                    final int pos5 = position;
                    viewHolder5.gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            // TODO 添加点击事件
//                            Toast.makeText(context, bean.getData().get(pos5).getData().get(position).getAction().getValue(), Toast.LENGTH_SHORT).show();
                            FragmentManager fragmentManager = mainActivity.getSupportFragmentManager();
                            FragmentTransaction ft = fragmentManager.beginTransaction();
                            NetSongListZeroFragment fragment = new NetSongListZeroFragment();
                            Bundle bundle = new Bundle();
                            bundle.putString("value", bean.getData().get(pos5).getData().get(position).getAction().getValue());
                            fragment.setArguments(bundle);
                            ft.replace(R.id.frameLayout, fragment);
                            ft.addToBackStack("");
                            ft.commit();
                        }
                    });
                    break;

                case TYPE_8:
                    //轮播图
                    convertView = LayoutInflater.from(context).inflate(R.layout.find_bannerlayout_type_8, parent, false);
                    viewHolder8 = new ViewHolder8();
                    viewHolder8.bannerLayout = (BannerLayout) convertView.findViewById(R.id.bannerLayout);

                    if (null != bean) {
                        List<String> imageViewUrl = new ArrayList<>();
                        for (int i = 0; i < bean.getData().get(position).getData().size(); i++) {
                            imageViewUrl.add(bean.getData().get(position).getData().get(i).getPicUrl());
                        }
                        viewHolder8.bannerLayout.setViewUrls(imageViewUrl);
                    }

                    final int pos8 = position;
                    viewHolder8.bannerLayout.setOnBannerItemClickListener(new BannerLayout.OnBannerItemClickListener() {
                        @Override
                        public void onItemClick(int position) {
//                            Toast.makeText(context, bean.getData().get(pos8).getData().get(position).getAction().getValue() + "", Toast.LENGTH_SHORT).show();
                            if (bean.getData().get(pos8).getData().get(position).getAction().getType() == 1) {
                                FragmentManager fragmentManager = mainActivity.getSupportFragmentManager();
                                FragmentTransaction ft = fragmentManager.beginTransaction();
                                WebViewFragment fragment = new WebViewFragment();
                                Bundle bundle = new Bundle();
                                bundle.putString("url", bean.getData().get(pos8).getData().get(position).getAction().getValue());
                                bundle.putString("title", bean.getData().get(pos8).getData().get(position).getName());
                                fragment.setArguments(bundle);
                                ft.replace(R.id.frameLayout, fragment);
                                ft.addToBackStack("");
                                ft.commit();
                            } else {
                                FragmentManager fragmentManager = mainActivity.getSupportFragmentManager();
                                FragmentTransaction ft = fragmentManager.beginTransaction();
                                NetSongListZeroFragment fragment = new NetSongListZeroFragment();
                                Bundle bundle = new Bundle();
                                bundle.putString("value", bean.getData().get(pos8).getData().get(position).getAction().getValue());
                                fragment.setArguments(bundle);
                                ft.replace(R.id.frameLayout, fragment);
                                ft.addToBackStack("");
                                ft.commit();
                            }
                        }
                    });
                    break;

                case TYPE_12:
                    //快捷入口
                    convertView = LayoutInflater.from(context).inflate(R.layout.find_gridview_type_12, parent, false);
                    viewHolder12 = new ViewHolder12();
                    viewHolder12.gridView = (MyGridView) convertView.findViewById(R.id.gridView);

                    FindGridviewType12BaseAdapter findGridviewType12BaseAdapter = new FindGridviewType12BaseAdapter(context, bean, position);
                    viewHolder12.gridView.setAdapter(findGridviewType12BaseAdapter);

                    final int pos12 = position;
                    viewHolder12.gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                            Toast.makeText(context, bean.getData().get(pos12).getData().get(position).getName() + "", Toast.LENGTH_SHORT).show();
                            switch (position) {
                                case 0:
                                    goNextFragment(RankingListFragment.newInstance());
                                    break;

                                case 1:
                                    goNextFragment(SongSheetFragment.newInstance());
                                    break;

                                case 2:     //电台
                                    break;

                                case 3:
                                    goNextFragment(SongerFragment.newInstance());
                                    break;
                            }
                        }
                    });
                    break;

                case TYPE_13:   //我是歌手
                    convertView = LayoutInflater.from(context).inflate(R.layout.find_listview_type_13, parent, false);
                    viewHolder13 = new ViewHolder13();
                    viewHolder13.textView = (TextView) convertView.findViewById(R.id.textView);
                    viewHolder13.textView_more = (TextView) convertView.findViewById(R.id.textView_more);
                    viewHolder13.listView = (MyListView) convertView.findViewById(R.id.listView);

                    FindListviewType13BaseAdapter findListviewType13BaseAdapter = new FindListviewType13BaseAdapter(context, bean, position);
                    viewHolder13.listView.setAdapter(findListviewType13BaseAdapter);

                    final int pos13 = position;
                    viewHolder13.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            // TODO 添加点击事件
//                            Toast.makeText(context, bean.getData().get(pos13).getData().get(position).getAction().getValue() + "", Toast.LENGTH_SHORT).show();
                            FragmentManager fragmentManager = mainActivity.getSupportFragmentManager();
                            FragmentTransaction ft = fragmentManager.beginTransaction();
                            WebViewFragment fragment = new WebViewFragment();
                            Bundle bundle = new Bundle();
                            bundle.putString("url", bean.getData().get(pos13).getData().get(position).getAction().getValue());
                            bundle.putString("title", bean.getData().get(pos13).getData().get(position).getName());
                            fragment.setArguments(bundle);
                            ft.replace(R.id.frameLayout, fragment);
                            ft.addToBackStack("");
                            ft.commit();
                        }
                    });
                    break;
            }
            return convertView;
        }

        class ViewHolder2 {
            TextView textView;
            MyListView listView;
        }

        class ViewHolder5 {
            TextView textView;
            MyGridView gridView;
        }

        class ViewHolder8 {
            BannerLayout bannerLayout;
        }

        class ViewHolder12 {
            MyGridView gridView;
        }

        class ViewHolder13 {
            TextView textView;
            TextView textView_more;
            MyListView listView;
        }
    }
}