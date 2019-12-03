package com.bawei.liangxingsong20191203.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * 作者：梁兴松
 * 时间：2019/12/3  8:46
 * 类名：com.bawei.liangxingsong20191203.util
 */

public class NetUtil {
    //单例
    static NetUtil netUtil = new NetUtil();

    public static NetUtil getInstance() {
        return netUtil;
    }

    private NetUtil() {
    }

    @SuppressLint("StaticFieldLeak")
    public void doget(final String http, final MyCallBack myCallBack){
        new AsyncTask<String, Void, String>() {
            @Override
            protected String doInBackground(String... strings) {
                HttpURLConnection httpURLConnection = null;
                InputStream inputStream = null;
                String json = "";
                try {
                    URL url = new URL(http);
                     httpURLConnection = (HttpURLConnection) url.openConnection();
                     httpURLConnection.setRequestMethod("GET");
                     httpURLConnection.setConnectTimeout(5000);
                     httpURLConnection.setReadTimeout(5000);
                     httpURLConnection.connect();
                     if (httpURLConnection.getResponseCode() == 200){
                          inputStream = httpURLConnection.getInputStream();
                          json = io2String(inputStream);
                         Log.e("TAG", "请求成功！");
                     }else{
                         Log.e("TAG", "请求失败！");
                     }
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                return json;
            }

            @Override
            protected void onPostExecute(String s) {
                if (TextUtils.isEmpty(s)){
                    myCallBack.Error(s);
                }else{
                    myCallBack.doget(s);
                }
            }
        }.execute();
    }

    @SuppressLint("StaticFieldLeak")
    public void dogetphoto(final String http, final ImageView imageView){
        new AsyncTask<String, Void, Bitmap>() {
            @Override
            protected Bitmap doInBackground(String... strings) {
                HttpURLConnection httpURLConnection = null;
                InputStream inputStream = null;
                Bitmap bitmap = null;
                try {
                    URL url = new URL(http);
                    httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setConnectTimeout(5000);
                    httpURLConnection.setReadTimeout(5000);
                    httpURLConnection.connect();
                    if (httpURLConnection.getResponseCode() == 200){
                        inputStream = httpURLConnection.getInputStream();
                         bitmap = io2Bitmap(inputStream);
                        Log.e("TAG", "请求图片成功！");
                    }else{
                        Log.e("TAG", "请求图片失败！");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                return bitmap;
            }

            @Override
            protected void onPostExecute(Bitmap bitmap) {
                imageView.setImageBitmap(bitmap);
            }
        }.execute();
    }

    public String io2String(InputStream inputStream){
        byte[] bytes = new byte[1024];
        int len = -1;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        String json = "";
        try {
            while ((len = inputStream.read(bytes)) != -1){
                byteArrayOutputStream.write(bytes,0,len);
            }
            byte[] bytes1 = byteArrayOutputStream.toByteArray();
             json = new String(bytes1);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }

    public Bitmap io2Bitmap(InputStream inputStream){
        Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
        return bitmap;
    }

//是否有网！
    public boolean hasnet(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
            return true;
        }else{
            return false;
        }
    }
    //是否是wifi
    public boolean wifi(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
            return true;
        }else{
            return false;
        }
    }
    //是否是移动网络
    public boolean mobile(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
            return true;
        }else{
            return false;
        }
    }
    //接口
    public interface MyCallBack{
        void doget(String json);
        void Error(String throwable);
    }
}
