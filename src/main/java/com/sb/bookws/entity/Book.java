/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sb.bookws.entity;

/**
 *
 * @author Alexx
 */
public class Book {

    private int id;
    private String name;
    private int authorid;
    private int genreid;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAuthorid() {
        return authorid;
    }

    public int getGenreid() {
        return genreid;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthorid(int authorid) {
        this.authorid = authorid;
    }

    public void setGenreid(int genreid) {
        this.genreid = genreid;
    }

}
