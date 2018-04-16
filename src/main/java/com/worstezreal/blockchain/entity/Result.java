package com.worstezreal.blockchain.entity;

/**
 * Restful结果
 *
 * @author zengxzh@yonyou.com
 * @version V1.0.0
 * @date 2018/4/2
 */
public class Result<T> {

    /**
     * 状态码
     */
    private String code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 内容
     */
    private T content;

    public Result(String code, String msg, T content) {
        this.code = code;
        this.msg = msg;
        this.content = content;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }
}
