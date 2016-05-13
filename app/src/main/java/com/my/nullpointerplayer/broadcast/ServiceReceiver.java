package com.my.nullpointerplayer.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.my.nullpointerplayer.service.PlayService;

/**
 * 后台开机自启服务广播接收者
 *
 * Created by dllo on 16/1/23.
 */
public class ServiceReceiver extends BroadcastReceiver {
    private Context context;
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)) {
            Intent i = new Intent(context, PlayService.class);
            context.startService(i);
            Toast.makeText(context, "空指针播放器的PlayService已经后台自启", Toast.LENGTH_LONG).show();
        }
    }
}
