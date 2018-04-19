package com.example.zaj261.repository;

import com.example.zaj261.mod.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {


    public User findById(long id);

    public User findByUsername(String username);
    public List<User> findUsersByEnabledIsTrue();
    public List<User> findUsersByEnabledIsFalse();
}