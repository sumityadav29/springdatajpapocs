package com.devworks.springdatajpapocs;

import com.devworks.springdatajpapocs.dsone.UserDSOneEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDSOneRepository extends ListCrudRepository<UserDSOneEntity, Long> {

}
