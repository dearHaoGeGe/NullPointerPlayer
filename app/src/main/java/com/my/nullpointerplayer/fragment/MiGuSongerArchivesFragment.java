package com.my.nullpointerplayer.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.my.nullpointerplayer.R;
import com.my.nullpointerplayer.activity.MainActivity;

/**
 * 咪咕歌手档案Fragment
 * Created by Administrator on 2016/2/17.
 */
public class MiGuSongerArchivesFragment extends BaseFragment {

    private TextView textView_name,textView_introduce;
    private String summary,detail;
    private MainActivity mainActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_migu_songer_archives,container,false);

        summary = getArguments().getString("summary");
        detail = getArguments().getString("detail");

        textView_name= (TextView) view.findViewById(R.id.textView_name);
        textView_introduce= (TextView) view.findViewById(R.id.textView_introduce);

        textView_name.setText(summary);
        textView_introduce.setText(detail);
        return view;
    }
}
