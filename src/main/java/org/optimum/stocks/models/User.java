package org.optimum.stocks.models;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.optimum.stocks.models.util.PasswordHash;

/**
 */

/**
 * Represents a user on our site
 */
@Entity
@Table(name = "users")
public class User extends AbstractEntity {

    private String userName;
    private String hash;


    // TODO - add cash to user class

    public User(String userName, String password) {
        this.hash = PasswordHash.getHash(password);
        this.userName = userName;
    }

    // empty constructor so Hibernate can do its magic
    public User() {}

    @NotNull
    @Column(name = "username", unique = true)
    public String getUserName() {
        return userName;
    }

    protected void setUserName(String userName){
        this.userName = userName;
    }

    @NotNull
    @Column(name = "hash")
    public String getHash() {
        return hash;
    }

    protected void setHash(String hash) {
        this.hash = hash;
    }


}