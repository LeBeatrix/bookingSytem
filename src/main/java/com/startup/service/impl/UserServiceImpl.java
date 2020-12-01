package com.startup.service.impl;
/**
 * @author Yamkela Mbali
 */
import com.startup.Repository.impl.RoleRepository;
import com.startup.Repository.impl.UserRepository;
import com.startup.entity.Role;
import com.startup.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<User> userList() {
        return this.repository.findAll();
    }

    @Override
    public User findById(Long id) {
        return this.repository.findById(id).get();
    }

    @Override
    public User findOne(Long id) {
        return null;
    }

    @Override
    public User addUser(User user) {
        user.setRole(roleRepository.findById(user.getRole().getId()).orElse(null));
        return this.repository.save(user);
    }

    @Override
    public String deleteById(Long id) {
        this.repository.deleteById(id);
        return "{'message':'User deleted successfully'}";
    }

    @Override
    public String delete(Long id) {
        this.repository.deleteById(id);
        return "{'message':'User deleted successfully'}";
    }

    @Override
    public List<Role> roleList() {
        return roleRepository.findAll();
    }

    @Override
    public String getAll() {
        return null;
    }




//    @Override
//    public Set<User> getAll() {
//        return this.repository.findAll().stream().collect(Collectors.toSet());
//    }
//
//    @Override
//    public User getUserById(String id) {
//        return this.repository.findById(id).get();
//    }
//
//    @Override
//    public void createUser(User user) {
//        this.repository.save(user);
//    }
//
//    @Override
//    public void deleteUserById(String id) {
//        this.repository.deleteById(id);
//    }




    @Override
    public User create(User user) {
        return this.repository.save(user);
    }

    @Override
    public User read(String s) {
        return null;
    }

    @Override
    public User update(User user) {

        return this.repository.save(user);
    }

    @Override
    public boolean delete(String s) {
        return false;
    }



//    @Override
//    public boolean delete(String s) {
//
//        this.repository.deleteById(s);
//        if (this.repository.existsById(s)) return false;
//        else return true;
//    }
}
