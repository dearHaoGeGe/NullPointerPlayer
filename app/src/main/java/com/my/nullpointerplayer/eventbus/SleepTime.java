package com.my.nullpointerplayer.eventbus;

/**
 * EventBus发送睡眠时间的
 * <p/>
 * Created by dllo on 16/1/22.
 */
public class SleepTime {
    private int sleepTime;

    public SleepTime(int sleepTime) {
        this.sleepTime = sleepTime;
    }

    public int getSleepTime() {
        return sleepTime;
    }

    public void setSleepTime(int sleepTime) {
        this.sleepTime = sleepTime;
    }
}
