package com.example.shikgoomoim.service;

import com.example.shikgoomoim.entity.Task;
import com.example.shikgoomoim.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {


    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    // task 추가
    public void addTask(Task task){
        taskRepository.save(task);
    }

    // task 아이디 이용해 조회
    public Task getTaskById(Long taskId){
       return taskRepository.findByTaskId(taskId);
    }

    // family 아이디 이용해 조회
    public Optional<List<Task>> getTaskByFamilyId(Long familyId){
        return taskRepository.findByFamilyId(familyId);
    }

    // task 아이디 이용해 삭제
    public void removeTask(Long taskId){
        taskRepository.deleteById(taskId);
    }


}
