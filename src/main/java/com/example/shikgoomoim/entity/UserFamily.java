package com.example.shikgoomoim.entity;

import jakarta.persistence.*;

@Entity
public class UserFamily {
    @Id
    @GeneratedValue
    private Long userFamilyId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id",  nullable = false)
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "family_id", nullable = false)
    private Family family;

    public Long getUserFamilyId() {
        return userFamilyId;
    }

    public User getUser() {
        return user;
    }

    public Family getFamily() {
        return family;
    }
}
