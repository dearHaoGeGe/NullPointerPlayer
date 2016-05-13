package com.my.nullpointerplayer.eventbus;

/**
 * Created by dllo on 16/1/27.
 */
public class UpdateProgress {

    private int progress;

    public UpdateProgress(int progress) {
        this.progress = progress;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }
}
