package com.startup.entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Role extends AbstractPersistable<Long> {

    private String name;

    @OneToMany(targetEntity = User.class, mappedBy = "role", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<User> users;

    public Role() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Role(Set<User> users){
//        this.users = users;
//    }

//    private Role(Role.Builder builder){
//        this.name = builder.name;
//    }
//
//    @Override
//    public String toString() {
//        return "Role{" +
//                    "name='" + name +
//                '}';
//    }
//
//    public static class Builder {
//
//        private String name;
//
//        public Role.Builder setName(String name) {
//            this.name = name;
//            return this;
//        }
//
//
//
//        public Role.Builder copy(Role role){
//            this.name = role.name;
//
//            return this;
//        }
//
//        public Role build(){
//            return new Role(this);
//        }

 //   }

}
