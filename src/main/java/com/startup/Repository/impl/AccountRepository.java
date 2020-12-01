package com.startup.Repository.impl;

import com.startup.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
@Repository
public interface AccountRepository extends JpaRepository<Account, String>{

}

