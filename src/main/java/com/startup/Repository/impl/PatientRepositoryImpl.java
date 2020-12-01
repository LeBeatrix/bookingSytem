//package com.startup.Repository.impl;
///**
// * @author Yamkela Mbali
// */
//
//import com.startup.entity.Patient;
//
//import java.util.HashSet;
//import java.util.Set;
//
//public class PatientRepositoryImpl implements PatientRepository {
//
//    private static PatientRepository repository = null;
//    private Set<Patient> patientDB;
//
//    private PatientRepositoryImpl() { this.patientDB = new HashSet<>();
//    }
//
//    public static PatientRepository getRepository(){
//        if (repository == null) repository = new PatientRepositoryImpl();
//        return repository;
//    }
//
//
//
//    @Override
//    public Patient create(Patient patient) {
//        this.patientDB.add(patient);
//        return patient;
//    }
//
//    @Override
//    public Patient read(String patientID) {
//        for (Patient patient : this.patientDB){
//            if (patient.getPatientId().equalsIgnoreCase(patientID)) return patient;
//        }
//        return null;
//    }
//
//    @Override
//    public Patient update(Patient patient) {
//        boolean deletePatient = delete(patient.getPatientId());
//        if(deletePatient){
//            this.patientDB.add(patient);
//            return patient;
//        }
//        return null;
//    }
//
//    @Override
//    public boolean delete(String patientID) {
//        Patient patient = read(patientID);
//        if(patient !=null){
//            this.patientDB.remove(patient);
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    public Set<Patient> getAll() {
//        return this.patientDB;
//    }
//}
