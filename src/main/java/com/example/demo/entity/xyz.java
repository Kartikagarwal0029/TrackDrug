package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class xyz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String bb;

    public xyz() {
    }

    public xyz(String id, String bb) {
        this.id = id;
        this.bb = bb;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBb() {
        return bb;
    }

    public void setBb(String bb) {
        this.bb = bb;
    }

    @Override
    public String toString() {
        return "xyz{" +
                "id='" + id + '\'' +
                ", bb='" + bb + '\'' +
                '}';
    }
}
