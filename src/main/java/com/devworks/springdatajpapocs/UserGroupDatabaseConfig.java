package com.devworks.springdatajpapocs;

import com.devworks.springdatajpapocs.dshibernate.UserGroup;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

@Component
public class UserGroupDatabaseConfig {

    private static SessionFactory sessionFactory = null;

    public UserGroupDatabaseConfig() {
        sessionFactory = new Configuration()
                .addAnnotatedClass(UserGroup.class)
                .setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/userdb")
                .setProperty("USER", "postgres")
                .setProperty("PASS", "postgres")
                .setProperty("SHOW_SQL", Boolean.TRUE.toString())
                .setProperty("FORMAT_SQL", Boolean.TRUE.toString())
                .setProperty("HIGHLIGHT_SQL", Boolean.TRUE.toString())
                .buildSessionFactory();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
