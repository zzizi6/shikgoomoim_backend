package com.example.shikgoomoim.entity;

import jakarta.persistence.*;

@Entity
public class Activity {
    @Id
    @GeneratedValue
    private Long activityId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="familyId")
    private Family family;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="userId")
    private User user;

    @Column(columnDefinition = "VARCHAR(255)")
    private String image;

    @Column(columnDefinition = "VARCHAR(1000)")
    private String content;

    @Column(columnDefinition = "DATE")
    private String date;

    public Long getActivityId() {
        return activityId;
    }

    public Family getFamily() {
        return family;
    }

    public String getImage() {
        return image;
    }

    public String getContent() {
        return content;
    }

    public String getDate() {
        return date;
    }

    public User getUser() {
        return user;
    }
}
