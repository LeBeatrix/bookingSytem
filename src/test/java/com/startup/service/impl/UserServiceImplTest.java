package com.startup.service.impl;
/**
 * @author Yamkela Mbali
 */
import com.startup.Repository.impl.UserRepository;
import com.startup.entity.User;
import com.startup.factory.UserFactory;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserServiceImplTest {

    @Autowired
    private static UserService service;
    private static User user = UserFactory.createUser("lprinsloo", "prinsloo50", "Lene", "Prinsloo", "0810488240", "prinsloolene@gmail.com");

    @Test
    public void d_getAll() {
//        System.out.println("Get all : " + service.getAll());
    }

    @Test
    public void a_create() {
        User created = service.create(user);
        Assert.assertEquals(user.getUserId(), created.getUserId());
        System.out.println("Created: " + created);
    }


    @Test
    public void b_read() {
        User read = service.read(user.getUserId());
        System.out.println("Read : " + read);
    }

    @Test
    public void c_update() {
        User updated = new User.Builder().copy(user).setEmailAddress("leneprinsloo@gmail.com").build();
        updated = service.update(updated);
        System.out.println("Updated : " + updated);
    }

    @Test
    public void e_delete() {
        boolean deleted = service.delete(user.getUserId());
        Assert.assertTrue(deleted);
    }
}