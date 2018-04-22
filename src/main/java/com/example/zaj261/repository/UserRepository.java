package com.example.zaj261.repository;

import com.example.zaj261.mod.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {


    User findById(long id);

    User findByUsername(String username);
    User findByUsernameAndEnabledTrue(String username);
    List<User> findUsersByEnabledIsTrue();
    List<User> findUsersByEnabledIsFalse();

}