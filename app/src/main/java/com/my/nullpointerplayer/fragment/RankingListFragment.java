package com.my.nullpointerplayer.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.NetworkImageView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.my.nullpointerplayer.R;
import com.my.nullpointerplayer.activity.MainActivity;
import com.my.nullpointerplayer.netbeans.RankingListBeans;
import com.my.nullpointerplayer.utils.MyRequestQueue;
import com.my.nullpointerplayer.utils.ReadStringRequestUtf;

import java.util.ArrayList;
import java.util.List;

/**
 * 排行榜Fragment
 * <p/>
 * Created by Administrator on 2016/2/4.
 */
public class RankingListFragment extends BaseFragment implements AdapterView.OnItemClickListener, View.OnClickListener {

    private MainActivity mainActivity;
    private List<RankingListBeans> beans = new ArrayList<>();
    private ListView listView;
    private ImageView imageView_back;
    private RankingListBaseAdapter adapter;

    public static RankingListFragment newInstance() {
        RankingListFragment rankingListFragment = new RankingListFragment();
        return rankingListFragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rankinglist, container, false);
        listView = (ListView) view.findViewById(R.id.listView);
        imageView_back= (ImageView) view.findViewById(R.id.imageView_back);

        listView.setOnItemClickListener(this);
        imageView_back.setOnClickListener(this);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getBeans();
    }

    /**
     * 获取网络数据
     */
    private void getBeans() {
        String url = "http://api.songlist.ttpod.com/channels/bhb/children?v=v8.3.2.2015121811";
        ReadStringRequestUtf request = new ReadStringRequestUtf(url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Gson gson = new Gson();
                        beans = gson.fromJson(response, new TypeToken<List<RankingListBeans>>(){}.getType());

                        adapter = new RankingListBaseAdapter(mainActivity, beans.get(0));
                        listView.setAdapter(adapter);
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
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //Toast.makeText(mainActivity, "已经点击了", Toast.LENGTH_SHORT).show();
        switch (position){
            case 0:
                break;

            case 1:     //动听热搜榜
                setUrlAndJumpNext("http://api.songlist.ttpod.com/ranklists/1/current?agent=none&longitude=0.0&utdid=VqTof1UU%2FvIDAJwcljAsz8ky&net=2&from=android&os=5.1&v=v8.3.2.2015121811&alf=700633&api_version=1.0&imei=000000000000000&latitude=0.0&f=1&resolution=1080x1776&language=zh&user_id=0");
//                FragmentManager fragmentManager = mainActivity.getSupportFragmentManager();
//                FragmentTransaction ft = fragmentManager.beginTransaction();
//                BangNetListFragment fragment = new BangNetListFragment();
//                Bundle bundle = new Bundle();
//                bundle.putString("url", "http://api.songlist.ttpod.com/ranklists/1/current?agent=none&longitude=0.0&utdid=VqTof1UU%2FvIDAJwcljAsz8ky&net=2&from=android&os=5.1&v=v8.3.2.2015121811&alf=700633&api_version=1.0&imei=000000000000000&latitude=0.0&f=1&resolution=1080x1776&language=zh&user_id=0");
//                fragment.setArguments(bundle);
//                ft.replace(R.id.frameLayout, fragment);
//                ft.addToBackStack("");
//                ft.commit();
                break;

            case 2:     //动听热歌榜
                setUrlAndJumpNext("http://api.songlist.ttpod.com/ranklists/111/current?f=1&os=4.4.4&alf=700633&imei=000000000000000&from=android&resolution=1080x1776&net=2&api_version=1.0&agent=none&v=v8.3.2.2015121811&utdid=VZ4wel5vHx8DAJwcljDPrh%2FZ&longitude=0.0&user_id=0&latitude=0.0&language=zh");
                break;

            case 3:     //动听新歌榜
                setUrlAndJumpNext("http://api.songlist.ttpod.com/ranklists/112/current?agent=none&longitude=0.0&utdid=VqTof1UU%2FvIDAJwcljAsz8ky&net=2&from=android&os=5.1&v=v8.3.2.2015121811&alf=700633&api_version=1.0&imei=000000000000000&latitude=0.0&f=1&resolution=1080x1776&language=zh&user_id=0");
                break;

            case 4:     //动听欧美榜
                setUrlAndJumpNext("http://api.songlist.ttpod.com/ranklists/14/current?agent=none&longitude=0.0&utdid=VqTof1UU%2FvIDAJwcljAsz8ky&net=2&from=android&os=5.1&v=v8.3.2.2015121811&alf=700633&api_version=1.0&imei=000000000000000&latitude=0.0&f=1&resolution=1080x1776&language=zh&user_id=0");
                break;

            case 5:     //动听日语榜
                setUrlAndJumpNext("http://api.songlist.ttpod.com/ranklists/10/current?agent=none&longitude=0.0&utdid=VqTof1UU%2FvIDAJwcljAsz8ky&net=2&from=android&os=5.1&v=v8.3.2.2015121811&alf=700633&api_version=1.0&imei=000000000000000&latitude=0.0&f=1&resolution=1080x1776&language=zh&user_id=0");
                break;

            case 6:     //动听韩语榜
                setUrlAndJumpNext("http://api.songlist.ttpod.com/ranklists/6/current?agent=none&longitude=0.0&utdid=VqTof1UU%2FvIDAJwcljAsz8ky&net=2&from=android&os=5.1&v=v8.3.2.2015121811&alf=700633&api_version=1.0&imei=000000000000000&latitude=0.0&f=1&resolution=1080x1776&language=zh&user_id=0");
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imageView_back:
                goBack();
                break;
        }
    }

    /**
     * 适配器
     */
    private class RankingListBaseAdapter extends BaseAdapter {

        private Context context;
        //private List<RankingListBeans> bean;
        private RankingListBeans bean;

        public RankingListBaseAdapter(Context context, RankingListBeans bean) {
            this.context = context;
            this.bean = bean;
        }

        @Override
        public int getCount() {
            return bean.getRefs().size();
        }

        @Override
        public Object getItem(int position) {
            return bean.getRefs().get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder = null;
            if (null == convertView) {
                convertView = LayoutInflater.from(context).inflate(R.layout.item_rankinglist, parent, false);
                viewHolder = new ViewHolder();
                viewHolder.textView_title = (TextView) convertView.findViewById(R.id.textView_title);
                viewHolder.textView_song1 = (TextView) convertView.findViewById(R.id.textView_song1);
                viewHolder.textView_song2 = (TextView) convertView.findViewById(R.id.textView_song2);
                viewHolder.textView_song3 = (TextView) convertView.findViewById(R.id.textView_song3);
                viewHolder.imageView = (NetworkImageView) convertView.findViewById(R.id.imageView);

                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            if (null != bean) {
                viewHolder.textView_title.setText(bean.getRefs().get(position).getTitle());
                viewHolder.textView_song1.setText("1." + bean.getRefs().get(position).getSongs().get(0).getName() + " - " + bean.getRefs().get(position).getSongs().get(0).getSingerName());
                viewHolder.textView_song2.setText("2." + bean.getRefs().get(position).getSongs().get(1).getName() + " - " + bean.getRefs().get(position).getSongs().get(1).getSingerName());
                viewHolder.textView_song3.setText("3." + bean.getRefs().get(position).getSongs().get(2).getName() + " - " + bean.getRefs().get(position).getSongs().get(2).getSingerName());
                MyRequestQueue.setNetImage(viewHolder.imageView, bean.getRefs().get(position).getImage().getPic());

            }
            return convertView;
        }

        class ViewHolder {
            TextView textView_title;
            TextView textView_song1;
            TextView textView_song2;
            TextView textView_song3;
            NetworkImageView imageView;
        }
    }

    /**
     * 为跳到下一页设置URL,并且跳转
     * @param url
     */
    private void setUrlAndJumpNext(String url){
        FragmentManager fragmentManager = mainActivity.getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        BangNetListFragment fragment = new BangNetListFragment();
        Bundle bundle = new Bundle();
        bundle.putString("url", url);
        fragment.setArguments(bundle);
        ft.replace(R.id.frameLayout, fragment);
        ft.addToBackStack("");
        ft.commit();
    }
}
