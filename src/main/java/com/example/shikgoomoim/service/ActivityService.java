package com.example.shikgoomoim.service;

import com.example.shikgoomoim.entity.Activity;
import com.example.shikgoomoim.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ActivityService {

    private final ActivityRepository activityRepository;

    @Autowired
    public ActivityService(ActivityRepository activityRepository) {
        this.activityRepository=activityRepository;
    }

    // 활동 추가
    public void addActivity(Activity activity){
        activityRepository.save(activity);
    }

    // 가족 아이디 통해 활동 가져오기
    public Optional<List<Activity>> getActivityByFamilyId(Long familyId){
        return activityRepository.findByFamilyId(familyId);
    }

    // 활동 아이디 통해 활동 삭제
    public void removeActivity(Long activityId){
        activityRepository.deleteById(activityId);
    }
}
