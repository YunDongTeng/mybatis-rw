package com.spark.result;

/**
 * Created by tyd on 2018-1-15.
 */
public class Result<T> {

    private int code;
    private String msg;
    private T data;

    public Result(ResultEnum resultEnum, T data) {
        this.data = data;
        this.msg = resultEnum.getMsg();
        this.code = resultEnum.getCode();
    }

}
