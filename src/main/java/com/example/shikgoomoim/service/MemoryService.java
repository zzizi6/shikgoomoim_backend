package com.example.shikgoomoim.service;

import com.example.shikgoomoim.entity.Memory;
import com.example.shikgoomoim.repository.MemoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class MemoryService {

    private final MemoryRepository memoryRepository;

    @Autowired
    public MemoryService(MemoryRepository memoryRepository) {
        this.memoryRepository = memoryRepository;
    }

    // 추억 추가
    public void addMemory(Memory memory){
        memoryRepository.save(memory);
    }

    // 가족 아이디로 추억 찾기
    public Optional<List<Memory>> getMemoryByFamilyId(Long familyId){
        return memoryRepository.findByFamilyId(familyId);
    }

    // 추억 아이디로 추억 찾기
    public Optional<List<Memory>> getMemoryByMemoryId(Long memoryId){
        return memoryRepository.findByFamilyId(memoryId);
    }

    // 추억 아이디로 추억 삭제
    public void removeMemoryByMemoryId(Long memoryId){
        memoryRepository.deleteById(memoryId);
    }
}
