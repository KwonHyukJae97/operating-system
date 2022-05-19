package com.operation.management.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import com.zaxxer.hikari.HikariDataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 4번째 DATABASE Configuration 설정파일
 * Oracle DB
 * 로우데이터 관련 DB(MCDB)
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
    entityManagerFactoryRef = "quaternary2EntityManagerFactory",
    transactionManagerRef = "quaternary2TransactionManager",
    basePackages = { "com.operation.management.quaternary2.repository" }
)
public class Quaternary2DataSourceConfig {
    
    @Bean
    @ConfigurationProperties("quaternary2.datasource")
    public DataSourceProperties quaternary2DataSourceProperties(){
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.configuration")
    public DataSource quaternary2DataSource(@Qualifier("quaternary2DataSourceProperties") DataSourceProperties dataSourceProperties){
        return dataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean quaternary2EntityManagerFactory(EntityManagerFactoryBuilder builder,
        @Qualifier("quaternary2DataSource") DataSource dataSource){
            return builder
                .dataSource(dataSource)
                .packages("com.operation.management.quaternary2.model")
                .persistenceUnit("quaternary2EntityManager")
                .build();
        }

    @Bean
    public PlatformTransactionManager quaternary2TransactionManager(@Qualifier("quaternary2EntityManagerFactory") EntityManagerFactory entityManagerFactory){
        return new JpaTransactionManager(entityManagerFactory);
    }
}
