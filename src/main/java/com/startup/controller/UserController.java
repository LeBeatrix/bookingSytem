package com.startup.controller;

import com.startup.entity.User;
import com.startup.factory.UserFactory;
import com.startup.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/list")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public String userList(Model model){
        model.addAttribute("users", userService.userList());
        return "user/list";
    }


    @GetMapping("/list/{id}")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public User findById(@PathVariable Long id){
        return userService.findById(id);
    }

    @RequestMapping("/add")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @RequestMapping("/delete/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteUser(Long id){
        return userService.deleteById(id);
    }


//    @RequestMapping
//    List<User> userList(){
//        return userService.
//    }


//    @RequestMapping("/list")
//    public ModelAndView list(){
//        ModelAndView model = new ModelAndView("user_list");
//        Set<User> userSet = userService.getAll();
//        model.addObject("userSet", userSet);
//        return model;
//    }

//    @RequestMapping(value="/updateUser/{id}", method=RequestMethod.GET)
//    public ModelAndView updateUser(@PathVariable String id) {
//        ModelAndView model = new ModelAndView();
//
//        User user = userService.getUserById(id);
//        model.addObject("userForm", user);
//        model.setViewName("user_form");
//
//        return model;
//    }
//
//    @RequestMapping(value="/create", method=RequestMethod.GET)
//    public ModelAndView create() {
//
//        ModelAndView model = new ModelAndView();
//        User user = new User();
//        model.addObject("userForm", user);
//        model.setViewName("user_form");
//
//        return model;
//    }

//    @RequestMapping(value="/create", method=RequestMethod.POST)
//    public ModelAndView add(@ModelAttribute("userForm") User user,
//                            ModelMap model) {
//
//        userService.createUser(user);
//        return new ModelAndView("redirect:/user/list");
//
//    }

//    @RequestMapping(value="/create", method=RequestMethod.POST)
//    @ResponseBody
//    public String createUser(@RequestBody User data) {
////        RequestAttribute req = new RequestAttribute();
//
//        System.out.println(data.getUsername());
//
//        return "/user/list";
//    }
//
//    @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
//    public ModelAndView delete(@PathVariable("id") String id) {
//        userService.deleteUserById(id);
//        return new ModelAndView("redirect:/user/list");
//
//    }


//    @PostMapping("/create")
//    public User create(@RequestBody User user){
//        User newUser = UserFactory.createUser(user.getUsername(), user.getPassword(), user.getName(), user.getSurname(), user.getCellNo(), user.getEmailAddress());
//        return  userService.create(newUser);
//    }

//    @GetMapping("/read/{id}")
//    public User read(@PathVariable String id) {
//        return userService.read(id);
//    }
//
//    @PostMapping("/update")
//    public User update(@RequestBody User user) {
//        return userService.update(user);
//    }
//
//    @GetMapping("/all")
//    public Set<User> getall(){
//        return userService.getAll();
//    }

//    @DeleteMapping("/delete/{id}")
//    public boolean delete(@PathVariable String id){
//        return userService.delete(id);
//    }
}
