package com.startup.service.impl;
/**
 * @author Yamkela Mbali
 */
import com.startup.entity.Role;
import com.startup.entity.User;
import com.startup.service.IService;

import java.util.List;

public interface UserService extends IService <User, String> {
    List<User> userList();

    User findById(Long id);

    User addUser(User user);

    String deleteById(Long id);

    String delete(Long id);

    List<Role> roleList();

    String getAll();

    User findOne(Long id);
}
