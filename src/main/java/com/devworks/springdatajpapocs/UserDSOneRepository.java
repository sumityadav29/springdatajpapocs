package com.devworks.springdatajpapocs;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDSOneRepository extends ListCrudRepository<UserDSOneEntity, Long> {

}