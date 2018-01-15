package com.spark.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Created by tyd on 2018-1-15.
 */
@Configuration
@MapperScan("com.spark.mapper")
@EnableTransactionManagement
public class DruidConfig {

    @Bean("writeDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.write")
    public DataSource createWriteDataSource() {
        //创建DataSource并且指定DataSource的类型为Druid类型
        return DataSourceBuilder.create().type(DruidDataSource.class).build();
    }

    @Bean("readDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.read")
    public DataSource createReadDataSource() {
        return DataSourceBuilder.create().type(DruidDataSource.class).build();
    }

}
