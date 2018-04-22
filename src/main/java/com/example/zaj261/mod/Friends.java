package com.example.zaj261.mod;

import javax.persistence.*;

@Entity
public class Friends {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private  long id;

 private  long fid;
 private  long uid;
 private  String friendname;
 private  String invitedname;
 private  boolean friend;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getfid() {
        return fid;
    }

    public void setfid(long fid) {
        this.fid = fid;
    }

    public long getUid() {
        return uid;
    }

    public long getFid() {
        return fid;
    }

    public void setFid(long fid) {
        this.fid = fid;
    }

    public String getInvitedname() {
        return invitedname;
    }

    public void setInvitedname(String invitedname) {
        this.invitedname = invitedname;
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
                ", fid=" + fid +
                ", uid=" + uid +
                ", friendname='" + friendname + '\'' +
                ", friend=" + friend +
                '}';
    }
}
