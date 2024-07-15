package com.example.shikgoomoim.entity;

import jakarta.persistence.*;

@Entity
public class Event {
    @Id
    @GeneratedValue
    private Long eventId;

    @Column(columnDefinition = "DATE")
    private String date;

    @Column(columnDefinition = "VARCHAR(1000)")
    private String content;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="familyId", nullable = false)
    private Family family;

    public Long getEventId() {
        return eventId;
    }

    public String getDate() {
        return date;
    }

    public Family getFamily() {
        return family;
    }

    public String getContent(){
        return content;
    }
}
