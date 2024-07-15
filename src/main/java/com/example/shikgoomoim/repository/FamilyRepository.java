package com.example.shikgoomoim.repository;

import com.example.shikgoomoim.entity.Family;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FamilyRepository extends JpaRepository<Family,Long> {

    // 가족 아이디로 가족 조회
    @Query("SELECT f FROM Family f WHERE f.familyId= :familyId")
    Family findFamilyById(@Param("familyId") Long familyId);

}
