/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faber.spring.configs;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.util.HashMap;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "secondEntityManagerFactory",
        transactionManagerRef = "secondTransactionManager",
        basePackages = {"com.faber.spring.repository.db2"})
public class SecondDB {

    @Value("${jdbc.driver-class-name}")
    private String driver;

    @Value("${datasource.second.url}")
    private String url;

    @Value("${datasource.second.username}")
    private String username;

    @Value("${datasource.second.password}")
    private String pass;

    @Value("${hibernate.dialect}")
    private String dialect;
    @Value("${jdbc.show-sql}")
    private String showSql;
    @Value("${hibernate.ddl-auto}")
    private String ddlAuto;
    @Value("${hibernate.use-new-id-generator-mappings}")
    private String newIdGeneratorMappings;

    @Bean
    public DataSource secondDataSource() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName(driver);
        config.setJdbcUrl(url);
        config.setUsername(username);
        config.setPassword(pass);
        return new HikariDataSource(config);
    }
    
    @Bean
    public PlatformTransactionManager secondTransactionManager() {
        return new JpaTransactionManager(secondEntityManagerFactory().getObject());
    }

    @Bean(name = "secondEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean secondEntityManagerFactory() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setDataSource(secondDataSource());
        factory.setPackagesToScan("com.faber.spring.model.db2");
        
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.dialect", dialect);
        properties.put("hibernate.show-sql", showSql);
        properties.put("hibernate.hbm2ddl.auto", ddlAuto);
        properties.put("hibernate.use-new-id-generator-mappings", newIdGeneratorMappings);
        factory.setJpaPropertyMap(properties);

        return factory;
    }

}
