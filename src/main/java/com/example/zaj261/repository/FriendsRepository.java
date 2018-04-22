package com.example.zaj261.repository;

import com.example.zaj261.mod.Friends;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FriendsRepository extends JpaRepository<Friends, Long> {



    List<Friends> findByFidAndFriendFalse(long id);

    List<Friends> findByUidAndFriendTrue(long id);

    Friends findById(long id);

    List<Friends> findAllByUidAndFriendTrue(long id);

 List<Friends> findByFriendIdAndFriendFalse(long id);

}
