package com.my.nullpointerplayer.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.LruCache;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;
import com.my.nullpointerplayer.R;
import com.my.nullpointerplayer.application.BaseApplication;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by dllo on 16/1/16.
 */
public class MyRequestQueue {
    private volatile static RequestQueue queue;
    private volatile static ImageLoader loader;

    public MyRequestQueue() {
    }

    public static RequestQueue getQueue() {
        if (queue == null) {
            queue = Volley.newRequestQueue(BaseApplication.context);
        }
        return queue;
    }

    public static void addRequest(Request request) {
        getQueue().add(request);
    }

    public static ImageLoader getLoader() {
        if (loader == null) {
            MyDoubleCache cache = new MyDoubleCache();
            loader = new ImageLoader(getQueue(), cache);
        }
        return loader;
    }

    public static void setNetImage(NetworkImageView networkImageView, String url) {
        networkImageView.setDefaultImageResId(R.mipmap.default_background);
        networkImageView.setErrorImageResId(R.mipmap.app_log);
        networkImageView.setImageUrl(url, getLoader());
    }


    //内存
    private static class MyMemoryCache implements ImageLoader.ImageCache {


        private LruCache<String, Bitmap> caches;

        public MyMemoryCache() {
            initMemoryCache();
        }

        private void initMemoryCache() {
            int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
            int cacheSize = maxMemory / 4;
            caches = new LruCache<String, Bitmap>(cacheSize) {
                @Override
                protected int sizeOf(String url, Bitmap bmp) {
                    //获得内存字节数
                    return bmp.getRowBytes() * bmp.getHeight() / 1024;
                }
            };
        }

        @Override
        public Bitmap getBitmap(String url) {
            return caches.get(url);
        }

        @Override
        public void putBitmap(String url, Bitmap bitmap) {
            caches.put(url, bitmap);
        }
    }

    private static class MyDoubleCache implements ImageLoader.ImageCache {
        private MyMemoryCache memoryCache;
        private DiskCache diskCache;

        public MyDoubleCache() {
            memoryCache = new MyMemoryCache();
            diskCache = new DiskCache();
        }

        @Override
        public Bitmap getBitmap(String url) {
            Bitmap bitmap = memoryCache.getBitmap(url);
            if (null == bitmap) {
                bitmap = diskCache.getBitmap(url);
            }
            return bitmap;
        }

        @Override
        public void putBitmap(String url, Bitmap bitmap) {
            diskCache.putBitmap(url, bitmap);
            memoryCache.putBitmap(url, bitmap);
        }
    }

    //SD卡
    private static class DiskCache implements ImageLoader.ImageCache {
        private final String ALBUM_PATH
                = Environment.getExternalStorageDirectory().getAbsolutePath() + "/download_test/";

        @Override
        public Bitmap getBitmap(String url) {

            return readFile(url);
        }

        @Override
        public void putBitmap(String url, Bitmap bitmap) {
//            if (url.length() > 100) {
//                url = url.substring(59, 70) + ".jpg";
//            } else {
                url = url.substring(url.lastIndexOf("/"), url.lastIndexOf(".") + 4);
            //}

            saveFile(bitmap, ALBUM_PATH + "/" + url);

        }

        public Bitmap readFile(String fileName) {
            if (fileName.length() > 100) {
                fileName = fileName.substring(59, 70) + ".jpg";
            } else {
                fileName = fileName.substring(fileName.lastIndexOf("/"), fileName.lastIndexOf(".") + 4);
            }
            fileName = ALBUM_PATH + "/" + fileName;

            File mFile = new File(fileName);
            if (mFile.exists()) {
                Bitmap bitmap = decodeSampledBitmapFromFile(fileName, 480, 800);
                return bitmap;
            }
            return null;
        }

        public void saveFile(Bitmap bm, String fileName) {
            File myCaptureFile = new File(ALBUM_PATH);
            if (!myCaptureFile.exists()) {
                myCaptureFile.mkdir();
            }
            FileOutputStream bos = null;
            try {
                bos = new FileOutputStream(fileName);
                bm.compress(Bitmap.CompressFormat.JPEG, 100, bos);


            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } finally {
                if (null == bos) {
                    try {
                        bos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        }

    }


    //获得缩放比例
    public static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) > reqHeight
                    && (halfWidth / inSampleSize) > reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }

    //从文件中按照比例设置图
    public static Bitmap decodeSampledBitmapFromFile(String url, int reqWidth, int reqHeight) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(url, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(url, options);
    }


}
