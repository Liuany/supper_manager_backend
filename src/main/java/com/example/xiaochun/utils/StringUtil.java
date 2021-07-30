package com.example.xiaochun.utils;

import java.util.UUID;

public class StringUtil {

    /**
     * 获取UUID.
     * 生成32位没有-符号且字母全部大写的UUID
     * @return the UUID
     */
    public static String getUUID() {
        String uuid = UUID.randomUUID().toString().replaceAll("-","").toUpperCase();
        return uuid;
    }
}
