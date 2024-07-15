package com.example.shikgoomoim.service;

import com.example.shikgoomoim.entity.Event;
import com.example.shikgoomoim.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {


    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    // 이벤트 추가
    public void addEvent(Event event){
        eventRepository.save(event);
    }

    // 이벤트 아이디 통해 이벤트 가져오기
    public Optional<List<Event>> getEventById(Long eventId){
        return eventRepository.findByEventId(eventId);
    }

    // 가족 아이디 통해 이벤트 가져오기
    public Optional<List<Event>> getEventByFamilyId(Long familyId){
        return eventRepository.findByFamilyId(familyId);
    }

    // 이벤트 아이디 통해 이벤트 삭제
    public void removeEvent(Long eventId){
        eventRepository.deleteById(eventId);
    }
}
