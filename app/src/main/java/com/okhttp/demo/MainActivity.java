package com.okhttp.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.okhttp.demo.response.Model;
import com.okhttp.demo.response.ResponseTest1;
import com.okhttp.demo.response.ResponseTest2;

import java.io.File;
import java.util.List;

import xiao.free.okgo.OkGo;
import xiao.free.okgo.callback.FileCallback;
import xiao.free.okgo.callback.JsonCallback;
import xiao.free.okgo.callback.StringCallback;
import xiao.free.okgo.model.Progress;
import xiao.free.okgo.model.Response;
import xiao.free.okgo.request.GetRequest;

public class MainActivity extends AppCompatActivity {
    private String TAG = "okgo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 请求返回字符串
     *
     * @param view
     */
    public void onString(View view) {
        OkGo.<String>get("http://www.wanandroid.com/tools/mockapi/2616/okgotest1")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Log.d(TAG, response.body());
                    }

                    @Override
                    public void onError(int code, String msg) {
                        Log.d(TAG, code + "::" + msg);
                    }
                });
    }

    public void onJson1(View view) {
        OkGo.<ResponseTest1>get("http://www.wanandroid.com/tools/mockapi/2616/okgotest1")
                .execute(new JsonCallback<ResponseTest1>() {
                    @Override
                    public void onSuccess(Response<ResponseTest1> response) {
                        int aa = 1;
                    }

                    @Override
                    public void onError(int code, String msg) {
                        Log.d(TAG, code + "::" + msg);
                    }
                });
    }

    public void onJson2(View view) {
        OkGo.<ResponseTest2>get("http://www.wanandroid.com/tools/mockapi/2616/okgotest2")
                .params("test", "122")
                .execute(new JsonCallback<ResponseTest2>() {
                    @Override
                    public void onSuccess(Response<ResponseTest2> response) {
                        int aa = 1;
                    }

                    @Override
                    public void onError(int code, String msg) {
                        Log.d(TAG, code + "::" + msg);
                    }
                });
    }

    public void onJsonArray(View view) {
        OkGo.<List<Model>>get("http://www.wanandroid.com/tools/mockapi/2616/okgotest3")
                .execute(new JsonCallback<List<Model>>() {
                    @Override
                    public void onSuccess(Response<List<Model>> response) {
                        int aa = 1;
                    }

                    @Override
                    public void onError(int code, String msg) {
                        Log.d(TAG, code + "::" + msg);
                    }
                });
    }



    public void onDownload(View view) {
        OkGo.<File>get("http://mmgr.myapp.com/myapp/gjbig/dianshiguanjia/tv_video.apk")
                .execute(new FileCallback() {
                    @Override
                    public void onSuccess(Response<File> response) {
                        Log.d(TAG, response.body().getAbsolutePath());
                    }

                    @Override
                    public void onError(int code, String msg) {
                        Log.d(TAG, code + ":" + msg);
                    }

                    @Override
                    public void downloadProgress(Progress progress) {
                        Log.d(TAG, progress.fraction + " : " + progress.speed);
                    }
                });
    }
}
