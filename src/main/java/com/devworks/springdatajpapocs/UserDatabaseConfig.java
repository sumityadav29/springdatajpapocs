package com.devworks.springdatajpapocs;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableJpaRepositories(basePackages = "com.devworks.springdatajpapocs.dsone",
        entityManagerFactoryRef = "userEntityManager",
        transactionManagerRef = "userPlatformTransactionManager")
public class UserDatabaseConfig {

    @Bean(name = "firstDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource userDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean("userEntityManager")
    @Primary
    public LocalContainerEntityManagerFactoryBean userEntityManger(@Qualifier("firstDataSource") DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
        entityManager.setDataSource(dataSource);
        entityManager.setPackagesToScan("com.devworks.springdatajpapocs.dsone");

        Map<String, String> propertiesMap = new HashMap<>();
        propertiesMap.put("hibernate.default_schema", "public");
        entityManager.setJpaPropertyMap(propertiesMap);

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        entityManager.setJpaVendorAdapter(vendorAdapter);

        return entityManager;
    }

    @Bean("userPlatformTransactionManager")
    @Primary
    public PlatformTransactionManager userPlatformTransactionManager(@Qualifier("userEntityManager") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
