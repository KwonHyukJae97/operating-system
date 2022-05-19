package com.operation.management.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import com.zaxxer.hikari.HikariDataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 5번째 DATABASE Configuration 설정파일
 * Oracle DB
 * 인트라넷 유저정보DB(aiwsdb)
 */

 @Configuration
 @EnableTransactionManagement
 @EnableJpaRepositories(
     entityManagerFactoryRef = "quinaryEntityManagerFactory",
     transactionManagerRef = "quinaryTransactionManager",
     basePackages = { "com.operation.management.quinary.repository" }
 )
public class QuinaryDataSourceConfig {

    @Bean
    @ConfigurationProperties("quinary.datasource")
    public DataSourceProperties quinaryDataSourceProperties(){
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.configuration")
    public DataSource quinaryDataSource(@Qualifier("quinaryDataSourceProperties") DataSourceProperties dataSourceProperties){
        return dataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean quinaryEntityManagerFactory(EntityManagerFactoryBuilder builder,
        @Qualifier("quinaryDataSource") DataSource dataSource){
            return builder
                .dataSource(dataSource)
                .packages("com.operation.management.quinary.model")
                .persistenceUnit("quinaryEntityManager")
                .build();
        }

    @Bean
    public PlatformTransactionManager quinaryTransactionManager(@Qualifier("quinaryEntityManagerFactory") EntityManagerFactory entityManagerFactory){
        return new JpaTransactionManager(entityManagerFactory);
    }
    
}
