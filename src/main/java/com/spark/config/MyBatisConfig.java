package com.spark.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tyd on 2018-1-15.
 */
@Configuration
@AutoConfigureAfter(DruidConfig.class)  //在Druid配置之后初始化配置
public class MyBatisConfig {

    private static final String CONFIG_LOCATION = "classpath:/mybatis-config.xml";
    private static final String MAPPER_LOCATION = "classpath:/mapper/*.xml";
    private static final String BASE_PACKAGE_ALIEASE = "com.spark.model";

    @Autowired
    @Qualifier("readDataSource")
    private DataSource readDataSource;

    @Autowired
    @Qualifier("writeDataSource")
    private DataSource writeDataSource;

    @Bean("sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory() {

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        SqlSessionFactory sqlSessionFactory = null;
        try {
            sqlSessionFactoryBean.setDataSource(abstractRoutingDataSource());
            sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_LOCATION));

            sqlSessionFactoryBean.setConfigLocation(new DefaultResourceLoader().getResource(CONFIG_LOCATION));
            sqlSessionFactoryBean.setTypeAliasesPackage(BASE_PACKAGE_ALIEASE);

            sqlSessionFactory = sqlSessionFactoryBean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sqlSessionFactory;
    }

    @Bean
    public AbstractRoutingDataSource abstractRoutingDataSource() {

        final Map<Object, Object> targetDataSources = new HashMap<Object, Object>();
        targetDataSources.put(DataSourceType.readType.getType(), readDataSource);
        targetDataSources.put(DataSourceType.writeType.getType(), writeDataSource);

        AbstractRoutingDataSource abstractRoutingDataSource = new AbstractRoutingDataSource() {
            @Override
            protected Object determineCurrentLookupKey() {

                String type = DataSourceHolder.get();

                System.out.println(type);
                if (type == null) {
                    System.out.println("No datasource...");
                }
                if (type.equals(DataSourceType.readType.getType())) {
                    System.out.println("readDataSource...");
                    return DataSourceType.readType.getType();
                }
                System.out.println(" writeDataSource...");
                return DataSourceType.writeType.getType();
            }
        };

        //设置默认数据源
        abstractRoutingDataSource.setDefaultTargetDataSource(writeDataSource);
        abstractRoutingDataSource.setTargetDataSources(targetDataSources);
        return abstractRoutingDataSource;
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }


}
