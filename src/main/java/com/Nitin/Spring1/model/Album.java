/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Nitin.Spring1.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Asus06
 */
@Entity
public class Album {
    @Id
    private int id;
    private int userId;
    private String title;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   
    @Override
    public String toString(){
        return id+"  "+userId+" "+title;
    }
}
