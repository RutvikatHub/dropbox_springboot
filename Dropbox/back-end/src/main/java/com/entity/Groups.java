package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Groups {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String owner;
    private String groupname;
    private String usernames;


    public Groups() {

    }

    public Groups(String owner, String groupname, String usernames) {
        this.owner = owner;
        this.groupname = groupname;
        this.usernames = usernames;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public String getUsernames() {
        return usernames;
    }

    public void setUsernames(String usernames) {
        this.usernames = usernames;
    }
}
