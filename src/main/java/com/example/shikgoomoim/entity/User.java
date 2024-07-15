package com.example.shikgoomoim.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    @Id
    private String userId;

    @Column(columnDefinition = "VARCHAR(255)")
    private String name;

    @Column(columnDefinition = "TINYINT")
    private int age;

    @Column(columnDefinition = "CHAR(10)")
    private String gender;

    @Column(columnDefinition = "VARCHAR(1000)")
    private String image;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserFamily> userFamilyList;

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getImage() {
        return image;
    }

    public List<UserFamily> getUserFamilyList() {
        return userFamilyList;
    }
}
