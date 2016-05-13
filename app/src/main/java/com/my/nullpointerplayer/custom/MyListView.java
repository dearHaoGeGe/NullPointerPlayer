package com.my.nullpointerplayer.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ListView;

/**
 * 自定义一个ListView,在嵌套ListView中能全部显示出来
 * Created by Administrator on 2016/2/3.
 */
public class MyListView extends ListView {

    public MyListView(Context context) {
        super(context);
    }

    public MyListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        Log.e("widthMeasureSpec=",widthMeasureSpec+"");
        Log.e("expandSpec=",expandSpec+"");
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
