package com.information.portfolio.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
@Configuration
/*Pool Connection*/
public class DataSourceConfig {

    /*
    * You can use DataSource from driver
    * You can use DataSourceBuilder*/

/* @Bean("dataSourcePortfolio")
    @Primary
    public DataSource getDataSourcePortfolio()
    {
       MysqlDataSource mysql = new MysqlDataSource();
        mysql.setPassword("root");
        mysql.setUser("root");
        mysql.setUrl("jdbc:mysql://localhost:3306/portfolio");
      return  mysql;
    }*/

    /*
    @Bean("dataSourcePortfolio")
    @Primary
    public DataSource getDataSourcePortfolio()
    {
       return DataSourceBuilder.create().
               driverClassName("com.mysql.cj.jdbc.Driver")
               .password("root")
               .url("jdbc:mysql://localhost:3306/portfolio")
               .username("root")
               .build();


    }*/
    @Bean(name = "dataSourcePortfolio")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource getDataSourcePortfolio() {
        return DataSourceBuilder.create().build();
    }
}
