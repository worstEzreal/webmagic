package com.worstezreal.blockchain.utils;

import java.security.MessageDigest;

/**
 * 字符串工具类
 *
 * @author zengxzh@yonyou.com
 * @version V1.0.0
 * @date 2018/4/2
 */
public class StringUtil {

    /**
     * 应用sha256算法让一个输入转变成256位的hash值
     *
     * @param input 原始字符串
     * @return 加密后的字符串
     */
    public static String applySha256(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(input.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
