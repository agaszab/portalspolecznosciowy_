package com.example.zaj261.mod;

import javax.persistence.*;

@Entity
public class Friends {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private  long id;

 private  long id_friend;
 private  long uid;
 private  String friendname;
 private  boolean friend;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId_friend() {
        return id_friend;
    }

    public void setId_friend(long id_friend) {
        this.id_friend = id_friend;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getFriendname() {
        return friendname;
    }

    public void setFriendname(String friendname) {
        this.friendname = friendname;
    }

    public boolean isFriend() {
        return friend;
    }

    public void setFriend(boolean friend) {
        this.friend = friend;
    }

    @Override
    public String toString() {
        return "Friends{" +
                "id=" + id +
                ", id_friend=" + id_friend +
                ", uid=" + uid +
                ", friendname='" + friendname + '\'' +
                ", friend=" + friend +
                '}';
    }
}
