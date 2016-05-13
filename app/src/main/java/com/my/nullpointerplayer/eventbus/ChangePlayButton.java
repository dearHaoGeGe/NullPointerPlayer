package com.my.nullpointerplayer.eventbus;

/**
 * 改变播放按钮拔出耳机和设置时间自动关闭音乐EventBus用到此类
 *
 * Created by Administrator on 2016/2/20.
 */
public class ChangePlayButton {

    private boolean changeUI;

    public ChangePlayButton(boolean changeUI) {
        this.changeUI = changeUI;
    }

    public boolean isChangeUI() {
        return changeUI;
    }

    public void setChangeUI(boolean changeUI) {
        this.changeUI = changeUI;
    }
}
