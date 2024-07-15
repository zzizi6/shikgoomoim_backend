package com.example.shikgoomoim.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Task {
    @Id
    @GeneratedValue
    private Long taskId;

    @Column(columnDefinition = "VARCHAR(1000)")
    private String content;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "familyId", nullable = false)
    private Family family;

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public Long getTaskId() {
        return taskId;
    }

    public String getContent() {
        return content;
    }

    public User getUser() {
        return user;
    }

    public Family getFamily() {
        return family;
    }
}
