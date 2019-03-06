package com.example.framework.http;

import android.util.Log;

/**
 * User : Blues
 * Date : 2019/3/5
 * Time : 17:50
 * Email : huajianlan@rastar.com
 */

public class HttpException extends RuntimeException {

    public HttpException(ErrorType errorType) {
        getHttpExceptionMessage(errorType, null);
    }

    public HttpException(String msg) {
        getHttpExceptionMessage(null, msg);
    }

    /**
     * 对服务器接口传过来的错误信息进行统一处理
     * 免除在Activity的过多的错误判断
     */
    private static String getHttpExceptionMessage(ErrorType errorType, String msg) {
        String message;
        switch (errorType) {
            case PARSE_DATA_ERROR:
                message = ErrorType.PARSE_DATA_ERROR.getMessage();
                break;
            case SERVER_RETURNS_ERROR:
                message = ErrorType.SERVER_RETURNS_ERROR.getMessage();
                break;
            case CONNECT_NETWORK_ERROR:
                message = ErrorType.CONNECT_NETWORK_ERROR.getMessage();
                break;
            default:
                message = msg;
        }
        Log.e("Blues", message);
        return message;
    }

    public enum ErrorType {
        PARSE_DATA_ERROR("数据解析错误"),
        CONNECT_NETWORK_ERROR("网络连接异常"),
        SERVER_RETURNS_ERROR("服务器返回错误");

        String message;

        ErrorType(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

}
