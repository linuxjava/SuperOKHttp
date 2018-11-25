package com.okhttp.demo.response;

import com.google.gson.annotations.SerializedName;

public class ResponseTest1 {
    @SerializedName("code")
    public int code;
    @SerializedName("msg")
    public String msg;
    @SerializedName("data")
    public Data data;

    public class Data{
        @SerializedName("id")
        public int id;
        @SerializedName("name")
        public String name;
        @SerializedName("age")
        public int age;
    }
}
