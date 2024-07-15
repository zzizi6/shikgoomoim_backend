package com.example.shikgoomoim.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Family {
    @Id
    @GeneratedValue
    private Long familyId;

    @Column(columnDefinition = "VARCHAR(30)")
    private String name;

    @OneToMany(mappedBy = "family", cascade = CascadeType.ALL)
    private List<UserFamily> userFamilies;

    public Long getFamilyId() {
        return familyId;
    }

    public String getName() {
        return name;
    }

    public List<UserFamily> getUserFamilies() {
        return userFamilies;
    }
}
