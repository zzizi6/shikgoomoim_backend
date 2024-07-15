package com.example.shikgoomoim.service;

import com.example.shikgoomoim.entity.User;
import com.example.shikgoomoim.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 유저 아이디 통해서 유저 내보냄
    public User getUserById(String userId){
        return userRepository.findByUserId(userId);
    }

}
