package com.startup.Repository.impl;
/*
  @author Lené Prinsloo
 */
import com.startup.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;
@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    @Query("FROM User where username=:username")
    User findByUsername(@Param("username") String username);
}

