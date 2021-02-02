package com.server.EmailAuthentication.domain;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Salt {
    @Id
    @GeneratedValue
    private int id;

    @NotNull()
    private String salt;

    public Salt(){

    }

    public Salt(String salt){
        this.salt = salt;
    }
}
