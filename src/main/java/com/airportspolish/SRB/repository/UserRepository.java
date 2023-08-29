/*
 * Copyright (c) 2023. Adam Skaźnik for SOL PPL Chopin Airport
 * All rights reserved.
 */

package com.airportspolish.SRB.repository;

import com.airportspolish.SRB.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    User findByEmail(String email);
//    String zap = "SELECT * FROM tab_users where user_name = ? and password = ? and active = true";
//    @Query(value = )
    User findByUserName(String userName);
    List<User> findAll();
    User findById(int userId);

}
