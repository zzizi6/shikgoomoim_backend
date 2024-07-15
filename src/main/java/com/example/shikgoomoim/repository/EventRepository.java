package com.example.shikgoomoim.repository;

import com.example.shikgoomoim.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event,Long> {

    // 이벤트 아이디 통해 이벤트 조회
    @Query("SELECT e FROM Event e WHERE e.eventId=:eventId")
    Optional<List<Event>> findByEventId(@Param("eventId") Long eventId);

    // 가족 아이디 통해 가져오기
    @Query("SELECT e FROM Event e WHERE e.family.familyId=:familyId")
    Optional<List<Event>> findByFamilyId(@Param("familyId") Long familyId);
}
