package com.my.nullpointerplayer.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.my.nullpointerplayer.R;
import com.my.nullpointerplayer.activity.MainActivity;

import java.util.HashMap;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;
import cn.sharesdk.tencent.qq.QQ;

/**
 * 我的页面Fragment
 * Created by dllo on 16/1/26.
 */
public class MyFragment extends BaseFragment implements View.OnClickListener {

    private MainActivity mainActivity;
    private LinearLayout linearLayout_local_music, linearLayout_songer, linearLayout_migu, linearLayout_Share, linearLayout_setting,linearLayout_login;
    //private FragmentManager fragmentManager;

    public static MyFragment newInstance() {
        MyFragment myFragment = new MyFragment();
        return myFragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my, container, false);
        linearLayout_local_music = (LinearLayout) view.findViewById(R.id.linearLayout_local_music);
        linearLayout_migu = (LinearLayout) view.findViewById(R.id.linearLayout_migu);
        linearLayout_songer = (LinearLayout) view.findViewById(R.id.linearLayout_songer);
        linearLayout_Share = (LinearLayout) view.findViewById(R.id.linearLayout_Share);
        linearLayout_setting = (LinearLayout) view.findViewById(R.id.linearLayout_setting);
        linearLayout_login= (LinearLayout) view.findViewById(R.id.linearLayout_login);

        linearLayout_login.setOnClickListener(this);
        linearLayout_setting.setOnClickListener(this);
        linearLayout_Share.setOnClickListener(this);
        linearLayout_songer.setOnClickListener(this);
        linearLayout_migu.setOnClickListener(this);
        linearLayout_local_music.setOnClickListener(this);

        ShareSDK.initSDK(mainActivity);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.linearLayout_local_music: //本地音乐
                //跳转到
                goNextFragment(LocalMusicFragment.newInstance());
                break;

            case R.id.linearLayout_migu:    //咪咕最热歌单
                //goNextFragment(MiGuMostHotFragment.newInstance());
                break;

            case R.id.linearLayout_songer:  //咪咕歌手
                goNextFragment(MiGuSongerFragment.newInstance());
                break;

            case R.id.linearLayout_Share:   //一键分享
                showShare();
                break;

            case R.id.linearLayout_setting: //设置睡眠时间
                goNextFragment(SettingFragment.newInstance());
                break;

            case R.id.linearLayout_login:   //登录
                thirdPartyLogin();
                break;
        }
    }

    /**
     * 分享
     */
    private void showShare() {
        ShareSDK.initSDK(mainActivity);
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();

// 分享时Notification的图标和文字  2.5.9以后的版本不调用此方法
        //oks.setNotification(R.drawable.ic_launcher, getString(R.string.app_name));
        // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
        oks.setTitle(getString(R.string.ssdk_oks_share));
        // titleUrl是标题的网络链接，仅在人人网和QQ空间使用
        oks.setTitleUrl("http://sharesdk.cn");
        // text是分享文本，所有平台都需要这个字段
        oks.setText("我是分享文本");
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl("http://sharesdk.cn");
        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment("我是测试评论文本");
        // site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite(getString(R.string.app_name));
        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl("http://sharesdk.cn");

// 启动分享GUI
        oks.show(mainActivity);
    }

    /**
     * 三方登录
     */
    private void thirdPartyLogin(){
        PlatformActionListener listener2 = new PlatformActionListener() {
            @Override
            public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
                Log.d("welcome", "12312312312312312312312312312312312312");
                Log.d("TrainFragment", platform.getDb().getUserId());
                Log.d("TrainFragment", platform.getDb().getUserName());
                Log.d("TrainFragment", platform.getDb().getUserIcon());
                Log.d("TrainFragment", "12312312312312312312312312312312312312");
                Log.d("TrainFragment", "hashMap:" + hashMap);

//                        Intent intent1 = new Intent(WelcomeActivity.this,MainActivity.class);
//                        intent1.putExtra("username", platform.getDb().getUserName());
//                        intent1.putExtra("usericon", platform.getDb().getUserIcon());
//                        startActivity(intent1);
            }

            @Override
            public void onError(Platform platform, int i, Throwable throwable) {
//                        Toast.makeText(WelcomeActivity.this, "授权失败", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancel(Platform platform, int i) {
//                        Toast.makeText(WelcomeActivity.this, "取消授权", Toast.LENGTH_SHORT).show();
            }
        };

        Platform platform2 = ShareSDK.getPlatform(mainActivity, QQ.NAME);
        //判断是否已经授权过，如果授权，删除授权信息重新授权
        if (platform2.isValid()) {
            platform2.removeAccount();
        }
        platform2.setPlatformActionListener(listener2);
        platform2.showUser(null);
        platform2.authorize();
    }
}
