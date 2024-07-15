package com.example.shikgoomoim.repository;

import com.example.shikgoomoim.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {

    // 유저 아이디로 유저 찾기
    @Query("SELECT u FROM User u WHERE u.userId = :userId")
    User findByUserId(@Param("userId") String userId);

}
