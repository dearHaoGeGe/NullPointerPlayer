package com.my.nullpointerplayer.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.my.nullpointerplayer.R;
import com.my.nullpointerplayer.activity.MainActivity;

/**
 * 咪咕WebViewFragment
 * Created by Administrator on 2016/2/16.
 */
public class MiGuWebViewFragment extends BaseFragment implements View.OnClickListener {

    private MainActivity mainActivity;
    private WebView webView;
    private ImageView imageView;
    private TextView textView;
    private String url, title;

    public static WebViewFragment newInstance() {
        WebViewFragment webViewFragment = new WebViewFragment();
        return webViewFragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_web_view, container, false);
        url = getArguments().getString("url");
        title = getArguments().getString("title");
        webView = (WebView) view.findViewById(R.id.webView);
        textView = (TextView) view.findViewById(R.id.textView_title);
        imageView = (ImageView) view.findViewById(R.id.imageView_back2);

        textView.setText(title);
        //设置WebView属性，能够执行Javascript脚本
        webView.getSettings().setJavaScriptEnabled(true);
        //加载需要显示的网页
        webView.loadUrl(url+"&pageno=1&ua=Android_sst&version=4.2280");
        //设置Web视图
        webView.setWebViewClient(new HelloWebViewClient());

        imageView.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageView_back2:
                goBack();
                break;
        }
    }

    //Web视图
    private class HelloWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
