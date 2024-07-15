package com.example.shikgoomoim.repository;

import com.example.shikgoomoim.entity.Memory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface MemoryRepository extends JpaRepository<Memory, Long> {

    // 가족 아이디로 추억 찾기
    @Query("SELECT m FROM Memory m WHERE m.family.familyId=:familyId")
    Optional<List<Memory>> findByFamilyId(@Param("familyId") Long familyId);

    // 추억 아이디로 추억 찾기
    @Query("SELECT m FROM Memory m WHERE m.memoryId=:memoryId")
    Optional<List<Memory>> findByMemoryId(@Param("memoryId") Long memoryId);

}
