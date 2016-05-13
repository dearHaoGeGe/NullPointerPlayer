package com.my.nullpointerplayer.eventbus;

/**
 * 本类是来确定MainActivity是否创建的,
 * 用EventBus给PlayService发消息,
 * 之后PlayService会给MainActivity发消息,来更新UI
 * <p>
 * Created by dllo on 16/1/28.
 */
public class IsMainActivityCreate {
    private boolean bool;

    public IsMainActivityCreate(boolean bool) {
        this.bool = bool;
    }

    public boolean isBool() {
        return bool;
    }

    public void setBool(boolean bool) {
        this.bool = bool;
    }
}
