package com.my.nullpointerplayer.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.my.nullpointerplayer.R;
import com.my.nullpointerplayer.activity.MainActivity;
import com.my.nullpointerplayer.eventbus.SleepTime;

import de.greenrobot.event.EventBus;

/**
 * 设置暂停时间的Fragment
 * Created by Administrator on 2016/2/20.
 */
public class SettingFragment extends BaseFragment implements View.OnClickListener {

    private MainActivity mainActivity;
    private Button button_setting;
    private EditText editText_setting;

    public static SettingFragment newInstance() {
        SettingFragment settingFragment = new SettingFragment();
        return settingFragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_setting, container, false);

        button_setting = (Button) view.findViewById(R.id.button_setting);
        editText_setting = (EditText) view.findViewById(R.id.editText_setting);

        button_setting.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_setting:
                int time = Integer.valueOf(editText_setting.getText().toString());
                EventBus.getDefault().post(new SleepTime(time));
                Toast.makeText(mainActivity, "设置成功" + time + "S之后歌曲停止", Toast.LENGTH_SHORT).show();
                goBack();
                break;
        }
    }
}
