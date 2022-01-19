// package com.operation.management.config;

// import javax.sql.DataSource;

// import com.zaxxer.hikari.HikariConfig;
// import com.zaxxer.hikari.HikariDataSource;

// import org.apache.ibatis.session.SqlSessionFactory;
// import org.mybatis.spring.SqlSessionFactoryBean;
// import org.mybatis.spring.SqlSessionTemplate;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Qualifier;
// import org.springframework.boot.context.properties.ConfigurationProperties;
// import org.springframework.context.ApplicationContext;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.context.annotation.Primary;
// import org.springframework.context.annotation.PropertySource;
// import org.springframework.jdbc.datasource.DataSourceTransactionManager;
// import org.springframework.transaction.PlatformTransactionManager;
// import org.springframework.transaction.annotation.EnableTransactionManagement;

// import lombok.extern.slf4j.Slf4j;

// @Slf4j
// @Configuration
// @PropertySource("classpath:/application.properties")
// @EnableTransactionManagement
// public class FirstDBConfig {
//     @Autowired
//     private ApplicationContext applicationContext;

//     public FirstDBConfig(ApplicationContext applicationContext){
//         this.applicationContext = applicationContext;
//     }

//     @Primary
//     @Bean(name = "hikariConfigFirst")
//     @ConfigurationProperties(prefix = "spring.first.datasource.hikari")
//     public HikariConfig hikariConfig(){
//         return new HikariConfig();
//     }

//     @Primary
//     @Bean(name = "dataSource")
//     @ConfigurationProperties(prefix = "spring.first.datasource")
//     public DataSource dataSource(){
//         DataSource dataSource = new HikariDataSource(hikariConfig());
//         log.info("datasource : {}", dataSource);
//         return dataSource;
//     }

//     @Primary
//     @Bean(name = "sqlSessionFactory")
//     public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) throws Exception{
//         SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//         sqlSessionFactoryBean.setDataSource(dataSource);
//         //mybatis query파일 생성유무에 따라 다름.
//         sqlSessionFactoryBean.setConfigLocation(applicationContext.getResource(""));
//         sqlSessionFactoryBean.setMapperLocations(applicationContext.getResource(""));
//         return sqlSessionFactoryBean.getObject();
//     }
        
//     @Primary
//     @Bean(name = "sqlSessionTemplate")
//     public SqlSessionTemplate sqlSessionTemplate(@Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory){
//         return new SqlSessionTemplate(sqlSessionFactory);
//     }

//     @Primary
//     @Bean(name = "transactionManager")
//     public PlatformTransactionManager transactionManager(@Qualifier("dataSource") DataSource dataSource){
//         DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(dataSource);
//         transactionManager.setGlobalRollbackOnParticipationFailure(false);
//         return transactionManager;
//     }
// }
