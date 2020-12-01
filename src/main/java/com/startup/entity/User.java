package com.startup.entity;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * @author Yamkela Mbali
 * desc : Entity for User
 */

@Entity
public class User extends AbstractPersistable<Long> {
    private String userId ;
    private String username;
    private String firstname;
    private String surname;
    private String cellNo;
    private String emailAddress;
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToMany(targetEntity = Bill.class, mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Bill> bills;

    public User(){}

    private User(Builder builder){
        this.username = builder.username;
        this.password = builder.password;
        this.userId = builder.userId;
        this.firstname = builder.firstname;
        this.surname = builder.surname;
        this.cellNo = builder.cellNo;
        this.emailAddress = builder.emailAddress;

    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return firstname;
    }

    public String getSurname() {
        return surname;
    }

    public String getCellNo() {
        return cellNo;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Set<Bill> getBills() {
        return bills;
    }

    public void setBills(Set<Bill> bills) {
        this.bills = bills;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userId='" + userId + '\'' +
                ", name='" + firstname + '\'' +
                ", surname='" + surname + '\'' +
                ", cellNo='" + cellNo + '\'' +
                ", emailAddress='" + emailAddress + '\'' +

                '}';
    }

    public static class Builder {

        private String username, password, userId, firstname, surname, cellNo, emailAddress, loginStatus;

        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }
        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setName(String name) {
            this.firstname = name;
            return this;
        }
        public Builder setSurName(String surname) {
            this.surname = surname;
            return this;
        }
        public Builder setUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder setCellNo(String cellNo) {
            this.cellNo = cellNo;
            return this;
        }

        public Builder setEmailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
            return this;
        }
        public Builder setLoginStatus(String loginStatus) {
            this.loginStatus = loginStatus;
            return this;
        }

        public Builder copy(User user){
            this.username = user.username;
            this.password = user.password;
            this.firstname = user.firstname;
            this.surname = user.surname;
            this.userId = user.userId;
            this.cellNo = user.cellNo;
            this.emailAddress = user.emailAddress;


            return this;
        }

        public User build(){
            return new User(this);
        }

    }

}
