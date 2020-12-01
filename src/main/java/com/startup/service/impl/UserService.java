package com.startup.service.impl;
/**
 * @author Yamkela Mbali
 */
import com.startup.entity.User;
import com.startup.service.IService;

import java.util.List;
import java.util.Set;

public interface UserService extends IService <User, String> {
    List<User> userList();

//    User findOne(Long id);

    User findById(Long id);

    User addUser(User user);

    String deleteById(Long id);
//    <User> getAll();
//
//    User getUserById(String id);
//
//    User create(User user);
//
//    void createUser(User user);
//
//    void deleteUserById(String id);
}
