package com.spark.result;

/**
 * Created by tyd on 2018-1-15.
 */
public enum ResultEnum {

    SUCCESSS_RESULT(200, "查询成功");

    ResultEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public java.lang.String getMsg() {
        return msg;
    }

    public void setMsg(java.lang.String msg) {
        this.msg = msg;
    }
}
