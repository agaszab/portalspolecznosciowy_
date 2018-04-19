package com.example.zaj261.repository;

import com.example.zaj261.mod.Friends;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FriendsRepository extends JpaRepository<Friends, Long> {

 public List<Friends> findAllById_friendFriendFalse(long id);

 public List<Friends> findById_friendAndFriendFalse(long id);

 public List<Friends> findAllById_friendFriendTrue(long id);
}
