package com.startup.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

/**
 * @author Lene Prinsloo
 * desc : Entity for Patient
 */

@Entity
public class Patient {

    @Id
    private String patientId;
    private String historyReport;
    private String medicalAidId;

    protected Patient() {
    }

    private Patient(Builder builder) {
        this.patientId = builder.patientId;
        this.historyReport = builder.historyReport;
        this.medicalAidId = builder.medicalAidId;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getHistoryReport() {
        return historyReport;
    }

    public String getMedicalAidId() {
        return medicalAidId;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientId='" + patientId + '\'' +
                ", historyReport='" + historyReport + '\'' +
                ", medicalAidId='" + medicalAidId + '\'' +
                '}';
    }

    public static class Builder{
        private  String patientId, historyReport, medicalAidId;

        public Builder setPatientId(String patientId){
            this.patientId = patientId;
            return this;
        }

        public Builder setHistoryReport(String historyReport){
            this.historyReport = historyReport;
            return this;
        }

        public Builder setMedicalAidId(String medicalAidId){
            this.medicalAidId = medicalAidId;
            return this;
        }

        public Patient.Builder copy(Patient patient){
            this.patientId = patient.patientId;
            this.historyReport = patient.historyReport;
            this.medicalAidId = patient.medicalAidId;
            return this;
        }

        public Patient build() {
            return new Patient(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Patient patient = (Patient) o;
        return patientId.equals(patient.patientId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patientId);
    }

}
