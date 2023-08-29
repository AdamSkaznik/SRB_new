/*
 * Copyright (c) 2023. Adam Skaźnik for SOL PPL Chopin Airport
 * All rights reserved.
 */

package com.airportspolish.SRB.service;

import com.airportspolish.SRB.model.Role;
import com.airportspolish.SRB.model.User;
import com.airportspolish.SRB.repository.RoleRepository;
import com.airportspolish.SRB.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
public class UserService {
//    private UserRepository userRepository;
//    private RoleRepository roleRepository;
//    private List<User> users = new ArrayList<User>();
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
//
//    public UserService(UserRepository userRepository, RoleRepository roleRepository, List<User> users, BCryptPasswordEncoder bCryptPasswordEncoder) {
//        this.userRepository = userRepository;
//        this.roleRepository = roleRepository;
//        this.users = users;
//        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
//    }
//
//    public User findUserByLogin(String login) {
//        return userRepository.findByLogin(login);
//    }
private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private List<User> users = new ArrayList<User>();
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, List<User> users, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.users = users;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    //    @Autowired
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User findUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }
    public User findById(Integer id){ return userRepository.findById(id);}

    public List<User> all() {
        return userRepository.findAll();
    }

    public List<Role> getRole() {
        return roleRepository.findAll();
    }
    public User findById(int userId) {
        return userRepository.findById(userId);
    }
    public User saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(true);
        Role userRole = roleRepository.findByRole("USER");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        return userRepository.save(user);
    }

//    @Modifying
//    public User saveUserPassword(String password, int id, User user) {
////        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword_tmp()));
//        password = bCryptPasswordEncoder.encode(user.getPassword_tmp());
//        id = user.getId();
//        return userRepository.updateUser(password, id);
//    }
//
//    public List<Role> listRoles() {
//        return roleRepository.findAll();
//    }
//
//    public User saveUserPassword(String password, int userId) {
//        return userRepository.updateUser(password, userId);
//    }

}
