package com.startup.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.print.Doc;
import java.util.Objects;

/**
 * @author Lene Prinsloo
 * desc : Entity for Doctor
 */

@Entity
public class Doctor {

    @Id
    private String docId;
    private String dept;
    private String specialisation;

    protected Doctor() {
    }

    private Doctor(Builder builder) {
        this.docId = builder.docId;
        this.dept = builder.dept;
        this.specialisation = builder.specialisation;
    }

    public String getDocId() {
        return docId;
    }

    public String getDept() {
        return dept;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "docID='" + docId + '\'' +
                ", dept='" + dept + '\'' +
                ", specialisation= '" + specialisation + '\'' +
                '}';
    }

    public static class Builder{

        private String docId, dept, specialisation;

        public Builder setDoctorId(String docId){
            this.docId = docId;
            return this;
        }

        public Builder setDept(String dept){
            this.dept = dept;
            return this;
        }
        public Builder setSpecialisation(String specialisation){
            this.specialisation = specialisation;
            return this;
        }

        public Builder copy(Doctor doctor) {
            this.docId = doctor.docId;
            this.dept = doctor.dept;
            this.specialisation = doctor.specialisation;

            return this;
        }

        public Doctor build() {
            return new Doctor(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Doctor doctor = (Doctor) o;
        return docId.equals(doctor.docId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(docId);
    }
}
