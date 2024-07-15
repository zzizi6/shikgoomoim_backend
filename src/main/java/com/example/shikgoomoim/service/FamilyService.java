package com.example.shikgoomoim.service;

import com.example.shikgoomoim.entity.Family;
import com.example.shikgoomoim.repository.FamilyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FamilyService {

    private final FamilyRepository familyRepository;

    @Autowired
    public FamilyService(FamilyRepository familyRepository) {
        this.familyRepository = familyRepository;
    }

    // [C] 가족 엔티티 통해 가족 생성
    public void addFamily(Family family){
        familyRepository.save(family);
    }

    // [R] 가족 조회
    public Family getFamilyById(Long familyId){
        return familyRepository.findFamilyById(familyId);
    }

    // [D] 가족 아이디 통해 가족 삭제
    public void removeFamily(Long familyId){
        familyRepository.deleteById(familyId);
    }
}
