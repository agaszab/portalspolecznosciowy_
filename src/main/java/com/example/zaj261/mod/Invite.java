package com.example.zaj261.mod;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;


@Entity
public class Invite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long id_inviting;
    private long id_invited;
    private Date date;
    private boolean executed=false;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId_inviting() {
        return id_inviting;
    }

    public void setId_inviting(long id_inviting) {
        this.id_inviting = id_inviting;
    }

    public long getId_invited() {
        return id_invited;
    }

    public void setId_invited(long id_invited) {
        this.id_invited = id_invited;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isExecuted() {
        return executed;
    }

    public void setExecuted(boolean executed) {
        this.executed = executed;
    }
}
