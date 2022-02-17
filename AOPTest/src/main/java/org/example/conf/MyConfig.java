package org.example.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
public class MyConfig {

    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }
}
