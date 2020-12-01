package com.startup.factory;

import com.startup.entity.Doctor;

/**
 * @author Lene Prinsloo
 * desc : factory class for Doctor
 */

public class DoctorFactory {

    public static Doctor createDoctor(String docId, String dept, String specialisation){

        Doctor doctor = new Doctor.Builder()
                .setDoctorId(docId)
                .setDept(dept)
                .setSpecialisation(specialisation)
                .build();

        return doctor;
    }

}
