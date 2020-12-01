package com.startup.Repository.impl;

import com.startup.Repository.IRepository;
import com.startup.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {
}
