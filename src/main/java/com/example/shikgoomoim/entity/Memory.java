package com.example.shikgoomoim.entity;

import jakarta.persistence.*;

@Entity
public class Memory {
    @Id
    @GeneratedValue
    private Long memoryId;

    @Column(columnDefinition = "VARCHAR(1000)")
    private String content;

    @Column(columnDefinition = "DATE")
    private String date;

    @Column(columnDefinition = "VARCHAR(100)")
    private String image;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "familyId", nullable = false)
    private Family family;  // 추억이 속한 가족

    public Long getMemoryId() {
        return memoryId;
    }

    public String getContent() {
        return content;
    }

    public String getDate() {
        return date;
    }

    public String getImage() {
        return image;
    }

    public Family getFamily() {
        return family;
    }
}
