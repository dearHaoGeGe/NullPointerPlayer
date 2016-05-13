package com.my.nullpointerplayer.eventbus;

/**
 * 本类是来确定PlayActivity是否创建的,
 * 用EventBus给PlayService发消息,
 * 之后PlayService会给PlayActivity消息,来更新UI
 * <p/>
 * Created by dllo on 16/1/29.
 */
public class IsPlayActivityCreate {
    private boolean bool;

    public IsPlayActivityCreate(boolean bool) {
        this.bool = bool;
    }

    public boolean isBool() {
        return bool;
    }

    public void setBool(boolean bool) {
        this.bool = bool;
    }
}
