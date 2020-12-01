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

}
