package com.startup.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Receptionist implements Serializable {

    @Id
    private String adminId;
    private String qualification;

    protected Receptionist(){}

    private Receptionist(Receptionist.Builder builder){
        this.adminId = builder.adminId;
        this.qualification = builder.qualification;
    }

    public String getAdminId() {
        return adminId;
    }

    public String getQualification() {
        return qualification;
    }

    @Override
    public String toString() {
        return "Receptionist{" +
                "adminId='" + adminId + '\'' +
                ", qualification='" + qualification + '\'' +
                '}';
    }

    public static class Builder{
        private  String adminId, qualification;

        public Builder setAdminId(String adminId){
            this.adminId = adminId;
            return this;
        }

        public Builder setQualification(String qualification){
            this.qualification = qualification;
            return this;
        }

        public Builder copy(Receptionist receptionist){
            this.adminId = receptionist.adminId;
            this.qualification = receptionist.qualification;
            return this;
        }

        public Receptionist build(){
            return new Receptionist (this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Receptionist that = (Receptionist) o;
        return adminId.equals(that.adminId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adminId);
    }
}
