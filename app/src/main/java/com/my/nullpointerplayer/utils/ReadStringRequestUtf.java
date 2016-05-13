package com.my.nullpointerplayer.utils;

import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;

import java.io.UnsupportedEncodingException;

/**
 * 把从网上拉取的数据转成utf-8
 *
 * Created by Administrator on 2016/1/14.
 */
public class ReadStringRequestUtf extends StringRequest{
    public ReadStringRequestUtf(int method, String url, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(method, url, listener, errorListener);
    }

    public ReadStringRequestUtf(String url, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(url, listener, errorListener);
    }

    @Override
    protected Response<String> parseNetworkResponse(NetworkResponse response) {
        String parsed = null;
        try {
            parsed = new String(response.data, HttpHeaderParser.parseCharset(response.headers, "utf-8"));
        } catch (UnsupportedEncodingException e) {
            try {
                parsed = new String(response.data,"utf-8");
            } catch (UnsupportedEncodingException e1) {
                parsed = new String(response.data);
            }
        }
        return Response.success(parsed, HttpHeaderParser.parseCacheHeaders(response));
    }
}
