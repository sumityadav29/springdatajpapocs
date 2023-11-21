package com.devworks.springdatajpapocs.dsone;

import com.devworks.springdatajpapocs.dsone.User;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDSOneRepository extends ListCrudRepository<User, Long> {

}
