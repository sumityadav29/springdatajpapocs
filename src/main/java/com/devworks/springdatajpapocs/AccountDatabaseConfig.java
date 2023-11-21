package com.devworks.springdatajpapocs;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableJpaRepositories(basePackages = "com.devworks.springdatajpapocs.dstwo",
        entityManagerFactoryRef = "accountEntityManager",
        transactionManagerRef = "accountPlatformTransactionManager")
public class AccountDatabaseConfig {

    @Bean(name = "secondDataSource")
    @ConfigurationProperties(prefix = "spring.datasource-second")
    public DataSource accountDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean("accountEntityManager")
    public LocalContainerEntityManagerFactoryBean accountEntityManger(@Qualifier("secondDataSource") DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
        entityManager.setDataSource(dataSource);
        entityManager.setPackagesToScan("com.devworks.springdatajpapocs.dstwo");

        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        entityManager.setJpaVendorAdapter(jpaVendorAdapter);

        return entityManager;
    }

    @Bean("accountPlatformTransactionManager")
    public PlatformTransactionManager accountPlatformTransactionManager(@Qualifier("accountEntityManager") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }


}
