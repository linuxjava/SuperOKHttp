package xiao.free.okgo.model;

import android.net.ParseException;
import android.system.ErrnoException;

import com.google.gson.JsonParseException;

import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;

import java.io.FileNotFoundException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import xiao.free.okgo.exception.OkGoException;

public class ErrorCode {
    public static final int REQUEST_TIMEOUT = 408;
    //连接异常
    public static final int CONNECT_EXCEPTION = 900;
    //未知错误
    public static final int UNKNOWN = -1001;
    //json解析错误
    public static final int PARSE_ERROR = -1002;
    //空指针异常
    public static final int CODE_NULLPOINTER_ERR = -1003;
    //GSON实体解析错误
    public static final int CODE_GSON_ERR = -1004;
    //EACCES (Permission denied) 缺少网络权限
    public static final int CODE_PERMISSION_DENIED = -1005;
    //网络无法访问
    public static final int CODE_UNKNOWN_HOST = -1006;
    //文件上传无法找到文件
    public static final int CODE_FILE_NOT_FOUND = -1007;
    //请求已执行
    public static final int CODE_REQUEST_ALREADY_EXECUTED = -1008;

    public static int getErrorCode(Throwable e) {
        int code;
        String msg;

        if (e instanceof SocketTimeoutException) {
            code = REQUEST_TIMEOUT;
            msg = "socket请求超时";
        } else if (e instanceof ConnectTimeoutException) {
            code = REQUEST_TIMEOUT;
            msg = "连接请求超时";
        } else if (e instanceof ConnectException) {
            code = CONNECT_EXCEPTION;
            msg = "网络不可访问";
        } else if (e instanceof JsonParseException
                || e instanceof JSONException
                || e instanceof ParseException) {
            code = PARSE_ERROR;
            msg = "数据解析错误";
        } else if (e instanceof NullPointerException) {//空指针异常
            code = CODE_NULLPOINTER_ERR;
            msg = "网络不可用";
        } else if (e instanceof IllegalStateException) {//JSON转换解析错误，例如Expected a string but was BEGIN_OBJECT
            code = CODE_GSON_ERR;
            msg = "GSON实体错误";
        } else if (e instanceof ErrnoException) {//未获取网络权限
            code = CODE_PERMISSION_DENIED;
            msg = "Permission denied";
        } else if (e instanceof UnknownHostException) {//网络无法访问
            code = CODE_UNKNOWN_HOST;
            msg = "网络无法访问";
        } else if (e instanceof FileNotFoundException) {//文件上传无法找到文件
            code = CODE_FILE_NOT_FOUND;
            msg = "无法找到文件";
        } else if (e instanceof OkGoException) {//自定义错误类型
            OkGoException okGoException = (OkGoException) e;
            code = okGoException.getCode();
            msg = okGoException.getMessage();
        } else {
            code = UNKNOWN;
            msg = "未知错误";
        }

        return code;
    }
}
