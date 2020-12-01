package com.startup.factory;

import com.startup.entity.Patient;
import com.startup.util.GenericHelper;

/**
 * desc: Factory for patient
 */

public class PatientFactory {

    public static Patient createPatient(String patientID, String historyReport, String medicalAidId){

        Patient patient = new Patient.Builder()
                .setPatientId(patientID)
                .setHistoryReport(historyReport)
                .setMedicalAidId(medicalAidId)
                .build();
        return patient;
    }
}
