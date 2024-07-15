package com.example.shikgoomoim.repository;

import com.example.shikgoomoim.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {

    // task 아이디 통해
    @Query("SELECT t FROM Task t WHERE t.taskId= :taskId")
    Task findByTaskId(@Param("taskId") Long taskId);

    // family 아이디 통해
    @Query("SELECT t FROM Task t WHERE t.family.familyId= :familyId")
    Optional<List<Task>> findByFamilyId(@Param("familyId") Long familyId);

}
