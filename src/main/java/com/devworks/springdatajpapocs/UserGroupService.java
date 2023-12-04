package com.devworks.springdatajpapocs;

import com.devworks.springdatajpapocs.dshibernate.UserGroup;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class UserGroupService {

    private final UserGroupDatabaseConfig userGroupDatabaseConfig;

    public UserGroupService(UserGroupDatabaseConfig userGroupDatabaseConfig) {
        this.userGroupDatabaseConfig = userGroupDatabaseConfig;
    }

    public List<UserGroup> getGroups() {
        SessionFactory sessionFactory = userGroupDatabaseConfig.getSessionFactory();
        AtomicReference<List<UserGroup>> groups = new AtomicReference<>();
        sessionFactory.inSession(session -> {
            groups.set(session.createNativeQuery("select * from user_group", UserGroup.class).getResultList());
        });
        return groups.get();
    }

}
