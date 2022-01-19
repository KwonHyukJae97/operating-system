// package com.operation.management.config;

// import javax.sql.DataSource;

// import com.zaxxer.hikari.HikariConfig;
// import com.zaxxer.hikari.HikariDataSource;

// import org.apache.ibatis.session.SqlSessionFactory;
// import org.mybatis.spring.SqlSessionFactoryBean;
// import org.mybatis.spring.SqlSessionTemplate;
// import org.springframework.beans.factory.annotation.Qualifier;
// import org.springframework.boot.context.properties.ConfigurationProperties;
// import org.springframework.context.ApplicationContext;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.context.annotation.PropertySource;

// import lombok.extern.slf4j.Slf4j;

// @Slf4j
// @Configuration
// @PropertySource("classpath:/application.properties")
// public class SecondDBConfig {

//     private ApplicationContext applicationContext;
    
//     public SecondDBConfig(ApplicationContext applicationContext){
//         this.applicationContext = applicationContext;
//     }

//     @Bean(name = "hikariConfigSecond")
//     @ConfigurationProperties(prefix = "spring.second.datasource.hikari")
//     public HikariConfig hikariConfig(){
//         return new HikariConfig();
//     }

//     @Bean(name = "dataSourceSecond")
//     @ConfigurationProperties(prefix = "spring.second.datasource")
//     public DataSource dataSource(){
//         DataSource dataSource = new HikariDataSource(hikariConfig());
//         log.info("datasource : {}", dataSource);
//         return dataSource;
//     }    

//     @Bean(name = "sqlSessionFactorySecond")
//     public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSourceSecond") DataSource dataSource) throws Exception{
//         SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//         sqlSessionFactoryBean.setDataSource(dataSource);
//         //mybatis query파일 생성유무에 따라 다름.
//         sqlSessionFactoryBean.setConfigLocation(applicationContext.getResource(""));
//         sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources(""));
//         return sqlSessionFactoryBean.getObject();
//     }

//     @Bean(name ="sqlSessionTemplateSecond")
//     public SqlSessionTemplate sqlSessionTemplate(@Qualifier("sqlSessionTemplateSecond")SqlSessionFactory sqlSessionFactory){
//         return new SqlSessionTemplate(sqlSessionFactory);
//     }
// }
