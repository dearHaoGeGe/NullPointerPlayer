package com.my.nullpointerplayer.fragment;

import android.content.Context;
import android.content.Intent;
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
import com.android.volley.toolbox.NetworkImageView;
import com.google.gson.Gson;
import com.my.nullpointerplayer.R;
import com.my.nullpointerplayer.activity.MainActivity;
import com.my.nullpointerplayer.netbeans.MiGuMostHotBeans;
import com.my.nullpointerplayer.utils.MyRequestQueue;
import com.my.nullpointerplayer.utils.ReadStringRequestUtf;

/**
 * 咪咕最热歌单Fragment
 * Created by Administrator on 2016/2/16.
 */
public class MiGuMostHotFragment extends BaseFragment implements AdapterView.OnItemClickListener {

    private MainActivity mainActivity;
    private MiGuMostHotBeans bean = new MiGuMostHotBeans();
    private ListView listView_MostHotFragment;
    private MostHotBaseAdapter adapter;

    public static MiGuMostHotFragment newInstance() {
        MiGuMostHotFragment miGuSongListFragment = new MiGuMostHotFragment();
        return miGuSongListFragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_migu_most_hot,container,false);
        initFindViewById(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //动态加载顶部View和底部View
        final LayoutInflater inflater = LayoutInflater.from(mainActivity);
        View headView = inflater.inflate(R.layout.item_head_migu_most_hot_fragment, null, false);
        listView_MostHotFragment.addHeaderView(headView);
        getBeans();
    }

    private void getBeans(){
        String url = "http://218.200.160.29/rdp2/v5.5/musicLists.do?&pageno=1&sort=1&groupcode=365925&tagid=-1&ua=Android_sst&version=4.2280";
        ReadStringRequestUtf request = new ReadStringRequestUtf(url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Gson gson = new Gson();
                        bean = gson.fromJson(response, MiGuMostHotBeans.class);

                        // 此处添加数据
                        adapter = new MostHotBaseAdapter();
                        listView_MostHotFragment.setAdapter(adapter);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        MyRequestQueue.addRequest(request);
    }

    private void initFindViewById(View view) {
        listView_MostHotFragment = (ListView) view.findViewById(R.id.listView_MostHotFragment);
        listView_MostHotFragment.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        position = position - 1;      //listview把head也算在position中，所以要-1判断
        if (position >= 0 && null != bean) {
            FragmentManager fragmentManager = mainActivity.getSupportFragmentManager();
            FragmentTransaction ft = fragmentManager.beginTransaction();
            MiGuSongListFragment fragment = new MiGuSongListFragment();
            Bundle bundle = new Bundle();
            bundle.putString("url", bean.getList().get(position).getUrl());
            bundle.putString("title", bean.getList().get(position).getTitle());
            fragment.setArguments(bundle);
            ft.replace(R.id.frameLayout, fragment);
            ft.addToBackStack("");
            ft.commit();
        }
    }

    /**
     * 适配器
     */
    private class MostHotBaseAdapter extends BaseAdapter {


        @Override
        public int getCount() {
            return bean.getList().size();
        }

        @Override
        public Object getItem(int i) {
            return bean.getList().size() > 0 && bean.getList() != null ? bean.getList().get(i) : null;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (null == view) {
                view = LayoutInflater.from(getActivity()).inflate(R.layout.item_migu_most_hot_fragment, viewGroup, false);
                viewHolder = new ViewHolder();
                viewHolder.textView_title = (TextView) view.findViewById(R.id.textView_title);
                viewHolder.textView_tagNames = (TextView) view.findViewById(R.id.textView_tagNames);
                viewHolder.textView_nickname = (TextView) view.findViewById(R.id.textView_nickname);
                viewHolder.networkImageView_icon = (NetworkImageView) view.findViewById(R.id.networkImageView_icon);
                viewHolder.networkImageView_img = (NetworkImageView) view.findViewById(R.id.networkImageView_img);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            if (null != bean.getList()) {
                viewHolder.textView_title.setText(bean.getList().get(i).getTitle());
                viewHolder.textView_tagNames.setText(bean.getList().get(i).getTagNames());
                viewHolder.textView_nickname.setText(bean.getList().get(i).getOwner().getNickname());
                MyRequestQueue.setNetImage(viewHolder.networkImageView_icon, bean.getList().get(i).getOwner().getIcon());
                MyRequestQueue.setNetImage(viewHolder.networkImageView_img, bean.getList().get(i).getImg());
            }
            return view;
        }

        class ViewHolder {
            TextView textView_title;
            TextView textView_tagNames;
            TextView textView_nickname;
            NetworkImageView networkImageView_icon;
            NetworkImageView networkImageView_img;
        }

    }
}
