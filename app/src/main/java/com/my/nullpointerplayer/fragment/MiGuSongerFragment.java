package com.my.nullpointerplayer.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.NetworkImageView;
import com.google.gson.Gson;
import com.my.nullpointerplayer.R;
import com.my.nullpointerplayer.activity.MainActivity;
import com.my.nullpointerplayer.netbeans.MiGuHotSongerBeans;
import com.my.nullpointerplayer.utils.MyRequestQueue;
import com.my.nullpointerplayer.utils.ReadStringRequestUtf;

/**
 * Created by Administrator on 2016/2/17.
 */
public class MiGuSongerFragment extends BaseFragment implements View.OnClickListener {

    private LinearLayout linearLayout_huanyu_nan, linearLayout_huanyu_nv, linearLayout_huanyu_zuhe,
            linearLayout_oumei_nan, linearLayout_oumei_nv, linearLayout_oumei_zuhe,
            linearLayout_rihan_nan, linearLayout_rihan_nv, linearLayout_rihan_zuhe;
    private TextView textView_singer1, textView_singer2, textView_singer3, textView_singer4, textView_singer5,
            textView_singer6, textView_singer7, textView_singer8, textView_singer9, textView_singer10;
    private NetworkImageView circleImageView1, circleImageView2, circleImageView3, circleImageView4, circleImageView5,
            circleImageView6, circleImageView7, circleImageView8, circleImageView9, circleImageView10;
    private MainActivity mainActivity;
    private MiGuHotSongerBeans bean = new MiGuHotSongerBeans();

    public static MiGuSongerFragment newInstance(){
        MiGuSongerFragment miGuSongerFragment=new MiGuSongerFragment();
        return miGuSongerFragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mainActivity= (MainActivity) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_migu_songer, container, false);
        initFindViewById(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getBeans();
    }

    private void getBeans(){
        String url = "http://218.200.160.29/rdp2/v5.5/singer_categorys.do?&ua=Android_sst&version=4.2280";
        ReadStringRequestUtf request = new ReadStringRequestUtf(url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Gson gson = new Gson();
                        bean = gson.fromJson(response, MiGuHotSongerBeans.class);
                        if (null != bean) {
                            addNetData(bean);
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

    /**
     * 添加网络数据
     * @param bean
     */
    private void addNetData(MiGuHotSongerBeans bean) {
        textView_singer1.setText(bean.getHots().get(0).getSinger());
        MyRequestQueue.setNetImage(circleImageView1, bean.getHots().get(0).getImg());

        textView_singer2.setText(bean.getHots().get(1).getSinger());
        MyRequestQueue.setNetImage(circleImageView2, bean.getHots().get(1).getImg());

        textView_singer3.setText(bean.getHots().get(2).getSinger());
        MyRequestQueue.setNetImage(circleImageView3, bean.getHots().get(2).getImg());

        textView_singer4.setText(bean.getHots().get(3).getSinger());
        MyRequestQueue.setNetImage(circleImageView4, bean.getHots().get(3).getImg());

        textView_singer5.setText(bean.getHots().get(4).getSinger());
        MyRequestQueue.setNetImage(circleImageView5, bean.getHots().get(4).getImg());

        textView_singer6.setText(bean.getHots().get(5).getSinger());
        MyRequestQueue.setNetImage(circleImageView6, bean.getHots().get(5).getImg());

        textView_singer7.setText(bean.getHots().get(6).getSinger());
        MyRequestQueue.setNetImage(circleImageView7, bean.getHots().get(6).getImg());

        textView_singer8.setText(bean.getHots().get(7).getSinger());
        MyRequestQueue.setNetImage(circleImageView8, bean.getHots().get(7).getImg());

        textView_singer9.setText(bean.getHots().get(8).getSinger());
        MyRequestQueue.setNetImage(circleImageView9, bean.getHots().get(8).getImg());

        textView_singer10.setText(bean.getHots().get(9).getSinger());
        MyRequestQueue.setNetImage(circleImageView10, bean.getHots().get(9).getImg());
    }

    private void initFindViewById(View view) {
        linearLayout_huanyu_nan = (LinearLayout) view.findViewById(R.id.linearLayout_huanyu_nan);
        linearLayout_huanyu_nv = (LinearLayout) view.findViewById(R.id.linearLayout_huanyu_nv);
        linearLayout_huanyu_zuhe = (LinearLayout) view.findViewById(R.id.linearLayout_huanyu_zuhe);
        linearLayout_oumei_nan = (LinearLayout) view.findViewById(R.id.linearLayout_oumei_nan);
        linearLayout_oumei_nv = (LinearLayout) view.findViewById(R.id.linearLayout_oumei_nv);
        linearLayout_oumei_zuhe = (LinearLayout) view.findViewById(R.id.linearLayout_oumei_zuhe);
        linearLayout_rihan_nan = (LinearLayout) view.findViewById(R.id.linearLayout_rihan_nan);
        linearLayout_rihan_nv = (LinearLayout) view.findViewById(R.id.linearLayout_rihan_nv);
        linearLayout_rihan_zuhe = (LinearLayout) view.findViewById(R.id.linearLayout_rihan_zuhe);
        linearLayout_huanyu_nan.setOnClickListener(this);
        linearLayout_huanyu_nv.setOnClickListener(this);
        linearLayout_huanyu_zuhe.setOnClickListener(this);
        linearLayout_oumei_nan.setOnClickListener(this);
        linearLayout_oumei_nv.setOnClickListener(this);
        linearLayout_oumei_zuhe.setOnClickListener(this);
        linearLayout_rihan_nan.setOnClickListener(this);
        linearLayout_rihan_nv.setOnClickListener(this);
        linearLayout_rihan_zuhe.setOnClickListener(this);

        textView_singer1 = (TextView) view.findViewById(R.id.textView_singer1);
        textView_singer2 = (TextView) view.findViewById(R.id.textView_singer2);
        textView_singer3 = (TextView) view.findViewById(R.id.textView_singer3);
        textView_singer4 = (TextView) view.findViewById(R.id.textView_singer4);
        textView_singer5 = (TextView) view.findViewById(R.id.textView_singer5);
        textView_singer6 = (TextView) view.findViewById(R.id.textView_singer6);
        textView_singer7 = (TextView) view.findViewById(R.id.textView_singer7);
        textView_singer8 = (TextView) view.findViewById(R.id.textView_singer8);
        textView_singer9 = (TextView) view.findViewById(R.id.textView_singer9);
        textView_singer10 = (TextView) view.findViewById(R.id.textView_singer10);

        circleImageView1 = (NetworkImageView) view.findViewById(R.id.circleImageView1);
        circleImageView2 = (NetworkImageView) view.findViewById(R.id.circleImageView2);
        circleImageView3 = (NetworkImageView) view.findViewById(R.id.circleImageView3);
        circleImageView4 = (NetworkImageView) view.findViewById(R.id.circleImageView4);
        circleImageView5 = (NetworkImageView) view.findViewById(R.id.circleImageView5);
        circleImageView6 = (NetworkImageView) view.findViewById(R.id.circleImageView6);
        circleImageView7 = (NetworkImageView) view.findViewById(R.id.circleImageView7);
        circleImageView8 = (NetworkImageView) view.findViewById(R.id.circleImageView8);
        circleImageView9 = (NetworkImageView) view.findViewById(R.id.circleImageView9);
        circleImageView10 = (NetworkImageView) view.findViewById(R.id.circleImageView10);

        circleImageView1.setOnClickListener(this);
        circleImageView2.setOnClickListener(this);
        circleImageView3.setOnClickListener(this);
        circleImageView4.setOnClickListener(this);
        circleImageView5.setOnClickListener(this);
        circleImageView6.setOnClickListener(this);
        circleImageView7.setOnClickListener(this);
        circleImageView8.setOnClickListener(this);
        circleImageView9.setOnClickListener(this);
        circleImageView10.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.linearLayout_huanyu_nan:
                if (null != bean.getCategories().get(0).getUrl()) {
//                    Intent intent = new Intent(mainActivity, SongerActivity.class);
//                    intent.putExtra("url", bean.getCategories().get(0).getUrl());
//                    intent.putExtra("type", "华语男歌手");
//                    startActivity(intent);
                    FragmentManager fragmentManager = mainActivity.getSupportFragmentManager();
                    FragmentTransaction ft = fragmentManager.beginTransaction();
                    MiGuSongerListFragment fragment = new MiGuSongerListFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("url", bean.getCategories().get(0).getUrl());
                    bundle.putString("type", "华语男歌手");
                    fragment.setArguments(bundle);
                    ft.replace(R.id.frameLayout, fragment);
                    ft.addToBackStack("");
                    ft.commit();
                }
                break;

            case R.id.linearLayout_huanyu_nv:
                if (null != bean.getCategories().get(1).getUrl()) {
//                    Intent intent = new Intent(mainActivity, SongerActivity.class);
//                    intent.putExtra("url", bean.getCategories().get(1).getUrl());
//                    intent.putExtra("type", "华语女歌手");
//                    startActivity(intent);
                    FragmentManager fragmentManager = mainActivity.getSupportFragmentManager();
                    FragmentTransaction ft = fragmentManager.beginTransaction();
                    MiGuSongerListFragment fragment = new MiGuSongerListFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("url", bean.getCategories().get(1).getUrl());
                    bundle.putString("type", "华语女歌手");
                    fragment.setArguments(bundle);
                    ft.replace(R.id.frameLayout, fragment);
                    ft.addToBackStack("");
                    ft.commit();
                }
                break;

            case R.id.linearLayout_huanyu_zuhe:
                if (null != bean.getCategories().get(2).getUrl()) {
//                    Intent intent = new Intent(mainActivity, SongerActivity.class);
//                    intent.putExtra("url", bean.getCategories().get(2).getUrl());
//                    intent.putExtra("type", "华语组合");
//                    startActivity(intent);
                    FragmentManager fragmentManager = mainActivity.getSupportFragmentManager();
                    FragmentTransaction ft = fragmentManager.beginTransaction();
                    MiGuSongerListFragment fragment = new MiGuSongerListFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("url", bean.getCategories().get(2).getUrl());
                    bundle.putString("type", "华语组合");
                    fragment.setArguments(bundle);
                    ft.replace(R.id.frameLayout, fragment);
                    ft.addToBackStack("");
                    ft.commit();
                }
                break;

            case R.id.linearLayout_oumei_nan:
                if (null != bean.getCategories().get(3).getUrl()) {
//                    Intent intent = new Intent(mainActivity, SongerActivity.class);
//                    intent.putExtra("url", bean.getCategories().get(3).getUrl());
//                    intent.putExtra("type", "欧美男歌手");
//                    startActivity(intent);
                    FragmentManager fragmentManager = mainActivity.getSupportFragmentManager();
                    FragmentTransaction ft = fragmentManager.beginTransaction();
                    MiGuSongerListFragment fragment = new MiGuSongerListFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("url", bean.getCategories().get(3).getUrl());
                    bundle.putString("type", "欧美男歌手");
                    fragment.setArguments(bundle);
                    ft.replace(R.id.frameLayout, fragment);
                    ft.addToBackStack("");
                    ft.commit();
                }
                break;

            case R.id.linearLayout_oumei_nv:
                if (null != bean.getCategories().get(4).getUrl()) {
//                    Intent intent = new Intent(mainActivity, SongerActivity.class);
//                    intent.putExtra("url", bean.getCategories().get(4).getUrl());
//                    intent.putExtra("type", "欧美女歌手");
//                    startActivity(intent);
                    FragmentManager fragmentManager = mainActivity.getSupportFragmentManager();
                    FragmentTransaction ft = fragmentManager.beginTransaction();
                    MiGuSongerListFragment fragment = new MiGuSongerListFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("url", bean.getCategories().get(4).getUrl());
                    bundle.putString("type", "欧美女歌手");
                    fragment.setArguments(bundle);
                    ft.replace(R.id.frameLayout, fragment);
                    ft.addToBackStack("");
                    ft.commit();
                }
                break;

            case R.id.linearLayout_oumei_zuhe:
                if (null != bean.getCategories().get(5).getUrl()) {
//                    Intent intent = new Intent(mainActivity, SongerActivity.class);
//                    intent.putExtra("url", bean.getCategories().get(5).getUrl());
//                    intent.putExtra("type", "欧美组合");
//                    startActivity(intent);
                    FragmentManager fragmentManager = mainActivity.getSupportFragmentManager();
                    FragmentTransaction ft = fragmentManager.beginTransaction();
                    MiGuSongerListFragment fragment = new MiGuSongerListFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("url", bean.getCategories().get(5).getUrl());
                    bundle.putString("type", "欧美组合");
                    fragment.setArguments(bundle);
                    ft.replace(R.id.frameLayout, fragment);
                    ft.addToBackStack("");
                    ft.commit();
                }
                break;

            case R.id.linearLayout_rihan_nan:
                if (null != bean.getCategories().get(6).getUrl()) {
//                    Intent intent = new Intent(mainActivity, SongerActivity.class);
//                    intent.putExtra("url", bean.getCategories().get(6).getUrl());
//                    intent.putExtra("type", "日韩男歌手");
//                    startActivity(intent);
                    FragmentManager fragmentManager = mainActivity.getSupportFragmentManager();
                    FragmentTransaction ft = fragmentManager.beginTransaction();
                    MiGuSongerListFragment fragment = new MiGuSongerListFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("url", bean.getCategories().get(6).getUrl());
                    bundle.putString("type", "日韩男歌手");
                    fragment.setArguments(bundle);
                    ft.replace(R.id.frameLayout, fragment);
                    ft.addToBackStack("");
                    ft.commit();
                }
                break;

            case R.id.linearLayout_rihan_nv:
                if (null != bean.getCategories().get(7).getUrl()) {
//                    Intent intent = new Intent(mainActivity, SongerActivity.class);
//                    intent.putExtra("url", bean.getCategories().get(7).getUrl());
//                    intent.putExtra("type", "日韩女歌手");
//                    startActivity(intent);
                    FragmentManager fragmentManager = mainActivity.getSupportFragmentManager();
                    FragmentTransaction ft = fragmentManager.beginTransaction();
                    MiGuSongerListFragment fragment = new MiGuSongerListFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("url", bean.getCategories().get(7).getUrl());
                    bundle.putString("type", "日韩女歌手");
                    fragment.setArguments(bundle);
                    ft.replace(R.id.frameLayout, fragment);
                    ft.addToBackStack("");
                    ft.commit();
                }
                break;

            case R.id.linearLayout_rihan_zuhe:
                if (null != bean.getCategories().get(8).getUrl()) {
//                    Intent intent = new Intent(mainActivity, SongerActivity.class);
//                    intent.putExtra("url", bean.getCategories().get(8).getUrl());
//                    intent.putExtra("type", "日韩组合");
//                    startActivity(intent);
                    FragmentManager fragmentManager = mainActivity.getSupportFragmentManager();
                    FragmentTransaction ft = fragmentManager.beginTransaction();
                    MiGuSongerListFragment fragment = new MiGuSongerListFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("url", bean.getCategories().get(8).getUrl());
                    bundle.putString("type", "日韩组合");
                    fragment.setArguments(bundle);
                    ft.replace(R.id.frameLayout, fragment);
                    ft.addToBackStack("");
                    ft.commit();
                }
                break;

            case R.id.circleImageView1:
                if (null != bean) {
//                    Intent intent = new Intent(mainActivity, NetSongerSongListActivity.class);
//                    String singerid = bean.getHots().get(0).getSingerid() + "";
//                    intent.putExtra("singerid", singerid);
//                    intent.putExtra("singer", bean.getHots().get(0).getSinger());
//                    startActivity(intent);
                    FragmentManager fragmentManager = mainActivity.getSupportFragmentManager();
                    FragmentTransaction ft = fragmentManager.beginTransaction();
                    MiGuSongerSongListFragment fragment = new MiGuSongerSongListFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("singerid", bean.getHots().get(0).getSingerid() + "");
                    bundle.putString("singer", bean.getHots().get(0).getSinger());
                    fragment.setArguments(bundle);
                    ft.replace(R.id.frameLayout, fragment);
                    ft.addToBackStack("");
                    ft.commit();
                }

                break;

            case R.id.circleImageView2:
                if (null != bean) {
//                    Intent intent = new Intent(mainActivity, NetSongerSongListActivity.class);
//                    String singerid = bean.getHots().get(1).getSingerid() + "";
//                    intent.putExtra("singerid", singerid);
//                    intent.putExtra("singer", bean.getHots().get(1).getSinger());
//                    startActivity(intent);
                    FragmentManager fragmentManager = mainActivity.getSupportFragmentManager();
                    FragmentTransaction ft = fragmentManager.beginTransaction();
                    MiGuSongerSongListFragment fragment = new MiGuSongerSongListFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("singerid", bean.getHots().get(1).getSingerid() + "");
                    bundle.putString("singer", bean.getHots().get(1).getSinger());
                    fragment.setArguments(bundle);
                    ft.replace(R.id.frameLayout, fragment);
                    ft.addToBackStack("");
                    ft.commit();
                }
                break;

            case R.id.circleImageView3:
                if (null != bean) {
//                    Intent intent = new Intent(mainActivity, NetSongerSongListActivity.class);
//                    String singerid = bean.getHots().get(2).getSingerid() + "";
//                    intent.putExtra("singerid", singerid);
//                    intent.putExtra("singer", bean.getHots().get(2).getSinger());
//                    startActivity(intent);
                    FragmentManager fragmentManager = mainActivity.getSupportFragmentManager();
                    FragmentTransaction ft = fragmentManager.beginTransaction();
                    MiGuSongerSongListFragment fragment = new MiGuSongerSongListFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("singerid", bean.getHots().get(2).getSingerid() + "");
                    bundle.putString("singer", bean.getHots().get(2).getSinger());
                    fragment.setArguments(bundle);
                    ft.replace(R.id.frameLayout, fragment);
                    ft.addToBackStack("");
                    ft.commit();
                }
                break;

            case R.id.circleImageView4:
                if (null != bean) {
//                    Intent intent = new Intent(mainActivity, NetSongerSongListActivity.class);
//                    String singerid = bean.getHots().get(3).getSingerid() + "";
//                    intent.putExtra("singerid", singerid);
//                    intent.putExtra("singer", bean.getHots().get(3).getSinger());
//                    startActivity(intent);
                    FragmentManager fragmentManager = mainActivity.getSupportFragmentManager();
                    FragmentTransaction ft = fragmentManager.beginTransaction();
                    MiGuSongerSongListFragment fragment = new MiGuSongerSongListFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("singerid", bean.getHots().get(3).getSingerid() + "");
                    bundle.putString("singer", bean.getHots().get(3).getSinger());
                    fragment.setArguments(bundle);
                    ft.replace(R.id.frameLayout, fragment);
                    ft.addToBackStack("");
                    ft.commit();
                }
                break;

            case R.id.circleImageView5:
                if (null != bean) {
//                    Intent intent = new Intent(mainActivity, NetSongerSongListActivity.class);
//                    String singerid = bean.getHots().get(4).getSingerid() + "";
//                    intent.putExtra("singerid", singerid);
//                    intent.putExtra("singer", bean.getHots().get(4).getSinger());
//                    startActivity(intent);
                    FragmentManager fragmentManager = mainActivity.getSupportFragmentManager();
                    FragmentTransaction ft = fragmentManager.beginTransaction();
                    MiGuSongerSongListFragment fragment = new MiGuSongerSongListFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("singerid", bean.getHots().get(4).getSingerid() + "");
                    bundle.putString("singer", bean.getHots().get(4).getSinger());
                    fragment.setArguments(bundle);
                    ft.replace(R.id.frameLayout, fragment);
                    ft.addToBackStack("");
                    ft.commit();
                }
                break;

            case R.id.circleImageView6:
                if (null != bean) {
//                    Intent intent = new Intent(mainActivity, NetSongerSongListActivity.class);
//                    String singerid = bean.getHots().get(5).getSingerid() + "";
//                    intent.putExtra("singerid", singerid);
//                    intent.putExtra("singer", bean.getHots().get(5).getSinger());
//                    Log.e("singerid", "id=" + bean.getHots().get(5).getSingerid());
//                    startActivity(intent);
                    FragmentManager fragmentManager = mainActivity.getSupportFragmentManager();
                    FragmentTransaction ft = fragmentManager.beginTransaction();
                    MiGuSongerSongListFragment fragment = new MiGuSongerSongListFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("singerid", bean.getHots().get(5).getSingerid() + "");
                    bundle.putString("singer", bean.getHots().get(5).getSinger());
                    fragment.setArguments(bundle);
                    ft.replace(R.id.frameLayout, fragment);
                    ft.addToBackStack("");
                    ft.commit();
                }
                break;

            case R.id.circleImageView7:
                if (null != bean) {
//                    Intent intent = new Intent(mainActivity, NetSongerSongListActivity.class);
//                    String singerid = bean.getHots().get(6).getSingerid() + "";
//                    intent.putExtra("singerid", singerid);
//                    intent.putExtra("singer", bean.getHots().get(6).getSinger());
//                    startActivity(intent);
                    FragmentManager fragmentManager = mainActivity.getSupportFragmentManager();
                    FragmentTransaction ft = fragmentManager.beginTransaction();
                    MiGuSongerSongListFragment fragment = new MiGuSongerSongListFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("singerid", bean.getHots().get(6).getSingerid() + "");
                    bundle.putString("singer", bean.getHots().get(6).getSinger());
                    fragment.setArguments(bundle);
                    ft.replace(R.id.frameLayout, fragment);
                    ft.addToBackStack("");
                    ft.commit();
                }
                break;

            case R.id.circleImageView8:
                if (null != bean) {
//                    Intent intent = new Intent(mainActivity, NetSongerSongListActivity.class);
//                    String singerid = bean.getHots().get(7).getSingerid() + "";
//                    intent.putExtra("singerid", singerid);
//                    intent.putExtra("singer", bean.getHots().get(7).getSinger());
//                    startActivity(intent);
                    FragmentManager fragmentManager = mainActivity.getSupportFragmentManager();
                    FragmentTransaction ft = fragmentManager.beginTransaction();
                    MiGuSongerSongListFragment fragment = new MiGuSongerSongListFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("singerid", bean.getHots().get(7).getSingerid() + "");
                    bundle.putString("singer", bean.getHots().get(7).getSinger());
                    fragment.setArguments(bundle);
                    ft.replace(R.id.frameLayout, fragment);
                    ft.addToBackStack("");
                    ft.commit();
                }
                break;

            case R.id.circleImageView9:
                if (null != bean) {
//                    Intent intent = new Intent(mainActivity, NetSongerSongListActivity.class);
//                    String singerid = bean.getHots().get(8).getSingerid() + "";
//                    intent.putExtra("singerid", singerid);
//                    intent.putExtra("singer", bean.getHots().get(8).getSinger());
//                    startActivity(intent);
                    FragmentManager fragmentManager = mainActivity.getSupportFragmentManager();
                    FragmentTransaction ft = fragmentManager.beginTransaction();
                    MiGuSongerSongListFragment fragment = new MiGuSongerSongListFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("singerid", bean.getHots().get(8).getSingerid() + "");
                    bundle.putString("singer", bean.getHots().get(8).getSinger());
                    fragment.setArguments(bundle);
                    ft.replace(R.id.frameLayout, fragment);
                    ft.addToBackStack("");
                    ft.commit();
                }
                break;

            case R.id.circleImageView10:
                if (null != bean) {
//                    Intent intent = new Intent(mainActivity, NetSongerSongListActivity.class);
//                    String singerid = bean.getHots().get(9).getSingerid() + "";
//                    intent.putExtra("singerid", singerid);
//                    intent.putExtra("singer", bean.getHots().get(9).getSinger());
//                    startActivity(intent);
                    FragmentManager fragmentManager = mainActivity.getSupportFragmentManager();
                    FragmentTransaction ft = fragmentManager.beginTransaction();
                    MiGuSongerSongListFragment fragment = new MiGuSongerSongListFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("singerid", bean.getHots().get(9).getSingerid() + "");
                    bundle.putString("singer", bean.getHots().get(9).getSinger());
                    fragment.setArguments(bundle);
                    ft.replace(R.id.frameLayout, fragment);
                    ft.addToBackStack("");
                    ft.commit();
                }
                break;
        }
    }
}
