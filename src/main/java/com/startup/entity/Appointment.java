package com.startup.entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

/**
 * @author Lene Prinsloo
 * desc : Entity for Appointment
 */

@Entity
public class Appointment extends AbstractPersistable<Long> {

    private String appointID;
    private String patientNo;
    private String docID;
    private LocalDate localDate;
    private LocalTime localTime;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    protected Appointment(){}

    public Appointment(Builder builder){
        this.appointID = builder.appointID;
        this.patientNo = builder.patientNo;
        this.docID = builder.docID;
        this.localDate = builder.localDate;
        this.localTime = builder.localTime;
    }

    public String getAppointID(){ return appointID;}

    public String getPatientNo(){ return patientNo;}

    public String getDocID(){ return docID;}

    public LocalDate getLocalDate(){ return localDate;}

    public LocalTime getLocalTime(){ return localTime;}

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    @Override
    public String toString(){
        return "Appointments{" +
                "appointID='" + appointID + '\'' +
                ", patientNo='" + patientNo + '\'' +
                ", docID='" + docID + '\'' +
                ", appointDate='" + localDate + '\'' +
                ", localTime='" + localTime + '\'' +
                '}';
    }

    public static class Builder{
        private String appointID, patientNo, docID;
        private LocalDate localDate;
        private LocalTime localTime;

        public Builder setAppointID(String appointID){

            this.appointID = appointID;
            return  this;
        }

        public Builder setPatientNo(String patientNo){

            this.patientNo = patientNo;
            return this;
        }

        public Builder setDocID(String docID){

            this.docID = docID;
            return this;
        }

        public Builder setLocalDate(LocalDate localDate){

            this.localDate = localDate;
            return this;
        }

        public Builder setLocalTime(LocalTime localTime){

            this.localTime = localTime;
            return this;
        }


        public Builder copy(Appointment appointment){
            this.appointID = appointment.appointID;
            this.patientNo = appointment.patientNo;
            this.docID = appointment.docID;
            this.localDate = appointment.localDate;
            this.localTime = appointment.localTime;
            return this;
        }
        public Appointment build(){
            return new Appointment (this);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appointment that = (Appointment) o;
        return appointID.equals(that.appointID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(appointID);
    }
}
