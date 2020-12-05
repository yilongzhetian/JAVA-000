package com.ylzt.geekbang.lesson07.work2.config;

/**
 * @ClassName: DataSourceContextHolder
 * @Description: TODO
 * @Author: liwenlong
 * @Date: 2020/12/6 12:52 上午
 **/
public class DynamicDataSourceContextHolder {

    private static final ThreadLocal<String> holder = new ThreadLocal<>();

    public static void setDataSource(String type) {
        holder.set(type);
    }

    public static String getDataSource() {
        String lookUpKey = holder.get();
        return lookUpKey == null ? "master" : lookUpKey;
    }

    public static void clear() {
        holder.remove();
    }

}
