package com.spark.config;

import javax.sql.DataSource;

/**
 * Created by tyd on 2018-1-15.
 */
public class DataSourceHolder {

    private static ThreadLocal<String> local = new ThreadLocal<String>();

    public static void setRead() {
        local.set(DataSourceType.readType.getType());
    }

    public static void setWrite() {
        local.set(DataSourceType.writeType.getType());
    }

    public static String get() {
        return local.get();
    }


}
