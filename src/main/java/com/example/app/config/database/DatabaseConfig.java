package com.example.app.config.database;

import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.LinkedHashMap;
import java.util.Map;

@EnableJpaAuditing
@EnableTransactionManagement
@Configuration
@Slf4j
public class DatabaseConfig {

    @Bean
    @ConfigurationProperties(prefix = "datasource")
    public DataSource dataSource() {

        log.debug("Create Master Datasource Bean!!");

        return DataSourceBuilder
                .create()
                .type(HikariDataSource.class)
                .build();
    }


    @Bean
    public PlatformTransactionManager transactionManager(
            @Qualifier(value = "dataSource") DataSource dataSource) {

        log.debug("Create Transaction Manager Bean!!");

        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setDataSource(dataSource);

        return jpaTransactionManager;
    }

}
