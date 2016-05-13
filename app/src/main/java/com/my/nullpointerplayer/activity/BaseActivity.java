package com.my.nullpointerplayer.activity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.my.nullpointerplayer.service.PlayService;

/**
 * Created by dllo on 16/1/26.
 */
public class BaseActivity extends AppCompatActivity {

    public PlayService playService;
    private boolean isBound = false;

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            PlayService.PlayBinder playBinder = (PlayService.PlayBinder) iBinder;
            playService = playBinder.getPlayService();
            // TODO 添加位置
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            playService = null;
            isBound = false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * 绑定服务
     */
    public void bindPlayService() {
        if (!isBound) {
            Intent intent = new Intent(this, PlayService.class);
            bindService(intent, connection, Context.BIND_AUTO_CREATE);
            Log.e("BaseActivity", "PlayService服务已经绑定");
            isBound = true;
        }
    }

    /**
     * 解除绑定服务
     */
    public void unbindPlayService() {
        if (isBound) {
            unbindService(connection);
            Log.e("BaseActivity", "PlayService服务已经解除绑定");
            isBound = false;
        }
    }
}
