package com.example.zaj261.mod;

import javax.persistence.*;

@Entity
public class Friends {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private  long id;

 private  long friendId;
 private  long uid;
 private  String friendname;
 private  boolean friend;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getFriendId() {
        return friendId;
    }

    public void setFriendId(long friendId) {
        this.friendId = friendId;
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
                ", friendId=" + friendId +
                ", uid=" + uid +
                ", friendname='" + friendname + '\'' +
                ", friend=" + friend +
                '}';
    }
}
