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
 * 3번째 DATABASE Configuration 설정파일
 * Oracle DB
 * 라우팅, 인증코드IP 관련 DB(XDB new)
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "tertiaryEntityManagerFactory",
        transactionManagerRef = "tertiaryTransactionManager",
        basePackages = { "com.operation.management.tertiary.repository" }
)
public class TertiaryDataSourceConfig {
    
    @Bean
    @ConfigurationProperties("tertiary.datasource")
    public DataSourceProperties tertiaryDataSourceProperties(){
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.configuration")
    public DataSource tertiaryDataSource(@Qualifier("tertiaryDataSourceProperties") DataSourceProperties dataSourceProperties){
        return dataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean tertiaryEntityManagerFactory(EntityManagerFactoryBuilder builder,
        @Qualifier("tertiaryDataSource") DataSource dataSource){
            return builder
                .dataSource(dataSource)
                .packages("com.operation.management.tertiary.model")
                .persistenceUnit("tertiaryEntityManager")
                .build();
        }

    @Bean
    public PlatformTransactionManager tertiaryTransactionManager(@Qualifier("tertiaryEntityManagerFactory") EntityManagerFactory entityManagerFactory){
        return new JpaTransactionManager(entityManagerFactory);
    }
}
