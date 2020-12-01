//package com.startup.Repository.impl;
///**
// * @author Yamkela Mbali
// */
//
//import com.startup.entity.Doctor;
//
//import java.util.HashSet;
//import java.util.Set;
//
//public class DoctorRepositoryImpl implements DoctorRepository {
//
//    private static DoctorRepository repository = null;
//    private Set<Doctor> doctorDB;
//
//    private DoctorRepositoryImpl() { this.doctorDB = new HashSet<>();
//    }
//
//    public static DoctorRepository getRepository(){
//        if (repository == null) repository = new DoctorRepositoryImpl();
//        return repository;
//    }
//
//
//
//
//    @Override
//    public Doctor create(Doctor doctor) {
//        this.doctorDB.add(doctor);
//        return doctor;
//    }
//
//    @Override
//    public Doctor read(String docId) {
//        for (Doctor doctor : this.doctorDB){
//            if (doctor.getDocId().equalsIgnoreCase(docId)) return doctor;
//        }
//        return null;
//    }
//
//    @Override
//    public Doctor update(Doctor doctor) {
//        boolean deleteDoctor = delete(doctor.getDocId());
//        if(deleteDoctor){
//            this.doctorDB.add(doctor);
//            return doctor;
//        }
//        return null;
//    }
//
//    @Override
//    public boolean delete(String docID) {
//        Doctor doctor = read(docID);
//        if(doctor != null){
//            this.doctorDB.remove(doctor);
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    public Set<Doctor> getAll() {
//        return this.doctorDB;
//    }
//}
