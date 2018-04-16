package com.worstezreal.blockchain.entity;

import com.alibaba.fastjson.JSON;
import com.worstezreal.blockchain.utils.StringUtil;

import java.util.ArrayList;
import java.util.Date;

/**
 * 区块
 *
 * @author zengxzh@yonyou.com
 * @version V1.0.0
 * @date 2018/4/2
 */
public class Block {
    /**
     * 签名
     */
    private String hash;

    /**
     * 前一个区块的签名
     */
    private String previousHash;

    /**
     * 数据
     */
    private String data;

    /**
     * 时间戳
     */
    private long timeStamp;

    /**
     * 工作量
     */
    private int nonce;

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getNonce() {
        return nonce;
    }

    public void setNonce(int nonce) {
        this.nonce = nonce;
    }

    public Block(String previousHash, String data) {
        this.timeStamp = new Date().getTime();
        this.previousHash = previousHash;
        this.data = data;
        this.hash = calcHash(previousHash, data, this.timeStamp);
    }

    private String calcHash(String previousHash, String data, long timeStamp) {
        return StringUtil.applySha256(previousHash + Long.toString(timeStamp) + data);
    }

    public static void main(String[] args) {
        ArrayList<Block> blockchain = new ArrayList<Block>() {{
            add(new Block("0", "hello world"));
            add(new Block(get(size() - 1).getHash(), "hello world2"));
            add(new Block(get(size() - 1).getHash(), "hello world3"));
        }};
        System.out.println(JSON.toJSONString(blockchain));
    }
}
