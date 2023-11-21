package com.devworks.springdatajpapocs.dstwo;

import com.devworks.springdatajpapocs.dstwo.Account;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends ListCrudRepository<Account, Long> {

}
