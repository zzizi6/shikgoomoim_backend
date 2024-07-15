package com.example.shikgoomoim.repository;

import com.example.shikgoomoim.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {

    // 가족 아이디 통해 가족 조회
    @Query("SELECT a FROM Activity a WHERE a.family.familyId=:familyId")
    Optional<List<Activity>> findByFamilyId(@Param("familyId") Long familyId);

}
