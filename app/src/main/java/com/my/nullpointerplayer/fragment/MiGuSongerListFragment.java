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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.NetworkImageView;
import com.google.gson.Gson;
import com.my.nullpointerplayer.R;
import com.my.nullpointerplayer.activity.MainActivity;
import com.my.nullpointerplayer.netbeans.MiGuSongerBeans;
import com.my.nullpointerplayer.utils.MyRequestQueue;
import com.my.nullpointerplayer.utils.ReadStringRequestUtf;

/**
 * 咪咕音乐歌手列表Fragment
 * Created by Administrator on 2016/2/17.
 */
public class MiGuSongerListFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {

    private ListView listview;
    private MiGuSongerBeans bean = new MiGuSongerBeans();
    private SongerActivityAdapter adapter;
    private String url, type;
    private TextView textView_title;
    private ImageView imageView;
    private MainActivity mainActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mainActivity= (MainActivity) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_migu_songer_list,container,false);

        textView_title = (TextView) view.findViewById(R.id.textView_title);
        listview = (ListView) view.findViewById(R.id.listview);
        imageView = (ImageView) view.findViewById(R.id.imageView);

        type = getArguments().getString("type");
        url=getArguments().getString("url");

        getBeans();

        textView_title.setText(type);
        imageView.setOnClickListener(this);
        listview.setOnItemClickListener(this);
        return view;
    }

    private void getBeans(){
        ReadStringRequestUtf request = new ReadStringRequestUtf(url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Gson gson = new Gson();
                        bean = gson.fromJson(response, MiGuSongerBeans.class);

                        if (bean.getSingers() != null) {
                            adapter = new SongerActivityAdapter(bean, mainActivity);
                            listview.setAdapter(adapter);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        MyRequestQueue.addRequest(request);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imageView:
                goBack();
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (null != bean.getSingers().get(position).getSinger()) {
            FragmentManager fragmentManager = mainActivity.getSupportFragmentManager();
            FragmentTransaction ft = fragmentManager.beginTransaction();
            MiGuSongerSongListFragment fragment = new MiGuSongerSongListFragment();
            Bundle bundle = new Bundle();
            bundle.putString("singerid", bean.getSingers().get(position).getSingerid() + "");
            bundle.putString("singer", bean.getSingers().get(position).getSinger());
            fragment.setArguments(bundle);
            ft.replace(R.id.frameLayout, fragment);
            ft.addToBackStack("");
            ft.commit();
        }

    }

    /**
     * 适配器
     */
    private class SongerActivityAdapter extends BaseAdapter {

        private MiGuSongerBeans beans;
        private Context context;

        public SongerActivityAdapter(MiGuSongerBeans beans, Context context) {
            this.beans = beans;
            this.context = context;
        }

        @Override
        public int getCount() {
            return beans.getSingers().size();
        }

        @Override
        public Object getItem(int i) {
            return beans.getSingers().size() > 0 && beans.getSingers() != null ? beans.getSingers().get(i) : null;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder = null;
            if (null == view) {
                view = LayoutInflater.from(context).inflate(R.layout.item_fragment_migu_songer_list, viewGroup, false);
                viewHolder = new ViewHolder();
                viewHolder.tv_Songer_item = (TextView) view.findViewById(R.id.tv_Songer_item);
                viewHolder.iv_item = (NetworkImageView) view.findViewById(R.id.iv_item);

                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }

            if (null != beans.getSingers()) {
                viewHolder.tv_Songer_item.setText(beans.getSingers().get(i).getSinger());
                MyRequestQueue.setNetImage(viewHolder.iv_item, beans.getSingers().get(i).getImg());
            }
            return view;
        }

        class ViewHolder {
            TextView tv_Songer_item;
            NetworkImageView iv_item;
        }
    }
}
