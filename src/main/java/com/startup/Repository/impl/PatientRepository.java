package com.startup.Repository.impl;
/**
 * @author Yamkela Mbali
 */
import com.startup.Repository.IRepository;
import com.startup.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface PatientRepository extends JpaRepository<Patient, String> {

}
