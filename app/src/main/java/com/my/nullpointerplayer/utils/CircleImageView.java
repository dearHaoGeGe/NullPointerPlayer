package com.my.nullpointerplayer.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

import com.android.volley.toolbox.NetworkImageView;

/**
 * 网络圆角图片
 * Created by dllo on 16/1/20.
 */
public class CircleImageView extends NetworkImageView {

    public CircleImageView(Context context) {
        super(context);
    }

    public CircleImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        // 获得ImageView里存得图片
        Drawable drawable = getDrawable();
        Paint paint = new Paint();
        // 判断drawable是否为空
        if (drawable != null) {
            // 将图片处理成圆形
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap(); // 获得drawable里的图片
            // 处理
            Bitmap b = getCircleBitMap(bitmap); // 接受处理过的图像
            Rect rectSrc = new Rect(0, 0, b.getWidth(), b.getHeight());
            Rect rectDest = new Rect(0, 0, b.getWidth(), b.getHeight());
            canvas.drawBitmap(b, rectSrc, rectDest, paint);
        } else {
            // 没给图片处理，用默认的方法
            super.onDraw(canvas);
        }
    }

    // 获取圆形的BitMap
    private Bitmap getCircleBitMap(Bitmap bitmap) {
        Bitmap outPut = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas();
        canvas.setBitmap(outPut);   // 让画布画出图像，显示在outPut这张bitMap上
        Paint paint = new Paint();  // 画笔
        paint.setAntiAlias(true);   // 抗锯齿
        // 矩形范围是bitmap
        Rect rect = new Rect(0, 0, bitmap.getHeight(), bitmap.getWidth());

        canvas.drawCircle(bitmap.getHeight() / 2, bitmap.getHeight() / 2, bitmap.getHeight() / 2, paint);
        // 设置叠放模式
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return outPut;
    }
}
