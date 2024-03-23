package com.ruoyi.common.core.domain.petFront;


import java.io.Serializable;


/**
 * @功能描述: 响应报文，统一封装类
 */
public class APIResponse<T> implements Serializable {
    private int code;
    private String msg;
    private T data;
    private String trace;
    private long total; /*数据总数*/
    private long timestamp;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getTrace() {
        return trace;
    }

    public void setTrace(String trace) {
        this.trace = trace;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public APIResponse() {
        this.timestamp = System.currentTimeMillis();
    }

    public APIResponse(ResponseCode responseCode) {
        this.timestamp = System.currentTimeMillis();
        this.code = responseCode.getCode();
        this.msg = responseCode.getMsg();
    }

    public APIResponse(ResponseCode responseCode, String msg) {
        this(responseCode);
        this.msg = msg;
    }

    public APIResponse(ResponseCode responseCode, T data) {
        this(responseCode);
        this.data = data;
    }

    public APIResponse(ResponseCode responseCode, String msg, T data) {
        this(responseCode);
        this.trace = msg;
        this.data = data;
    }

    @Override
    public String toString() {
        return "APIResponse{" +
                "timestamp=" + timestamp +
                ", code=" + code +
                ", msg='" + msg + '\'' +
                ", trace='" + trace + '\'' +
                ", data=" + data +
                //", count=" + count +
                '}';
    }
}
