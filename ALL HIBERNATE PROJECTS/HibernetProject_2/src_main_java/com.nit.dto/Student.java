package com.nit.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String course;
    private long mob_num;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public long getMob_num() {
        return mob_num;
    }

    public void setMob_num(long mob_num) {
        this.mob_num = mob_num;
    }

    
    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", course=" + course + ", mob_num=" + mob_num + "]";
    }
}
