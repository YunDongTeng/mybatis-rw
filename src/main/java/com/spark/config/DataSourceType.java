package com.spark.config;

import javax.sql.DataSource;

/**
 * Created by tyd on 2018-1-15.
 */
public class DataSourceType {

    private String type;
    private String name;

    public static DataSourceType readType = new DataSourceType("read", "从库");
    public static DataSourceType writeType = new DataSourceType("write", "主库");

    public DataSourceType(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
